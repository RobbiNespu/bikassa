
package com.google.common.eventbus;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import com.eb.warehouse.util.DirectedEventSubscriber;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.DirectedEventBus;
import com.google.common.eventbus.Subscribe;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class DirectedEventBusTest {

  @Test
  public void postToQueue() {
    DirectedEventBus eventBus = new DirectedEventBus();
    String sendTo = "a";
    String event = "b";
    CaptureEventSubscriber capture = new CaptureEventSubscriber(ImmutableSet.of(sendTo));
    eventBus.register(capture);
    eventBus.postToQueue(sendTo, event);
    assertEquals(event, capture.receivedEvent);
  }

  private static class CaptureEventSubscriber implements DirectedEventSubscriber {

    Set<String> acceptedQueues;
    String receivedEvent;

    CaptureEventSubscriber(Set<String> acceptedQueues) {
      this.acceptedQueues = acceptedQueues;
    }

    /** {@inheritDoc} */
    @Override
    public Set<String> acceptedQueues() {
      return acceptedQueues;
    }

    @Subscribe
    public void assertEvent(String e) {
      receivedEvent = e;
    }

  }
}
