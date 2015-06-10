package com.eb.warehouse.io;

import com.eb.warehouse.io.pcx.DemoWarehousePcxConnectionsModule;
import com.google.inject.AbstractModule;

/**
 * Created by ebe on 25.03.2015.
 */
public class DemoWarehousePcxNetworkCommModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new LocalhostNetworkBaseModule());
    install(new DemoWarehousePcxConnectionsModule());
  }
}
