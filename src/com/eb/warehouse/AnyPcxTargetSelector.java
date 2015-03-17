
package com.eb.warehouse;

import java.util.Set;

import com.eb.warehouse.io.pcx.message.ResponseQuery;
import com.google.common.base.Optional;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class AnyPcxTargetSelector implements PcxTargetSelector {

  /** {@inheritDoc} */
  @Override
  public Optional<String> selectTarget(String stationId, Set<String> targets, ResponseQuery query) {
    return Optional.of(targets.iterator().next());
  }

}