package com.eb.warehouse.io.pcx;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Set;

/**
 * Created by eb on 11.06.2015.
 */
public final class PcxConnectionInfo {

    private final String connectionId;
    private final String hostname;
    private final int commandPort;
    private final int statusPort;
    private final Set<String> stationIds;


    public PcxConnectionInfo(String connectionId, String hostname, int commandPort, int statusPort, Set<String> stationIds) {
        this.connectionId = connectionId;
        this.hostname = hostname;
        this.commandPort = commandPort;
        this.statusPort = statusPort;
        this.stationIds = stationIds;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public String getHostname() {
        return hostname;
    }

    public int getCommandPort() {
        return commandPort;
    }

    public int getStatusPort() {
        return statusPort;
    }

    public Set<String> getStationIds() {
        return stationIds;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PcxConnectionInfo) {
            PcxConnectionInfo other = (PcxConnectionInfo) obj;
            return Objects.equal(connectionId, other.connectionId) && Objects.equal(hostname, other.hostname)
                    && commandPort == other.commandPort && statusPort == other.statusPort
                    && stationIds.equals(other.stationIds);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(connectionId, hostname, commandPort, statusPort, stationIds);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("connId", connectionId).add("hostname", hostname)
                .add("cmdPort", commandPort).add("statusPort", statusPort).add("stationIds", stationIds).toString();
    }
}
