package com.eb.warehouse.io.pcx;

import com.eb.warehouse.io.pcx.message.Life;
import com.eb.warehouse.io.socket.SocketConnection;
import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public final class PcxConnectionImpl extends AbstractIdleService implements PcxConnection {

  private static final Logger L = LoggerFactory.getLogger(PcxConnectionImpl.class);
  private static final Life LIFE_MESSAGE = new Life();
  private final String connectionId;
  private final SocketConnection command;
  private final SocketConnection status;
  private final Marshaller marshaller;
  private final Set<String> associatedStationIds;
  private final byte delimiter;
  private ListenableScheduledFuture<?> sendLifeFuture;

  @Inject
  public PcxConnectionImpl(@PcxConnectionId String connectionId, @PcxCommandConnectionBinding SocketConnection command,
                           @PcxStatusConnectionBinding SocketConnection status,
                           Marshaller marshaller,
                           Set<String> associatedStationIds, byte delimiter) {
    this.connectionId = connectionId;
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

  @Override
  public String getId() {
    return connectionId;
  }

  @Override
  public String getHostname() {
    return command.getHostname();
  }

  @Override
  public int getCommandPort() {
    return command.getPort();
  }

  @Override
  public int getStatusPort() {
    return status.getPort();
  }

  @Override
  protected void startUp() throws Exception {
    L.trace("Starting PCX command connection={} and status connection={}.", command, status);
    command.startAsync();
    status.startAsync();
  }

  @Override
  protected void shutDown() throws Exception {
    L.trace("Stopping PCX command connection={} and status connection={}.", command, status);
    command.stopAsync();
    status.stopAsync();
    command.awaitTerminated();
    status.awaitTerminated();
    L.trace("Stopped PCX command/status connection.");
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
      L.trace("Marshalled PCX message={} to XML string={} and send to hardware.", message,
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