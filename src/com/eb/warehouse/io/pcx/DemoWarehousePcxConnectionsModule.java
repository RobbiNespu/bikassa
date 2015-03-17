
package com.eb.warehouse.io.pcx;

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

import java.util.Collection;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.assertj.core.util.Sets;

import com.eb.warehouse.io.pcx.message.Action;
import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.IoChange;
import com.eb.warehouse.io.pcx.message.Life;
import com.eb.warehouse.io.pcx.message.Query;
import com.eb.warehouse.io.pcx.message.Remove;
import com.eb.warehouse.io.pcx.message.Request;
import com.eb.warehouse.io.pcx.message.Response;
import com.eb.warehouse.io.pcx.message.Status;
import com.eb.warehouse.util.Service2;
import com.eb.warehouse.util.ServicesManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class DemoWarehousePcxConnectionsModule extends AbstractModule {

  private static String createLifeSenderThreadName(String a) {
    return a + "-life-sender";
  }

  private static final String PCX1 = "pcx1";
  private static final String PCX2 = "pcx2";
  private static final String PCX3 = "pcx3";
  private static final String PCX4 = "pcx4";

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    bind(ServicesManager.class).in(Singleton.class);
    bind(Service2.class).to(ServicesManager.class);

    bind(String.class).annotatedWith(Names.named("hostname")).toInstance("localhost");
    bind(Integer.class).annotatedWith(Names.named("bufferSize")).toInstance(1024);
    bind(Byte.class).toInstance((byte) 0x1A);

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PcxConnectionModule(9200, 8888, ImmutableSet.of(STATION_JPP01,
                                                                    STATION_JPP02,
                                                                    STATION_JPP03,
                                                                    STATION_JPP04,
                                                                    STATION_CRS01,
                                                                    STATION_CRS02,
                                                                    STATION_CRS03,
                                                                    STATION_CRS04), createLifeSenderThreadName(PCX1)) {
          @Override
          protected void bindPcxConnection() {
            bind(Service2.class).annotatedWith(Names.named(PCX1)).to(PcxConnection.class);
          }
        });
        expose(Service2.class).annotatedWith(Names.named(PCX1));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PcxConnectionModule(9201, 8889, ImmutableSet.of("AIP01"), createLifeSenderThreadName(PCX2)) {
          @Override
          protected void bindPcxConnection() {
            bind(Service2.class).annotatedWith(Names.named(PCX2)).to(PcxConnection.class);
          }
        });
        expose(Service2.class).annotatedWith(Names.named(PCX2));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PcxConnectionModule(9202, 8890, ImmutableSet.of(STATION_JPP10, STATION_JPP11, STATION_JPP12), createLifeSenderThreadName(PCX3)) {
          @Override
          protected void bindPcxConnection() {
            bind(Service2.class).annotatedWith(Names.named(PCX3)).to(PcxConnection.class);
          }
        });
        expose(Service2.class).annotatedWith(Names.named(PCX3));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PcxConnectionModule(9203, 8891, Sets.<String> newHashSet(), createLifeSenderThreadName(PCX4)) {
          @Override
          protected void bindPcxConnection() {
            bind(Service2.class).annotatedWith(Names.named(PCX4)).to(PcxConnection.class);
          }
        });
        expose(Service2.class).annotatedWith(Names.named(PCX4));
      }
    });
  }

  @Provides
  Collection<Service2> createPcxConnections(@Named(PCX1) Service2 pcx1Conn,
                                            @Named(PCX2) Service2 pcx2Conn,
                                            @Named(PCX3) Service2 pcx3Conn,
                                            @Named(PCX4) Service2 pcx4Conn) {
    return ImmutableList.of(pcx1Conn, pcx2Conn, pcx3Conn, pcx4Conn);
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