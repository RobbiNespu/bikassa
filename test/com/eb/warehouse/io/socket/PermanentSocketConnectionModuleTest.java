
package com.eb.warehouse.io.socket;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import javax.inject.Named;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.SendableConnectionService;
import com.eb.warehouse.io.XmlMessageListener;
import com.eb.warehouse.io.socket.PermanentSocketConnectionModule;
import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class PermanentSocketConnectionModuleTest {

  public static class TestModule extends AbstractModule {
    @Override
    protected void configure() {
      bind(Integer.class).annotatedWith(Names.named("bufferSize")).toInstance(1);
      bind(String.class).annotatedWith(Names.named("hostname")).toInstance("a");
      bind(Byte.class).toInstance((byte) 3);
      bind(Unmarshaller.class).toInstance(mock(Unmarshaller.class));
    }

    @Provides
    @Named("incoming")
    EventBus createIncomingEventBus() {
      return new EventBus();
    }
  }

  public static class TestModule2 extends TestModule {

    /** {@inheritDoc} */
    @Override
    protected void configure() {
      super.configure();
      bind(ByteMessageListener.class).to(XmlMessageListener.class);
    }

    @Provides
    @Named("internal")
    public EventBus createInternalEventBus() {
      return new EventBus();
    }
  }

  @Test
  public void inject() {
    Injector injector = Guice.createInjector(new PermanentSocketConnectionModule(2), new TestModule2());
    SendableConnectionService communication = injector.getInstance(SendableConnectionService.class);
    assertNotNull(communication);
  }
}
