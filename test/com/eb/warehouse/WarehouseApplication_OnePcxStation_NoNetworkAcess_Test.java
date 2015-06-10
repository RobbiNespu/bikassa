package com.eb.warehouse;

import com.eb.warehouse.io.LocalhostNetworkBaseModule;
import com.eb.warehouse.io.pcx.PcxConnection;
import com.eb.warehouse.io.pcx.PcxConnectionExposingModule;
import com.eb.warehouse.io.pcx.PcxConnectionsBaseModule;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ServiceManager;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.multibindings.Multibinder;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by eb on 09.06.2015.
 */
public class WarehouseApplication_OnePcxStation_NoNetworkAcess_Test {

    private static final String PCX_STATION_ID = "test-station-id";
    private WarehouseApplication app;

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new WarehouseApplicationBaseModule(), new LocalhostNetworkBaseModule(), new PcxConnectionsBaseModule()
                , new AbstractModule() {
            @Override
            protected void configure() {
                Multibinder<PcxConnection> m = Multibinder.newSetBinder(binder(), PcxConnection.class);
                install(new PcxConnectionExposingModule(m, PCX_STATION_ID, 9000, 8000, ImmutableSet.<String>of()));
            }
        });
        app = injector.getInstance(WarehouseApplication.class);
    }

    @Test(timeout = 5000)
    public void run2_isRunningSuccessfullyOnePcxStation() throws Exception {
        final String pcxStationId = "test-station-id";
        app.addListener(new ServiceManager.Listener() {
            @Override
            public void healthy() {
                // Let's assert state
                assertTrue(app.isHealthy());
                Set<PcxStation> pcxStations = app.getPcxStations();
                assertThat(pcxStations).hasSize(1);
                PcxStation actualStation = pcxStations.iterator().next();
                assertEquals(pcxStationId, actualStation.getStationId());

                // Shutdown test
                app.stop();
            }
        });
        app.run2();
    }
}