
package com.eb.warehouse.io.pcx;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import javax.inject.Named;

import org.junit.Test;

import com.eb.warehouse.util.Service2;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;

public class DemoWarehousePcxConnectionsModuleTest {

  @Test
  public void inject() {
    Injector injector = Guice.createInjector(new DemoWarehousePcxConnectionsModule(), new AbstractModule() {
      @Override
      protected void configure() {
      }

      @Provides
      @Named("incoming")
      EventBus create() {
        return new EventBus();
      }
    });
    Collection<Service2> pcxConnections = injector.getInstance(Key.get(new TypeLiteral<Collection<Service2>>() {
    }));
    assertNotNull(pcxConnections);
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
