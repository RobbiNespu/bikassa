package com.eb.warehouse.io.socket;

import com.eb.warehouse.io.SocketConnection;

import java.io.IOException;

/**
 * <p> TODO </p>
 */
public abstract class ForwardingSocketConnection implements SocketConnection {

  protected abstract SocketConnection delegate();

  /**
   * {@inheritDoc}
   */
  @Override
  public void startAsync2() {
    delegate().startAsync2();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop2() {
    delegate().stop2();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void writeToSocket(byte[] bytes) throws IOException {
    delegate().writeToSocket(bytes);
  }

}