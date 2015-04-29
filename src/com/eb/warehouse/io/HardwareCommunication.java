package com.eb.warehouse.io;

import com.eb.warehouse.util.Service2;

import javax.inject.Named;

/**
 * Created by ebe on 25.03.2015.
 */
final class HardwareCommunication implements Service2 {

  private final Service2 ngkpComm;
  private final Service2 pcxComm;

  public HardwareCommunication(@Named("") Service2 ngkpComm, @Named("") Service2 pcxComm) {
    this.ngkpComm = ngkpComm;
    this.pcxComm = pcxComm;
  }

  @Override
  public void startAsync2() {
    ngkpComm.startAsync2();
    pcxComm.startAsync2();
  }

  @Override
  public void stop2() {
    ngkpComm.stop2();
    pcxComm.stop2();
  }
}
