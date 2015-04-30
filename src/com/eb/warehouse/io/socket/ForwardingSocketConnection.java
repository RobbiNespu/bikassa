package com.eb.warehouse.io.socket;

import com.google.common.util.concurrent.Service;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <p>Socket connection that delegates all method calls to another {@link SocketConnection}.</p>
 */
public abstract class ForwardingSocketConnection implements SocketConnection {

  /**
   * Get the delegate to which method calls should be forwarded to.
   *
   * @return wrapped socket connection instance. Never NULL.
   */
  protected abstract SocketConnection delegate();

  @Override
  public Service startAsync() {
    return delegate().startAsync();
  }

  @Override
  public boolean isRunning() {
    return delegate().isRunning();
  }

  @Override
  public State state() {
    return delegate().state();
  }

  @Override
  public Service stopAsync() {
    return delegate().stopAsync();
  }

  @Override
  public void awaitRunning() {
    delegate().awaitRunning();
  }

  @Override
  public void awaitRunning(long l, TimeUnit timeUnit) throws TimeoutException {
    delegate().awaitRunning(l, timeUnit);
  }

  @Override
  public void awaitTerminated() {
    delegate().awaitTerminated();
  }

  @Override
  public void awaitTerminated(long l, TimeUnit timeUnit) throws TimeoutException {
    delegate().awaitTerminated(l, timeUnit);
  }

  @Override
  public Throwable failureCause() {
    return delegate().failureCause();
  }

  @Override
  public void addListener(Listener listener, Executor executor) {
    delegate().addListener(listener, executor);
  }

  @Override
  public void writeToSocket(byte[] bytes) throws IOException {
    delegate().writeToSocket(bytes);
  }

}
