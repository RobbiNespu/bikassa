/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7036 telegrams.
 * 
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1613 $, $Date: 2014-01-09 11:01:11 +0100 (Do, 09 Jan 2014) $, $Author: dennis.chong $
 */
public class TT7036 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  protected final static byte STATUS_BIT_CONNECTABLE = 0;
  protected final static byte STATUS_BIT_BROKEN = 1;
  protected final static byte STATUS_BIT_BLOCKED = 2;
  protected final static byte STATUS_BIT_TURBO_USE = 3;

  protected int totalSupports;
  protected int currentSupport;
  protected byte openingNo;
  protected byte rackSide;
  protected int supportNo;
  protected int height;
  protected int absolutePosition;
  protected boolean[] status;

  public TT7036() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 7036;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.status = new boolean[16];
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " totalSupports=" + totalSupports + ",";
    s += " currentSupport=" + currentSupport + ",";
    s += " openingNo=" + openingNo + ",";
    s += " rackSide=" + rackSide + ",";
    s += " supportNo=" + supportNo + ",";
    s += " height=" + height + ",";
    s += " absolutePosition=" + absolutePosition + ",";
    s += " status=" + bitsToString(status);
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
    hex = insertIntIntoHex(hex, totalSupports, 2);
    hex = insertIntIntoHex(hex, currentSupport, 2);
    hex = insertIntIntoHex(hex, openingNo, 1);
    hex = insertIntIntoHex(hex, rackSide, 1);
    hex = insertIntIntoHex(hex, supportNo, 2);
    hex = insertIntIntoHex(hex, height, 2);
    hex = insertIntIntoHex(hex, absolutePosition, 4);
    hex = insertBitsIntoHex(hex, status, 2);
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
    totalSupports = extractIntFromHex(hex, 14, 2);
    currentSupport = extractIntFromHex(hex, 16, 2);
    openingNo = (byte) extractIntFromHex(hex, 18, 1);
    rackSide = (byte) extractIntFromHex(hex, 19, 1);
    supportNo = extractIntFromHex(hex, 20, 2);
    height = extractIntFromHex(hex, 22, 2);
    absolutePosition = extractIntFromHex(hex, 24, 4);
    extractBitsFromHex(hex, status, 28, 2);
  }

  public int getTotalSupports() {
    return totalSupports;
  }

  public void setTotalSupports(int totalSupports) {
    this.totalSupports = totalSupports;
  }

  public int getCurrentSupport() {
    return currentSupport;
  }

  public void setCurrentSupport(int currentSupport) {
    this.currentSupport = currentSupport;
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

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getAbsolutePosition() {
    return absolutePosition;
  }

  public void setAbsolutePosition(int absolutePosition) {
    this.absolutePosition = absolutePosition;
  }

  public void setConnectable(boolean connectable) {
    this.status[STATUS_BIT_CONNECTABLE] = connectable;
  }

  public boolean getConnectable() {
    return this.status[STATUS_BIT_CONNECTABLE];
  }

  public void setBroken(boolean broken) {
    this.status[STATUS_BIT_BROKEN] = broken;
  }

  public boolean getBroken() {
    return this.status[STATUS_BIT_BROKEN];
  }

  public void setBlocked(boolean blocked) {
    this.status[STATUS_BIT_BLOCKED] = blocked;
  }

  public boolean getBlocked() {
    return this.status[STATUS_BIT_BLOCKED];
  }

  public void setTurboUse(boolean turbo) {
    this.status[STATUS_BIT_TURBO_USE] = turbo;
  }

  public boolean getTurboUse() {
    return this.status[STATUS_BIT_TURBO_USE];
  }
}
