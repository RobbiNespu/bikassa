package com.eb.warehouse.io.socket;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.util.EventBusRegistrationListener;
import com.eb.warehouse.util.NamedThreadFactoryModule;
import com.eb.warehouse.util.SubclassesOf;
import com.eb.warehouse.util.ThreadNameBinding;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Named;

/**
 * Created by ebe on 24.03.2015.
 */
public class AutoLifeSendSocketConnectionModule extends AbstractModule {

  public static final String LIFE_SEND_THREAD_NAME_BINDING = "life-send-thread-name";
  private static final Key<ListeningScheduledExecutorService>
      LIFE_SENDER_KEY =
      Key.get(ListeningScheduledExecutorService.class, LifeSendExecServiceBinding.class);
  private final EventBus socketEventBus;

  public AutoLifeSendSocketConnectionModule(EventBus socketEventBus) {
    this.socketEventBus = socketEventBus;
  }

  @Override
  protected void configure() {
    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new NamedThreadFactoryModule());
        expose(LIFE_SENDER_KEY);
      }

      @Provides
      @LifeSendExecServiceBinding
      ListeningScheduledExecutorService provideLifeSendExecService(ThreadFactory threadFactory) {
        return MoreExecutors.listeningDecorator(Executors.newSingleThreadScheduledExecutor(
            threadFactory));
      }

      @Provides
      @ThreadNameBinding
      String provideLifeSendThreadName(@Named(LIFE_SEND_THREAD_NAME_BINDING) String threadName) {
        return threadName;
      }
    });

    install(new AutoConnectSocketConnectionModule());
    bind(SocketConnection.class)
        .annotatedWith(AutoLifeSendSocketConnectionBinding.class)
        .to(AutoLifeSendSocketConnection.class);

    bindListener(new SubclassesOf(AutoLifeSendSocketConnection.class),
                 new EventBusRegistrationListener(socketEventBus));
  }
}
