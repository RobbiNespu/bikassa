package com.eb.warehouse.io.pcx;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import com.eb.warehouse.PcxStation;
import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.Response;
import com.eb.warehouse.io.pcx.message.ResponseQuery;
import com.eb.warehouse.util.EventConsumer;
import com.eb.warehouse.util.Service2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import javax.inject.Inject;

/**
 * Created by ebe on 24.03.2015.
 */
public class PcxCommunication extends PcxMessageSender implements Service2, EventConsumer {

  private static final Logger L = LoggerFactory.getLogger(PcxCommunication.class);
  private final Map<String, StationEventBus> registeredStations = Maps.newHashMap();
  private final Set<PcxConnection> connections;
  private final Map<String, PcxConnection> stationToConnectionMapping;
  private final EventBus loopbackEventBus = new AsyncEventBus(Executors.newFixedThreadPool(4));

  @Inject
  public PcxCommunication(Set<PcxConnection> pcxConnections) {
    ImmutableMap.Builder<String, PcxConnection> connectionsBuilder = ImmutableMap.builder();
    for (PcxConnection conn : pcxConnections) {
      for (String stationId : conn.getAssociatedStationIds()) {
        connectionsBuilder.put(stationId, conn);
      }
    }
    this.connections = pcxConnections;
    this.stationToConnectionMapping = connectionsBuilder.build();
    loopbackEventBus.register(this);
  }

  public void registerStation(PcxStation station) {
    if (!registeredStations.containsKey(station.getStationId())) {
      EventBus eventBus = new EventBus();
      eventBus.register(station);
      registeredStations.put(station.getStationId(), new StationEventBus(station, eventBus));
      L.trace(
          "Register PCX station={} at PCX hardware communication={} for receiving events.", station,
          this);
    }
  }

  @Override
  public void sendAnnounceMessage(Announce announce) throws IOException {
    String stationId = announce.getStation().getFrom();
    PcxConnection pcxConn = stationToConnectionMapping.get(stationId);
    if (pcxConn != null) {
      pcxConn.sendMessage(announce);
    } else {
      L.warn(
          "Not sent PCX message={} to station={} because no connection of station configured.",
          announce, stationId);
    }
  }

  @Override
  public void onEvent(Object event) {
    loopbackEventBus.post(event);
  }

  @Subscribe
  public void deliverResponse(Response response) {
    L.debug("Try deliver PCX response={} to station.", response);
    if (response.getQuery() != null) {
      ResponseQuery rq = response.getQuery();
      String stationId = rq.getFrom();
      StationEventBus station = registeredStations.get(stationId);
      if (station != null) {
        station.eventBus.post(rq);
      } else {
        L.debug(
            "Not delivered PCX response query={} to station={} because no station for this name registered.",
            rq, stationId);
      }
    }
  }

  @Override
  public void startAsync2() {
    for (PcxConnection conn : connections) {
      conn.startAsync2();
    }
  }

  @Override
  public void stop2() {
    for (PcxConnection conn : connections) {
      conn.stop2();
    }
  }

  private static final class StationEventBus {

    final PcxStation station;
    final EventBus eventBus;

    StationEventBus(PcxStation station, EventBus eventBus) {
      this.station = station;
      this.eventBus = eventBus;
    }

    @Override
    public boolean equals(Object obj) {
      return station.getStationId().equals(((StationEventBus) obj).station.getStationId());
    }

    @Override
    public int hashCode() {
      return station.getStationId().hashCode();
    }
  }
}
