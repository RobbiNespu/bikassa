package com.eb.warehouse.io.ngkp;

import com.google.inject.AbstractModule;
import com.google.inject.Key;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class DemoWarehouseNgkp2ConnectionsModule extends AbstractModule {

  private static final Key<Ngkp2Connection>
      MINILOAD_01_BINDING_KEY =
      Key.get(Ngkp2Connection.class);
  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
//    bind(Service2.class).to(NgkpCommunication.class);
//    install(new Ngkp2ConnectionModule(2011, 2012, MINILOAD_01_BINDING_KEY));
//    final Multibinder<Ngkp2Connection>
//        multibinder =
//        Multibinder.newSetBinder(binder(), Ngkp2Connection.class);
//    multibinder.addBinding().to(MINILOAD_01_BINDING_KEY);
  }

}