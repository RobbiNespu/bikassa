package com.eb.warehouse.util;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * Wrapper for {@link Thread} to make interrupting and sleeping of a thread testable.
 */
public class ThreadWrapper {

  /**
   * Constant that delegates all method calls to {@link Thread}'s static methods or the current
   * executing thread. It's for production code.
   */
  public static final ThreadWrapper REAL = new ThreadWrapper() {
    @Override
    public void sleep2(int duration, TimeUnit unit) throws InterruptedException {
      unit.sleep(duration);
    }

    @Override
    public void sleepUninterruptibly(int duration, TimeUnit unit) {
      Uninterruptibles.sleepUninterruptibly(duration, unit);
    }

    @Override
    public boolean isInterruptedAndReset(boolean resetInterruptedFlag) {
      if (resetInterruptedFlag) {
        return Thread.interrupted();
      }
      return Thread.currentThread().isInterrupted();
    }
  };

  /**
   * Causes the currently executing thread to sleep (temporarily cease execution) for the specified
   * period, subject to the precision and accuracy of system timers and schedulers.
   *
   * @throws java.lang.IllegalArgumentException if the value of millis is negative.
   * @throws java.lang.InterruptedException     if any thread has interrupted the current thread.
   *                                            The <em>interrupted status</em> of the current
   *                                            thread is cleared when this exception is thrown.
   */
  public void sleep2(int duration, TimeUnit unit) throws InterruptedException {
  }

  /**
   * Causes the currently executing thread to sleep (temporarily cease execution) for the specified
   * period, subject to the precision and accuracy of system timers and schedulers.
   *
   * @throws java.lang.IllegalArgumentException if the value of millis is negative.
   */
  public void sleepUninterruptibly(int duration, TimeUnit unit) {
  }

  /**
   * Test whether this thread has been interrupted. The interrupted status of the thread is
   * unaffected by this method. <p>A thread interruption ignored because a thread was not alive at
   * the time of the interrupt will be reflected by this method returning false.</p>
   *
   * @param resetInterruptedFlag clears the interrupted status of the thread if <code>true</code>.
   *                             In other words, if this method were to be called twice in
   *                             succession with the <code>true</code>, the second call would return
   *                             false (unless the current thread were interrupted again, after the
   *                             first call had cleared its interrupted status and before the second
   *                             call had examined it).
   */
  public boolean isInterruptedAndReset(boolean resetInterruptedFlag) {
    return false;
  }
}
