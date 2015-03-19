package com.eb.warehouse.io.ngkp;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.socket.ForwardingSocketConnection;
import com.eb.warehouse.io.socket.AliveSocketConnection.SendLifeCallback;

/**
 * <p>
 * TODO
 * </p>
 */
final class Nkgp2SocketConnection extends ForwardingSocketConnection implements SendLifeCallback {

  private static final Logger L = LoggerFactory.getLogger(Nkgp2SocketConnection.class);
  private final SocketConnection wrapped;
  private 

  public Nkgp2SocketConnection(SocketConnection wrapped) {
    this.wrapped = wrapped;
  }

  /** {@inheritDoc} */
  @Override
  protected SocketConnection delegate() {
    return wrapped;
  }

  /** {@inheritDoc} */
  @Override
  public void onSendLife() {}

}
