package com.eb.warehouse.io.pcx;

import com.eb.warehouse.io.NetworkBaseModule;
import com.google.inject.multibindings.Multibinder;

import java.util.Set;

/**
 * Created by eb on 10.06.2015.
 */
public class PcxConnectionWithHostModule extends PcxConnectionWithoutHostModule {

    private final String hostname;

    public PcxConnectionWithHostModule(Multibinder<PcxConnection> multibinder, String connectionId, String hostname
            , int commandPort, int statusPort, Set<String> stationIds) {
        super(multibinder, connectionId, commandPort, statusPort, stationIds);
        this.hostname = hostname;
    }

    @Override
    protected void configure() {
        super.configure();
        install(new NetworkBaseModule(hostname));
        exposeTo(binder());
    }
}
