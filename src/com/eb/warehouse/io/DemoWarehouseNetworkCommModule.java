package com.eb.warehouse.io;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import com.eb.warehouse.io.socket.HostnameBinding;

/**
 * Created by ebe on 25.03.2015.
 */
final class DemoWarehouseNetworkCommModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).annotatedWith(HostnameBinding.class).toInstance("localhost");
    bind(Integer.class).annotatedWith(Names.named("bufferSize")).toInstance(1024);
  }
}
