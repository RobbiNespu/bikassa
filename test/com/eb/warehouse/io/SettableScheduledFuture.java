
package com.eb.warehouse.io;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public final class SettableScheduledFuture<V> extends ForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {

  public static <V> SettableScheduledFuture<V> create(ListenableFuture<V> wrapped) {
    return new SettableScheduledFuture<V>(wrapped);
  }

  private final ListenableFuture<V> wrapped;

  public SettableScheduledFuture(ListenableFuture<V> wrapped) {
    this.wrapped = wrapped;
  }

  /** {@inheritDoc} */
  @Override
  protected ListenableFuture<V> delegate() {
    return wrapped;
  }

  /** {@inheritDoc} */
  @Override
  public long getDelay(TimeUnit unit) {
    return 0;
  }

  /** {@inheritDoc} */
  @Override
  public int compareTo(Delayed o) {
    return 0;
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
