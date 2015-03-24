package com.eb.warehouse.io.pcx;

import com.google.common.base.Charsets;
import com.google.common.eventbus.Subscribe;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.pcx.message.Life;
import com.eb.warehouse.io.socket.ForwardingSocketConnection;
import com.eb.warehouse.io.socket.LifeSendEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * <p> TODO </p>
 */

final class PcxSocketConnection extends ForwardingSocketConnection {

  private static final Logger L = LoggerFactory.getLogger(PcxSocketConnection.class);
  private static final Life LIFE_MESSAGE = new Life();
  private final SocketConnection wrapped;
  private final Marshaller marshaller;
  private final byte delimiter;

  @Inject
  public PcxSocketConnection(@Named("aliveSender") SocketConnection wrapped, Marshaller marshaller,
                             byte delimiter) {
    this.wrapped = wrapped;
    this.marshaller = marshaller;
    this.delimiter = delimiter;
  }

  @Override
  protected SocketConnection delegate() {
    return wrapped;
  }

  /**
   * {@inheritDoc}
   */
  @Subscribe
  public void sendLifeMessage(LifeSendEvent e) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    try {
      L.trace("Try marshalling PCX life message={} to XML string.", LIFE_MESSAGE);
      marshaller.marshal(LIFE_MESSAGE, os);
      L.debug("Marshalled PCX life message to XML string={} and send to hardware.",
              new String(os.toByteArray(), Charsets.UTF_8));
      os.write(delimiter);
      writeToSocket(os.toByteArray());

    } catch (JAXBException ex) {
      throw new AssertionError("Failed marshalling PCX life message=" + LIFE_MESSAGE
                               + " to XML string.", ex);

    } catch (IOException ex) {
      L.error("Not sent PCX life message. Connection broken.");
    }
  }

}
