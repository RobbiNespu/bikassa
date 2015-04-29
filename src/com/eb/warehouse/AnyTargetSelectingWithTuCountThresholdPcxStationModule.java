package com.eb.warehouse;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class AnyTargetSelectingWithTuCountThresholdPcxStationModule
    extends AbstractModule {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(Integer.class).annotatedWith(Names.named("tuCountThreshold")).toInstance(1);
    bind(PcxTargetSelector.class).annotatedWith(Names.named("wrapped"))
        .to(AnyPcxTargetSelector.class);
    bind(PcxTargetSelector.class).to(MaxTuCountPassingPcxTargetSelector.class);
  }
}