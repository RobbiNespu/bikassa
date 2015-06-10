package com.eb.warehouse.io.pcx;

import com.eb.warehouse.PcxStation;
import com.eb.warehouse.util.EventConsumer;
import com.google.common.util.concurrent.Service;

import java.util.Set;

/**
 * Created by eb on 10.06.2015.
 */
public interface PcxConnections extends Service, EventConsumer {

    void registerStation(PcxStation station);

    Set<PcxConnectionInfo> getInfos();
}
