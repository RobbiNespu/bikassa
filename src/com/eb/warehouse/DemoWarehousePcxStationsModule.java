package com.eb.warehouse;

import com.eb.warehouse.io.pcx.PcxConnections;
import com.eb.warehouse.util.OneOf;
import com.eb.warehouse.util.SubclassesOf;
import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure() {
        bindListener(new OneOf(new SubclassesOf(PcxStation.class), new SubclassesOf(PcxConnections.class)), new PcxStationEventRegistrationListener());

        Multibinder<PcxStation> pcxStationsMultibinder = Multibinder.newSetBinder(binder(), PcxStation.class);
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_JPP01,
                ImmutableSet.of("any"), new AnyTargetSelectingWithTuCountThresholdPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_JPP02,
                ImmutableSet.of("TEJP12"/* , "TEJP11" */), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_JPP03,
                ImmutableSet.of("TCRS01"/* , "TEXIT" */), new AnyTargetSelectingWithTuCountThresholdPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_JPP04,
                ImmutableSet.of("TJPP02", "TJPP10"), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_JPP10,
                ImmutableSet.of("TJPP11"/* , "TTPS05" */), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_JPP11,
                ImmutableSet.of("TJPP12"/* , "TTPS06" */), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_JPP12,
                ImmutableSet.of("TJPP02", "TJPP10"/* , "TEXIT" */), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_CRS01,
                ImmutableSet.of("TCRS02"/* , "TTPS01" */), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_CRS02,
                ImmutableSet.of("TCRS03"/* , "TTPS02" */), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_CRS03,
                ImmutableSet.of("TCRS04", "TJPP02"/* , "TTPS03" */), new RandomTargetSelectingPcxStationModule()));
        install(new PcxStationImplModule(pcxStationsMultibinder, STATION_CRS04,
                ImmutableSet.of("TJPP04"/* , "TTPS04" */), new RandomTargetSelectingPcxStationModule()));
    }
}
