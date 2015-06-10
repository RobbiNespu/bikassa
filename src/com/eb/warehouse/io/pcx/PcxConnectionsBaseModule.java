package com.eb.warehouse.io.pcx;

import com.eb.warehouse.util.EventConsumer;
import com.google.common.util.concurrent.Service;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

import javax.inject.Singleton;

/**
 * Configures PCX connections including classes that all connections share. It uses a Multibinder to expose a set of Service instances each of them representing one PCX connection.
 */
public final class PcxConnectionsBaseModule extends AbstractModule {

    private static final String PCX_COMM = "pcx-comm";
    private static final Key<Service> PCX_COMM_KEY = Key.get(Service.class, Names.named(PCX_COMM));

    @Override
    protected void configure() {
        install(new JaxbPcxMessageMarshallerModule());
        install(new PcxMessageDelimiterByteModule());

        bind(PcxCommunication.class).in(Singleton.class);
        bind(PCX_COMM_KEY).to(PcxCommunication.class);
        bind(PcxMessageSender.class).to(PcxCommunication.class);
        bind(EventConsumer.class).to(PcxCommunication.class);

        Multibinder<Service> networkCommServicesMultibinder =
                Multibinder.newSetBinder(binder(), Service.class);
        networkCommServicesMultibinder.addBinding().to(PCX_COMM_KEY);
    }
}
