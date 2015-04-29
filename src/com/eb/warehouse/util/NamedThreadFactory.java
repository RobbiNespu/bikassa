package com.eb.warehouse.util;

import com.google.common.base.MoreObjects;

import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public final class NamedThreadFactory implements ThreadFactory {

  private final String name;

  @Inject
  public NamedThreadFactory(@ThreadNameBinding String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", name).toString();
  }
}
