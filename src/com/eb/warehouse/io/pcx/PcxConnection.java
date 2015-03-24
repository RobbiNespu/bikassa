package com.eb.warehouse.io.pcx;

import com.eb.warehouse.util.Service2;

import java.io.IOException;
import java.util.Set;

/**
 * Created by ebe on 24.03.2015.
 */
public interface PcxConnection extends Service2 {

  void sendMessage(Object message) throws IOException;

  Set<String> getAssociatedStationIds();
}
