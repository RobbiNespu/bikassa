/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */

public class TT1518Version1 extends TT1518 {
  private static final long serialVersionUID = 1L;
  private static final int DATA_LENGTH = 190;
  // topic 1
  protected int partNumber;
  protected int numberOfParts;
  protected String socID;
  protected int conveyorSystem;
  protected int conveyorUnit;
  protected int conveyorPlace;
  protected boolean[] infoFlags1;
  protected boolean[] infoFlags2;
  protected boolean[] reserve1;
  protected boolean[] reserve2;
  protected String data;

  public TT1518Version1() {
    super();
    this.topic = 1;
    this.partNumber = 1;
    this.numberOfParts = 1;
    this.socID = "0000";
    this.conveyorSystem = 0;
    this.conveyorUnit = 0;
    this.conveyorPlace = 0;
    this.infoFlags1 = new boolean[8];
    this.infoFlags2 = new boolean[8];
    this.reserve1 = new boolean[8];
    this.reserve2 = new boolean[8];
    this.data = "";
    for (int i = 0; i < DATA_LENGTH; ++i) {
      data += " ";
    }
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " topic=" + topic + ",";
    if (topic == 1) {
      s += " partNumber=" + partNumber + ",";
      s += " numberOfParts=" + numberOfParts + ",";
      s += " socID=" + socID + ",";
      s += " conveyorSystem=" + conveyorSystem + ",";
      s += " conveyorUnit=" + conveyorUnit + ",";
      s += " conveyorPLace=" + conveyorPlace + ",";
      s += " infoFlags1=" + bitsToString(infoFlags1) + ",";
      s += " infoFlags2=" + bitsToString(infoFlags2) + ",";
      s += " reserve1=" + bitsToString(reserve1) + ",";
      s += " resreve2=" + bitsToString(reserve2) + ",";
      s += " data=" + data.replaceAll("\n", "\0") + ",";
    }
    return s;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, topic, 2);
    if (topic == 1) {
      hex = insertIntIntoHex(hex, partNumber, 2);
      hex = insertIntIntoHex(hex, numberOfParts, 2);
      hex = insertStringIntoHex(hex, NGKPTelegram.formatString(socID, 4));
      hex = insertIntIntoHex(hex, conveyorSystem, 2);
      hex = insertIntIntoHex(hex, conveyorUnit, 2);
      hex = insertIntIntoHex(hex, conveyorPlace, 2);
      hex = insertBitsIntoHex(hex, infoFlags1, 1);
      hex = insertBitsIntoHex(hex, infoFlags2, 1);
      hex = insertBitsIntoHex(hex, reserve1, 1);
      hex = insertBitsIntoHex(hex, reserve2, 1);
      hex = insertStringIntoHex(hex, NGKPTelegram.formatString(data, DATA_LENGTH));
    }
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    version = extractIntFromHex(hex, 8, 2);
    topic = extractIntFromHex(hex, 10, 2);
    if (topic == 1) {
      partNumber = extractIntFromHex(hex, 12, 2);
      numberOfParts = extractIntFromHex(hex, 14, 2);
      socID = extractStringFromHex(hex, 16, 4);
      conveyorSystem = extractIntFromHex(hex, 20, 2);
      conveyorUnit = extractIntFromHex(hex, 22, 2);
      conveyorPlace = extractIntFromHex(hex, 24, 2);
      extractBitsFromHex(hex, infoFlags1, 26, 1);
      extractBitsFromHex(hex, infoFlags2, 27, 1);
      extractBitsFromHex(hex, reserve1, 28, 1);
      extractBitsFromHex(hex, reserve1, 29, 1);
      data = extractStringFromHex(hex, 30, DATA_LENGTH);
    }
  }

  public int getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(int partNumber) {
    this.partNumber = partNumber;
  }

  public int getNumberOfParts() {
    return numberOfParts;
  }

  public void setNumberOfParts(int numberOfParts) {
    this.numberOfParts = numberOfParts;
  }

  public String getSocID() {
    return socID;
  }

  public void setSocID(String socID) {
    this.socID = socID;
  }

  public int getConveyorSystem() {
    return conveyorSystem;
  }

  public void setConveyorSystem(int conveyorSystem) {
    this.conveyorSystem = conveyorSystem;
  }

  public int getConveyorUnit() {
    return conveyorUnit;
  }

  public void setConveyorUnit(int conveyorUnit) {
    this.conveyorUnit = conveyorUnit;
  }

  public int getConveyorPlace() {
    return conveyorPlace;
  }

  public void setConveyorPlace(int conveyorPlace) {
    this.conveyorPlace = conveyorPlace;
  }

  public boolean[] getInfoFlags1() {
    return infoFlags1;
  }

  public void setInfoFlags1(boolean[] infoFlags1) {
    this.infoFlags1 = infoFlags1;
  }

  public boolean[] getInfoFlags2() {
    return infoFlags2;
  }

  public void setInfoFlags2(boolean[] infoFlags2) {
    this.infoFlags2 = infoFlags2;
  }

  public boolean[] getReserve1() {
    return reserve1;
  }

  public void setReserve1(boolean[] reserve1) {
    this.reserve1 = reserve1;
  }

  public boolean[] getReserve2() {
    return reserve2;
  }

  public void setReserve2(boolean[] reserve2) {
    this.reserve2 = reserve2;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
