package com.eb.warehouse.io.pcx;

import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

import com.eb.warehouse.io.pcx.message.Action;
import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.IoChange;
import com.eb.warehouse.io.pcx.message.Life;
import com.eb.warehouse.io.pcx.message.Query;
import com.eb.warehouse.io.pcx.message.Remove;
import com.eb.warehouse.io.pcx.message.Request;
import com.eb.warehouse.io.pcx.message.Response;
import com.eb.warehouse.io.pcx.message.Status;
import com.eb.warehouse.util.EventConsumer;
import com.eb.warehouse.util.Service2;

import java.util.Set;

import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_CRS01;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_CRS02;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_CRS03;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_CRS04;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_JPP01;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_JPP02;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_JPP03;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_JPP04;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_JPP10;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_JPP11;
import static com.eb.warehouse.DemoWarehousePcxStationsModule.STATION_JPP12;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class DemoWarehousePcxConnectionsModule extends AbstractModule {

  private static final String PCX1 = "pcx1";
  private static final String PCX2 = "pcx2";
  private static final String PCX3 = "pcx3";
  private static final String PCX4 = "pcx4";

  private static final Key<PcxConnection>
      PCX_1_KEY =
      Key.get(PcxConnection.class, Names.named("pcx1"));
  private static final Key<PcxConnection>
      PCX_2_KEY =
      Key.get(PcxConnection.class, Names.named("pcx2"));
  private static final Key<PcxConnection>
      PCX_3_KEY =
      Key.get(PcxConnection.class, Names.named("pcx3"));
  private static final Key<PcxConnection>
      PCX_4_KEY =
      Key.get(PcxConnection.class, Names.named("pcx4"));

  private static void bindPcxParams(Binder binder, int cmdPort, int statusPort, String connName,
                                    Set<String> stationIds) {
    binder.bind(Integer.class).annotatedWith(Names.named(PcxConnectionModule.COMMAND_PORT_BINDING))
        .toInstance(cmdPort);
    binder.bind(Integer.class).annotatedWith(Names.named(PcxConnectionModule.STATUS_PORT_BINDING))
        .toInstance(statusPort);
    binder.bind(String.class)
        .annotatedWith(Names.named(PcxConnectionModule.CONNECTION_NAME_BINDING))
        .toInstance(connName);
    binder.bind(new TypeLiteral<Set<String>>() {
    }).toInstance(stationIds);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(PcxCommunication.class).in(Singleton.class);
    bind(Service2.class).to(PcxCommunication.class);
    bind(PcxMessageSender.class).to(PcxCommunication.class);
    bind(EventConsumer.class).to(PcxCommunication.class);

    bind(Byte.class).toInstance((byte) 0x1A);

    install(new PrivateModule() {
      @Override
      protected void configure() {
        bindPcxParams(binder(), 9200, 8888, PCX1, ImmutableSet.of(STATION_JPP01,
                                                                  STATION_JPP02,
                                                                  STATION_JPP03,
                                                                  STATION_JPP04,
                                                                  STATION_CRS01,
                                                                  STATION_CRS02,
                                                                  STATION_CRS03,
                                                                  STATION_CRS04));
        install(new PcxConnectionModule(PCX_1_KEY));
        expose(PCX_1_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        bindPcxParams(binder(), 9201, 8889, PCX2, ImmutableSet.of("AIP01"));
        install(new PcxConnectionModule(PCX_2_KEY));
        expose(PCX_2_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        bindPcxParams(binder(), 9202, 8890, PCX3,
                      ImmutableSet.of(STATION_JPP10, STATION_JPP11, STATION_JPP12));
        install(new PcxConnectionModule(PCX_3_KEY));
        expose(PCX_3_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        bindPcxParams(binder(), 9203, 8891, PCX4, ImmutableSet.<String>of());
        install(new PcxConnectionModule(PCX_4_KEY));
        expose(PCX_4_KEY);
      }
    });

    Multibinder<PcxConnection> pcxConnectionsMultibinder =
        Multibinder.newSetBinder(binder(), PcxConnection.class);
    pcxConnectionsMultibinder.addBinding().to(PCX_1_KEY);
    pcxConnectionsMultibinder.addBinding().to(PCX_2_KEY);
    pcxConnectionsMultibinder.addBinding().to(PCX_3_KEY);
    pcxConnectionsMultibinder.addBinding().to(PCX_4_KEY);
  }

  @Provides
  JAXBContext bindJaxbClasses() throws JAXBException {
    Class<?>[] classesToBeBound = { //
                                    Action.class, //
                                    Announce.class, //
                                    IoChange.class, //
                                    Life.class, //
                                    Query.class, //
                                    Remove.class, //
                                    Response.class, //
                                    Request.class, //
                                    Status.class, //
    };

    return JAXBContext.newInstance(classesToBeBound);
  }

  @Provides
  Marshaller createMarshaller(JAXBContext cxt) throws JAXBException {
    //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    return cxt.createMarshaller();
  }

  @Provides
  Unmarshaller createUnmarshaller(JAXBContext cxt) throws JAXBException {
    return cxt.createUnmarshaller();
  }
}