package com.eb.warehouse;

import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class DemoWarehousePcxStationsModule extends AbstractModule {

  public static final String STATION_CRS01 = "CRS01";
  public static final String STATION_CRS02 = "CRS02";
  public static final String STATION_CRS03 = "CRS03";
  public static final String STATION_CRS04 = "CRS04";
  public static final String STATION_JPP01 = "JPP01";
  public static final String STATION_JPP02 = "JPP02";
  public static final String STATION_JPP03 = "JPP03";
  public static final String STATION_JPP04 = "JPP04";
  public static final String STATION_JPP10 = "JPP10";
  public static final String STATION_JPP11 = "JPP11";
  public static final String STATION_JPP12 = "JPP12";


  private static final Key<PcxStation>
      STATION_CRS01_KEY =
      Key.get(PcxStation.class, Names.named(STATION_CRS01));
  private static final Key<PcxStation>
      STATION_CRS02_KEY =
      Key.get(PcxStation.class, Names.named(STATION_CRS02));
  private static final Key<PcxStation>
      STATION_CRS03_KEY =
      Key.get(PcxStation.class, Names.named(STATION_CRS03));
  private static final Key<PcxStation>
      STATION_CRS04_KEY =
      Key.get(PcxStation.class, Names.named(STATION_CRS04));
  private static final Key<PcxStation>
      STATION_JPP01_KEY =
      Key.get(PcxStation.class, Names.named(STATION_JPP01));
  private static final Key<PcxStation>
      STATION_JPP02_KEY =
      Key.get(PcxStation.class, Names.named(STATION_JPP02));
  private static final Key<PcxStation>
      STATION_JPP03_KEY =
      Key.get(PcxStation.class, Names.named(STATION_JPP03));
  private static final Key<PcxStation>
      STATION_JPP04_KEY =
      Key.get(PcxStation.class, Names.named(STATION_JPP04));
  private static final Key<PcxStation>
      STATION_JPP10_KEY =
      Key.get(PcxStation.class, Names.named(STATION_JPP10));
  private static final Key<PcxStation>
      STATION_JPP11_KEY =
      Key.get(PcxStation.class, Names.named(STATION_JPP11));
  private static final Key<PcxStation>
      STATION_JPP12_KEY =
      Key.get(PcxStation.class, Names.named(STATION_JPP12));


  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bindListener(Matchers.any(), new PcxStationEventRegistrationListener());

    Multibinder<PcxStation>
        pcxStationsMultibinder =
        Multibinder.newSetBinder(binder(), PcxStation.class);
    pcxStationsMultibinder.addBinding().to(STATION_JPP01_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_JPP02_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_JPP03_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_JPP04_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_JPP10_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_JPP11_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_JPP12_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_CRS01_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_CRS02_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_CRS03_KEY);
    pcxStationsMultibinder.addBinding().to(STATION_CRS04_KEY);

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new AnyTargetSelectingWithTuCountThresholdPcxStationModule(STATION_JPP01,
                                                                           ImmutableSet.of("any"),
                                                                           STATION_JPP01_KEY));
        expose(STATION_JPP01_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP02,
                                                          ImmutableSet
                                                              .of("TEJP12"/* , "TEJP11" */),
                                                          STATION_JPP02_KEY));
        expose(STATION_JPP02_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP03,
                                                          ImmutableSet
                                                              .of("TCRS01"/* , "TEXIT" */),
                                                          STATION_JPP03_KEY));
        expose(STATION_JPP03_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP04, ImmutableSet.of("TJPP02",
                                                                                         "TJPP10"),
                                                          STATION_JPP04_KEY));
        expose(STATION_JPP04_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP10,
                                                          ImmutableSet
                                                              .of("TJPP11"/* , "TTPS05" */),
                                                          STATION_JPP10_KEY));
        expose(STATION_JPP10_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP11,
                                                          ImmutableSet
                                                              .of("TJPP12"/* , "TTPS06" */),
                                                          STATION_JPP11_KEY));
        expose(STATION_JPP11_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_JPP12, ImmutableSet.of("TJPP02",
                                                                                         "TJPP10"/* , "TEXIT" */),
                                                          STATION_JPP12_KEY));
        expose(STATION_JPP12_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS01,
                                                          ImmutableSet
                                                              .of("TCRS02"/* , "TTPS01" */),
                                                          STATION_CRS01_KEY));
        expose(STATION_CRS01_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS02,
                                                          ImmutableSet
                                                              .of("TCRS03"/* , "TTPS02" */),
                                                          STATION_CRS02_KEY));
        expose(STATION_CRS02_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS03, ImmutableSet.of("TCRS04",
                                                                                         "TJPP02"/* , "TTPS03" */),
                                                          STATION_CRS03_KEY));
        expose(STATION_CRS03_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new RandomTargetSelectingPcxStationModule(STATION_CRS04,
                                                          ImmutableSet
                                                              .of("TJPP04"/* , "TTPS04" */),
                                                          STATION_CRS04_KEY));
        expose(STATION_CRS04_KEY);
      }
    });
  }
}
