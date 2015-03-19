package com.eb.warehouse.io.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eb.warehouse.io.SocketConnection;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;

/**
 * <p>
 * Socket connection that provides periodic life-message-sending functionality and delegates those
 * to another socket connection.
 * </p>
 */
public final class AliveSocketConnection implements SocketConnection {

  /**
   * <p>
   * Callback interface for life messages.
   * </p>
   */
  public static interface SendLifeCallback {

    /**
     * Invoked when a life message should be sent. Periodically called on a "life-message-sending"
     * thread.
     */
    void onSendLife();
  }

  private static final Logger L = LoggerFactory.getLogger(AliveSocketConnection.class);
  private final SocketConnection wrapped;
  private final ListeningScheduledExecutorService lifeSendTrigger;
  private SendLifeCallback lifeSender;
  private ListenableScheduledFuture<?> sendLifeFuture;

  @Inject
  public AliveSocketConnection(SocketConnection wrapped,
      ListeningScheduledExecutorService lifeSendTrigger) {
    this.wrapped = wrapped;
    this.lifeSendTrigger = lifeSendTrigger;
  }

  /** {@inheritDoc} */
  @Override
  public final void startAsync2() {
    wrapped.startAsync2();
  }

  /** {@inheritDoc} */
  @Override
  public final void stop2() {
    wrapped.stop2();
  }

  @Subscribe
  public final void startSendingLifeMessagesIfNotAlreadySending(InetSocketAddress connectedToAddress) {
    if (sendLifeFuture == null || sendLifeFuture.isDone()) {
      // Send life messages if not started yet or previous task was cancelled.
      sendLifeFuture = lifeSendTrigger.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
          lifeSender.onSendLife();
        }
      }, 5, 5, TimeUnit.SECONDS);
    }
  }

  /** {@inheritDoc} */
  @Override
  public final void writeToSocket(byte[] bytes) throws IOException {
    try {
      wrapped.writeToSocket(bytes);
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
