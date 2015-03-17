
package com.eb.warehouse;

import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

import com.eb.warehouse.util.Service2;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class WarehouseApplication implements ServerApplication {

  /**
   * Controls the shutdown of the {@link #run2()} method.
   */
  final CountDownLatch appShutdownLatch = new CountDownLatch(1);
  private final Service2 networkConnectionsService;

  @Inject
  public WarehouseApplication(Service2 networkConnectionsService) {
    this.networkConnectionsService = networkConnectionsService;
  }

  /** {@inheritDoc} */
  @Override
  public void run2() {
    networkConnectionsService.startAsync2();
    /**
     * Blocks main thread until someone triggers shutdown of application.
     */
    Uninterruptibles.awaitUninterruptibly(appShutdownLatch);
    networkConnectionsService.stop2();
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
