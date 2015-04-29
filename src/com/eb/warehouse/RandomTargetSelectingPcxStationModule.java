package com.eb.warehouse;

import com.google.inject.AbstractModule;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class RandomTargetSelectingPcxStationModule extends AbstractModule {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(PcxTargetSelector.class).to(RandomPcxTargetSelector.class);
  }

}