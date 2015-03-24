/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7035 telegrams.
 *
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1613 $, $Date: 2014-01-09 11:01:11 +0100 (Do, 09 Jan 2014) $, $Author:
 *          dennis.chong $
 */
public class TT7035 extends NGKPTelegram {

  public final static byte CLASS_OFF = 0;
  public final static byte CLASS_A = 1;
  public final static byte CLASS_B = 2;
  public final static byte CLASS_C = 3;
  public final static byte STATUS_BIT_BROKEN = 0;
  public final static byte STATUS_BIT_BLOCKED = 1;
  private static final long serialVersionUID = 1L;
  protected int totalTrays;
  protected int currentTray;
  protected int trayNo;
  protected boolean[] status;
  protected int trayLoad;
  protected int maximumLoad;
  protected int trayWeight;
  protected int trayHeight;
  protected int emptyTrayHeight;
  protected String trayID;
  protected byte tilt;
  protected byte security;
  protected byte velocityHorizontal;
  protected byte velocityVertical;
  protected byte accelerationHorizontal;
  protected byte accelerationVertical;
  protected byte decelerationHorizontal;
  protected byte decelerationVertical;
  protected byte classABC;
  protected byte currentOpeningNo;
  protected byte currentSide;
  protected int currentSupportNo;
  protected byte currentSlideNo;
  protected byte originalOpeningNo;
  protected byte originalSide;
  protected int originalSupportNo;
  protected byte originalSlideNo;
  protected int trayCycles;

  public TT7035() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 7035;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.status = new boolean[16];
    this.trayID = "00000001001";
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " totalTrays=" + totalTrays + ",";
    s += " currentTray=" + currentTray + ",";
    s += " trayNo=" + trayNo + ",";
    s += " status=" + bitsToString(status) + ",";
    s += " trayLoad=" + trayLoad + ",";
    s += " maximumLoad=" + maximumLoad + ",";
    s += " trayWeight=" + trayWeight + ",";
    s += " trayHeight=" + trayHeight + ",";
    s += " emptyTrayHeight=" + emptyTrayHeight + ",";
    s += " trayID=" + trayID + ",";
    s += " tilt=" + tilt + ",";
    s += " security=" + security + ",";
    s += " velocityHorizontal=" + velocityHorizontal + ",";
    s += " velocityVertical=" + velocityVertical + ",";
    s += " accelerationHorizontal=" + accelerationHorizontal + ",";
    s += " accelerationVertical=" + accelerationVertical + ",";
    s += " decelerationHorizontal=" + decelerationHorizontal + ",";
    s += " decelerationVertical=" + decelerationVertical + ",";
    s += " classABC=" + classABC + ",";
    s += " currentOpeningNo=" + currentOpeningNo + ",";
    s += " currentRack=" + currentSide + ",";
    s += " currentSupportNo=" + currentSupportNo + ",";
    s += " currentSlideNo=" + currentSlideNo + ",";
    s += " originalOpeningNo=" + originalOpeningNo + ",";
    s += " originalSide=" + originalSide + ",";
    s += " originalSupportNo=" + originalSupportNo + ",";
    s += " originalSlideNo=" + originalSlideNo + ",";
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
    hex = insertIntIntoHex(hex, totalTrays, 2);
    hex = insertIntIntoHex(hex, currentTray, 2);
    hex = insertIntIntoHex(hex, trayNo, 2);
    hex = insertIntIntoHex(hex, 0, 2);
    hex = insertBitsIntoHex(hex, status, 2);
    hex = insertIntIntoHex(hex, trayLoad, 2);
    hex = insertIntIntoHex(hex, maximumLoad, 2);
    hex = insertIntIntoHex(hex, trayWeight, 2);
    hex = insertIntIntoHex(hex, trayHeight, 2);
    hex = insertIntIntoHex(hex, emptyTrayHeight, 2);
    hex = insertStringIntoHex(hex, trayID);
    hex = insertIntIntoHex(hex, 0, 1);
    hex = insertIntIntoHex(hex, tilt, 1);
    hex = insertIntIntoHex(hex, security, 1);
    hex = insertIntIntoHex(hex, velocityHorizontal, 1);
    hex = insertIntIntoHex(hex, velocityVertical, 1);
    hex = insertIntIntoHex(hex, accelerationHorizontal, 1);
    hex = insertIntIntoHex(hex, accelerationVertical, 1);
    hex = insertIntIntoHex(hex, decelerationHorizontal, 1);
    hex = insertIntIntoHex(hex, decelerationVertical, 1);
    hex = insertIntIntoHex(hex, classABC, 1);
    hex = insertIntIntoHex(hex, 0, 1);
    hex = insertIntIntoHex(hex, currentOpeningNo, 1);
    hex = insertIntIntoHex(hex, currentSide, 1);
    hex = insertIntIntoHex(hex, currentSupportNo, 2);
    hex = insertIntIntoHex(hex, currentSlideNo, 1);
    hex = insertIntIntoHex(hex, 0, 1);
    hex = insertIntIntoHex(hex, originalOpeningNo, 1);
    hex = insertIntIntoHex(hex, originalSide, 1);
    hex = insertIntIntoHex(hex, originalSupportNo, 2);
    hex = insertIntIntoHex(hex, originalSlideNo, 1);
    hex = insertIntIntoHex(hex, 0, 1);
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
    totalTrays = extractIntFromHex(hex, 14, 2);
    currentTray = extractIntFromHex(hex, 16, 2);
    trayNo = extractIntFromHex(hex, 18, 2);
    // res 2
    extractBitsFromHex(hex, status, 22, 2);
    trayLoad = extractIntFromHex(hex, 24, 2);
    maximumLoad = extractIntFromHex(hex, 26, 2);
    trayWeight = extractIntFromHex(hex, 28, 2);
    trayHeight = extractIntFromHex(hex, 30, 2);
    emptyTrayHeight = extractIntFromHex(hex, 32, 2);
    trayID = extractStringFromHex(hex, 34, 11);
    // res 1
    tilt = (byte) extractIntFromHex(hex, 46, 1);
    security = (byte) extractIntFromHex(hex, 47, 1);
    velocityHorizontal = (byte) extractIntFromHex(hex, 48, 1);
    velocityVertical = (byte) extractIntFromHex(hex, 49, 1);
    accelerationHorizontal = (byte) extractIntFromHex(hex, 50, 1);
    accelerationVertical = (byte) extractIntFromHex(hex, 51, 1);
    decelerationHorizontal = (byte) extractIntFromHex(hex, 52, 1);
    decelerationVertical = (byte) extractIntFromHex(hex, 53, 1);
    classABC = (byte) extractIntFromHex(hex, 54, 1);
    // res 1
    currentOpeningNo = (byte) extractIntFromHex(hex, 56, 1);
    currentSide = (byte) extractIntFromHex(hex, 57, 1);
    currentSupportNo = extractIntFromHex(hex, 58, 2);
    currentSlideNo = (byte) extractIntFromHex(hex, 59, 1);
    // res 1
    originalOpeningNo = (byte) extractIntFromHex(hex, 62, 1);
    originalSide = (byte) extractIntFromHex(hex, 63, 1);
    originalSupportNo = extractIntFromHex(hex, 64, 2);
    originalSlideNo = (byte) extractIntFromHex(hex, 66, 1);
    // res3
    trayCycles = extractIntFromHex(hex, 70, 4);
  }

  public int getTotalTrays() {
    return totalTrays;
  }

  public void setTotalTrays(int totalTrays) {
    this.totalTrays = totalTrays;
  }

  public int getCurrentTray() {
    return currentTray;
  }

  public void setCurrentTray(int currentTray) {
    this.currentTray = currentTray;
  }

  public int getTrayNo() {
    return trayNo;
  }

  public void setTrayNo(int trayNo) {
    this.trayNo = trayNo;
  }

  public boolean getBroken() {
    return this.status[STATUS_BIT_BROKEN];
  }

  public void setBroken(boolean broken) {
    this.status[STATUS_BIT_BROKEN] = broken;
  }

  public boolean getBlocked() {
    return this.status[STATUS_BIT_BLOCKED];
  }

  public void setBlocked(boolean blocked) {
    this.status[STATUS_BIT_BLOCKED] = blocked;
  }

  public int getTrayLoad() {
    return trayLoad;
  }

  public void setTrayLoad(int trayLoad) {
    this.trayLoad = trayLoad;
  }

  public int getMaximumLoad() {
    return maximumLoad;
  }

  public void setMaximumLoad(int maximumLoad) {
    this.maximumLoad = maximumLoad;
  }

  public int getTrayWeight() {
    return trayWeight;
  }

  public void setTrayWeight(int trayWeight) {
    this.trayWeight = trayWeight;
  }

  public int getTrayHeight() {
    return trayHeight;
  }

  public void setTrayHeight(int trayHeight) {
    this.trayHeight = trayHeight;
  }

  public int getEmptyTrayHeight() {
    return emptyTrayHeight;
  }

  public void setEmptyTrayHeight(int emptyTrayHeight) {
    this.emptyTrayHeight = emptyTrayHeight;
  }

  public String getTrayID() {
    return trayID;
  }

  public void setTrayID(String trayID) {
    if (trayID == null || trayID.length() != 11) {
      throw new RuntimeException("Invalid tray ID: " + trayID);
    }
    this.trayID = trayID;
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

  public byte getCurrentOpeningNo() {
    return currentOpeningNo;
  }

  public void setCurrentOpeningNo(byte currentOpeningNo) {
    this.currentOpeningNo = currentOpeningNo;
  }

  public byte getCurrentSide() {
    return currentSide;
  }

  public void setCurrentSide(byte currentSide) {
    this.currentSide = currentSide;
  }

  public int getCurrentSupportNo() {
    return currentSupportNo;
  }

  public void setCurrentSupportNo(int currentSupportNo) {
    this.currentSupportNo = currentSupportNo;
  }

  public byte getCurrentSlideNo() {
    return currentSlideNo;
  }

  public void setCurrentSlideNo(byte currentSlideNo) {
    this.currentSlideNo = currentSlideNo;
  }

  public byte getOriginalOpeningNo() {
    return originalOpeningNo;
  }

  public void setOriginalOpeningNo(byte originalOpeningNo) {
    this.originalOpeningNo = originalOpeningNo;
  }

  public byte getOriginalSide() {
    return originalSide;
  }

  public void setOriginalSide(byte originalSide) {
    this.originalSide = originalSide;
  }

  public int getOriginalSupportNo() {
    return originalSupportNo;
  }

  public void setOriginalSupportNo(int originalSupportNo) {
    this.originalSupportNo = originalSupportNo;
  }

  public byte getOriginalSlideNo() {
    return originalSlideNo;
  }

  public void setOriginalSlideNo(byte originalSlideNo) {
    this.originalSlideNo = originalSlideNo;
  }

  public int getTrayCycles() {
    return trayCycles;
  }

  public void setTrayCycles(int trayCycles) {
    this.trayCycles = trayCycles;
  }
}
