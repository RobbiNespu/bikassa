
package com.eb.warehouse.io.socket;

import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

final class SocketThreadFactory implements ThreadFactory {

  private final String hostname;
  private final int port;

  @Inject
  public SocketThreadFactory(@Named("hostname") String hostname, @Named("port") int port) {
    this.hostname = hostname;
    this.port = port;
  }

  /** {@inheritDoc} */
  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, hostname + ":" + port);
  }

}
