package com.eb.warehouse.io.socket;

import java.io.IOException;

/**
 * <p>Socket connection that delegates all method calls to another {@link
 * SocketConnection}.</p>
 */
public abstract class ForwardingSocketConnection implements SocketConnection {

  /**
   * Get the delegate to which method calls should be forwarded to.
   *
   * @return wrapped socket connection instance. Never NULL.
   */
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
