package com.eb.warehouse.io.pcx;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.pcx.message.Life;
import com.eb.warehouse.io.socket.AliveSocketConnection.SendLifeCallback;
import com.google.common.base.Charsets;

/**
 * <p>
 * TODO
 * </p>
 */

final class PcxSocketConnection implements SocketConnection, SendLifeCallback {

  private static final Logger L = LoggerFactory.getLogger(PcxSocketConnection.class);
  private static final Life LIFE_MESSAGE = new Life();
  private final SocketConnection wrapped;
  private final Marshaller marshaller;
  private final byte delimiter;

  @Inject
  public PcxSocketConnection(SocketConnection wrapped, Marshaller marshaller, byte delimiter) {
    this.wrapped = wrapped;
    this.marshaller = marshaller;
    this.delimiter = delimiter;
  }

  /** {@inheritDoc} */
  @Override
  public void onSendLife() {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    try {
      L.trace("Try marshalling PCX life message={} to XML string.", LIFE_MESSAGE);
      marshaller.marshal(LIFE_MESSAGE, os);
      L.debug("Marshalled PCX life message={} to XML string={} and send to hardware.",
          LIFE_MESSAGE, new String(os.toByteArray(), Charsets.UTF_8));
      os.write(delimiter);
      writeToSocket(os.toByteArray());

    } catch (JAXBException e) {
      throw new AssertionError("Failed marshalling PCX life message=" + LIFE_MESSAGE
          + " to XML string.");

    } catch (IOException e) {
      L.error("Not sent PCX life message.", e);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void startAsync2() {
    wrapped.startAsync2();
  }

  /** {@inheritDoc} */
  @Override
  public void stop2() {
    wrapped.stop2();
  }

  /** {@inheritDoc} */
  @Override
  public void writeToSocket(byte[] bytes) throws IOException {
    wrapped.writeToSocket(bytes);
  }

}
