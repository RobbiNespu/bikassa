
package com.eb.warehouse.util;

import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.common.base.MoreObjects;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public final class NamedThreadFactory implements ThreadFactory {

  private final String name;

  @Inject
  public NamedThreadFactory(@Named("threadName") String name) {
    this.name = name;
  }

  /** {@inheritDoc} */
  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, name);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", name).toString();
  }
}
