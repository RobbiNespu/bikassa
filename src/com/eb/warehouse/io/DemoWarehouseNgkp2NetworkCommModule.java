package com.eb.warehouse.io;

import com.google.inject.AbstractModule;

import com.eb.warehouse.io.ngkp.DemoWarehouseNgkp2ConnectionsModule;

/**
 * Created by ebe on 25.03.2015.
 */
public class DemoWarehouseNgkp2NetworkCommModule
    extends AbstractModule {

  @Override
  protected void configure() {
    install(new DemoWarehouseNetworkCommModule());
    install(new DemoWarehouseNgkp2ConnectionsModule());
  }

}
