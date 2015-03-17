
package com.eb.warehouse;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.AnnounceStation;
import com.eb.warehouse.io.pcx.message.AnnounceTarget;
import com.eb.warehouse.io.pcx.message.Response;
import com.eb.warehouse.io.pcx.message.ResponseQuery;
import com.eb.warehouse.io.pcx.message.ResponseStation;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class PcxStationImpl implements PcxStation {

  private static final Logger L = LoggerFactory.getLogger(PcxStationImpl.class);
  private final EventBus outgoingEventBus;
  private final String stationId;
  private final Set<String> targets;
  private final PcxTargetSelector targetSelector;
  private ResponseQuery pendingQuery;

  @Inject
  public PcxStationImpl(@Named("outgoing") EventBus outgoingEventBus, @Named("stationId") String stationId, Set<String> targets,
                        PcxTargetSelector targetSelector) {
    this.outgoingEventBus = outgoingEventBus;
    this.stationId = stationId;
    this.targets = targets;
    this.targetSelector = targetSelector;
  }

  /** {@inheritDoc} */
  @Override
  public String getStationId() {
    return stationId;
  }

  /** {@inheritDoc} */
  @Override
  public Set<String> getTargets() {
    return targets;
  }

  @Subscribe
  public void handleResponse(Response r) {
    if (r.getQuery() != null) {
      ResponseQuery query = r.getQuery();
      String atLocation = query.getFrom();

      if (Objects.equal(atLocation, stationId)) {
        L.info("Process PCX query={}.", r);
        String tuCode = query.getBox();
        pendingQuery = null;

        Optional<String> dstLoc = targetSelector.selectTarget(stationId, targets, query);
        if (dstLoc.isPresent()) {
          Announce a = new Announce();
          AnnounceStation rs = new AnnounceStation();
          AnnounceTarget target = new AnnounceTarget();
          target.setTo(dstLoc.get());
          target.setMode(AnnounceTarget.MODE_NEXT);
          rs.getTargets().add(target);
          rs.setBox(tuCode);
          rs.setFrom(atLocation);
          rs.setOrder("");
          a.setStation(rs);
          L.info("Send PCX message={} to hardware over eventBusId={}.", a, outgoingEventBus.hashCode());
          outgoingEventBus.post(a);

        } else {
          pendingQuery = query;
        }

      } else {
        L.trace("Discarded received PCX query={}. {} is not responsible for station={}.", query, this, atLocation);
      }

    } else if (r.getStation() != null) {
      ResponseStation stationResponse = r.getStation();

      if (Objects.equal(stationResponse.getFrom(), stationId)) {
        L.info("Process PCX station response={}.", r);
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PcxStation) {
      PcxStation other = (PcxStation) obj;
      return stationId.equals(other.getStationId());
    }
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return stationId.hashCode();
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
                      .add("outgoingEventBusId", outgoingEventBus.hashCode())
                      .add("stationId", stationId)
                      .add("targets", targets)
                      .add("targetSelector", targetSelector)
                      .toString();
  }
}
