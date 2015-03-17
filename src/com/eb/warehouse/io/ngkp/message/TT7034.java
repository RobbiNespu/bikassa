/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7034 telegrams.
 * 
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1576 $, $Date: 2013-11-29 13:17:05 +0100 (Fr, 29 Nov 2013) $, $Author: dennis.chong $
 */
public class TT7034 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  protected final static int STATUS_BIT_AUTO_ON = 0;
  protected final static int STATUS_BIT_ERROR = 1;
  protected final static int STATUS_BIT_EMERGENCY_STOP = 2;
  protected final static int STATUS_BIT_FIRE_ALARM = 3;
  protected final static int HIGH_BIT_BLOCK = 0;
  protected final static int HIGH_BIT_STUB = 1;
  protected final static int HIGH_BIT_SAFE = 2;
  protected final static int LOW_BIT_LIGHT = 0;
  protected final static int LOW_BIT_TILT = 1;

  protected int activeOrderID;
  protected int bufferedOrderID;
  protected boolean[] status;
  protected int largestSpaceFront;
  protected int largestSpaceRear;
  protected int fillingPercentageFront;
  protected int fillingPercentageRear;
  protected int totalLoadFront;
  protected int totalLoadRear;
  protected int elevatorTrayNo;
  protected int opening1Tray1;
  protected int opening1Tray2;
  protected boolean[] opening1StatusHigh;
  protected boolean[] opening1StatusLow;
  protected int opening2Tray1;
  protected int opening2Tray2;
  protected boolean[] opening2StatusHigh;
  protected boolean[] opening2StatusLow;
  protected int opening3Tray1;
  protected int opening3Tray2;
  protected boolean[] opening3StatusHigh;
  protected boolean[] opening3StatusLow;
  protected int opening4Tray1;
  protected int opening4Tray2;
  protected boolean[] opening4StatusHigh;
  protected boolean[] opening4StatusLow;

  public TT7034() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 7034;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.status = new boolean[16];
    this.opening1StatusHigh = new boolean[16];
    this.opening1StatusLow = new boolean[16];
    this.opening2StatusHigh = new boolean[16];
    this.opening2StatusLow = new boolean[16];
    this.opening3StatusHigh = new boolean[16];
    this.opening3StatusLow = new boolean[16];
    this.opening4StatusHigh = new boolean[16];
    this.opening4StatusLow = new boolean[16];
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " activeOrderID=" + activeOrderID + ",";
    s += " bufferedOrderID=" + bufferedOrderID + ",";
    s += " status=" + statusToString(status) + ",";
    s += " largestSpaceFront=" + largestSpaceFront + ",";
    s += " largestSpaceRear=" + largestSpaceRear + ",";
    s += " fillingPercentageFront=" + fillingPercentageFront + ",";
    s += " fillingPercentageRear=" + fillingPercentageRear + ",";
    s += " totalLoadFront=" + totalLoadFront + ",";
    s += " totalLoadRear=" + totalLoadRear + ",";
    s += " elevatorTrayNo=" + elevatorTrayNo + ",";
    s += " opening1Tray1=" + opening1Tray1 + ",";
    s += " opening1Tray2=" + opening1Tray2 + ",";
    s += " opening1StatusHigh=" + highStatusToString(opening1StatusHigh) + ",";
    s += " opening1StatusLow=" + lowStatusToString(opening1StatusLow) + ",";
    s += " opening2Tray1=" + opening2Tray1 + ",";
    s += " opening2Tray2=" + opening2Tray2 + ",";
    s += " opening2StatusHigh=" + highStatusToString(opening2StatusHigh) + ",";
    s += " opening2StatusLow=" + lowStatusToString(opening2StatusLow) + ",";
    s += " opening3Tray1=" + opening3Tray1 + ",";
    s += " opening3Tray2=" + opening3Tray2 + ",";
    s += " opening3StatusHigh=" + highStatusToString(opening3StatusHigh) + ",";
    s += " opening3StatusLow=" + lowStatusToString(opening3StatusLow) + ",";
    s += " opening4Tray1=" + opening4Tray1 + ",";
    s += " opening4Tray2=" + opening4Tray2 + ",";
    s += " opening4StatusHigh=" + highStatusToString(opening4StatusHigh) + ",";
    s += " opening4StatusLow=" + lowStatusToString(opening4StatusLow);
    return s;
  }

  private String statusToString(boolean[] bits) {
    String s = "[autoON=" + bits[STATUS_BIT_AUTO_ON] + ",";
    s += " error=" + bits[STATUS_BIT_ERROR] + ",";
    s += " emergency=" + bits[STATUS_BIT_EMERGENCY_STOP] + ",";
    s += " fireAlarm=" + bits[STATUS_BIT_FIRE_ALARM] + "]";
    return s;
  }

  private String lowStatusToString(boolean[] bits) {
    String s = "[tilt=" + bits[LOW_BIT_TILT] + ",";
    s += " light=" + bits[LOW_BIT_LIGHT] + "]";
    return s;
  }

  private String highStatusToString(boolean[] bits) {
    String s = "[safe=" + bits[HIGH_BIT_SAFE] + ",";
    s += " stub=" + bits[HIGH_BIT_STUB] + ",";
    s += " block=" + bits[HIGH_BIT_BLOCK] + "]";
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
    hex = insertBitsIntoHex(hex, status, 2);
    hex = insertIntIntoHex(hex, 0, 2);
    hex = insertIntIntoHex(hex, activeOrderID, 4);
    hex = insertIntIntoHex(hex, bufferedOrderID, 4);
    hex = insertIntIntoHex(hex, largestSpaceFront, 2);
    hex = insertIntIntoHex(hex, largestSpaceRear, 2);
    hex = insertIntIntoHex(hex, fillingPercentageFront, 2);
    hex = insertIntIntoHex(hex, fillingPercentageRear, 2);
    hex = insertIntIntoHex(hex, totalLoadFront, 4);
    hex = insertIntIntoHex(hex, totalLoadRear, 4);
    hex = insertIntIntoHex(hex, elevatorTrayNo, 2);
    hex = insertIntIntoHex(hex, opening1Tray1, 2);
    hex = insertIntIntoHex(hex, opening1Tray2, 2);
    hex = insertBitsIntoHex(hex, opening1StatusHigh, 2);
    hex = insertBitsIntoHex(hex, opening1StatusLow, 2);
    hex = insertIntIntoHex(hex, opening2Tray1, 2);
    hex = insertIntIntoHex(hex, opening2Tray2, 2);
    hex = insertBitsIntoHex(hex, opening2StatusHigh, 2);
    hex = insertBitsIntoHex(hex, opening2StatusLow, 2);
    hex = insertIntIntoHex(hex, opening3Tray1, 2);
    hex = insertIntIntoHex(hex, opening3Tray2, 2);
    hex = insertBitsIntoHex(hex, opening3StatusHigh, 2);
    hex = insertBitsIntoHex(hex, opening3StatusLow, 2);
    hex = insertIntIntoHex(hex, opening4Tray1, 2);
    hex = insertIntIntoHex(hex, opening4Tray2, 2);
    hex = insertBitsIntoHex(hex, opening4StatusHigh, 2);
    hex = insertBitsIntoHex(hex, opening4StatusLow, 2);
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
    extractBitsFromHex(hex, status, 14, 2);
    // res 2
    activeOrderID = extractIntFromHex(hex, 18, 4);
    bufferedOrderID = extractIntFromHex(hex, 22, 4);
    largestSpaceFront = extractIntFromHex(hex, 26, 2);
    largestSpaceRear = extractIntFromHex(hex, 28, 2);
    fillingPercentageFront = extractIntFromHex(hex, 30, 2);
    fillingPercentageRear = extractIntFromHex(hex, 32, 2);
    totalLoadFront = extractIntFromHex(hex, 34, 4);
    totalLoadRear = extractIntFromHex(hex, 38, 4);
    elevatorTrayNo = extractIntFromHex(hex, 42, 2);
    opening1Tray1 = extractIntFromHex(hex, 44, 2);
    opening1Tray2 = extractIntFromHex(hex, 46, 2);
    extractBitsFromHex(hex, opening1StatusHigh, 48, 2);
    extractBitsFromHex(hex, opening1StatusLow, 50, 2);
    opening2Tray1 = extractIntFromHex(hex, 52, 2);
    opening2Tray2 = extractIntFromHex(hex, 54, 2);
    extractBitsFromHex(hex, opening2StatusHigh, 56, 2);
    extractBitsFromHex(hex, opening2StatusLow, 58, 2);
    opening3Tray1 = extractIntFromHex(hex, 60, 2);
    opening3Tray2 = extractIntFromHex(hex, 62, 2);
    extractBitsFromHex(hex, opening3StatusHigh, 64, 2);
    extractBitsFromHex(hex, opening3StatusLow, 66, 2);
    opening4Tray1 = extractIntFromHex(hex, 68, 2);
    opening4Tray2 = extractIntFromHex(hex, 70, 2);
    extractBitsFromHex(hex, opening4StatusHigh, 72, 2);
    extractBitsFromHex(hex, opening4StatusLow, 74, 2);
  }

  public int getActiveOrderID() {
    return activeOrderID;
  }

  public void setActiveOrderID(int activeOrderID) {
    this.activeOrderID = activeOrderID;
  }

  public int getBufferedOrderID() {
    return bufferedOrderID;
  }

  public void setBufferedOrderID(int bufferedOrderID) {
    this.bufferedOrderID = bufferedOrderID;
  }

  public int getElevatorTrayNo() {
    return elevatorTrayNo;
  }

  public void setElevatorTrayNo(int elevatorTrayNo) {
    this.elevatorTrayNo = elevatorTrayNo;
  }

  public int getLargestSpaceFront() {
    return largestSpaceFront;
  }

  public void setLargestSpaceFront(int largestSpaceFront) {
    this.largestSpaceFront = largestSpaceFront;
  }

  public int getLargestSpaceRear() {
    return largestSpaceRear;
  }

  public void setLargestSpaceRear(int largestSpaceRear) {
    this.largestSpaceRear = largestSpaceRear;
  }

  public int getFillingPercentageFront() {
    return fillingPercentageFront;
  }

  public void setFillingPercentageFront(int fillingPercentageFront) {
    this.fillingPercentageFront = fillingPercentageFront;
  }

  public int getFillingPercentageRear() {
    return fillingPercentageRear;
  }

  public void setFillingPercentageRear(int fillingPercentageRear) {
    this.fillingPercentageRear = fillingPercentageRear;
  }

  public int getTotalLoadFront() {
    return totalLoadFront;
  }

  public void setTotalLoadFront(int totalLoadFront) {
    this.totalLoadFront = totalLoadFront;
  }

  public int getTotalLoadRear() {
    return totalLoadRear;
  }

  public void setTotalLoadRear(int totalLoadRear) {
    this.totalLoadRear = totalLoadRear;
  }

  public int getOpening1Tray1() {
    return opening1Tray1;
  }

  public void setOpening1Tray1(int opening1Tray1) {
    this.opening1Tray1 = opening1Tray1;
  }

  public int getOpening1Tray2() {
    return opening1Tray2;
  }

  public void setOpening1Tray2(int opening1Tray2) {
    this.opening1Tray2 = opening1Tray2;
  }

  public int getOpening2Tray1() {
    return opening2Tray1;
  }

  public void setOpening2Tray1(int opening2Tray1) {
    this.opening2Tray1 = opening2Tray1;
  }

  public int getOpening2Tray2() {
    return opening2Tray2;
  }

  public void setOpening2Tray2(int opening2Tray2) {
    this.opening2Tray2 = opening2Tray2;
  }

  public int getOpening3Tray1() {
    return opening3Tray1;
  }

  public void setOpening3Tray1(int opening3Tray1) {
    this.opening3Tray1 = opening3Tray1;
  }

  public int getOpening3Tray2() {
    return opening3Tray2;
  }

  public void setOpening3Tray2(int opening3Tray2) {
    this.opening3Tray2 = opening3Tray2;
  }

  public int getOpening4Tray1() {
    return opening4Tray1;
  }

  public void setOpening4Tray1(int opening4Tray1) {
    this.opening4Tray1 = opening4Tray1;
  }

  public int getOpening4Tray2() {
    return opening4Tray2;
  }

  public void setOpening4Tray2(int opening4Tray2) {
    this.opening4Tray2 = opening4Tray2;
  }

  public void setOpening1Block(boolean block) {
    this.opening1StatusHigh[HIGH_BIT_BLOCK] = block;
  }

  public boolean getOpening1Block() {
    return this.opening1StatusHigh[HIGH_BIT_BLOCK];
  }

  public void setOpening1Stub(boolean stub) {
    this.opening1StatusHigh[HIGH_BIT_STUB] = stub;
  }

  public boolean getOpening1Stub() {
    return this.opening1StatusHigh[HIGH_BIT_STUB];
  }

  public void setOpening1Safe(boolean safe) {
    this.opening1StatusHigh[HIGH_BIT_SAFE] = safe;
  }

  public boolean getOpening1Safe() {
    return this.opening1StatusHigh[HIGH_BIT_SAFE];
  }

  public void setOpening1Light(boolean light) {
    this.opening1StatusLow[LOW_BIT_LIGHT] = light;
  }

  public boolean getOpening1Light() {
    return this.opening1StatusLow[LOW_BIT_LIGHT];
  }

  public void setOpening1Tilt(boolean tilt) {
    this.opening1StatusLow[LOW_BIT_TILT] = tilt;
  }

  public boolean getOpening1Tilt() {
    return this.opening1StatusLow[LOW_BIT_TILT];
  }

  public void setOpening2Block(boolean block) {
    this.opening2StatusHigh[HIGH_BIT_BLOCK] = block;
  }

  public boolean getOpening2Block() {
    return this.opening2StatusHigh[HIGH_BIT_BLOCK];
  }

  public void setOpening2Stub(boolean stub) {
    this.opening2StatusHigh[HIGH_BIT_STUB] = stub;
  }

  public boolean getOpening2Stub() {
    return this.opening2StatusHigh[HIGH_BIT_STUB];
  }

  public void setOpening2Safe(boolean safe) {
    this.opening2StatusHigh[HIGH_BIT_SAFE] = safe;
  }

  public boolean getOpening2Safe() {
    return this.opening2StatusHigh[HIGH_BIT_SAFE];
  }

  public void setOpening2Light(boolean light) {
    this.opening2StatusLow[LOW_BIT_LIGHT] = light;
  }

  public boolean getOpening2Light() {
    return this.opening2StatusLow[LOW_BIT_LIGHT];
  }

  public void setOpening2Tilt(boolean tilt) {
    this.opening2StatusLow[LOW_BIT_TILT] = tilt;
  }

  public boolean getOpening2Tilt() {
    return this.opening2StatusLow[LOW_BIT_TILT];
  }

  public void setOpening3Block(boolean block) {
    this.opening3StatusHigh[HIGH_BIT_BLOCK] = block;
  }

  public boolean getOpening3Block() {
    return this.opening3StatusHigh[HIGH_BIT_BLOCK];
  }

  public void setOpening3Stub(boolean stub) {
    this.opening3StatusHigh[HIGH_BIT_STUB] = stub;
  }

  public boolean getOpening3Stub() {
    return this.opening3StatusHigh[HIGH_BIT_STUB];
  }

  public void setOpening3Safe(boolean safe) {
    this.opening3StatusHigh[HIGH_BIT_SAFE] = safe;
  }

  public boolean getOpening3Safe() {
    return this.opening3StatusHigh[HIGH_BIT_SAFE];
  }

  public void setOpening3Light(boolean light) {
    this.opening3StatusLow[LOW_BIT_LIGHT] = light;
  }

  public boolean getOpening3Light() {
    return this.opening3StatusLow[LOW_BIT_LIGHT];
  }

  public void setOpening3Tilt(boolean tilt) {
    this.opening3StatusLow[LOW_BIT_TILT] = tilt;
  }

  public boolean getOpening3Tilt() {
    return this.opening3StatusLow[LOW_BIT_TILT];
  }

  public void setOpening4Block(boolean block) {
    this.opening4StatusHigh[HIGH_BIT_BLOCK] = block;
  }

  public boolean getOpening4Block() {
    return this.opening4StatusHigh[HIGH_BIT_BLOCK];
  }

  public void setOpening4Stub(boolean stub) {
    this.opening4StatusHigh[HIGH_BIT_STUB] = stub;
  }

  public boolean getOpening4Stub() {
    return this.opening4StatusHigh[HIGH_BIT_STUB];
  }

  public void setOpening4Safe(boolean safe) {
    this.opening4StatusHigh[HIGH_BIT_SAFE] = safe;
  }

  public boolean getOpening4Safe() {
    return this.opening4StatusHigh[HIGH_BIT_SAFE];
  }

  public void setOpening4Light(boolean light) {
    this.opening4StatusLow[LOW_BIT_LIGHT] = light;
  }

  public boolean getOpening4Light() {
    return this.opening4StatusLow[LOW_BIT_LIGHT];
  }

  public void setOpening4Tilt(boolean tilt) {
    this.opening4StatusLow[LOW_BIT_TILT] = tilt;
  }

  public boolean getOpening4Tilt() {
    return this.opening4StatusLow[LOW_BIT_TILT];
  }

  public void setAutoON(boolean status) {
    this.status[STATUS_BIT_AUTO_ON] = status;
  }

  public void setError(boolean status) {
    this.status[STATUS_BIT_ERROR] = status;
  }
}
