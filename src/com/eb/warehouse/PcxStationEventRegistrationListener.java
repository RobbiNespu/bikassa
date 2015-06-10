package com.eb.warehouse;

import com.eb.warehouse.io.pcx.PcxConnections;
import com.eb.warehouse.io.pcx.PcxConnectionsImpl;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PcxStationEventRegistrationListener implements TypeListener {

  private static final Logger
      L =
      LoggerFactory.getLogger(PcxStationEventRegistrationListener.class);
  private PcxConnections pcxConnections;

  @Override
  public <I> void hear(TypeLiteral<I> arg0, TypeEncounter<I> typeEncounter) {
    typeEncounter.register(new InjectionListener<I>() {
      @Override
      public void afterInjection(I i) {
        if (i instanceof PcxConnectionsImpl) {
          L.trace("PcxConnections={} is constructed.", i);
          pcxConnections = (PcxConnections) i;
        }

        if (i instanceof PcxStation) {
          L.trace("Register PCX station={} at PCX connections={}.", i, pcxConnections);
          pcxConnections.registerStation((PcxStation) i);
        }
      }
    });
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
