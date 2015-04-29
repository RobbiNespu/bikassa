package com.eb.warehouse.io.ngkp;

import com.google.common.eventbus.Subscribe;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.socket.AutoConnectSocketConnectionModule;
import com.eb.warehouse.io.socket.ForwardingSocketConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ebe on 25.03.2015.
 */
final class Ngkp2ReceiverSocketConnection extends ForwardingSocketConnection {

  static final String
      WRAPPED_CONN_BINDING_NAME =
      AutoConnectSocketConnectionModule.AUTO_CONNECT_SOCKET_CONN_BINDING_NAME;
  private static final Logger L = LoggerFactory.getLogger(Ngkp2ReceiverSocketConnection.class);
  private static final char ACK_TELEGRAM_TYPE = 'Q';
  private final SocketConnection wrapped;

  @Inject
  Ngkp2ReceiverSocketConnection(@Named(WRAPPED_CONN_BINDING_NAME) SocketConnection wrapped) {
    this.wrapped = wrapped;
  }

  @Override
  protected SocketConnection delegate() {
    return wrapped;
  }

  @Subscribe
  public void sendAckMessage(Ngkp2Header header) {
    L.trace("Try send ack telegram for received NGKP2 header={}.", header);
    Ngkp2Header copy = new Ngkp2Header(header);
    copy.setTelegramType(ACK_TELEGRAM_TYPE);
    byte[] bytes = new byte[10];
    copy.intoByteArray(bytes, 0);
    try {
      writeToSocket(bytes);
    } catch (IOException e) {
      L.error("Not sent ack telegram.", e);
    }
  }
}
