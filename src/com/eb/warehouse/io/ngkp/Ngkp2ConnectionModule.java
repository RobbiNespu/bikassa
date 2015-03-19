
package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.socket.ReconnectingSocketConnectionModule;
import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.google.inject.name.Names;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class Ngkp2ConnectionModule extends AbstractModule {

  private final int port;

  public Ngkp2ConnectionModule(int port) {
    this.port = port;
  }

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new ReconnectingSocketConnectionModule(port) {
          @Override
          protected void configureBinding(Class<SocketConnection> def, Class<? extends SocketConnection> impl) {
            bind(def).annotatedWith(Names.named("ngkp-test")).to(impl);
          }
        });
        expose(SocketConnection.class);
      }
    });
  }

}