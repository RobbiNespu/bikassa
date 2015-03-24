/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7011 telegrams.
 *
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1576 $, $Date: 2013-11-29 13:17:05 +0100 (Fr, 29 Nov 2013) $, $Author:
 *          dennis.chong $
 */
public class TT7011 extends NGKPTelegram {

  public final static byte RACK_ELEVATOR = 3;
  public final static byte RACK_FRONT = 1;
  public final static byte RACK_BACK = 2;
  public final static byte ACK_OK = 1;
  public final static byte ACK_ACTIVE = 2;
  public final static byte ACK_INVALID_TRAY = 11;
  public final static byte ACK_INVALID_DESTINATION = 12;
  public final static byte ACK_INVALID_OPENING = 13;
  public final static byte ACK_ORDER_DELETED = 31;
  public final static byte ACK_ORDER_NOT_DELETED = 32;
  public final static byte ACK_DUPLICATE_ORDER = 33;
  public final static byte ACK_ORDER_BUFFER_FULL = 34;
  public final static byte ACK_FULL_HEIGHT = 51;
  public final static byte ACK_FULL_WEIGHT = 52;
  public final static byte ACK_DESTINATON_OCCUPIED = 53;
  public final static byte ACK_NOT_ENOUGH_SPACE_DESTINATION = 54;
  public final static byte ACK_SOURCE_EMPTY = 55;
  public final static byte ACK_HEIGHT_CHANGED = 101;
  public final static byte ACK_MAXIMUM_HEIGHT_EXCEEDED = 102;
  public final static byte ACK_MAXIMUM_WEIGHT_EXCEEDED = 103;
  public final static byte ACK_GOOD_OVERHANG = 104;
  private static final long serialVersionUID = 1L;
  protected int trayNo;
  protected byte openingNo;
  protected byte rackSide;
  protected int supportNo;
  protected byte traySlideNo;
  protected int actualWeight;
  protected int actualHeight;
  protected byte orderCode;
  protected byte acknowledgeCode;
  protected int trayCycles;

  public TT7011() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 7011;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " trayNo=" + trayNo + ",";
    s += " openingNo=" + openingNo + ",";
    s += " rackSide=" + rackSide + ",";
    s += " supportNo=" + supportNo + ",";
    s += " traySlideNo=" + traySlideNo + ",";
    s += " actualWeight=" + actualWeight + ",";
    s += " actualHeight=" + actualHeight + ",";
    s += " orderCode=" + orderCode + ",";
    s += " acknowledgeCode=" + acknowledgeCode + ",";
    s += " trayCycles=" + trayCycles;
    return s;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, requestID, 4);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, trayNo, 2);
    hex = insertIntIntoHex(hex, openingNo, 1);
    hex = insertIntIntoHex(hex, rackSide, 1);
    hex = insertIntIntoHex(hex, supportNo, 2);
    hex = insertIntIntoHex(hex, traySlideNo, 1);
    hex = insertIntIntoHex(hex, 0, 1);
    hex = insertIntIntoHex(hex, actualWeight, 2);
    hex = insertIntIntoHex(hex, actualHeight, 2);
    hex = insertIntIntoHex(hex, orderCode, 1);
    hex = insertIntIntoHex(hex, acknowledgeCode, 1);
    hex = insertIntIntoHex(hex, 0, 2);
    hex = insertIntIntoHex(hex, trayCycles, 4);
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    requestID = extractIntFromHex(hex, 8, 4);
    version = extractIntFromHex(hex, 12, 2);
    trayNo = extractIntFromHex(hex, 14, 2);
    openingNo = (byte) extractIntFromHex(hex, 16, 1);
    rackSide = (byte) extractIntFromHex(hex, 17, 1);
    supportNo = extractIntFromHex(hex, 18, 2);
    traySlideNo = (byte) extractIntFromHex(hex, 20, 1);
    // res 1
    actualWeight = extractIntFromHex(hex, 22, 2);
    actualHeight = extractIntFromHex(hex, 24, 2);
    orderCode = (byte) extractIntFromHex(hex, 26, 1);
    acknowledgeCode = (byte) extractIntFromHex(hex, 27, 1);
    trayCycles = (byte) extractIntFromHex(hex, 30, 4);
  }

  public int getTrayNo() {
    return trayNo;
  }

  public void setTrayNo(int trayNo) {
    this.trayNo = trayNo;
  }

  public byte getOpeningNo() {
    return openingNo;
  }

  public void setOpeningNo(byte openingNo) {
    this.openingNo = openingNo;
  }

  public byte getRackSide() {
    return rackSide;
  }

  public void setRackSide(byte rackSide) {
    this.rackSide = rackSide;
  }

  public int getSupportNo() {
    return supportNo;
  }

  public void setSupportNo(int supportNo) {
    this.supportNo = supportNo;
  }

  public byte getTraySlideNo() {
    return traySlideNo;
  }

  public void setTraySlideNo(byte traySlideNo) {
    this.traySlideNo = traySlideNo;
  }

  public int getActualWeight() {
    return actualWeight;
  }

  public void setActualWeight(int actualWeight) {
    this.actualWeight = actualWeight;
  }

  public int getActualHeight() {
    return actualHeight;
  }

  public void setActualHeight(int actualHeight) {
    this.actualHeight = actualHeight;
  }

  public byte getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(byte orderCode) {
    this.orderCode = orderCode;
  }

  public byte getAcknowledgeCode() {
    return acknowledgeCode;
  }

  public void setAcknowledgeCode(byte acknowledgeCode) {
    this.acknowledgeCode = acknowledgeCode;
  }

  public int getTrayCycles() {
    return trayCycles;
  }

  public void setTrayCycles(int trayCycles) {
    this.trayCycles = trayCycles;
  }
}
