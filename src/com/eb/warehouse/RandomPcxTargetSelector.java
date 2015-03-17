
package com.eb.warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import com.eb.warehouse.io.pcx.message.ResponseQuery;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class RandomPcxTargetSelector implements PcxTargetSelector {

  /** {@inheritDoc} */
  @Override
  public Optional<String> selectTarget(String stationId, Set<String> targets, ResponseQuery query) {
    ArrayList<String> copiedTargets = Lists.newArrayList(targets);
    Collections.shuffle(copiedTargets);
    String chosenTarget = copiedTargets.iterator().next(); // choose target randomly
    return Optional.of(chosenTarget);
  }

}
