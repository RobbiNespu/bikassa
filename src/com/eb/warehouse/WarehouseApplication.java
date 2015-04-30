package com.eb.warehouse;

import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.Uninterruptibles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

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
    hardwareCommunication.stopAsync();
    hardwareCommunication.awaitStopped(); // TODO: add timeout and shutdown hook listener.
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
