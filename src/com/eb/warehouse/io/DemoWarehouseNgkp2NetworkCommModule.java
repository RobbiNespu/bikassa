package com.eb.warehouse.io;

import com.eb.warehouse.io.ngkp.DemoWarehouseNgkp2ConnectionsModule;
import com.google.inject.AbstractModule;

/**
 * Created by ebe on 25.03.2015.
 */
public class DemoWarehouseNgkp2NetworkCommModule
    extends AbstractModule {

  @Override
  protected void configure() {
    install(new NetworkBaseModule("localhost"));
    install(new DemoWarehouseNgkp2ConnectionsModule());
  }

}
