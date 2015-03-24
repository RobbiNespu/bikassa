package com.eb.warehouse;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */
abstract class AbstractPcxStationImplModule extends AbstractModule {

  private final String stationId;
  private final Set<String> targets;
  private final Key<PcxStation> pcxStationBindingKey;

  protected AbstractPcxStationImplModule(String stationId, Set<String> targets,
                                         Key<PcxStation> pcxStationBindingKey) {
    this.stationId = stationId;
    this.targets = targets;
    this.pcxStationBindingKey = pcxStationBindingKey;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(String.class).annotatedWith(Names.named("stationId")).toInstance(stationId);
    bind(new TypeLiteral<Set<String>>() {
    }).toInstance(targets);
    bind(pcxStationBindingKey).to(PcxStationImpl.class);
  }

}
