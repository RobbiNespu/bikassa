
package com.eb.warehouse.util;

import java.util.Collection;

import javax.inject.Inject;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */
public final class ServicesManager implements Service2 {

  private final Collection<Service2> services;

  @Inject
  public ServicesManager(Collection<Service2> services) {
    this.services = services;
  }

  /** {@inheritDoc} */
  @Override
  public void startAsync2() {
    for (Service2 service : services) {
      service.startAsync2();
    }
  }

  /** {@inheritDoc} */
  @Override
  public void stop2() {
    for (Service2 service : services) {
      service.stop2();
    }
  }
}
