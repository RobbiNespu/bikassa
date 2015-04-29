package com.eb.warehouse.io.ngkp;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

import com.eb.warehouse.PcxStation;
import com.eb.warehouse.io.pcx.PcxCommunication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Ngkp2EventRegistrationListener implements TypeListener {

  private static final Logger
      L =
      LoggerFactory.getLogger(Ngkp2EventRegistrationListener.class);
  private NgkpCommunication ngkpCommunication;

  @Override
  public <I> void hear(TypeLiteral<I> arg0, TypeEncounter<I> typeEncounter) {
    typeEncounter.register(new InjectionListener<I>() {
      @Override
      public void afterInjection(I i) {
        if (i instanceof PcxCommunication) {
          L.trace("NgkpCommunication={} is constructed.", i);
          ngkpCommunication = (NgkpCommunication) i;
        }

        if (i instanceof PcxStation) {
          L.trace("Register PCX station={} at PCX hardware communication={}.", i,
                  ngkpCommunication);
//          ngkpCommunication.registerStation((PcxStation) i);
        }
      }
    });
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
