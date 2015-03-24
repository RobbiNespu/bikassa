package com.eb.warehouse.io.pcx;

import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.ListenableScheduledFuture;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.pcx.message.Life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public final class PcxConnectionImpl implements PcxConnection {

  private static final Logger L = LoggerFactory.getLogger(PcxConnectionImpl.class);
  private static final Life LIFE_MESSAGE = new Life();
  private final SocketConnection command;
  private final SocketConnection status;
  private final Marshaller marshaller;
  private final Set<String> associatedStationIds;
  private final byte delimiter;
  private ListenableScheduledFuture<?> sendLifeFuture;

  @Inject
  public PcxConnectionImpl(@Named("command") SocketConnection command,
                           @Named("status") SocketConnection status,
                           Marshaller marshaller,
                           Set<String> associatedStationIds, byte delimiter) {
    this.command = command;
    this.status = status;
    this.marshaller = marshaller;
    this.associatedStationIds = associatedStationIds;
    this.delimiter = delimiter;
  }

  @Override
  public Set<String> getAssociatedStationIds() {
    return associatedStationIds;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void startAsync2() {
    command.startAsync2();
    status.startAsync2();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop2() {
    command.stop2();
    status.stop2();
  }

  @Override
  public void sendMessage(Object message) throws IOException {
    send(message, command);
  }

  private void send(Object message, SocketConnection comm) throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    try {
      L.trace("Try marshalling PCX message={} to XML string.", message);
      marshaller.marshal(message, os);
      L.debug("Marshalled PCX message={} to XML string={} and send to hardware.", message,
              new String(os.toByteArray(), Charsets.UTF_8));
      os.write(delimiter);
      comm.writeToSocket(os.toByteArray());
    } catch (JAXBException e) {
      L.error("Not marshalled PCX message={} to XML string.", message);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PcxConnection) {
      PcxConnection other = (PcxConnection) obj;
      return associatedStationIds.equals(other.getAssociatedStationIds());
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("cmdConn", command).add("statusConn", status)
        .toString();
  }
}