package com.eb.warehouse.util;

import com.google.common.base.MoreObjects;

import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public final class NamedThreadFactory implements ThreadFactory {

  public static final String THREAD_NAME_BINDING_NAME = "threadName";
  private final String name;

  @Inject
  public NamedThreadFactory(@Named(THREAD_NAME_BINDING_NAME) String name) {
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
