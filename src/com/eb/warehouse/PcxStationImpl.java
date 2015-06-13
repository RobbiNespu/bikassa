package com.eb.warehouse;

import com.eb.warehouse.io.pcx.PcxMessageSender;
import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.AnnounceStation;
import com.eb.warehouse.io.pcx.message.AnnounceTarget;
import com.eb.warehouse.io.pcx.message.ResponseQuery;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class PcxStationImpl implements PcxStation {

  private static final Logger L = LoggerFactory.getLogger(PcxStationImpl.class);
  private final PcxMessageSender pcxCommunication;
  private final String stationId;
  private final Set<String> targets;
  private final PcxTargetSelector targetSelector;
  private ResponseQuery pendingQuery;

  @Inject
  public PcxStationImpl(PcxMessageSender pcxCommunication,
                        @Named("stationId") String stationId, Set<String> targets,
                        PcxTargetSelector targetSelector) {
    this.pcxCommunication = pcxCommunication;
    this.stationId = stationId;
    this.targets = targets;
    this.targetSelector = targetSelector;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getStationId() {
    return stationId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<String> getTargets() {
    return targets;
  }

  @Subscribe
  public void onResponseQuery(ResponseQuery responseQuery) {
    L.info("Process PCX response query={}.", responseQuery);
    String tuCode = responseQuery.getBox();
    final String atLocation = responseQuery.getFrom();
    pendingQuery = null;

    Optional<String> dstLoc = targetSelector.selectTarget(stationId, targets, responseQuery);
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
      try {
        L.info("Send TU to target with PCX message={}.", a);
        pcxCommunication.sendAnnounceMessage(a);
      } catch (IOException e) {
        // TODO: Add handling if connection broken.
        L.error("Not sent PCX station announce to hardware.", e);
      }

    } else {
      pendingQuery = responseQuery;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PcxStation) {
      PcxStation other = (PcxStation) obj;
      return stationId.equals(other.getStationId());
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return stationId.hashCode();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("stationId", stationId).add("targets", targets)
            .add("targetSelector", targetSelector).toString();
  }
}
