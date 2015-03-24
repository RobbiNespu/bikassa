package com.eb.warehouse.io.socket;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import com.eb.warehouse.io.SocketConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.inject.Named;

import static com.google.common.base.Preconditions.checkState;

/**
 * <p> Socket connection that tries to be connected to the socket as long as the connection is
 * running. Reconnect is triggered either if {@link #writeToSocket(byte[])} throws an exception or a
 * previous connect to the socket failed. </p>
 */
final class PermanentSocketConnection implements SocketConnection {

  static final String CONNECT_AND_READ_EXECUTOR_SERVICE_NAME_BINDING = "connectAndRead";
  private static final Logger L = LoggerFactory.getLogger(PermanentSocketConnection.class);
  private final ConnectSocketTask connectSocketTask;
  private final ReadSocketTaskFactory readSocketTaskFactory;
  private final EventBus socketConnectEvents;
  private final FutureCallback<Socket> connectCallback;
  private final FutureCallback<Void> readCallback;
  private final ListeningExecutorService connectAndReadRunner;
  // private ConnectionStatsCounter statsCounter;
  private volatile boolean running;
  private volatile Socket socket;
  private ListenableFuture<Socket> connectFuture;
  private ListenableFuture<Void> readFuture;

  @Inject
  PermanentSocketConnection(
      @Named(CONNECT_AND_READ_EXECUTOR_SERVICE_NAME_BINDING) ListeningExecutorService connectAndReadRunner,
      ConnectSocketTask connectSocketTask,
      ReadSocketTaskFactory readSocketTaskFactory,
      @Named("socketEvents") EventBus socketConnectEvents) {
    this.connectAndReadRunner = connectAndReadRunner;
    this.connectSocketTask = connectSocketTask;
    this.readSocketTaskFactory = readSocketTaskFactory;
    this.socketConnectEvents = socketConnectEvents;
    connectCallback = new ConnectSocketCallback();
    readCallback = new ReadSocketCallback();
  }

  PermanentSocketConnection(ListeningExecutorService connectAndReadRunner,
                            ConnectSocketTask connectSocketTask,
                            ReadSocketTaskFactory readSocketTaskFactory,
                            EventBus socketConnectEvents,
                            FutureCallback<Socket> connectCallback,
                            FutureCallback<Void> readCallback) {
    this.connectAndReadRunner = connectAndReadRunner;
    this.connectSocketTask = connectSocketTask;
    this.readSocketTaskFactory = readSocketTaskFactory;
    this.socketConnectEvents = socketConnectEvents;
    this.connectCallback = connectCallback;
    this.readCallback = readCallback;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void startAsync2() {
    checkState(!running,
               "Connection is already started. Call 'stop2()' before starting the connection again!");
    running = true;
    connectAsync();
  }

  private void connectAsync() {
    connectFuture = connectSocketTask.submitTo(connectAndReadRunner);
    Futures.addCallback(connectFuture, connectCallback);
  }

  private void closeOldSocketAndReconnectAsync() {
    if (connectFuture.isCancelled() || connectFuture.isDone()) {
      Sockets.closeQuietly(socket);
      connectAsync();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop2() {
    if (connectFuture != null) {
      connectFuture.cancel(true);
    }
    Sockets.closeQuietly(socket);
    try {
      if (connectFuture != null) {
        connectFuture.get();
      }
    } catch (InterruptedException e) {
    } catch (ExecutionException e) {
    }
    running = false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void writeToSocket(byte[] bytes) throws IOException {
    L.trace("Try writing bytes={} to socket={} output stream.", bytes, socket);
    if (socket == null) {
      throw new IOException(
          "Cannot write to socket. Called 'startAsync2()'.");
    }
    if (!connectFuture.isDone()) {
      throw new IOException(
          "Cannot write to socket. Still connecting to it.");
    }

    try {
      socket.getOutputStream().write(bytes);
      // statsCounter.incrementSentBytes(bytes.length);
      L.trace("Wrote bytes successfully to socket output stream.");
    } catch (IOException e) {
      closeOldSocketAndReconnectAsync();
      throw e;
    }
  }

  /**
   * Set the socket instance and the listenable future that is used to abort the task that is
   * connecting to a socket. Only use for testing!
   */
  void setSocketAndConnecting(Socket socket, ListenableFuture<Socket> connectFuture) {
    this.socket = socket;
    this.connectFuture = connectFuture;
  }

  /**
   * Set the socket instance. Only use for testing!
   */
  void setSocket(Socket socket) {
    this.socket = socket;
  }

  /**
   * Set the socket's output stream. Only use for testing!
   */
  void setOutputStream(OutputStream os) {
//    this.os = os;
  }

  /**
   * Set the listenable future that is used to abort the task that is connecting to a socket. Only
   * use for testing!
   */
  void setConnecting(ListenableFuture<Socket> connectFuture) {
    this.connectFuture = connectFuture;
  }

  final class ConnectSocketCallback implements FutureCallback<Socket> {

    @Override
    public void onSuccess(Socket connected) {
      socket = connected;
      try {
        Callable<Void> readTask =
            readSocketTaskFactory.createReadSocketInputStreamTask(connected.getInputStream());
        readFuture = connectAndReadRunner.submit(readTask);
        Futures.addCallback(readFuture, readCallback);
        socketConnectEvents.post(new SocketConnectedEvent());
      } catch (IOException e) {
        closeOldSocketAndReconnectAsync();
      }
    }

    @Override
    public void onFailure(Throwable t) {
      // Fails only if task is interrupted and/or underyling socket gets closed.
    }
  }

  final class ReadSocketCallback implements FutureCallback<Void> {

    @Override
    public void onSuccess(Void none) {
      // Comes here only if remote host closes socket.
//      closeOldSocketAndReconnectAsync();
    }

    @Override
    public void onFailure(Throwable t) {
      closeOldSocketAndReconnectAsync();
    }
  }
}
