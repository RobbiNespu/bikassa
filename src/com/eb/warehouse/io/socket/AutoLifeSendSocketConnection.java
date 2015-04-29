package com.eb.warehouse.io.socket;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;

import com.eb.warehouse.io.SocketConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p> Socket connection that provides periodic life-message-sending functionality and delegates
 * those to another socket connection. </p>
 */
public final class AutoLifeSendSocketConnection extends ForwardingSocketConnection {

  public static final String BINDING_NAME = "lifeTrigger";
  static final String SEND_LIFE_SCHEDULED_EXECUTOR_SERVICE_BINDING_NAME = "sendLife";
  private static final Logger L = LoggerFactory.getLogger(AutoLifeSendSocketConnection.class);
  private final SocketConnection wrapped;
  private final ListeningScheduledExecutorService lifeSendTrigger;
  private final EventBus lifeEventBus;
  private ListenableScheduledFuture<?> sendLifeFuture;

  @Inject
  public AutoLifeSendSocketConnection(
      @Named(AutoConnectSocketConnectionModule.AUTO_CONNECT_SOCKET_CONN_BINDING_NAME) SocketConnection wrapped,
      @Named(SEND_LIFE_SCHEDULED_EXECUTOR_SERVICE_BINDING_NAME) ListeningScheduledExecutorService lifeSendTrigger,
      @Named(AutoConnectSocketConnectionModule.SOCKET_EVENTS_BINDING_NAME) EventBus lifeEventBus) {
    this.wrapped = wrapped;
    this.lifeSendTrigger = lifeSendTrigger;
    this.lifeEventBus = lifeEventBus;
  }

  @Override
  protected SocketConnection delegate() {
    return wrapped;
  }

  @Subscribe
  public final void startLifeMessageSenderThread(SocketConnectedEvent e) {
    if (sendLifeFuture == null || sendLifeFuture.isDone()) {
      // Send life messages if not started yet or previous task was cancelled.
      L.trace("Start life-message-sender thread.");
      sendLifeFuture = lifeSendTrigger.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
          L.trace("Trigger send life message.");
          lifeEventBus.post(new LifeSendEvent());
        }
      }, 5, 5, TimeUnit.SECONDS);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void writeToSocket(byte[] bytes) throws IOException {
    try {
      super.writeToSocket(bytes);
    } catch (IOException e) {
      if (sendLifeFuture != null) {
        // Stop sending life messages
        L.trace("Stop sending life messages. Connection broken.");
        sendLifeFuture.cancel(false);
      }
      throw e;
    }
  }
}