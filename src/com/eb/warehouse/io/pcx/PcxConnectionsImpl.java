package com.eb.warehouse.io.pcx;

import com.eb.warehouse.PcxStation;
import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.Response;
import com.eb.warehouse.io.pcx.message.ResponseQuery;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by ebe on 24.03.2015.
 */
public class PcxConnectionsImpl extends PcxMessageSender implements PcxConnections {

  private static final Logger L = LoggerFactory.getLogger(PcxConnectionsImpl.class);
  private final Map<String, StationEventBus> registeredStations = Maps.newHashMap();
  private final Set<PcxConnection> connections;
  private final Set<PcxConnectionInfo> infos;
  private final ServiceManager connectionsManager;
  private final Map<String, PcxConnection> stationToConnectionMapping;
  private final EventBus loopbackEventBus = new AsyncEventBus(Executors.newFixedThreadPool(8));
  private final Service delegateService = new AbstractIdleService() {
    @Override
    protected void startUp() throws Exception {
      L.trace("Starting PCX connections service={}.", connectionsManager);
      connectionsManager.startAsync();
      connectionsManager.awaitHealthy();
      L.trace("Started PCX connections service.");
    }

    @Override
    protected void shutDown() throws Exception {
      L.trace("Stopping PCX connections service={}.", connectionsManager);
      connectionsManager.stopAsync();
      connectionsManager.awaitStopped();
      L.trace("Stopped PCX connections service.");
    }
  };

  @Inject
  public PcxConnectionsImpl(Set<PcxConnection> pcxConnections) {
    ImmutableMap.Builder<String, PcxConnection> connectionsBuilder = ImmutableMap.builder();
    ImmutableSet.Builder<PcxConnectionInfo> infos = ImmutableSet.builder();
    for (PcxConnection conn : pcxConnections) {
      infos.add(new PcxConnectionInfo(conn.getId(), conn.getHostname(), conn.getCommandPort(), conn.getStatusPort(), conn.getAssociatedStationIds()));
      for (String stationId : conn.getAssociatedStationIds()) {
        connectionsBuilder.put(stationId, conn);
      }
    }
    this.connections = pcxConnections;
    this.infos = infos.build();
    this.connectionsManager = new ServiceManager(pcxConnections);
    this.stationToConnectionMapping = connectionsBuilder.build();
    loopbackEventBus.register(this);
  }

  @Override
  public Set<PcxConnectionInfo> getInfos() {
    return infos;
  }

  @Override
  public void registerStation(PcxStation station) {
    if (!registeredStations.containsKey(station.getStationId())) {
      EventBus eventBus = new EventBus();
      eventBus.register(station);
      registeredStations.put(station.getStationId(), new StationEventBus(station, eventBus));
      L.trace("Register PCX station={} at PCX connections for receiving events.", station);
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

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("connInfos", infos).add("conns", connections)
            .add("stationToConn", stationToConnectionMapping).add("regStations", registeredStations).toString();
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
