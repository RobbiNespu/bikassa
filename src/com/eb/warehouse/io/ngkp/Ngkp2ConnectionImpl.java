package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.socket.SocketConnection;

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
  public void startAsync2() {
    senderConnection.startAsync2();
    receiverConnection.startAsync2();
  }

  @Override
  public void stop2() {
    senderConnection.stop2();
    receiverConnection.stop2();
  }
}
