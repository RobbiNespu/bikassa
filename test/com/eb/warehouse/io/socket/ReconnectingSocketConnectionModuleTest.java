package com.eb.warehouse.io.socket;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.XmlMessageListener;

import org.junit.Test;

import javax.inject.Named;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class ReconnectingSocketConnectionModuleTest {

  @Test
  public void inject() {
    Injector injector = Guice.createInjector(new PermanentSocketConnectionModule(2,
                                                                                 new EventBus(),
                                                                                 Key.get(
                                                                                     SocketConnection.class),
                                                                                 Void.class),
                                             new TestModule2());
    SocketConnection communication = injector.getInstance(SocketConnection.class);
    assertNotNull(communication);
  }

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

    /**
     * {@inheritDoc}
     */
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
}
