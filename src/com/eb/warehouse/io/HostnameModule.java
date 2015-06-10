package com.eb.warehouse.io;

import com.eb.warehouse.io.socket.HostnameBinding;
import com.google.inject.AbstractModule;

/**
 * Configures the hostname to be the specified name or IP address string.
 */
public final class HostnameModule extends AbstractModule {

    private final String hostname;

    public HostnameModule(String hostname) {
        this.hostname = hostname;
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(HostnameBinding.class).toInstance(hostname);
    }
}
