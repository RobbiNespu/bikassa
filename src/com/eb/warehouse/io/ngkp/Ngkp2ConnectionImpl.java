package com.eb.warehouse.io.ngkp;

import com.google.common.util.concurrent.Service;

import com.eb.warehouse.io.socket.SocketConnection;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ebe on 25.03.2015.
 */
final class Ngkp2ConnectionImpl implements Ngkp2Connection {

  static final String SENDER_CONN_BINDING_NAME = "sender";
  static final String RECEIVER_CONN_BINDING_NAME = "receiver";
  private final SocketConnection senderConnection;
  private final SocketConnection receiverConnection;

  @Inject
  Ngkp2ConnectionImpl(
      @Named(SENDER_CONN_BINDING_NAME) SocketConnection senderConnection,
      @Named(RECEIVER_CONN_BINDING_NAME) SocketConnection receiverConnection) {
    this.senderConnection = senderConnection;
    this.receiverConnection = receiverConnection;
  }

  @Override
  public Service startAsync() {
    return null;
  }

  @Override
  public boolean isRunning() {
    return false;
  }

  @Override
  public State state() {
    return null;
  }

  @Override
  public Service stopAsync() {
    return null;
  }

  @Override
  public void awaitRunning() {

  }

  @Override
  public void awaitRunning(long l, TimeUnit timeUnit) throws TimeoutException {

  }

  @Override
  public void awaitTerminated() {

  }

  @Override
  public void awaitTerminated(long l, TimeUnit timeUnit) throws TimeoutException {

  }

  @Override
  public Throwable failureCause() {
    return null;
  }

  @Override
  public void addListener(Listener listener, Executor executor) {

  }
}
