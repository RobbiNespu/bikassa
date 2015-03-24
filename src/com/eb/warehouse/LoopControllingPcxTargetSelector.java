package com.eb.warehouse;

import com.google.common.base.Optional;

import com.eb.warehouse.io.pcx.message.ResponseQuery;

import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class LoopControllingPcxTargetSelector implements PcxTargetSelector {

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<String> selectTarget(String stationId, Set<String> targets, ResponseQuery query) {
    return null;
  }

}
