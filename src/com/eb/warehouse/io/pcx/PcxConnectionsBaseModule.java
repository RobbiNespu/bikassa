package com.eb.warehouse.io.pcx;

import com.eb.warehouse.util.EventConsumer;
import com.google.inject.AbstractModule;

import javax.inject.Singleton;

/**
 * Configures classes of PCX connections that all share and creates a Multibinder to expose a set of Service instances each of them representing one PCX connection.
 */
public final class PcxConnectionsBaseModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JaxbPcxMessageMarshallerModule());
        install(new PcxMessageDelimiterByteModule());

        bind(PcxConnectionsImpl.class).in(Singleton.class);
        bind(PcxConnections.class).to(PcxConnectionsImpl.class);
        bind(PcxMessageSender.class).to(PcxConnectionsImpl.class);
        bind(EventConsumer.class).to(PcxConnectionsImpl.class);
    }
}
