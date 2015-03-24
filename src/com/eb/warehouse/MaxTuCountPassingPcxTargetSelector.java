package com.eb.warehouse;

import com.google.common.base.Optional;

import com.eb.warehouse.io.pcx.message.ResponseQuery;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class MaxTuCountPassingPcxTargetSelector implements PcxTargetSelector {

  private final PcxTargetSelector wrapped;
  private final int passedTuCountThreshold;
  private int passedTuCount = 0;

  @Inject
  public MaxTuCountPassingPcxTargetSelector(@Named("wrapped") PcxTargetSelector wrapped,
                                            @Named("tuCountThreshold") int passedTuCountThreshold) {
    this.wrapped = wrapped;
    this.passedTuCountThreshold = passedTuCountThreshold;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<String> selectTarget(String stationId, Set<String> targets, ResponseQuery query) {
    Optional<String> chosenTarget = wrapped.selectTarget(null, targets, query);
    if (chosenTarget.isPresent()) {
      if (passedTuCount <= passedTuCountThreshold) {
        passedTuCount++;
      } else {
        return Optional.absent();
      }
    }
    return chosenTarget;
  }

}
