package com.eb.warehouse.io.socket;

import com.google.common.base.MoreObjects;

/**
 * Created by ebe on 24.03.2015.
 */
public class SocketConnectedEvent extends AbstractSocketEvent {

    public SocketConnectedEvent(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(super.toString()).toString();
    }
}
