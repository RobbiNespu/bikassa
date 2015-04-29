package com.eb.warehouse.io;

import com.google.inject.AbstractModule;

import com.eb.warehouse.io.pcx.DemoWarehousePcxConnectionsModule;

/**
 * Created by ebe on 25.03.2015.
 */
public class DemoWarehousePcxNetworkCommModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new DemoWarehouseNetworkCommModule());
    install(new DemoWarehousePcxConnectionsModule());
  }
}
