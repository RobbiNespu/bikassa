
package com.eb.warehouse.io.socket;

import static com.google.common.base.Preconditions.checkState;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eb.warehouse.io.SendableConnectionService;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

final class PermanentSocketConnection implements SendableConnectionService {

  private static final Logger L = LoggerFactory.getLogger(PermanentSocketConnection.class);
  private final ConnectSocketTask connectSocketTask;
  private final ReadSocketTaskFactory readSocketTaskFactory;
  private final EventBus socketConnectEvents;
  private final FutureCallback<Socket> connectCallback = new FutureCallback<Socket>() {
    @Override
    public void onSuccess(Socket connected) {
      socket = connected;
      try {
        Callable<Void> readTask = readSocketTaskFactory.createReadSocketInputStreamTask(connected.getInputStream());
        readFuture = connectAndReadRunner.submit(readTask);
        Futures.addCallback(readFuture, readCallback);
        socketConnectEvents.post(new InetSocketAddress(socket.getInetAddress(), socket.getPort()));
      } catch (IOException e) {
        closeOldSocketAndReconnectAsync();
      }
    }

    @Override
    public void onFailure(Throwable t) {
      // Fails only if application is going to be shut down.
    }
  };
  private final FutureCallback<Void> readCallback = new FutureCallback<Void>() {
    @Override
    public void onSuccess(Void none) {
      // Reading from socket always ends with exception thrown.
    }

    @Override
    public void onFailure(Throwable t) {
      closeOldSocketAndReconnectAsync();
    }
  };
  private final ListeningExecutorService connectAndReadRunner;
  //  private ConnectionStatsCounter statsCounter;
  private volatile Socket socket;
  private ListenableFuture<Socket> connectFuture;
  private ListenableFuture<Void> readFuture;

  @Inject
  public PermanentSocketConnection(ListeningExecutorService connectAndReadRunner, ConnectSocketTask connectSocketTask,
                                   ReadSocketTaskFactory readSocketTaskFactory, @Named("internal") EventBus socketConnectEvents) {
    this.connectAndReadRunner = connectAndReadRunner;
    this.connectSocketTask = connectSocketTask;
    this.readSocketTaskFactory = readSocketTaskFactory;
    this.socketConnectEvents = socketConnectEvents;
  }

  /** {@inheritDoc} */
  @Override
  public void startAsync2() {
    checkState(socket == null, "This method must be called only once at application start-up.");
    connectAsync();
  }

  private void connectAsync() {
    connectFuture = connectSocketTask.submitTo(connectAndReadRunner);
    Futures.addCallback(connectFuture, connectCallback);
  }

  private void closeOldSocketAndReconnectAsync() {
    Sockets.closeQuietly(socket);
    connectAsync();
  }

  /** {@inheritDoc} */
  @Override
  public void stop2() {
    if (connectFuture != null) {
      connectFuture.cancel(true);
    }
    Sockets.closeQuietly(socket);
  }

  /** {@inheritDoc} */
  @Override
  public void send(byte[] bytes) throws IOException {
    try {
      OutputStream os = socket.getOutputStream();
      L.trace("Try writing bytes={} to socket={}.", bytes, socket);
      os.write(bytes);
      //      statsCounter.incrementSentBytes(bytes.length);
      L.trace("Wrote bytes={} to socket={}.", bytes, socket);
    } catch (IOException e) {
      L.error("Not sent bytes={} to socket={}. IOException occurred.", bytes, socket);
      closeOldSocketAndReconnectAsync();
      throw e;
    }
  }
}
