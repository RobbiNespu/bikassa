package com.eb.warehouse.io.pcx;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;

import com.eb.warehouse.PcxStation;
import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.Response;
import com.eb.warehouse.io.pcx.message.ResponseQuery;
import com.eb.warehouse.util.EventConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

/**
 * Created by ebe on 24.03.2015.
 */
public class PcxCommunication extends PcxMessageSender implements Service, EventConsumer {

  private static final Logger L = LoggerFactory.getLogger(PcxCommunication.class);
  private final Map<String, StationEventBus> registeredStations = Maps.newHashMap();
  private final Set<PcxConnection> connections;
  private final ServiceManager connectionsManager;
  private final Map<String, PcxConnection> stationToConnectionMapping;
  private final EventBus loopbackEventBus = new AsyncEventBus(Executors.newFixedThreadPool(8));
  private final Service delegateService = new AbstractIdleService() {
    @Override
    protected void startUp() throws Exception {
      connectionsManager.startAsync();
      connectionsManager.awaitHealthy();
    }

    @Override
    protected void shutDown() throws Exception {
      connectionsManager.stopAsync();
      connectionsManager.awaitStopped();
    }
  };

  @Inject
  public PcxCommunication(Set<PcxConnection> pcxConnections) {
    ImmutableMap.Builder<String, PcxConnection> connectionsBuilder = ImmutableMap.builder();
    for (PcxConnection conn : pcxConnections) {
      for (String stationId : conn.getAssociatedStationIds()) {
        connectionsBuilder.put(stationId, conn);
      }
    }
    this.connections = pcxConnections;
    this.connectionsManager = new ServiceManager(pcxConnections);
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
    L.debug("Received PCX response={} from station.", response);
    if (response.getQuery() != null) {
      ResponseQuery rq = response.getQuery();
      String stationId = rq.getFrom();
      StationEventBus station = registeredStations.get(stationId);
      if (station != null) {
        station.eventBus.post(rq);
      } else {
        L.error(
            "Not delivered PCX response query={} to station={} because no station for this name registered.",
            rq, stationId);
      }
    }
  }

  @Override
  public Service startAsync() {
    return delegateService.startAsync();
  }

  @Override
  public boolean isRunning() {
    return delegateService.isRunning();
  }

  @Override
  public State state() {
    return delegateService.state();
  }

  @Override
  public Service stopAsync() {
    return delegateService.stopAsync();
  }

  @Override
  public void awaitRunning() {
    delegateService.awaitRunning();
  }

  @Override
  public void awaitRunning(long l, TimeUnit timeUnit) throws TimeoutException {
    delegateService.awaitRunning(l, timeUnit);
  }

  @Override
  public void awaitTerminated() {
    delegateService.awaitTerminated();
  }

  @Override
  public void awaitTerminated(long l, TimeUnit timeUnit) throws TimeoutException {
    delegateService.awaitRunning(l, timeUnit);
  }

  @Override
  public Throwable failureCause() {
    return delegateService.failureCause();
  }

  @Override
  public void addListener(Listener listener, Executor executor) {
    delegateService.addListener(listener, executor);
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
