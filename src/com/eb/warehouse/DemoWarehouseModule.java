package com.eb.warehouse;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import com.eb.warehouse.io.DemoWarehousePcxNetworkCommModule;

import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DemoWarehouseModule extends AbstractModule {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    setUpLogging();
    bind(ServerApplication.class).to(WarehouseApplication.class);
//    install(new DemoWarehouseNgkp2NetworkCommModule());
    install(new DemoWarehousePcxNetworkCommModule());
    install(new DemoWarehousePcxStationsModule());
  }

  @Provides
  ServiceManager provideNetworkCommServiceManager(Set<Service> networkCommServices) {
    return new ServiceManager(networkCommServices);
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
