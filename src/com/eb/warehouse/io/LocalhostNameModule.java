package com.eb.warehouse.io;

import com.eb.warehouse.io.socket.HostnameBinding;
import com.google.inject.AbstractModule;

/**
 * Configures the hostname to be the <code>localhost</code>.
 */
public final class LocalhostNameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(HostnameBinding.class).toInstance("localhost");
    }
}
