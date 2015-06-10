package com.eb.warehouse.io;

import com.google.inject.AbstractModule;

/**
 * Configures the warehouse's network properties that all network connections connect to the <code>hostname</code>
 * and the network's buffer size.
 */
public final class NetworkBaseModule extends AbstractModule {

    private final String hostname;

    public NetworkBaseModule(String hostname) {
        this.hostname = hostname;
    }

    @Override
    protected void configure() {
        install(new HostnameModule(hostname));
        install(new NetworkBufferSizeModule(1024));
    }
}
