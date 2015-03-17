
package com.eb.warehouse.io;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.SettableFuture;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

final class DirectListeningScheduledExecutorService implements ListeningScheduledExecutorService {

  /** {@inheritDoc} */
  @Override
  public void shutdown() {
  }

  /** {@inheritDoc} */
  @Override
  public List<Runnable> shutdownNow() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isShutdown() {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isTerminated() {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException,
    TimeoutException {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public void execute(Runnable command) {
  }

  /** {@inheritDoc} */
  @Override
  public <T> ListenableFuture<T> submit(Callable<T> task) {
    SettableFuture<T> f = SettableFuture.create();
    try {
      T res = task.call();
      f.set(res);
    } catch (Exception e) {
      f.setException(e);
    }
    return f;
  }

  /** {@inheritDoc} */
  @Override
  public ListenableFuture<?> submit(Runnable task) {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public <T> ListenableFuture<T> submit(Runnable task, T result) {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ListenableScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
    SettableFuture<V> f = SettableFuture.create();
    try {
      V res = callable.call();
      f.set(res);
    } catch (Exception e) {
      f.setException(e);
    }
    return SettableScheduledFuture.create(f);
  }

  /** {@inheritDoc} */
  @Override
  public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
    return null;
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
