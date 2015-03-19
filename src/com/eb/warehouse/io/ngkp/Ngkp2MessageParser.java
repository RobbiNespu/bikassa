package com.eb.warehouse.io.ngkp;

import javax.inject.Inject;
import javax.inject.Named;

import com.eb.warehouse.io.ByteMessageListener;
import com.google.common.eventbus.EventBus;

/**
 * <p>
 * TODO
 * </p>
 */

class Ngkp2MessageParser implements ByteMessageListener {

  private final EventBus incomingEventBus;

  @Inject
  public Ngkp2MessageParser(@Named("incoming") EventBus incomingEventBus) {
    this.incomingEventBus = incomingEventBus;
  }

  /** {@inheritDoc} */
  @Override
  public void consumeMessage(byte[] buffer) {
    Ngkp2Header header = Ngkp2Header.fromBytes(buffer);

    if (buffer.length > 10) {
      Ngkp2Telegram telegram = Ngkp2Telegram.fromHeaderAndBytes(header, buffer, 10);
      incomingEventBus.post(telegram);
      System.out.println("NGKP arrived!! " + telegram);

    } else {
      incomingEventBus.post(header);
    }
  }

}
