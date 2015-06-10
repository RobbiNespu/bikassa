package com.eb.warehouse;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.Uninterruptibles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class WarehouseApplication implements ServerApplication {

  private static final Logger L = LoggerFactory.getLogger(WarehouseApplication.class);
  /**
   * Controls the shutdown of the {@link #run2()} method.
   */
  final CountDownLatch appShutdownLatch = new CountDownLatch(1);
  private final ServiceManager hardwareCommunication;

  @Inject
  public WarehouseApplication(ServiceManager hardwareCommunication) {
    this.hardwareCommunication = hardwareCommunication;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run2() {
    L.info("Starting warehouse application.");
    hardwareCommunication.startAsync();
    /**
     * Blocks main thread until someone triggers shutdown of application.
     */
    Uninterruptibles.awaitUninterruptibly(appShutdownLatch);
    stop();
    // TODO: add timeout and shutdown hook listener.
  }

  /**
   * Stop the running warehouse application. If not running nothing is done.
   */
  @VisibleForTesting
  void stop() {
    hardwareCommunication.stopAsync();
    hardwareCommunication.awaitStopped();
  }

  /**
   * Indicate whether the warehouse application is running successfully with no errors.
   *
   * @return
   */
  @VisibleForTesting
  boolean isHealthy() {
    return hardwareCommunication.isHealthy();
  }

  @VisibleForTesting
  void addListener(ServiceManager.Listener listener) {
    hardwareCommunication.addListener(listener);
  }

  @VisibleForTesting
  Set<PcxStation> getPcxStations() {
    return null;
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
