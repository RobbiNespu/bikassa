package com.eb.warehouse;

import com.google.common.util.concurrent.Uninterruptibles;

import com.eb.warehouse.util.Service2;

import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class WarehouseApplication implements ServerApplication {

  /**
   * Controls the shutdown of the {@link #run2()} method.
   */
  final CountDownLatch appShutdownLatch = new CountDownLatch(1);
  private final Service2 hardwareCommunication;

  @Inject
  public WarehouseApplication(Service2 hardwareCommunication) {
    this.hardwareCommunication = hardwareCommunication;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run2() {
    hardwareCommunication.startAsync2();
    /**
     * Blocks main thread until someone triggers shutdown of application.
     */
    Uninterruptibles.awaitUninterruptibly(appShutdownLatch);
    hardwareCommunication.stop2();
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
