package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.ByteMessageListener;
import com.google.common.eventbus.EventBus;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p> TODO </p>
 */
class NgkpMessageListener implements ByteMessageListener {

    private final EventBus eventBus;
    private final NgkpTelegramParser parser;

    @Inject
    NgkpMessageListener(@Named(Ngkp2ConnectionModule.TELEGRAM_EVENTS_BINDING_NAME) EventBus eventBus, NgkpTelegramParser parser) {
        this.eventBus = eventBus;
        this.parser = parser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void consumeMessage(byte[] buffer) {
        NgkpTelegram telegram = parser.parseFromBytes(buffer);
        // Used to send an ack message
        eventBus.post(telegram.getHeader());

        if (telegram.hasTT1411()) {
            eventBus.post(telegram.getTT1411());
        } else if (telegram.hasTT1430()) {
            eventBus.post(telegram.getTT1430());
        } else if (telegram.hasTT1434()) {
            eventBus.post(telegram.getTT1434());
        } else {
            throw new UnsupportedOperationException("Telegram type not implemented.");
        }
    }

}
