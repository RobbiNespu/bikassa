package com.eb.warehouse.io.pcx;

import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

import java.util.Set;

/**
 * Configures a PCX station connection with the parameters specific to one station.
 * <p>It's a private module that keeps the connection ID, all port numbers, target station IDs and other variables private to the station and only exposes the PCX connection instance.</p>
 */
public final class PcxConnectionExposingModule extends PrivateModule {

    private final Multibinder<PcxConnection> multibinder;
    private final String connectionId;
    private final int commandPort;
    private final int statusPort;
    private final Set<String> targetStationIds;
    private final Key<PcxConnection> key;

    public PcxConnectionExposingModule(Multibinder<PcxConnection> multibinder, String connectionId, int commandPort, int statusPort, Set<String> targetStationIds) {
        this.multibinder = multibinder;
        this.connectionId = connectionId;
        this.commandPort = commandPort;
        this.statusPort = statusPort;
        this.targetStationIds = targetStationIds;
        key = Key.get(PcxConnection.class, Names.named(connectionId));
    }

    @Override
    protected void configure() {
        PcxConnectionModule.bindParameters(binder(), commandPort, statusPort, connectionId, targetStationIds);
        install(new PcxConnectionModule(key));
        expose(key);
        multibinder.addBinding().to(key);
    }
}
