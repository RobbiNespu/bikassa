
package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.SendableConnectionService;
import com.eb.warehouse.io.socket.PermanentSocketConnectionModule;
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
        install(new PermanentSocketConnectionModule(port) {
          @Override
          protected void configureBinding(Class<SendableConnectionService> def, Class<? extends SendableConnectionService> impl) {
            bind(def).annotatedWith(Names.named("ngkp-test")).to(impl);
          }
        });
        expose(SendableConnectionService.class);
      }
    });
  }

}