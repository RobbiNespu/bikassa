package com.eb.warehouse;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import com.eb.warehouse.io.pcx.PcxCommunication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PcxStationEventRegistrationListener implements TypeListener {

  private static final Logger
      L =
      LoggerFactory.getLogger(PcxStationEventRegistrationListener.class);
  private PcxCommunication pcxCommunication;

  @Override
  public <I> void hear(TypeLiteral<I> arg0, TypeEncounter<I> typeEncounter) {
    typeEncounter.register(new InjectionListener<I>() {
      @Override
      public void afterInjection(I i) {
        if (i instanceof PcxCommunication) {
          L.trace("PcxCommunication={} is constructed.", i);
          pcxCommunication = (PcxCommunication) i;
        }

        if (i instanceof PcxStation) {
          L.trace("Register PCX station={} at PCX hardware communication={}.", i, pcxCommunication);
          pcxCommunication.registerStation((PcxStation) i);
        }
      }
    });
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
