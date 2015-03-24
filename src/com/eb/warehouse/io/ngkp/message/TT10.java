/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT10.java,v 1.1 2011/11/21 16:21:04 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT10 telegrams.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1787 $, $Date: 2014-07-02 09:13:37 +0200 (Wed, 02 Jul 2014) $, $Author:
 *          dennis.chong $
 */
public class TT10 extends NGKPTelegram {

  public static final int VOID_ORDER = 0;
  public static final int TRANSPORT_ORDER = 2;
  public static final int FOLLOWUP_ORDER = 4;
  public static final int POSITIONING_ORDER = 5;
  public static final int DELETION_ORDER = 101;
  public static final int COMPLETION = 1;
  public static final int UNABLETODETERMINATEDESTINATION = 5;
  public static final int TRANSPORTNOTICE = 21;
  public static final int ORDERNOTFORTHISSOC = 60;
  public static final int SOURCE_X_WRONG = 61;
  public static final int SOURCE_Y_WRONG = 62;
  public static final int SOURCE_Z_WRONG = 63;
  public static final int DESTINATION_X_WRONG = 64;
  public static final int DESTINATION_Y_WRONG = 65;
  public static final int DESTINATION_Z_WRONG = 66;
  public static final int GENERAL_PLAUSIBILITY_ERROR = 70;
  public static final int STORAGE_NOT_POSSIBLE_TPS_EMPTY = 118;
  public static final int RACK_LOCATION_OCCUPIED = 101;
  public static final int RACK_LOCATION_EMPTY = 102;
  private static final long serialVersionUID = 1L;
  protected int mfsID;
  protected int sourceSystem;
  protected int sourceUnit;
  protected int sourcePlace;
  protected int sourceReserve;
  protected int sourceSCS;
  protected int sourceAisle;
  protected int sourceX;
  protected int sourceY;
  protected int sourceZ;
  protected int destinationSystem;
  protected int destinationUnit;
  protected int destinationPlace;
  protected int destinationReserve;
  protected int destinationSCS;
  protected int destinationAisle;
  protected int destinationX;
  protected int destinationY;
  protected int destinationZ;
  protected int lastSystem;
  protected int lastUnit;
  protected int lastPlace;
  protected int lastReserve;
  protected int lastSCS;
  protected int lastAisle;
  protected int lastX;
  protected int lastY;
  protected int lastZ;
  protected int orderStatus1;
  protected int orderStatus2;
  protected boolean[] orderStatus3MSB;
  protected boolean[] orderStatus3LSB;
  protected boolean[] typeInfo;
  protected boolean[] conturError;
  protected String tuBarcode;
  protected String reserve1;
  protected int stretcherProgram;
  protected String reserve2;
  protected String reserve3;

  public TT10() {
    super();
    senderID = 201;
    receiverID = 0;
    telegramType = 10;
    subType = 0;
    version = 0;
    requestID = 0;
    producerID = 0;
    mfsID = 0;
    sourceSystem = 0;
    sourceUnit = 0;
    sourcePlace = 0;
    sourceReserve = 0;
    sourceSCS = 0;
    sourceAisle = 0;
    sourceX = 0;
    sourceY = 0;
    sourceZ = 0;
    destinationSystem = 0;
    destinationUnit = 0;
    destinationPlace = 0;
    destinationReserve = 0;
    destinationSCS = 0;
    destinationAisle = 0;
    destinationX = 0;
    destinationY = 0;
    destinationZ = 0;
    lastSystem = 0;
    lastUnit = 0;
    lastPlace = 0;
    lastReserve = 0;
    lastSCS = 0;
    lastAisle = 0;
    lastX = 0;
    lastY = 0;
    lastZ = 0;
    orderStatus1 = 0;
    orderStatus2 = 0;
    orderStatus3MSB = new boolean[8];
    orderStatus3LSB = new boolean[8];
    typeInfo = new boolean[8];
    conturError = new boolean[8];
    tuBarcode = "        ";
    reserve1 = "000000";
    stretcherProgram = 0;
    reserve2 = "0";
    reserve3 = "00";
  }

  @Override
  public String fieldsToString() {
    String s = "senderID=" + senderID + ",";
    s += " receiverID=" + receiverID + ",";
    s += " telegramType=" + telegramType + ",";
    s += " producerID=" + producerID + ",";
    s += " mfsID=" + mfsID + ",";
    s += " sourceSystem=" + sourceSystem + ",";
    s += " sourceUnit=" + sourceUnit + ",";
    s += " sourcePlace=" + sourcePlace + ",";
    s += " sourceReserve=" + sourceReserve + ",";
    s += " sourceSCS=" + sourceSCS + ",";
    s += " sourceAisle=" + sourceAisle + ",";
    s += " sourceX=" + sourceX + ",";
    s += " sourceY=" + sourceY + ",";
    s += " sourceZ=" + sourceZ + ",";
    s += " destinationSystem=" + destinationSystem + ",";
    s += " destinationUnit=" + destinationUnit + ",";
    s += " destinationPlace=" + destinationPlace + ",";
    s += " destinationReserve=" + destinationReserve + ",";
    s += " destinationSCS=" + destinationSCS + ",";
    s += " destinationAisle=" + destinationAisle + ",";
    s += " destinationX=" + destinationX + ",";
    s += " destinationY=" + destinationY + ",";
    s += " destinationZ=" + destinationZ + ",";
    s += " lastSystem=" + lastSystem + ",";
    s += " lastUnit=" + lastUnit + ",";
    s += " lastPlace=" + lastPlace + ",";
    s += " lastReserve=" + lastReserve + ",";
    s += " lastSCS=" + lastSCS + ",";
    s += " lastAisle=" + lastAisle + ",";
    s += " lastX=" + lastX + ",";
    s += " lastY=" + lastY + ",";
    s += " lastZ=" + lastZ + ",";
    s += " orderStatus1=" + orderStatus1 + ",";
    s += " orderStatus2=" + orderStatus2 + ",";
    s += " orderStatus3MSB=" + bitsToString(orderStatus3MSB) + ",";
    s += " orderStatus3LSB=" + bitsToString(orderStatus3LSB) + ",";
    s += " typeInfo=" + bitsToString(typeInfo) + ",";
    s += " conturError=" + bitsToString(conturError) + ",";
    s += " tuBarcode=" + tuBarcode + ",";
    s += " stretcherProgram=" + stretcherProgram + ",";
    return s;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 1);
    hex = insertIntIntoHex(hex, receiverID, 1);
    hex = insertIntIntoHex(hex, telegramType, 1);
    hex = insertIntIntoHex(hex, producerID, 1);
    hex = insertIntIntoHex(hex, mfsID, 2);
    hex = insertIntIntoHex(hex, sourceSystem, 1);
    hex = insertIntIntoHex(hex, sourceUnit, 1);
    hex = insertIntIntoHex(hex, sourcePlace, 1);
    hex = insertIntIntoHex(hex, sourceReserve, 1);
    hex = insertIntIntoHex(hex, sourceSCS, 1);
    hex = insertIntIntoHex(hex, sourceAisle, 1);
    hex = insertIntIntoHex(hex, sourceX, 2);
    hex = insertIntIntoHex(hex, sourceY, 1);
    hex = insertIntIntoHex(hex, sourceZ, 1);
    hex = insertIntIntoHex(hex, destinationSystem, 1);
    hex = insertIntIntoHex(hex, destinationUnit, 1);
    hex = insertIntIntoHex(hex, destinationPlace, 1);
    hex = insertIntIntoHex(hex, destinationReserve, 1);
    hex = insertIntIntoHex(hex, destinationSCS, 1);
    hex = insertIntIntoHex(hex, destinationAisle, 1);
    hex = insertIntIntoHex(hex, destinationX, 2);
    hex = insertIntIntoHex(hex, destinationY, 1);
    hex = insertIntIntoHex(hex, destinationZ, 1);
    hex = insertIntIntoHex(hex, lastSystem, 1);
    hex = insertIntIntoHex(hex, lastUnit, 1);
    hex = insertIntIntoHex(hex, lastPlace, 1);
    hex = insertIntIntoHex(hex, lastReserve, 1);
    hex = insertIntIntoHex(hex, lastSCS, 1);
    hex = insertIntIntoHex(hex, lastAisle, 1);
    hex = insertIntIntoHex(hex, lastX, 2);
    hex = insertIntIntoHex(hex, lastY, 1);
    hex = insertIntIntoHex(hex, lastZ, 1);
    hex = insertIntIntoHex(hex, orderStatus1, 2);
    hex = insertIntIntoHex(hex, orderStatus2, 2);
    hex = insertBitsIntoHex(hex, orderStatus3LSB, 1);
    hex = insertBitsIntoHex(hex, orderStatus3MSB, 1);
    hex = insertBitsIntoHex(hex, typeInfo, 1);
    hex = insertBitsIntoHex(hex, conturError, 1);
    hex = insertStringIntoHex(hex, tuBarcode);
    hex = insertStringIntoHex(hex, reserve1);
    hex = insertIntIntoHex(hex, stretcherProgram, 1);
    hex = insertStringIntoHex(hex, reserve2);
    hex = insertStringIntoHex(hex, reserve3);
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 1);
    receiverID = extractIntFromHex(hex, 1, 1);
    telegramType = extractIntFromHex(hex, 2, 1);
    producerID = extractIntFromHex(hex, 3, 1);
    mfsID = extractIntFromHex(hex, 4, 2);
    sourceSystem = extractIntFromHex(hex, 6, 1);
    sourceUnit = extractIntFromHex(hex, 7, 1);
    sourcePlace = extractIntFromHex(hex, 8, 1);
    sourceReserve = extractIntFromHex(hex, 9, 1);
    sourceSCS = extractIntFromHex(hex, 10, 1);
    sourceAisle = extractIntFromHex(hex, 11, 1);
    sourceX = extractIntFromHex(hex, 12, 2);
    sourceY = extractIntFromHex(hex, 14, 1);
    sourceZ = extractIntFromHex(hex, 15, 1);
    destinationSystem = extractIntFromHex(hex, 16, 1);
    destinationUnit = extractIntFromHex(hex, 17, 1);
    destinationPlace = extractIntFromHex(hex, 18, 1);
    destinationReserve = extractIntFromHex(hex, 19, 1);
    destinationSCS = extractIntFromHex(hex, 20, 1);
    destinationAisle = extractIntFromHex(hex, 21, 1);
    destinationX = extractIntFromHex(hex, 22, 2);
    destinationY = extractIntFromHex(hex, 24, 1);
    destinationZ = extractIntFromHex(hex, 25, 1);
    lastSystem = extractIntFromHex(hex, 26, 1);
    lastUnit = extractIntFromHex(hex, 27, 1);
    lastPlace = extractIntFromHex(hex, 28, 1);
    lastReserve = extractIntFromHex(hex, 29, 1);
    lastSCS = extractIntFromHex(hex, 30, 1);
    lastAisle = extractIntFromHex(hex, 31, 1);
    lastX = extractIntFromHex(hex, 32, 2);
    lastY = extractIntFromHex(hex, 34, 1);
    lastZ = extractIntFromHex(hex, 35, 1);
    orderStatus1 = extractIntFromHex(hex, 36, 2);
    orderStatus2 = extractIntFromHex(hex, 38, 2);
    extractBitsFromHex(hex, orderStatus3MSB, 40, 1); //TODO: fixed from Yuriy
    extractBitsFromHex(hex, orderStatus3LSB, 41, 1); // TODO: fixed from Yuriy
    //extractBitsFromHex(hex, orderStatus3LSB, 40, 1); 
    //extractBitsFromHex(hex, orderStatus3MSB, 41, 1); 
    extractBitsFromHex(hex, typeInfo, 42, 1);
    extractBitsFromHex(hex, conturError, 43, 1);
    tuBarcode = extractStringFromHex(hex, 44, 10);
    reserve1 = extractStringFromHex(hex, 54, 4);
    stretcherProgram = extractIntFromHex(hex, 58, 1);
    reserve2 = extractStringFromHex(hex, 59, 1);
    reserve3 = extractStringFromHex(hex, 60, 2);
  }

  public String getSourceConveyerID() {
    return getSourceSystem() + "/" + getSourceUnit() + "/" + getSourcePlace();
  }

  public String getDestinationConveyerID() {
    return getDestinationSystem() + "/" + getDestinationUnit() + "/" + getDestinationPlace();
  }

  public String getLastNoticeConveyerID() {
    return getLastSystem() + "/" + getLastUnit() + "/" + getLastPlace();
  }

  public String getSourceLocationID() {
    return getSourceSCS() + "/" + getSourceAisle() + "/" + getSourceX() + "/" + getSourceY() + "/"
           + getSourceZ();
  }

  public String getDestinationLocationID() {
    return getDestinationSCS() + "/" + getDestinationAisle() + "/" + getDestinationX() + "/"
           + getDestinationY() + "/" + getDestinationZ();
  }

  public String getLastNoticeLocationID() {
    return getLastSCS() + "/" + getLastAisle() + "/" + getLastX() + "/" + getLastY() + "/"
           + getLastZ();
  }

  public boolean isTransportOrder() {
    return orderStatus1 == TT10.TRANSPORT_ORDER;
  }

  public boolean isPositioningOrder() {
    return orderStatus1 == TT10.POSITIONING_ORDER;
  }

  public boolean isDeletionOrder() {
    return orderStatus1 == TT10.DELETION_ORDER;
  }

  public boolean isFollowupOrder() {
    return orderStatus1 == TT10.FOLLOWUP_ORDER;
  }

  public int getMfsID() {
    return mfsID;
  }

  public void setMfsID(int mfsID) {
    this.mfsID = mfsID;
  }

  public int getSourceSystem() {
    return sourceSystem;
  }

  public void setSourceSystem(int sourceSystem) {
    this.sourceSystem = sourceSystem;
  }

  public int getSourceUnit() {
    return sourceUnit;
  }

  public void setSourceUnit(int sourceUnit) {
    this.sourceUnit = sourceUnit;
  }

  public int getSourcePlace() {
    return sourcePlace;
  }

  public void setSourcePlace(int sourcePlace) {
    this.sourcePlace = sourcePlace;
  }

  public int getSourceReserve() {
    return sourceReserve;
  }

  public void setSourceReserve(int sourceReserve) {
    this.sourceReserve = sourceReserve;
  }

  public int getSourceSCS() {
    return sourceSCS;
  }

  public void setSourceSCS(int sourceSCS) {
    this.sourceSCS = sourceSCS;
  }

  public int getSourceAisle() {
    return sourceAisle;
  }

  public void setSourceAisle(int sourceAisle) {
    this.sourceAisle = sourceAisle;
  }

  public int getSourceX() {
    return sourceX;
  }

  public void setSourceX(int sourceX) {
    this.sourceX = sourceX;
  }

  public int getSourceY() {
    return sourceY;
  }

  public void setSourceY(int sourceY) {
    this.sourceY = sourceY;
  }

  public int getSourceZ() {
    return sourceZ;
  }

  public void setSourceZ(int sourceZ) {
    this.sourceZ = sourceZ;
  }

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

  public int getDestinationPlace() {
    return destinationPlace;
  }

  public void setDestinationPlace(int destinationPlace) {
    this.destinationPlace = destinationPlace;
  }

  public int getDestinationReserve() {
    return destinationReserve;
  }

  public void setDestinationReserve(int destinationReserve) {
    this.destinationReserve = destinationReserve;
  }

  public int getDestinationSCS() {
    return destinationSCS;
  }

  public void setDestinationSCS(int destinationSCS) {
    this.destinationSCS = destinationSCS;
  }

  public int getDestinationAisle() {
    return destinationAisle;
  }

  public void setDestinationAisle(int destinationAisle) {
    this.destinationAisle = destinationAisle;
  }

  public int getDestinationX() {
    return destinationX;
  }

  public void setDestinationX(int destinationX) {
    this.destinationX = destinationX;
  }

  public int getDestinationY() {
    return destinationY;
  }

  public void setDestinationY(int destinationY) {
    this.destinationY = destinationY;
  }

  public int getDestinationZ() {
    return destinationZ;
  }

  public void setDestinationZ(int destinationZ) {
    this.destinationZ = destinationZ;
  }

  public int getLastSystem() {
    return lastSystem;
  }

  public void setLastSystem(int lastSystem) {
    this.lastSystem = lastSystem;
  }

  public int getLastUnit() {
    return lastUnit;
  }

  public void setLastUnit(int lastUnit) {
    this.lastUnit = lastUnit;
  }

  public int getLastPlace() {
    return lastPlace;
  }

  public void setLastPlace(int lastPlace) {
    this.lastPlace = lastPlace;
  }

  public int getLastReserve() {
    return lastReserve;
  }

  public void setLastReserve(int lastReserve) {
    this.lastReserve = lastReserve;
  }

  public int getLastSCS() {
    return lastSCS;
  }

  public void setLastSCS(int lastSCS) {
    this.lastSCS = lastSCS;
  }

  public int getLastAisle() {
    return lastAisle;
  }

  public void setLastAisle(int lastAisle) {
    this.lastAisle = lastAisle;
  }

  public int getLastX() {
    return lastX;
  }

  public void setLastX(int lastX) {
    this.lastX = lastX;
  }

  public int getLastY() {
    return lastY;
  }

  public void setLastY(int lastY) {
    this.lastY = lastY;
  }

  public int getLastZ() {
    return lastZ;
  }

  public void setLastZ(int lastZ) {
    this.lastZ = lastZ;
  }

  public int getOrderStatus1() {
    return orderStatus1;
  }

  public void setOrderStatus1(int orderStatus1) {
    this.orderStatus1 = orderStatus1;
  }

  public int getOrderStatus2() {
    return orderStatus2;
  }

  public void setOrderStatus2(int orderStatus2) {
    this.orderStatus2 = orderStatus2;
  }

  public boolean[] getTypeInfo() {
    return typeInfo;
  }

  public void setTypeInfo(boolean[] typeInfo) {
    this.typeInfo = typeInfo;
  }

  public boolean[] getConturError() {
    return conturError;
  }

  public void setConturError(boolean[] conturError) {
    this.conturError = conturError;
  }

  public String getTuBarcode() {
    return tuBarcode;
  }

  public void setTuBarcode(String tuBarcode) {
    this.tuBarcode = tuBarcode;
  }

  public String getReserve1() {
    return reserve1;
  }

  public void setReserve1(String reserve1) {
    this.reserve1 = reserve1;
  }

  public int getStretcherProgram() {
    return stretcherProgram;
  }

  public void setStretcherProgram(int stretcherProgram) {
    this.stretcherProgram = stretcherProgram;
  }

  public String getReserve2() {
    return reserve2;
  }

  public void setReserve2(String reserve2) {
    this.reserve2 = reserve2;
  }

  public String getReserve3() {
    return reserve3;
  }

  public void setReserve3(String reserve3) {
    this.reserve3 = reserve3;
  }

  /**
   * @return the orderStatus3MSB
   */
  public boolean[] getOrderStatus3MSB() {
    return orderStatus3MSB;
  }

  /**
   * @param orderStatus3MSB the orderStatus3MSB to set
   */
  public void setOrderStatus3MSB(boolean[] orderStatus3MSB) {
    this.orderStatus3MSB = orderStatus3MSB;
  }

  /**
   * @return the orderStatus3LSB
   */
  public boolean[] getOrderStatus3LSB() {
    return orderStatus3LSB;
  }

  /**
   * @param orderStatus3LSB the orderStatus3LSB to set
   */
  public void setOrderStatus3LSB(boolean[] orderStatus3LSB) {
    this.orderStatus3LSB = orderStatus3LSB;
  }
}
