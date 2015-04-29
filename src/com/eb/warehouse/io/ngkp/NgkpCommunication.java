package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.ngkp.message.TT1411;
import com.eb.warehouse.util.Service2;

import java.util.Set;

import javax.inject.Inject;

/**
 * Created by ebe on 25.03.2015.
 */
final class NgkpCommunication extends NgkpMessageSender implements Service2 {

  private final Set<Ngkp2Connection> connections;

  @Inject
  NgkpCommunication(Set<Ngkp2Connection> connections) {
    this.connections = connections;
  }

  @Override
  public void sendTT1430Message(TT1411 message) {
  }

  @Override
  public void startAsync2() {
    for (Ngkp2Connection conn : connections) {
      conn.startAsync2();
    }
  }

  @Override
  public void stop2() {
    for (Ngkp2Connection conn : connections) {
      conn.stop2();
    }
  }
}
