package com.eb.warehouse;

import com.google.inject.Key;

import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class RandomTargetSelectingPcxStationModule extends AbstractPcxStationImplModule {

  public RandomTargetSelectingPcxStationModule(String stationId, Set<String> targets,
                                               Key<PcxStation> pcxStationBindingKey) {
    super(stationId, targets, pcxStationBindingKey);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    super.configure();
    bind(PcxTargetSelector.class).to(RandomPcxTargetSelector.class);
  }

}