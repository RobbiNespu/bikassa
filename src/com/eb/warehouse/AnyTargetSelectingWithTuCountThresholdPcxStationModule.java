package com.eb.warehouse;

import com.google.inject.Key;
import com.google.inject.name.Names;

import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class AnyTargetSelectingWithTuCountThresholdPcxStationModule
    extends AbstractPcxStationImplModule {

  public AnyTargetSelectingWithTuCountThresholdPcxStationModule(String stationId,
                                                                Set<String> targets,
                                                                Key<PcxStation> pcxStationBindingKey) {
    super(stationId, targets, pcxStationBindingKey);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    super.configure();
    bind(Integer.class).annotatedWith(Names.named("tuCountThreshold")).toInstance(1);
    bind(PcxTargetSelector.class).annotatedWith(Names.named("wrapped"))
        .to(AnyPcxTargetSelector.class);
    bind(PcxTargetSelector.class).to(MaxTuCountPassingPcxTargetSelector.class);
  }
}