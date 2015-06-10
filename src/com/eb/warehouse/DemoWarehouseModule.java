package com.eb.warehouse;

import com.eb.warehouse.io.DemoWarehousePcxNetworkCommModule;
import com.google.inject.AbstractModule;

public class DemoWarehouseModule extends AbstractModule {

  @Override
  protected void configure() {
//    install(new DemoWarehouseNgkp2NetworkCommModule());
    install(new WarehouseApplicationBaseModule());
    install(new DemoWarehousePcxNetworkCommModule());
    install(new DemoWarehousePcxStationsModule());
  }
}
