/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

/**
 * Simple class to represent a transport order block of the TT1611 telegram.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1548 $, $Date: 2013-10-31 13:56:14 +0100 (Do, 31 Okt 2013) $, $Author: dennis.chong $
 */
public class TT1611TOBlock implements Serializable {
  private static final long serialVersionUID = 1L;
  protected int sourceEMS;
  protected int sourceArea;
  protected int sourceLocation;
  protected int sourcePlace;
  protected int sourceVehicle;
  protected int sourceVehicleLSD;
  protected int sourceVehiclePlace;
  protected int destinationEMS;
  protected int destinationArea;
  protected int destinationLocation;
  protected int destinationPlace;
  protected int destinationVehicle;
  protected int destinationVehicleLSD;
  protected int destinationVehiclePlace;
  protected int lastEMS;
  protected int lastArea;
  protected int lastLocation;
  protected int lastPlace;
  protected int lastVehicle;
  protected int lastVehicleLSD;
  protected int lastVehiclePlace;
  protected int order;
  protected int acknowledge;
  protected int tuAmount;
  protected boolean[] orderExtensions1;
  protected boolean[] orderExtensions2;
  protected boolean[] acknowledgeExtensions1;
  protected boolean[] acknowledgeExtensions2;
  protected TT1611TUBlock[] tuBlocks;

  public TT1611TOBlock() {
    this(1);
  }

  public TT1611TOBlock(int tuCount) {
    super();
    this.sourceEMS = 0;
    this.sourceArea = 0;
    this.sourceLocation = 0;
    this.sourcePlace = 0;
    this.sourceVehicle = 0;
    this.sourceVehicleLSD = 0;
    this.sourceVehiclePlace = 0;
    this.destinationEMS = 0;
    this.destinationArea = 0;
    this.destinationLocation = 0;
    this.destinationPlace = 0;
    this.destinationVehicle = 0;
    this.destinationVehicleLSD = 0;
    this.destinationVehiclePlace = 0;
    this.lastEMS = 0;
    this.lastArea = 0;
    this.lastLocation = 0;
    this.lastPlace = 0;
    this.lastVehicle = 0;
    this.lastVehicleLSD = 0;
    this.lastVehiclePlace = 0;
    this.order = 0;
    this.acknowledge = 0;
    this.tuAmount = 0;
    this.orderExtensions1 = new boolean[8];
    this.orderExtensions2 = new boolean[8];
    this.acknowledgeExtensions1 = new boolean[8];
    this.acknowledgeExtensions2 = new boolean[8];
    this.tuBlocks = new TT1611TUBlock[tuCount];
    for (int i = 0; i < tuBlocks.length; ++i) {
      tuBlocks[i] = new TT1611TUBlock();
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" + fieldsToString(0) + "]";
  }

  public String fieldsToString(int index) {
    String s = " sourceEMS[" + index + "]=" + sourceEMS + "," + //
        " sourceArea[" + index + "]=" + sourceArea + "," + //
        " sourceLocation[" + index + "]=" + sourceLocation + "," + //
        " sourcePlace[" + index + "]=" + sourcePlace + "," + //
        " sourceVehicle[" + index + "]=" + sourceVehicle + "," + //
        " sourceVehicleLSD[" + index + "]=" + sourceVehicleLSD + "," + //
        " sourceVehiclePlace[" + index + "]=" + sourceVehiclePlace + "," + //
        " destinationEMS[" + index + "]=" + destinationEMS + "," + //
        " destinationArea[" + index + "]=" + destinationArea + "," + //
        " destinationLocation[" + index + "]=" + destinationLocation + "," + //
        " destinationPlace[" + index + "]=" + destinationPlace + "," + //
        " destinationVehicle[" + index + "]=" + destinationVehicle + "," + //
        " destinationVehicleLSD[" + index + "]=" + destinationVehicleLSD + "," + //
        " destinationVehiclePlace[" + index + "]=" + destinationVehiclePlace + "," + //
        " lastEMS[" + index + "]=" + lastEMS + "," + //
        " lastArea[" + index + "]=" + lastArea + "," + //
        " lastLocation[" + index + "]=" + lastLocation + "," + //
        " lastPlace[" + index + "]=" + lastPlace + "," + //
        " lastVehicle[" + index + "]=" + lastVehicle + "," + //
        " lastVehicleLSD[" + index + "]=" + lastVehicleLSD + "," + //
        " lastVehiclePlace[" + index + "]=" + lastVehiclePlace + "," + //
        " order[" + index + "]=" + order + "," + //
        " acknowledge[" + index + "]=" + acknowledge + "," + //
        " tuAmount[" + index + "]=" + tuAmount + "," + //
        " orderExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions1) + "," + //
        " orderExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions2) + "," + //
        " acknowledgeExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions1) + "," + //
        " acknowledgeExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions2) + ",";
    for (int i = 0; i < tuBlocks.length; ++i) {
      s += tuBlocks[i].fieldsToString(index, i + 1);
    }
    return s;
  }

  public String toHex() {
    String str = "";
    str = NGKPTelegram.insertIntIntoHex(str, sourceEMS, 2);
    str = NGKPTelegram.insertIntIntoHex(str, sourceArea, 2);
    str = NGKPTelegram.insertIntIntoHex(str, sourceLocation, 2);
    str = NGKPTelegram.insertIntIntoHex(str, sourcePlace, 2);
    str = NGKPTelegram.insertIntIntoHex(str, sourceVehicle, 2);
    str = NGKPTelegram.insertIntIntoHex(str, sourceVehicleLSD, 2);
    str = NGKPTelegram.insertIntIntoHex(str, sourceVehiclePlace, 2);
    str = NGKPTelegram.insertIntIntoHex(str, destinationEMS, 2);
    str = NGKPTelegram.insertIntIntoHex(str, destinationArea, 2);
    str = NGKPTelegram.insertIntIntoHex(str, destinationLocation, 2);
    str = NGKPTelegram.insertIntIntoHex(str, destinationPlace, 2);
    str = NGKPTelegram.insertIntIntoHex(str, destinationVehicle, 2);
    str = NGKPTelegram.insertIntIntoHex(str, destinationVehicleLSD, 2);
    str = NGKPTelegram.insertIntIntoHex(str, destinationVehiclePlace, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lastEMS, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lastArea, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lastLocation, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lastPlace, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lastVehicle, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lastVehicleLSD, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lastVehiclePlace, 2);
    str = NGKPTelegram.insertIntIntoHex(str, tuAmount, 2);
    str = NGKPTelegram.insertIntIntoHex(str, order, 2);
    str = NGKPTelegram.insertBitsIntoHex(str, orderExtensions1, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, orderExtensions2, 1);
    str = NGKPTelegram.insertIntIntoHex(str, acknowledge, 2);
    str = NGKPTelegram.insertBitsIntoHex(str, acknowledgeExtensions1, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, acknowledgeExtensions2, 1);
    for (int j = 0; j < tuBlocks.length; ++j) {
      str = str + tuBlocks[j].toHex();
    }
    return str;
  }

  public int fromHex(String hex, int byteoffset) {
    sourceEMS = NGKPTelegram.extractIntFromHex(hex, byteoffset + 0, 2);
    sourceArea = NGKPTelegram.extractIntFromHex(hex, byteoffset + 2, 2);
    sourceLocation = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 2);
    sourcePlace = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 2);
    sourceVehicle = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 2);
    sourceVehicleLSD = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 2);
    sourceVehiclePlace = NGKPTelegram.extractIntFromHex(hex, byteoffset + 12, 2);
    destinationEMS = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 2);
    destinationArea = NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 2);
    destinationLocation = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 2);
    destinationPlace = NGKPTelegram.extractIntFromHex(hex, byteoffset + 20, 2);
    destinationVehicle = NGKPTelegram.extractIntFromHex(hex, byteoffset + 22, 2);
    destinationVehicleLSD = NGKPTelegram.extractIntFromHex(hex, byteoffset + 24, 2);
    destinationVehiclePlace = NGKPTelegram.extractIntFromHex(hex, byteoffset + 26, 2);
    lastEMS = NGKPTelegram.extractIntFromHex(hex, byteoffset + 28, 2);
    lastArea = NGKPTelegram.extractIntFromHex(hex, byteoffset + 30, 2);
    lastLocation = NGKPTelegram.extractIntFromHex(hex, byteoffset + 32, 2);
    lastPlace = NGKPTelegram.extractIntFromHex(hex, byteoffset + 34, 2);
    lastVehicle = NGKPTelegram.extractIntFromHex(hex, byteoffset + 36, 2);
    lastVehicleLSD = NGKPTelegram.extractIntFromHex(hex, byteoffset + 38, 2);
    lastVehiclePlace = NGKPTelegram.extractIntFromHex(hex, byteoffset + 40, 2);
    tuAmount = NGKPTelegram.extractIntFromHex(hex, byteoffset + 42, 2);
    order = NGKPTelegram.extractIntFromHex(hex, byteoffset + 44, 2);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions1, byteoffset + 46, 1);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions2, byteoffset + 47, 1);
    acknowledge = NGKPTelegram.extractIntFromHex(hex, byteoffset + 48, 2);
    NGKPTelegram.extractBitsFromHex(hex, acknowledgeExtensions1, byteoffset + 50, 1);
    NGKPTelegram.extractBitsFromHex(hex, acknowledgeExtensions2, byteoffset + 51, 1);
    byteoffset += 52;
    for (int i = 0; i < tuBlocks.length; ++i) {
      byteoffset = tuBlocks[i].fromHex(hex, byteoffset);
    }
    return byteoffset;
  }

  public boolean isTransportOrder() {
    return order == TT1611.TRANSPORT_ORDER || order == TT1611.TRANSPORT_ORDER_LOW_PRIORITY || order == TT1611.TRANSPORT_ORDER_HIGH_PRIORITY;
  }

  public boolean isTransportUpdate() {
    return order == TT1611.TRANSPORT_ORDER_UPDATE;
  }

  public boolean isFollowUp() {
    return order == TT1611.TRANSPORT_ORDER_FOLLOW_UP;
  }

  public String getSourceID() {
    return sourceArea + "/" + sourceLocation + "/" + sourcePlace;
  }

  public String getDestinationID() {
    return destinationArea + "/" + destinationLocation + "/" + destinationPlace;
  }

  public String getLastNoticeID() {
    return lastArea + "/" + lastLocation + "/" + lastPlace;
  }

  public TT1611TUBlock getFirstBlock() {
    return tuBlocks[0];
  }

  public boolean getOrderExtensionBit(int extension, int bit) {
    if (extension == 1) {
      return getOrderExtensions1()[bit];
    }
    if (extension == 2) {
      return getOrderExtensions2()[bit];
    }
    return false;
  }

  public void setOrderExtensionBit(int extension, int bit, boolean value) {
    if (extension == 1) {
      getOrderExtensions1()[bit] = value;
    }
    if (extension == 2) {
      getOrderExtensions2()[bit] = value;
    }
  }

  public boolean getAckExtensionBit(int extension, int bit) {
    if (extension == 1) {
      return getAcknowledgeExtensions1()[bit];
    }
    if (extension == 2) {
      return getAcknowledgeExtensions2()[bit];
    }
    return false;
  }

  public void setAckExtensionBit(int extension, int bit, boolean value) {
    if (extension == 1) {
      getAcknowledgeExtensions1()[bit] = value;
    }
    if (extension == 2) {
      getAcknowledgeExtensions1()[bit] = value;
    }
  }

  public int getSourceEMS() {
    return sourceEMS;
  }

  public void setSourceEMS(int sourceEMS) {
    this.sourceEMS = sourceEMS;
  }

  public int getSourceArea() {
    return sourceArea;
  }

  public void setSourceArea(int sourceArea) {
    this.sourceArea = sourceArea;
  }

  public int getSourceLocation() {
    return sourceLocation;
  }

  public void setSourceLocation(int sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  public int getSourcePlace() {
    return sourcePlace;
  }

  public void setSourcePlace(int sourcePlace) {
    this.sourcePlace = sourcePlace;
  }

  public int getSourceVehicle() {
    return sourceVehicle;
  }

  public void setSourceVehicle(int sourceVehicle) {
    this.sourceVehicle = sourceVehicle;
  }

  public int getSourceVehicleLSD() {
    return sourceVehicleLSD;
  }

  public void setSourceVehicleLSD(int sourceVehicleLSD) {
    this.sourceVehicleLSD = sourceVehicleLSD;
  }

  public int getSourceVehiclePlace() {
    return sourceVehiclePlace;
  }

  public void setSourceVehiclePlace(int sourceVehiclePlace) {
    this.sourceVehiclePlace = sourceVehiclePlace;
  }

  public int getDestinationEMS() {
    return destinationEMS;
  }

  public void setDestinationEMS(int destinationEMS) {
    this.destinationEMS = destinationEMS;
  }

  public int getDestinationArea() {
    return destinationArea;
  }

  public void setDestinationArea(int destinationArea) {
    this.destinationArea = destinationArea;
  }

  public int getDestinationLocation() {
    return destinationLocation;
  }

  public void setDestinationLocation(int destinationLocation) {
    this.destinationLocation = destinationLocation;
  }

  public int getDestinationPlace() {
    return destinationPlace;
  }

  public void setDestinationPlace(int destinationPlace) {
    this.destinationPlace = destinationPlace;
  }

  public int getDestinationVehicle() {
    return destinationVehicle;
  }

  public void setDestinationVehicle(int destinationVehicle) {
    this.destinationVehicle = destinationVehicle;
  }

  public int getDestinationVehicleLSD() {
    return destinationVehicleLSD;
  }

  public void setDestinationVehicleLSD(int destinationVehicleLSD) {
    this.destinationVehicleLSD = destinationVehicleLSD;
  }

  public int getDestinationVehiclePlace() {
    return destinationVehiclePlace;
  }

  public void setDestinationVehiclePlace(int destinationVehiclePlace) {
    this.destinationVehiclePlace = destinationVehiclePlace;
  }

  public int getLastEMS() {
    return lastEMS;
  }

  public void setLastEMS(int lastEMS) {
    this.lastEMS = lastEMS;
  }

  public int getLastArea() {
    return lastArea;
  }

  public void setLastArea(int lastArea) {
    this.lastArea = lastArea;
  }

  public int getLastLocation() {
    return lastLocation;
  }

  public void setLastLocation(int lastLocation) {
    this.lastLocation = lastLocation;
  }

  public int getLastPlace() {
    return lastPlace;
  }

  public void setLastPlace(int lastPlace) {
    this.lastPlace = lastPlace;
  }

  public int getLastVehicle() {
    return lastVehicle;
  }

  public void setLastVehicle(int lastVehicle) {
    this.lastVehicle = lastVehicle;
  }

  public int getLastVehicleLSD() {
    return lastVehicleLSD;
  }

  public void setLastVehicleLSD(int lastVehicleLSD) {
    this.lastVehicleLSD = lastVehicleLSD;
  }

  public int getLastVehiclePlace() {
    return lastVehiclePlace;
  }

  public void setLastVehiclePlace(int lastVehiclePlace) {
    this.lastVehiclePlace = lastVehiclePlace;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
  }

  public int getTuAmount() {
    return tuAmount;
  }

  public void setTuAmount(int tuAmount) {
    this.tuAmount = tuAmount;
  }

  public boolean[] getOrderExtensions1() {
    return orderExtensions1;
  }

  public void setOrderExtensions1(boolean[] orderExtensions1) {
    this.orderExtensions1 = orderExtensions1;
  }

  public boolean[] getOrderExtensions2() {
    return orderExtensions2;
  }

  public void setOrderExtensions2(boolean[] orderExtensions2) {
    this.orderExtensions2 = orderExtensions2;
  }

  public boolean[] getAcknowledgeExtensions1() {
    return acknowledgeExtensions1;
  }

  public void setAcknowledgeExtensions1(boolean[] acknowledgeExtensions1) {
    this.acknowledgeExtensions1 = acknowledgeExtensions1;
  }

  public boolean[] getAcknowledgeExtensions2() {
    return acknowledgeExtensions2;
  }

  public void setAcknowledgeExtensions2(boolean[] acknowledgeExtensions2) {
    this.acknowledgeExtensions2 = acknowledgeExtensions2;
  }

  public TT1611TUBlock[] getTuBlocks() {
    return tuBlocks;
  }

  public void setTuBlocks(TT1611TUBlock[] tuBlocks) {
    this.tuBlocks = tuBlocks;
  }
}
