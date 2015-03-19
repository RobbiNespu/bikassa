
package com.eb.warehouse.io.pcx;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.Life;
import com.eb.warehouse.util.Service2;
import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public final class PcxConnection implements Service2 {

  private static final Logger L = LoggerFactory.getLogger(PcxConnection.class);
  private static final Life LIFE_MESSAGE = new Life();
  private final SocketConnection command;
  private final SocketConnection status;
  private final Marshaller marshaller;
  private final Set<String> associatedStationNames;
  private final byte delimiter;
  private final ListeningScheduledExecutorService lifeMessageExecutorService;
  private ListenableScheduledFuture<?> sendLifeFuture;

  @Inject
  public PcxConnection(@Named("commandConnection") SocketConnection command, @Named("statusConnection") SocketConnection status, Marshaller marshaller,
                          Set<String> associatedStationNames, byte delimiter,
                          @Named("sendLifeMessageService") ListeningScheduledExecutorService lifeMessageExecutorService) {
    this.command = command;
    this.status = status;
    this.marshaller = marshaller;
    this.associatedStationNames = associatedStationNames;
    this.delimiter = delimiter;
    this.lifeMessageExecutorService = lifeMessageExecutorService;
  }

  /** {@inheritDoc} */
  @Override
  public void startAsync2() {
    command.startAsync2();
    status.startAsync2();
  }

  /** {@inheritDoc} */
  @Override
  public void stop2() {
    command.stop2();
    status.stop2();
  }

  @Subscribe
  public void serializeAndSendAnnounceToPcxHardware(Announce a) {
    if (a.getStation() == null) {
      L.trace("Discard PCX announce={}. Announce.getStation is NULL.", a);
    } else if (!associatedStationNames.contains(a.getStation().getFrom())) {
      L.trace("Discard PCX announce={}. Announce.getStation.getFrom()={} not contained in associated stations={}.",
              a,
              a.getStation().getFrom(),
              associatedStationNames);
      return;
    }

    send(a, command);
  }

  private void send(Object message, SocketConnection comm) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    try {
      L.trace("Try marshalling PCX message={} to XML string.", message);
      marshaller.marshal(message, os);
      L.debug("Marshalled PCX message={} to XML string={} and send to hardware.", message, new String(os.toByteArray(), Charsets.UTF_8));
      os.write(delimiter);
      comm.writeToSocket(os.toByteArray());
    } catch (JAXBException e) {
      L.error("Not marshalled PCX message={} to XML string.", message);
    } catch (IOException e) {
      if (sendLifeFuture != null) {
        // Stop sending life messages
        L.trace("Stop sending life PCX messages. Connection broken.");
        sendLifeFuture.cancel(false);
      }
    }
  }

  @Subscribe
  public void startSendingLifeMessages(InetSocketAddress connectedToAddress) {
    if (sendLifeFuture == null || sendLifeFuture.isDone()) {
      // Send life messages if not started yet or previous task was cancelled.
      sendLifeFuture = lifeMessageExecutorService.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
          send(LIFE_MESSAGE, command);
          send(LIFE_MESSAGE, status);
        }
      }, 5, 5, TimeUnit.SECONDS);
    }
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("cmdComm", command).add("statusComm", status).toString();
  }
}