package com.eb.warehouse.util;

import com.google.common.eventbus.EventBus;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EventBusRegistrationListener implements TypeListener {

  private static final Logger L = LoggerFactory.getLogger(EventBusRegistrationListener.class);
  private final EventBus eventBus;

  public EventBusRegistrationListener(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  @Override
  public <I> void hear(TypeLiteral<I> arg0, TypeEncounter<I> typeEncounter) {
    typeEncounter.register(new InjectionListener<I>() {
      @Override
      public void afterInjection(I i) {
        L.trace("Register event-receiving obj={} at eventBusId={}.", i, eventBus.hashCode());
        eventBus.register(i);
      }
    });
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
