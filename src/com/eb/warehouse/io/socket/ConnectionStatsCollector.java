package com.eb.warehouse.io.socket;

import com.google.common.base.Stopwatch;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

final class ConnectionStatsCollector implements ConnectionStatsCounter {

  private final AtomicLong receivedBytes = new AtomicLong();
  private final AtomicLong sentBytes = new AtomicLong();
  private final AtomicLong connectAttempts = new AtomicLong();
  private final AtomicLong successfulConnects = new AtomicLong();
  private final AtomicLong failedConnects = new AtomicLong();
  private final Stopwatch upTimeStopwatch = Stopwatch.createUnstarted();
  private final Stopwatch connectedStopwatch = Stopwatch.createUnstarted();
  private final AtomicLong connectionAvailability = new AtomicLong();

  /**
   * {@inheritDoc}
   */
  @Override
  public void incrementReceivedBytes() {
    incrementReceivedBytes(1L);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void incrementReceivedBytes(long bytes) {
    receivedBytes.addAndGet(bytes);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void incrementSentBytes() {
    sentBytes.incrementAndGet();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void incrementSentBytes(long bytes) {
    sentBytes.addAndGet(bytes);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void incrementSocketConnectAttempts() {
    connectAttempts.incrementAndGet();
    if (!upTimeStopwatch.isRunning()) {
      upTimeStopwatch.start();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void incrementSuccessfulSocketConnects() {
    successfulConnects.incrementAndGet();
    connectedStopwatch.start();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void incrementFailedSocketConnects() {
    failedConnects.incrementAndGet();
    connectedStopwatch.stop();
  }

}