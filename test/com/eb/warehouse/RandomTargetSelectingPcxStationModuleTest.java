
package com.eb.warehouse;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;

import org.assertj.core.util.Sets;
import org.junit.Test;

import javax.inject.Named;

import static org.junit.Assert.assertNotNull;

public class RandomTargetSelectingPcxStationModuleTest {

  @Test
  public void inject() {
    Injector
        injector =
        Guice.createInjector(
            new RandomTargetSelectingPcxStationModule("a", Sets.<String>newHashSet(), Key
                .get(PcxStation.class)), new AbstractModule() {
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
