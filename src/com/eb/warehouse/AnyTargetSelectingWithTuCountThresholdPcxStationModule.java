
package com.eb.warehouse;

import java.util.Set;

import com.google.inject.name.Names;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class AnyTargetSelectingWithTuCountThresholdPcxStationModule extends AbstractPcxStationImplModule {

  public AnyTargetSelectingWithTuCountThresholdPcxStationModule(String stationId, Set<String> targets) {
    super(stationId, targets);
  }

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    super.configure();
    bind(Integer.class).annotatedWith(Names.named("tuCountThreshold")).toInstance(1);
    bind(PcxTargetSelector.class).annotatedWith(Names.named("wrapped")).to(AnyPcxTargetSelector.class);
    bind(PcxTargetSelector.class).to(MaxTuCountPassingPcxTargetSelector.class);
  }
}