package com.eb.warehouse.io.pcx;

import com.google.common.base.Charsets;
import com.google.common.eventbus.Subscribe;

import com.eb.warehouse.io.pcx.message.Life;
import com.eb.warehouse.io.socket.AutoLifeSendSocketConnectionBinding;
import com.eb.warehouse.io.socket.ForwardingSocketConnection;
import com.eb.warehouse.io.socket.SendLifeEvent;
import com.eb.warehouse.io.socket.SocketConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * <p>PCX socket connection that represents either a "command" or "status" connection.</p>
 * <p>Instances of this class must register for {@link com.eb.warehouse.io.socket.SendLifeEvent}
 * events so that PCX {@link com.eb.warehouse.io.pcx.message.Life} message can be periodically
 * sent.</p>
 */
final class PcxSocketConnection extends ForwardingSocketConnection {

  private static final Logger L = LoggerFactory.getLogger(PcxSocketConnection.class);
  private static final Life LIFE_MESSAGE = new Life();
  private final SocketConnection wrapped;
  private final Marshaller marshaller;
  private final byte delimiter;

  @Inject
  public PcxSocketConnection(
      @AutoLifeSendSocketConnectionBinding SocketConnection wrapped,
      Marshaller marshaller,
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
   * Write PCX {@link com.eb.warehouse.io.pcx.message.Life} message to underlying socket. <p>This
   * method doesn't throw any {@link java.io.IOException}s when writing the life message fails. It's
   * only logged.</p>
   */
  @Subscribe
  public void writeLifeMessage(SendLifeEvent e) {
    ByteArrayOutputStream os = new ByteArrayOutputStream(128);
    try {
      L.trace("Try marshalling PCX life message={} to XML string.", LIFE_MESSAGE);
      marshaller.marshal(LIFE_MESSAGE, os);
      L.trace("Marshalled PCX life message to XML string={} and send to hardware.",
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
