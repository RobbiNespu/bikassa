package com.eb.warehouse;

import com.eb.warehouse.io.NetworkBaseModule;
import com.eb.warehouse.io.pcx.PcxConnection;
import com.eb.warehouse.io.pcx.PcxConnectionWithHostModule;
import com.eb.warehouse.io.pcx.PcxConnectionWithoutHostModule;
import com.eb.warehouse.io.pcx.PcxConnectionsBaseModule;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.multibindings.Multibinder;
import org.junit.Before;
import org.junit.Test;

import java.net.Socket;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

/**
 * Created by eb on 09.06.2015.
 */
public class WarehouseApplication_NoNetworkAccess_Test {

    private static final ImmutableSet<String> NO_STRINGS = ImmutableSet.of();
    private Module sameHostConnModule;
    private Module noHostConnModule;
    private Module mockSocketModule;
    private Socket mockSocket;

    @Before
    public void setUp() throws Exception {
        sameHostConnModule = new AbstractModule() {
            @Override
            protected void configure() {
                install(new WarehouseApplicationBaseModule());
                install(new NetworkBaseModule("somehost.me"));
                install(new PcxConnectionsBaseModule());
            }
        };
        noHostConnModule = new AbstractModule() {
            @Override
            protected void configure() {
                install(new WarehouseApplicationBaseModule());
                install(new PcxConnectionsBaseModule());
            }
        };
        mockSocket = mock(Socket.class);
        mockSocketModule = new AbstractModule() {
            @Override
            protected void configure() {
                bind(Socket.class).toInstance(mockSocket);
            }
        };
    }

    @Test(timeout = 5000)
    public void run2_onePcxConnection_isHealthyAfterStarted() throws Exception {
        Injector injector = Guice.createInjector(sameHostConnModule
                , new AbstractModule() {
            @Override
            protected void configure() {
                Multibinder<PcxConnection> m = Multibinder.newSetBinder(binder(), PcxConnection.class);
                install(new PcxConnectionWithoutHostModule(m, "test-pcx-conn", 0, 0, NO_STRINGS));
            }
        }, mockSocketModule);
        WarehouseApplication app = injector.getInstance(WarehouseApplication.class);
        runAppAndAssertHealthy(app);
    }

    private void runAppAndAssertHealthy(WarehouseApplication app) {
        AssertionListener listener = new AssertionListener(app);
        app.addListener(listener);
        app.run2();
        assertFalse(listener.hasError);
    }

    @Test(timeout = 10000)
    public void run2_twoPcxConnectionsOnSameHost_isHealthyAfterStarted() throws Exception {
        Injector injector = Guice.createInjector(sameHostConnModule
                , new AbstractModule() {
            @Override
            protected void configure() {
                Multibinder<PcxConnection> m = Multibinder.newSetBinder(binder(), PcxConnection.class);
                install(new PcxConnectionWithoutHostModule(m, "test-pcx1-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx2-conn", 0, 0, NO_STRINGS));
            }
        }, mockSocketModule);
        WarehouseApplication app = injector.getInstance(WarehouseApplication.class);
        runAppAndAssertHealthy(app);
    }

    @Test(timeout = 10000)
    public void run2_twoPcxConnectionsOnDifferentHosts_isHealthyAfterStarted() throws Exception {
        Injector injector = Guice.createInjector(noHostConnModule
                , new AbstractModule() {
            @Override
            protected void configure() {
                final Multibinder<PcxConnection> mb = Multibinder.newSetBinder(binder(), PcxConnection.class);
                install(new PcxConnectionWithHostModule(mb, "test-pcx1-conn", "firstHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx2-conn", "secondHost.me", 0, 0, NO_STRINGS));
            }
        }, mockSocketModule);
        WarehouseApplication app = injector.getInstance(WarehouseApplication.class);
        runAppAndAssertHealthy(app);
    }

    @Test(timeout = 20000)
    public void run2_ninePcxConnectionsOnSameHost_isHealthyAfterStarted() throws Exception {
        Injector injector = Guice.createInjector(sameHostConnModule
                , new AbstractModule() {
            @Override
            protected void configure() {
                Multibinder<PcxConnection> m = Multibinder.newSetBinder(binder(), PcxConnection.class);
                install(new PcxConnectionWithoutHostModule(m, "test-pcx1-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx2-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx3-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx4-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx5-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx6-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx7-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx8-conn", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithoutHostModule(m, "test-pcx9-conn", 0, 0, NO_STRINGS));
            }
        }, mockSocketModule);
        WarehouseApplication app = injector.getInstance(WarehouseApplication.class);
        runAppAndAssertHealthy(app);
    }

    @Test(timeout = 30000)
    public void run2_ninePcxConnectionsOnDifferentHosts_isHealthyAfterStarted() throws Exception {
        Injector injector = Guice.createInjector(noHostConnModule
                , new AbstractModule() {
            @Override
            protected void configure() {
                final Multibinder<PcxConnection> mb = Multibinder.newSetBinder(binder(), PcxConnection.class);
                install(new PcxConnectionWithHostModule(mb, "test-pcx1-conn", "firstHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx2-conn", "secondHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx3-conn", "thirdHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx4-conn", "fourthHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx5-conn", "fifthHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx6-conn", "sixthHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx7-conn", "seventhHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx8-conn", "eighthHost.me", 0, 0, NO_STRINGS));
                install(new PcxConnectionWithHostModule(mb, "test-pcx9-conn", "ninethHost.me", 0, 0, NO_STRINGS));
            }
        }, mockSocketModule);
        WarehouseApplication app = injector.getInstance(WarehouseApplication.class);
        runAppAndAssertHealthy(app);
    }

    private static final class AssertionListener extends ServiceManager.Listener {
        WarehouseApplication app;
        boolean hasError;

        AssertionListener(WarehouseApplication app) {
            this.app = app;
        }

        @Override
        public void healthy() {
            // No errors occurred. Let's shutdown app to finish test.
            app.triggerStop2();
        }

        @Override
        public void failure(Service service) {
            // We don't expect any errors. Test failed.
            hasError = true;
            app.triggerStop2();
        }
    }
}