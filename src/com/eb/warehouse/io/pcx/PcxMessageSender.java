package com.eb.warehouse.io.pcx;

import com.eb.warehouse.io.pcx.message.AnnounceStation;

import java.io.IOException;

/**
 * Created by ebe on 24.03.2015.
 */
public abstract class PcxMessageSender {

  public void sendAnnounceMessage(AnnounceStation announceStation) throws IOException {
    throw new UnsupportedOperationException();
  }
}
