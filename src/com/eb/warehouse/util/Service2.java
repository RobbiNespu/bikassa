package com.eb.warehouse.util;

import com.google.common.util.concurrent.Service;

/**
 * <p> Service that is simpler than Guava's {@link Service}. </p> <p> It provides only two methods
 * to start and stop the service. </p>
 */

public interface Service2 {

  /**
   * Start the service asynchronously. This method returns immediately.
   */
  void startAsync2();

  /**
   * Stop the service. This method returns when the service has been stopped.
   */
  void stop2();
}
