
package com.eb.warehouse.io.ngkp;

import com.google.inject.AbstractModule;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class DemoWarehouseNgkp2ConnectionsModule extends AbstractModule {

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    install(new Ngkp2ConnectionModule(2301));
  }

}