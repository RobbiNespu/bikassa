
package com.google.common.eventbus;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.eb.warehouse.util.DirectedEventSubscriber;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class DirectedEventBus {

  /**
   * A thread-safe cache for flattenHierarchy(). The Class class is immutable. This cache is shared
   * across all EventBus instances, which greatly improves performance if multiple such instances
   * are created and objects of the same class are posted on all of them.
   */
  private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder()
                                                                                                 .weakKeys()
                                                                                                 .build(new CacheLoader<Class<?>, Set<Class<?>>>() {
                                                                                                   @SuppressWarnings({"unchecked", "rawtypes"})
                                                                                                   // safe cast
                                                                                                   @Override
                                                                                                   public Set<Class<?>> load(Class<?> concreteClass) {
                                                                                                     return (Set) TypeToken.of(concreteClass)
                                                                                                                           .getTypes()
                                                                                                                           .rawTypes();
                                                                                                   }
                                                                                                 });

  /**
   * All registered event subscribers, indexed by event type.
   * <p>
   * This SetMultimap is NOT safe for concurrent use; all access should be made after acquiring a
   * read or write lock via {@link #subscribersByTypeLock}.
   */
  private final SetMultimap<SubscriberIdentifier, EventSubscriber> subscribersByQueueAndType = HashMultimap.create();
  private final ReadWriteLock subscribersByTypeLock = new ReentrantReadWriteLock();

  /**
   * Strategy for finding subscriber methods in registered objects. Currently, only the
   * {@link AnnotatedSubscriberFinder} is supported, but this is encapsulated for future expansion.
   */
  private final SubscriberFindingStrategy finder = new AnnotatedSubscriberFinder();

  /** queues of events for the current thread to dispatch */
  private final ThreadLocal<Queue<EventWithSubscriber>> eventsToDispatch = new ThreadLocal<Queue<EventWithSubscriber>>() {
    @Override
    protected Queue<EventWithSubscriber> initialValue() {
      return new LinkedList<EventWithSubscriber>();
    }
  };

  /** true if the current thread is currently dispatching an event */
  private final ThreadLocal<Boolean> isDispatching = new ThreadLocal<Boolean>() {
    @Override
    protected Boolean initialValue() {
      return false;
    }
  };

  private SubscriberExceptionHandler subscriberExceptionHandler;

  /**
   * Creates a new EventBus named "default".
   */
  public DirectedEventBus() {
    this("default");
  }

  /**
   * Creates a new EventBus with the given {@code identifier}.
   *
   * @param identifier a brief name for this bus, for logging purposes. Should be a valid Java
   * identifier.
   */
  public DirectedEventBus(String identifier) {
    this(new LoggingSubscriberExceptionHandler(identifier));
  }

  /**
   * Creates a new EventBus with the given {@link SubscriberExceptionHandler}.
   * 
   * @param subscriberExceptionHandler Handler for subscriber exceptions.
   * @since 16.0
   */
  public DirectedEventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
    this.subscriberExceptionHandler = checkNotNull(subscriberExceptionHandler);
  }

  /**
   * Registers all subscriber methods on {@code object} to receive events. Subscriber methods are
   * selected and classified using this EventBus's {@link SubscriberFindingStrategy}; the default
   * strategy is the {@link AnnotatedSubscriberFinder}.
   *
   * @param subscriber object whose subscriber methods should be registered.
   */
  public void register(DirectedEventSubscriber subscriber) {
    Multimap<Class<?>, EventSubscriber> methodsInListener = finder.findAllSubscribers(subscriber);
    subscribersByTypeLock.writeLock().lock();
    try {
      Set<String> acceptedQueues = subscriber.acceptedQueues();
      for (String queue : acceptedQueues) {
        for (Entry<Class<?>, Collection<EventSubscriber>> entry : methodsInListener.asMap().entrySet()) {
          for (EventSubscriber eventSub : entry.getValue()) {
            subscribersByQueueAndType.put(new SubscriberIdentifier(queue, entry.getKey()), eventSub);
          }
        }
      }
    } finally {
      subscribersByTypeLock.writeLock().unlock();
    }
  }

  /**
   * Unregisters all subscriber methods on a registered {@code object}.
   *
   * @param object object whose subscriber methods should be unregistered.
   * @throws IllegalArgumentException if the object was not previously registered.
   */
  //  public void unregister(Object object) {
  //    Multimap<Class<?>, EventSubscriber> methodsInListener = finder.findAllSubscribers(object);
  //    for (Entry<Class<?>, Collection<EventSubscriber>> entry : methodsInListener.asMap().entrySet()) {
  //      Class<?> eventType = entry.getKey();
  //      Collection<EventSubscriber> eventMethodsInListener = entry.getValue();
  //
  //      subscribersByTypeLock.writeLock().lock();
  //      try {
  //        Set<EventSubscriber> currentSubscribers = subscribersByQueueAndType.get(eventType);
  //        if (!currentSubscribers.containsAll(eventMethodsInListener)) {
  //          throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + object + " registered?");
  //        }
  //        currentSubscribers.removeAll(eventMethodsInListener);
  //      } finally {
  //        subscribersByTypeLock.writeLock().unlock();
  //      }
  //    }
  //  }

  /**
   * Posts an event to all registered subscribers. This method will return successfully after the
   * event has been posted to all subscribers, and regardless of any exceptions thrown by
   * subscribers.
   * <p>
   * If no subscribers have been subscribed for {@code event}'s class, and {@code event} is not
   * already a {@link DeadEvent}, it will be wrapped in a DeadEvent and reposted.
   *
   * @param queue to which the event is posted to.
   * @param event event to post.
   */
  public void postToQueue(String queue, Object event) {
    Set<Class<?>> dispatchTypes = flattenHierarchy(event.getClass());

    boolean dispatched = false;
    for (Class<?> eventType : dispatchTypes) {
      subscribersByTypeLock.readLock().lock();
      try {
        Set<EventSubscriber> wrappers = subscribersByQueueAndType.get(new SubscriberIdentifier(queue, eventType));

        if (!wrappers.isEmpty()) {
          dispatched = true;
          for (EventSubscriber wrapper : wrappers) {
            enqueueEvent(event, wrapper);
          }
        }
      } finally {
        subscribersByTypeLock.readLock().unlock();
      }
    }

    if (!dispatched && !(event instanceof DeadEvent)) {
      // TODO: where post the dead event?
      //      post(new DeadEvent(this, event));
    }

    dispatchQueuedEvents();
  }

  /**
   * Queue the {@code event} for dispatch during {@link #dispatchQueuedEvents()}. Events are queued
   * in-order of occurrence so they can be dispatched in the same order.
   */
  void enqueueEvent(Object event, EventSubscriber subscriber) {
    eventsToDispatch.get().offer(new EventWithSubscriber(event, subscriber));
  }

  /**
   * Drain the queue of events to be dispatched. As the queue is being drained, new events may be
   * posted to the end of the queue.
   */
  void dispatchQueuedEvents() {
    // don't dispatch if we're already dispatching, that would allow reentrancy
    // and out-of-order events. Instead, leave the events to be dispatched
    // after the in-progress dispatch is complete.
    if (isDispatching.get()) {
      return;
    }

    isDispatching.set(true);
    try {
      Queue<EventWithSubscriber> events = eventsToDispatch.get();
      EventWithSubscriber eventWithSubscriber;
      while ((eventWithSubscriber = events.poll()) != null) {
        dispatch(eventWithSubscriber.event, eventWithSubscriber.subscriber);
      }
    } finally {
      isDispatching.remove();
      eventsToDispatch.remove();
    }
  }

  /**
   * Dispatches {@code event} to the subscriber in {@code wrapper}. This method is an appropriate
   * override point for subclasses that wish to make event delivery asynchronous.
   *
   * @param event event to dispatch.
   * @param wrapper wrapper that will call the subscriber.
   */
  void dispatch(Object event, EventSubscriber wrapper) {
    try {
      wrapper.handleEvent(event);
    } catch (InvocationTargetException e) {
      //      try {
      //        subscriberExceptionHandler.handleException(e.getCause(), new SubscriberExceptionContext(this, event, wrapper.getSubscriber(), wrapper.getMethod()));
      //      } catch (Throwable t) {
      //        // If the exception handler throws, log it. There isn't much else to do!
      //        Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, String.format("Exception %s thrown while handling exception: %s", t, e.getCause()), t);
      //      }
    }
  }

  /**
   * Flattens a class's type hierarchy into a set of Class objects. The set will include all
   * superclasses (transitively), and all interfaces implemented by these superclasses.
   *
   * @param concreteClass class whose type hierarchy will be retrieved.
   * @return {@code clazz}'s complete type hierarchy, flattened and uniqued.
   */
  @VisibleForTesting
  Set<Class<?>> flattenHierarchy(Class<?> concreteClass) {
    try {
      return flattenHierarchyCache.getUnchecked(concreteClass);
    } catch (UncheckedExecutionException e) {
      throw Throwables.propagate(e.getCause());
    }
  }

  /**
   * Simple logging handler for subscriber exceptions.
   */
  private static final class LoggingSubscriberExceptionHandler implements SubscriberExceptionHandler {

    /**
     * Logger for event dispatch failures. Named by the fully-qualified name of this class, followed
     * by the identifier provided at construction.
     */
    private final Logger logger;

    /**
     * @param identifier a brief name for this bus, for logging purposes. Should be a valid Java
     * identifier.
     */
    public LoggingSubscriberExceptionHandler(String identifier) {
      logger = Logger.getLogger(EventBus.class.getName() + "." + checkNotNull(identifier));
    }

    @Override
    public void handleException(Throwable exception, SubscriberExceptionContext context) {
      logger.log(Level.SEVERE, "Could not dispatch event: " + context.getSubscriber() + " to " + context.getSubscriberMethod(), exception.getCause());
    }
  }

  /** simple struct representing an event and it's subscriber */
  static class EventWithSubscriber {
    final Object event;
    final EventSubscriber subscriber;

    public EventWithSubscriber(Object event, EventSubscriber subscriber) {
      this.event = checkNotNull(event);
      this.subscriber = checkNotNull(subscriber);
    }
  }

  static class SubscriberIdentifier {
    final String queue;
    final Class<?> eventType;

    public SubscriberIdentifier(String queue, Class<?> eventType) {
      this.queue = queue;
      this.eventType = eventType;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
      if (obj instanceof SubscriberIdentifier) {
        SubscriberIdentifier other = (SubscriberIdentifier) obj;
        return queue.equals(other.queue) && eventType == other.eventType;
      }
      return false;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
      return Objects.hash(queue, eventType);
    }
  }

}
