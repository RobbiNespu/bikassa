package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

public class TT0810Destination implements Serializable {

  private static final long serialVersionUID = 1L;

  private int destinationSystem;
  private int destinationUnit;
  private int destinationPosition;

  public int getDestinationSystem() {
    return destinationSystem;
  }

  public void setDestinationSystem(int destinationSystem) {
    this.destinationSystem = destinationSystem;
  }

  public int getDestinationUnit() {
    return destinationUnit;
  }

  public void setDestinationUnit(int destinationUnit) {
    this.destinationUnit = destinationUnit;
  }

  public int getDestinationPosition() {
    return destinationPosition;
  }

  public void setDestinationPosition(int destinationPosition) {
    this.destinationPosition = destinationPosition;
  }
}
