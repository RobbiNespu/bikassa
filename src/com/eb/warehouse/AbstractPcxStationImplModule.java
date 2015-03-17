
package com.eb.warehouse;

import java.util.Set;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */
abstract class AbstractPcxStationImplModule extends AbstractModule {

  private final String stationId;
  private final Set<String> targets;

  protected AbstractPcxStationImplModule(String stationId, Set<String> targets) {
    this.stationId = stationId;
    this.targets = targets;
  }

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    bind(String.class).annotatedWith(Names.named("stationId")).toInstance(stationId);
    bind(new TypeLiteral<Set<String>>() {
    }).toInstance(targets);
    bindPcxStation();
  }

  protected void bindPcxStation() {
    bind(PcxStation.class).to(PcxStationImpl.class);
  }

}
