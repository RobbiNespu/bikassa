package com.eb.warehouse.io.ngkp;

import com.google.common.eventbus.Subscribe;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.socket.AutoLifeSendSocketConnectionBinding;
import com.eb.warehouse.io.socket.ForwardingSocketConnection;
import com.eb.warehouse.io.socket.SendLifeEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.inject.Inject;

/**
 * <p> TODO </p>
 */
final class Ngkp2SenderSocketConnection extends ForwardingSocketConnection {

  private static final Logger L = LoggerFactory.getLogger(Ngkp2SenderSocketConnection.class);
  private static final char START_TELEGRAM_COUNTER = '/';
  private static final char LIFE_TELEGRAM_TYPE = 'D';
  private final SocketConnection wrapped;
  private char currentTelegramCounter = START_TELEGRAM_COUNTER;

  @Inject
  Ngkp2SenderSocketConnection(@AutoLifeSendSocketConnectionBinding SocketConnection wrapped) {
    this.wrapped = wrapped;
  }

  private static char incrementCounter(char current) {
    if (current == '/') {
      return '0';
    } else if (current == '0') {
      return '1';
    } else if (current == '1') {
      return '2';
    } else if (current == '2') {
      return '3';
    } else if (current == '3') {
      return '4';
    } else if (current == '4') {
      return '5';
    } else if (current == '5') {
      return '6';
    } else if (current == '6') {
      return '7';
    } else if (current == '7') {
      return '8';
    } else if (current == '8') {
      return '9';
    } else if (current == '9') {
      return '0';
    }
    throw new AssertionError("Unknown telegramCounter=" + current);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected SocketConnection delegate() {
    return wrapped;
  }

  @Subscribe
  public void incrementCounterOnAckTelegramReceived(Ngkp2Header header) {
    currentTelegramCounter = incrementCounter(currentTelegramCounter);
    L.trace("Incremented telegram counter for received NGKP2 header={}.", header);
  }

  /**
   * {@inheritDoc}
   */
  @Subscribe
  public void sendLifeMessage(SendLifeEvent e) {
    Ngkp2Header header = new Ngkp2Header();
    header.setDestinationAddress(115);
    header.setTelegramLength(10);
    header.setTelegramType(LIFE_TELEGRAM_TYPE);
    header.setTelegramCounter(currentTelegramCounter);
    L.trace("Try send NGKP2 life message={}.", header);
    byte[] bytes = new byte[10];
    header.intoByteArray(bytes, 0);
    try {
      writeToSocket(bytes);
    } catch (IOException ex) {
      L.error("Not sent NGKP2 life message.");
    }
  }
}
