package com.eb.warehouse.io;

import com.google.inject.AbstractModule;

/**
 * Configures the warehouse's network properties that all network connections connect to the <code>localhost</code> and the network's buffer size.
 */
public final class LocalhostNetworkBaseModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new LocalhostNameModule());
        install(new NetworkBufferSizeModule(1024));
    }
}
