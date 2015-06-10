package com.eb.warehouse.io.pcx;

import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import static com.eb.warehouse.DemoWarehousePcxStationsModule.*;

public final class DemoWarehousePcxConnectionsModule extends AbstractModule {

    private static final String PCX1 = "pcx1";
    private static final String PCX2 = "pcx2";
    private static final String PCX3 = "pcx3";
    private static final String PCX4 = "pcx4";

    @Override
    protected void configure() {
        install(new PcxConnectionsBaseModule());

        Multibinder<PcxConnection> pcxConnectionsMultibinder =
                Multibinder.newSetBinder(binder(), PcxConnection.class);
        install(new PcxConnectionWithoutHostModule(pcxConnectionsMultibinder, PCX1, 9200, 8888, ImmutableSet.of(STATION_JPP01,
                STATION_JPP02,
                STATION_JPP03,
                STATION_JPP04,
                STATION_CRS01,
                STATION_CRS02,
                STATION_CRS03,
                STATION_CRS04)));
        install(new PcxConnectionWithoutHostModule(pcxConnectionsMultibinder, PCX2, 9201, 8889, ImmutableSet.of("AIP01")));
        install(new PcxConnectionWithoutHostModule(pcxConnectionsMultibinder, PCX3, 9202, 8890,
                ImmutableSet.of(STATION_JPP10, STATION_JPP11, STATION_JPP12)));
        install(new PcxConnectionWithoutHostModule(pcxConnectionsMultibinder, PCX4, 9203, 8891, ImmutableSet.<String>of()));
    }
}