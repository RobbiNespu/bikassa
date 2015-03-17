
package com.eb.warehouse.io;

import java.io.IOException;

import com.eb.warehouse.util.Service2;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public interface SendableConnectionService extends Service2 {

  /**
   * TODO JavaDoc according to WAMAS C conventions
   *
   * @param ab
   */
  void send(byte[] bytes) throws IOException;

}
