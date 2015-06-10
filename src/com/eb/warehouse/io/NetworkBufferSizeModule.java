package com.eb.warehouse.io;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Configures the network's buffer size.
 */
public final class NetworkBufferSizeModule extends AbstractModule {

    private final int size;

    public NetworkBufferSizeModule(int size) {
        this.size = size;
    }

    @Override
    protected void configure() {
        bind(Integer.class).annotatedWith(Names.named(NamedBindings.BUFFER_SIZE_BINDING)).toInstance(
                size);
    }
}
