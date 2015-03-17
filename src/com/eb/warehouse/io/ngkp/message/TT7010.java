/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7010 telegrams.
 * 
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1613 $, $Date: 2014-01-09 11:01:11 +0100 (Do, 09 Jan 2014) $, $Author: dennis.chong $
 */
public class TT7010 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  public final static int ORDER_CODE_TRANSPORT_REQUEST = 11;
  public final static int ORDER_CODE_FOLLOWUP_REQUEST = 12;
  public final static int ORDER_CODE_DELETE_REQUEST = 101;
  public final static int ORDER_CODE_DELETE_ALL_ORDERS = 103;
  public final static int RACK_PLC_AUTO = 0;
  public final static int RACK_FRONT = 1;
  public final static int RACK_BACK = 2;
  public final static int TILT_OFF = 0;
  public final static int TILT_ON = 1;
  public final static int TURBO = 0;
  public final static int CHECK_WEIGHT = 1;

  protected int trayNo;
  protected byte openingNo;
  protected byte rackSide;
  protected int supportNo;
  protected byte traySlideNo;
  protected byte orderCode;
  protected boolean[] extensions;
  protected byte tilt;
  protected byte security;
  protected byte velocityHorizontal;
  protected byte velocityVertical;
  protected byte accelerationHorizontal;
  protected byte accelerationVertical;
  protected byte decelerationHorizontal;
  protected byte decelerationVertical;
  protected int maximumHeight;
  protected int expectedWeight;
  protected byte classABC;

  public TT7010() {
    super();
    this.senderID = 20001;
    this.receiverID = 0;
    this.telegramType = 7010;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.extensions = new boolean[8];
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " trayNo=" + trayNo + ",";
    s += " openingNo=" + openingNo + ",";
    s += " rackSide=" + rackSide + ",";
    s += " supportNo=" + supportNo + ",";
    s += " traySlideNo=" + traySlideNo + ",";
    s += " orderCode=" + orderCode + ",";
    s += " extensions=" + bitsToString(extensions) + ",";
    s += " tilt=" + tilt + ",";
    s += " security=" + security + ",";
    s += " velocityHorizontal=" + velocityHorizontal + ",";
    s += " velocityVertical=" + velocityVertical + ",";
    s += " accelerationHorizontal=" + accelerationHorizontal + ",";
    s += " accelerationVertical=" + accelerationVertical + ",";
    s += " decelerationHorizontal=" + decelerationHorizontal + ",";
    s += " decelerationVertical=" + decelerationVertical + ",";
    s += " maximumHeight=" + maximumHeight + ",";
    s += " expectedWeight=" + expectedWeight + ",";
    s += " classABC=" + classABC;
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
    hex = insertIntIntoHex(hex, orderCode, 1);
    hex = insertBitsIntoHex(hex, extensions, 1);
    hex = insertIntIntoHex(hex, tilt, 1);
    hex = insertIntIntoHex(hex, security, 1);
    hex = insertIntIntoHex(hex, velocityHorizontal, 1);
    hex = insertIntIntoHex(hex, velocityVertical, 1);
    hex = insertIntIntoHex(hex, accelerationHorizontal, 1);
    hex = insertIntIntoHex(hex, accelerationVertical, 1);
    hex = insertIntIntoHex(hex, decelerationHorizontal, 1);
    hex = insertIntIntoHex(hex, decelerationVertical, 1);
    hex = insertIntIntoHex(hex, maximumHeight, 2);
    hex = insertIntIntoHex(hex, expectedWeight, 2);
    hex = insertIntIntoHex(hex, classABC, 1);
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
    // reserved 1
    orderCode = (byte) extractIntFromHex(hex, 22, 1);
    extractBitsFromHex(hex, extensions, 23, 1);
    tilt = (byte) extractIntFromHex(hex, 24, 1);
    security = (byte) extractIntFromHex(hex, 25, 1);
    velocityHorizontal = (byte) extractIntFromHex(hex, 26, 1);
    velocityVertical = (byte) extractIntFromHex(hex, 27, 1);
    accelerationHorizontal = (byte) extractIntFromHex(hex, 28, 1);
    accelerationVertical = (byte) extractIntFromHex(hex, 29, 1);
    decelerationHorizontal = (byte) extractIntFromHex(hex, 30, 1);
    decelerationVertical = (byte) extractIntFromHex(hex, 31, 1);
    maximumHeight = extractIntFromHex(hex, 32, 2);
    expectedWeight = extractIntFromHex(hex, 34, 2);
    classABC = (byte) extractIntFromHex(hex, 36, 1);
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

  public byte getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(byte orderCode) {
    this.orderCode = orderCode;
  }

  public byte getTilt() {
    return tilt;
  }

  public void setTilt(byte tilt) {
    this.tilt = tilt;
  }

  public byte getSecurity() {
    return security;
  }

  public void setSecurity(byte security) {
    this.security = security;
  }

  public byte getVelocityHorizontal() {
    return velocityHorizontal;
  }

  public void setVelocityHorizontal(byte velocityHorizontal) {
    this.velocityHorizontal = velocityHorizontal;
  }

  public byte getVelocityVertical() {
    return velocityVertical;
  }

  public void setVelocityVertical(byte velocityVertical) {
    this.velocityVertical = velocityVertical;
  }

  public byte getAccelerationHorizontal() {
    return accelerationHorizontal;
  }

  public void setAccelerationHorizontal(byte accelerationHorizontal) {
    this.accelerationHorizontal = accelerationHorizontal;
  }

  public byte getAccelerationVertical() {
    return accelerationVertical;
  }

  public void setAccelerationVertical(byte accelerationVertical) {
    this.accelerationVertical = accelerationVertical;
  }

  public byte getDecelerationHorizontal() {
    return decelerationHorizontal;
  }

  public void setDecelerationHorizontal(byte decelerationHorizontal) {
    this.decelerationHorizontal = decelerationHorizontal;
  }

  public byte getDecelerationVertical() {
    return decelerationVertical;
  }

  public void setDecelerationVertical(byte decelerationVertical) {
    this.decelerationVertical = decelerationVertical;
  }

  public byte getClassABC() {
    return classABC;
  }

  public void setClassABC(byte classABC) {
    this.classABC = classABC;
  }

  public int getMaximumHeight() {
    return maximumHeight;
  }

  public void setMaximumHeight(int maximumHeight) {
    this.maximumHeight = maximumHeight;
  }

  public int getExpectedWeight() {
    return expectedWeight;
  }

  public void setExpectedWeight(int expectedWeight) {
    this.expectedWeight = expectedWeight;
  }

  public void setTurbo(boolean turbo) {
    extensions[TURBO] = turbo;
  }

  public boolean getTurbo() {
    return extensions[TURBO];
  }

  public void setCheckWeight(boolean checkWeight) {
    extensions[CHECK_WEIGHT] = checkWeight;
  }

  public boolean getCheckWeight() {
    return extensions[CHECK_WEIGHT];
  }
}
