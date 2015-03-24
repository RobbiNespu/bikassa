package com.eb.warehouse.io.ngkp;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.socket.PermanentSocketConnectionModule;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class Ngkp2ConnectionModule extends AbstractModule {

  private final int port;

  public Ngkp2ConnectionModule(int port) {
    this.port = port;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PermanentSocketConnectionModule(port, new EventBus(),
                                                    Key.get(SocketConnection.class),
                                                    Void.class));
        expose(SocketConnection.class);
      }
    });
  }

}