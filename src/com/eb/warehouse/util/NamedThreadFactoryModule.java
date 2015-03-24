package com.eb.warehouse.util;

import com.google.inject.AbstractModule;

import java.util.concurrent.ThreadFactory;

/**
 * Created by ebe on 24.03.2015.
 */
public class NamedThreadFactoryModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ThreadFactory.class).to(NamedThreadFactory.class);
  }
}
