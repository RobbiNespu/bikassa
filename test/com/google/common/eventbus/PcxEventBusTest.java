
package com.google.common.eventbus;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Before;
import org.junit.Test;

import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.AnnounceStation;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.PcxEventBus;
import com.google.common.eventbus.PcxEventBus.PcxEventReceiver;

public class PcxEventBusTest {

  private PcxEventBus eventBus;

  @Before
  public void setUp() {
    eventBus = new PcxEventBus("");
  }
  
  @Test
  public void postEvent(){
  }

  @Test
  public void deliverPcxEvent() {
    final AtomicBoolean postedEvent = new AtomicBoolean();
    final Announce expected = new Announce();
    PcxEventReceiver eventReceiver = new PcxEventReceiver() {
      @Subscribe
      public void assertEvent(Announce a) {
        assertSame(expected, a);
        assertEquals("1", a.getStation().getFrom());
        postedEvent.set(true);
      }
      @Override
      public Set<String> getAssociatedStationIds() {
        return ImmutableSet.of("1");
      }
    };
    eventBus.register(eventReceiver);
    AnnounceStation as = new AnnounceStation();
    as.setFrom("1");
    expected.setStation(as);
    eventBus.post(expected);
    assertTrue(postedEvent.get());
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
