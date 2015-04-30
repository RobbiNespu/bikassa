package com.eb.warehouse.io.pcx;

import com.google.common.util.concurrent.Service;

import java.io.IOException;
import java.util.Set;

/**
 * Created by ebe on 24.03.2015.
 */
public interface PcxConnection extends Service {

  void sendMessage(Object message) throws IOException;

  Set<String> getAssociatedStationIds();
}
