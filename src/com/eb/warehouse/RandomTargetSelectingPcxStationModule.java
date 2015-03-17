
package com.eb.warehouse;

import java.util.Set;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class RandomTargetSelectingPcxStationModule extends AbstractPcxStationImplModule {

  public RandomTargetSelectingPcxStationModule(String stationId, Set<String> targets) {
    super(stationId, targets);
  }

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    super.configure();
    bind(PcxTargetSelector.class).to(RandomPcxTargetSelector.class);
  }

}