package com.eb.warehouse;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.Set;

public final class DemoWarehouseApplicationBootstrapper {

  private DemoWarehouseApplicationBootstrapper() {
  }

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new DemoWarehouseModule());
    ServerApplication app = injector.getInstance(ServerApplication.class);
    injector.getInstance(Key.get(new TypeLiteral<Set<PcxStation>>() {
    }));
    app.run2();
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
