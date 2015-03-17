
package com.eb.warehouse;

import static org.junit.Assert.assertNotNull;

import javax.inject.Named;

import org.assertj.core.util.Sets;
import org.junit.Test;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;

public class RandomTargetSelectingPcxStationModuleTest {

  @Test
  public void inject() {
    Injector injector = Guice.createInjector(new RandomTargetSelectingPcxStationModule("a", Sets.<String> newHashSet()), new AbstractModule() {
      @Override
      protected void configure() {
      }

      @Provides
      @Named("outgoing")
      EventBus create() {
        return new EventBus();
      }
    });
    PcxStation station = injector.getInstance(PcxStation.class);
    assertNotNull(station);
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
