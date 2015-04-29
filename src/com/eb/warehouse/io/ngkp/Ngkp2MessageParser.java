package com.eb.warehouse.io.ngkp;

import com.google.common.eventbus.EventBus;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.ngkp.message.Ngkp2TelegramParser;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p> TODO </p>
 */
class Ngkp2MessageParser implements ByteMessageListener {

  private final EventBus eventBus;

  @Inject
  Ngkp2MessageParser(@Named(Ngkp2ConnectionModule.TELEGRAM_EVENTS_BINDING_NAME) EventBus eventBus) {
    this.eventBus = eventBus;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void consumeMessage(byte[] buffer) {
    Ngkp2Header header = new Ngkp2Header();
    header.fromByteArray(buffer, 0);

    if (buffer.length > 10) {
      Object telegram = Ngkp2TelegramParser.fromHeaderAndBytes(header, buffer, 10);
      eventBus.post(telegram);
    }

    // Used to send an ack message
    eventBus.post(header);
  }

}
