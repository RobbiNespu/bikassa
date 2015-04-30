package com.eb.warehouse.io.ngkp;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.ByteStreamConsumer;
import com.eb.warehouse.io.socket.AutoConnectSocketConnectionModule;
import com.eb.warehouse.io.socket.SocketConnection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

/**
 * <p> TODO </p>
 */
public class Ngkp2TelegramIntegrationTest {

  @Test
  @Ignore
  public void test2() {
    Injector injector =
        Guice.createInjector(new AutoConnectSocketConnectionModule(),
                             new TestModule());
    SocketConnection connectionService =
        injector.getInstance(SocketConnection.class);
    connectionService.startAsync2();
    Uninterruptibles.sleepUninterruptibly(100, TimeUnit.SECONDS);
  }

  private static class TestModule extends AbstractModule {

    @Override
    protected void configure() {
      bind(Integer.class).annotatedWith(Names.named("bufferSize")).toInstance(300);
      bind(String.class).annotatedWith(Names.named("hostname")).toInstance("localhost");
      bind(ByteMessageListener.class).to(Ngkp2MessageParser.class);
      bind(ByteStreamConsumer.class).to(Ngkp2SlicingByteStreamConsumer.class);
      bind(String.class).annotatedWith(Names.named("threadName")).toInstance("thread");
    }

    @Provides
    @Named("internal")
    EventBus createInternalEventBus() {
      return new EventBus();
    }

    @Provides
    @Named("incoming")
    EventBus createIncomingEventBus() {
      return new EventBus();
    }
  }
}
