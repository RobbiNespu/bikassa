package com.eb.warehouse.io.socket;

import com.google.common.base.Objects;

/**
 * Created by eb on 13.06.2015.
 */
abstract class AbstractSocketEvent {

    protected final String hostname;
    protected final int port;

    protected AbstractSocketEvent(String hostname, int port) {
        this.port = port;
        this.hostname = hostname;
    }

    public final String getHostname() {
        return hostname;
    }

    public final int getPort() {
        return port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractSocketEvent) {
            AbstractSocketEvent other = (AbstractSocketEvent) obj;
            return hostname.equals(other.hostname) && port == other.getPort();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hostname, port);
    }

    @Override
    public String toString() {
        return "hostname=" + hostname + ", port=" + port;
    }
}
