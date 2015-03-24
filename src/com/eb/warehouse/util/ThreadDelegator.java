package com.eb.warehouse.util;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public abstract class ThreadDelegator {

  public static final ThreadDelegator REAL = new ThreadDelegator() {
    @Override
    public void sleepCurrentThread(int duration, TimeUnit unit) throws InterruptedException {
      unit.sleep(duration);
    }

    @Override
    public void sleepCurrentThreadUninterruptibly(int duration, TimeUnit unit) {
      Uninterruptibles.sleepUninterruptibly(duration, unit);
    }

    @Override
    public boolean isCurrentThreadInterrupted(boolean resetInterruptedFlag) {
      if (resetInterruptedFlag) {
        return Thread.interrupted();
      }
      return Thread.currentThread().isInterrupted();
    }
  };

  /**
   * TODO JavaDoc according to WAMAS C conventions
   */
  public abstract void sleepCurrentThread(int duration, TimeUnit unit) throws InterruptedException;

  public abstract void sleepCurrentThreadUninterruptibly(int duration, TimeUnit unit);

  public abstract boolean isCurrentThreadInterrupted(boolean resetInterruptedFlag);

}
