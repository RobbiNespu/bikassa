package com.eb.warehouse.io.pcx;

import com.eb.warehouse.io.pcx.message.Announce;

import java.io.IOException;

/**
 * Created by ebe on 24.03.2015.
 */
public abstract class PcxMessageSender {

  public void sendAnnounceMessage(Announce announce) throws IOException {
    throw new UnsupportedOperationException();
  }
}
