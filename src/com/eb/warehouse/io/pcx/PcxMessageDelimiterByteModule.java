package com.eb.warehouse.io.pcx;

import com.google.inject.AbstractModule;

/**
 * Configures the PCX message's delimiter byte to <code>0x1A</code>.
 */
final class PcxMessageDelimiterByteModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Byte.class).toInstance((byte) 0x1A);
    }
}
