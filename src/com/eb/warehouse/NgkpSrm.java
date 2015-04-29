package com.eb.warehouse;

import com.google.common.eventbus.Subscribe;

import com.eb.warehouse.io.ngkp.NgkpMessageSender;
import com.eb.warehouse.io.ngkp.message.TT1411;
import com.eb.warehouse.io.ngkp.message.TT1434;

/**
 * Created by ebe on 25.03.2015.
 */
public class NgkpSrm {

  private final NgkpMessageSender sender;

  public NgkpSrm(NgkpMessageSender sender) {
    this.sender = sender;
  }

  @Subscribe
  public void onStatusOrControlReply(TT1434 e) {

  }

  @Subscribe
  public void onTransportOrderCompletion(TT1411 e) {

  }
}
