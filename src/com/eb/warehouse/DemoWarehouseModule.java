package com.eb.warehouse;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.inject.AbstractModule;

import com.eb.warehouse.io.pcx.DemoWarehousePcxConnectionsModule;

import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DemoWarehouseModule extends AbstractModule {

//  private final EventBus outgoingEventBus = new EventBus("outgoing");
//  private final EventBus incomingEventBus = new EventBus("incoming");

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    setUpLogging();
    bind(ServerApplication.class).to(WarehouseApplication.class);
    install(new DemoWarehousePcxConnectionsModule());
    install(new DemoWarehousePcxStationsModule());

//    bind(EventBus.class).annotatedWith(Names.named("outgoing")).toInstance(outgoingEventBus);
//    bind(EventBus.class).annotatedWith(Names.named("incoming")).toInstance(incomingEventBus);

//    bindListener(new SubclassesOf(PcxStationImpl.class),
//                 new EventBusRegistrationListener(incomingEventBus));
//    bindListener(new SubclassesOf(PcxConnectionImpl.class),
//                 new EventBusRegistrationListener(outgoingEventBus));
  }

  private void setUpLogging() {
    System.setProperty("java.util.logging.SimpleFormatter.format",
                       "%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %2$s%n%4$s: %5$s%n");
    Logger logger = Logger.getGlobal();
    ConsoleHandler handler = new ConsoleHandler();
    try {
      handler.setEncoding(Charsets.UTF_8.name());
    } catch (SecurityException e) {
      Throwables.propagate(e);
    } catch (UnsupportedEncodingException e) {
      Throwables.propagate(e);
    }
    SimpleFormatter formatter = new SimpleFormatter();
    handler.setFormatter(formatter);
    logger.addHandler(handler);

    ch.qos.logback.classic.Logger
        root =
        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    root.setLevel(ch.qos.logback.classic.Level.TRACE);
  }
}
