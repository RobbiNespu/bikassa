
package com.eb.warehouse;

import java.util.Collection;

import javax.inject.Named;

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

public class DemoWarehousePcxStationsModule extends AbstractModule {

  public static final String STATION_JPP01 = "JPP01";
  public static final String STATION_CRS01 = "CRS01";
  public static final String STATION_CRS02 = "CRS02";
  public static final String STATION_CRS03 = "CRS03";
  public static final String STATION_CRS04 = "CRS04";
  public static final String STATION_JPP02 = "JPP02";
  public static final String STATION_JPP03 = "JPP03";
  public static final String STATION_JPP04 = "JPP04";
  public static final String STATION_JPP10 = "JPP10";
  public static final String STATION_JPP11 = "JPP11";
  public static final String STATION_JPP12 = "JPP12";

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new AnyTargetSelectingWithTuCountThresholdPcxStationModule(STATION_JPP01, ImmutableSet.of("any")) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_JPP01)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_JPP01));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP02, ImmutableSet.of("TEJP12"/*, "TEJP11"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_JPP02)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_JPP02));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP03, ImmutableSet.of("TCRS01"/*, "TEXIT"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_JPP03)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_JPP03));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP04, ImmutableSet.of("TJPP02", "TJPP10")) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_JPP04)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_JPP04));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP10, ImmutableSet.of("TJPP11"/*, "TTPS05"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_JPP10)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_JPP10));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP11, ImmutableSet.of("TJPP12"/*, "TTPS06"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_JPP11)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_JPP11));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP12, ImmutableSet.of("TJPP02", "TJPP10"/*, "TEXIT"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_JPP12)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_JPP12));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS01, ImmutableSet.of("TCRS02"/*, "TTPS01"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_CRS01)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_CRS01));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS02, ImmutableSet.of("TCRS03"/*, "TTPS02"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_CRS02)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_CRS02));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS03, ImmutableSet.of("TCRS04", "TJPP02"/*, "TTPS03"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_CRS03)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_CRS03));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS04, ImmutableSet.of("TJPP04"/*, "TTPS04"*/)) {
          /** {@inheritDoc} */
          @Override
          protected void bindPcxStation() {
            bind(PcxStation.class).annotatedWith(Names.named(STATION_CRS04)).to(PcxStationImpl.class);
          }
        });
        expose(PcxStation.class).annotatedWith(Names.named(STATION_CRS04));
      }
    });
  }

  @Provides
  Collection<PcxStation> createPcxStations(@Named(STATION_JPP01) PcxStation jpp01,
                                           @Named(STATION_JPP02) PcxStation jpp02,
                                           @Named(STATION_JPP03) PcxStation jpp03,
                                           @Named(STATION_JPP04) PcxStation jpp04,
                                           @Named(STATION_JPP10) PcxStation jpp10,
                                           @Named(STATION_JPP11) PcxStation jpp11,
                                           @Named(STATION_JPP12) PcxStation jpp12,
                                           @Named(STATION_CRS01) PcxStation crs01,
                                           @Named(STATION_CRS02) PcxStation crs02,
                                           @Named(STATION_CRS03) PcxStation crs03,
                                           @Named(STATION_CRS04) PcxStation crs04) {
    return ImmutableSet.of(jpp01, jpp02, jpp03, jpp04, jpp10, jpp11, jpp12, crs01, crs02, crs03, crs04);
  }
}
