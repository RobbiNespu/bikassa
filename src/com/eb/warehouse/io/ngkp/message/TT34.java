/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/wmlau/simulation/scs/telegrams/TT34.java,v 1.1 2011/11/21 16:21:04 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:draeger@ssi-schaefer-noell.com">draeger</a>
 * @version $Revision: 1793 $, $Date: 2014-07-14 16:55:41 +0200 (Mon, 14 Jul 2014) $, $Author: dennis.chong $
 */

public class TT34 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  private int reserve;
  private int srmNo;
  private boolean[][] systemStatus;
  private boolean[][] activities;
  private int numberOfOrders;
  private int aisle;
  private int xCoordinate;
  private int yCoordinate;
  private int zCoordinate;
  private int currentPalletTypeFork1;
  private int currentPalletTypeFork2;
  private int currentPalletTypeFork3;
  private int currentPalletTypeFork4;
  private int activeOrderFork1TuGoingTo;
  private int activeOrderFork2;
  private int activeOrderFork1PrePositionCarousel;
  private int activeOrderFork4;
  private int bufferStorage1;
  private int bufferStorage2;
  private int bufferStorage3;
  private int bufferStorage4;
  private int bufferRetrieval1;
  private int bufferRetrieval2;
  private int bufferRetrieval3;
  private int bufferRetrieval4;
  private int bufferFollowUp1;
  private int bufferFollowUp2;
  private int bufferFollowUp3;
  private int bufferFollowUp4;

  public TT34() {
    super();
    this.senderID = 201;
    this.telegramType = 34;
    this.systemStatus = new boolean[2][8];
    this.activities = new boolean[2][8];
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 1);
    hex = insertIntIntoHex(hex, receiverID, 1);
    hex = insertIntIntoHex(hex, telegramType, 1);
    hex = insertIntIntoHex(hex, producerID, 1);
    hex = insertIntIntoHex(hex, reserve, 1);
    hex = insertIntIntoHex(hex, srmNo, 1);
    hex = insertBitsIntoHex(hex, systemStatus[0], 1);
    hex = insertBitsIntoHex(hex, systemStatus[1], 1);
    hex = insertBitsIntoHex(hex, activities[0], 1);
    hex = insertBitsIntoHex(hex, activities[1], 1);
    hex = insertIntIntoHex(hex, numberOfOrders, 1);
    hex = insertIntIntoHex(hex, aisle, 1);
    hex = insertIntIntoHex(hex, xCoordinate, 2);
    hex = insertIntIntoHex(hex, yCoordinate, 1);
    hex = insertIntIntoHex(hex, zCoordinate, 1);
    hex = insertIntIntoHex(hex, currentPalletTypeFork1, 2);
    hex = insertIntIntoHex(hex, currentPalletTypeFork2, 2);
    hex = insertIntIntoHex(hex, currentPalletTypeFork3, 2);
    hex = insertIntIntoHex(hex, currentPalletTypeFork4, 2);
    hex = insertIntIntoHex(hex, activeOrderFork1TuGoingTo, 2);
    hex = insertIntIntoHex(hex, activeOrderFork2, 2);
    hex = insertIntIntoHex(hex, activeOrderFork1PrePositionCarousel, 2);
    hex = insertIntIntoHex(hex, activeOrderFork4, 2);
    hex = insertIntIntoHex(hex, bufferStorage1, 2);
    hex = insertIntIntoHex(hex, bufferStorage2, 2);
    hex = insertIntIntoHex(hex, bufferStorage3, 2);
    hex = insertIntIntoHex(hex, bufferStorage4, 2);
    hex = insertIntIntoHex(hex, bufferRetrieval1, 2);
    hex = insertIntIntoHex(hex, bufferRetrieval2, 2);
    hex = insertIntIntoHex(hex, bufferRetrieval3, 2);
    hex = insertIntIntoHex(hex, bufferRetrieval4, 2);
    hex = insertIntIntoHex(hex, bufferFollowUp1, 2);
    hex = insertIntIntoHex(hex, bufferFollowUp2, 2);
    hex = insertIntIntoHex(hex, bufferFollowUp3, 2);
    hex = insertIntIntoHex(hex, bufferFollowUp4, 2);
    return hex;
  }

  // TODO: changed by Pavlenko Yuriy <Yuriy.Pavlenko@ssi-schaefer.com>
  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 1);
    receiverID = extractIntFromHex(hex, 1, 1);
    telegramType = extractIntFromHex(hex, 2, 1);
    producerID = extractIntFromHex(hex, 3, 1);
    reserve = extractIntFromHex(hex, 4, 1);
    srmNo = extractIntFromHex(hex, 5, 1);
    extractBitsFromHex(hex, systemStatus[0], 6, 1);
    extractBitsFromHex(hex, systemStatus[1], 7, 1);
    extractBitsFromHex(hex, activities[0], 8, 1);
    extractBitsFromHex(hex, activities[1], 9, 1);
    numberOfOrders = extractIntFromHex(hex, 10, 1);
    aisle = extractIntFromHex(hex, 11, 1);
    xCoordinate = extractIntFromHex(hex, 12, 2);
    yCoordinate = extractIntFromHex(hex, 14, 1);
    zCoordinate = extractIntFromHex(hex, 15, 1);
    currentPalletTypeFork1 = extractIntFromHex(hex, 16, 2);
    currentPalletTypeFork2 = extractIntFromHex(hex, 18, 2);
    currentPalletTypeFork3 = extractIntFromHex(hex, 20, 2);
    currentPalletTypeFork4 = extractIntFromHex(hex, 22, 2);
    activeOrderFork1TuGoingTo = extractIntFromHex(hex, 24, 2);
    activeOrderFork2 = extractIntFromHex(hex, 26, 2);
    activeOrderFork1PrePositionCarousel = extractIntFromHex(hex, 28, 2);
    activeOrderFork4 = extractIntFromHex(hex, 30, 2);
    bufferStorage1 = extractIntFromHex(hex, 32, 2);
    bufferStorage2 = extractIntFromHex(hex, 34, 2);
    bufferStorage3 = extractIntFromHex(hex, 36, 2);
    bufferStorage4 = extractIntFromHex(hex, 38, 2);
    bufferRetrieval1 = extractIntFromHex(hex, 40, 2);
    bufferRetrieval2 = extractIntFromHex(hex, 42, 2);
    bufferRetrieval3 = extractIntFromHex(hex, 44, 2);
    bufferRetrieval4 = extractIntFromHex(hex, 46, 2);
    bufferFollowUp1 = extractIntFromHex(hex, 48, 2);
    bufferFollowUp2 = extractIntFromHex(hex, 50, 2);
    bufferFollowUp3 = extractIntFromHex(hex, 52, 2);
    bufferFollowUp4 = extractIntFromHex(hex, 54, 2);
  }

  //  @Override
  //  public void fromHex(String hex) {
  //    senderID = extractIntFromHex(hex, 0, 2);
  //    receiverID = extractIntFromHex(hex, 2, 2);
  //    telegramType = extractIntFromHex(hex, 4, 2);
  //    producerID = extractIntFromHex(hex, 6, 2);
  //    reserve = extractIntFromHex(hex, 8, 2);
  //    srmNo = extractIntFromHex(hex, 10, 2);
  //    extractBitsFromHex(hex, systemStatus[0], 12, 2);
  //    extractBitsFromHex(hex, systemStatus[1], 14, 2);
  //    extractBitsFromHex(hex, activities[0], 16, 2);
  //    extractBitsFromHex(hex, activities[1], 18, 2);
  //    numberOfOrders = extractIntFromHex(hex, 20, 2);
  //    aisle = extractIntFromHex(hex, 22, 2);
  //    xCoordinate = extractIntFromHex(hex, 24, 4);
  //    yCoordinate = extractIntFromHex(hex, 28, 2);
  //    zCoordinate = extractIntFromHex(hex, 30, 2);
  //    currentPalletTypeFork1 = extractIntFromHex(hex, 32, 4);
  //    currentPalletTypeFork2 = extractIntFromHex(hex, 36, 4);
  //    currentPalletTypeFork3 = extractIntFromHex(hex, 40, 4);
  //    currentPalletTypeFork4 = extractIntFromHex(hex, 44, 4);
  //    activeOrderFork1TuGoingTo = extractIntFromHex(hex, 48, 4);
  //    activeOrderFork2 = extractIntFromHex(hex, 52, 4);
  //    activeOrderFork1PrePositionCarousel = extractIntFromHex(hex, 56, 4);
  //    activeOrderFork4 = extractIntFromHex(hex, 60, 4);
  //    bufferStorage1 = extractIntFromHex(hex, 64, 4);
  //    bufferStorage2 = extractIntFromHex(hex, 68, 4);
  //    bufferStorage3 = extractIntFromHex(hex, 72, 4);
  //    bufferStorage4 = extractIntFromHex(hex, 76, 4);
  //    bufferRetrieval1 = extractIntFromHex(hex, 80, 4);
  //    bufferRetrieval2 = extractIntFromHex(hex, 84, 4);
  //    bufferRetrieval3 = extractIntFromHex(hex, 88, 4);
  //    bufferRetrieval4 = extractIntFromHex(hex, 92, 4);
  //    bufferFollowUp1 = extractIntFromHex(hex, 96, 4);
  //    bufferFollowUp2 = extractIntFromHex(hex, 100, 4);
  //    bufferFollowUp3 = extractIntFromHex(hex, 104, 4);
  //    bufferFollowUp4 = extractIntFromHex(hex, 108, 4);
  //  }

  @Override
  public String fieldsToString() {
    String s = "senderID=" + senderID + ",";
    s += " receiverID=" + receiverID + ",";
    s += " telegramType=" + telegramType + ",";
    s += " producerID=" + producerID + ",";
    s += " reserve=" + reserve + ",";
    s += " srm=" + srmNo + ",";
    s += " aisle=" + aisle + ",";
    s += " systemstatus= ";
    for (int i = 0; i < systemStatus.length; i++) {
      final boolean[] b = systemStatus[i];
      for (int j = 0; j < b.length; j++) {
        s += String.format("[%s,%s]=%s", i, j, b[j]);
      }
    }
    return s;
  }

  public int getReserve() {
    return reserve;
  }

  public void setReserve(int reserve) {
    this.reserve = reserve;
  }

  public int getSrmNo() {
    return srmNo;
  }

  public void setSrmNo(int srmNo) {
    this.srmNo = srmNo;
  }

  public boolean[][] getSystemStatus() {
    return systemStatus;
  }

  public void setSystemStatus(boolean[][] systemStatus) {
    this.systemStatus = systemStatus;
  }

  public boolean[][] getActivities() {
    return activities;
  }

  public void setActivities(boolean[][] activities) {
    this.activities = activities;
  }

  public int getNumberOfOrders() {
    return numberOfOrders;
  }

  public void setNumberOfOrders(int numberOfOrders) {
    this.numberOfOrders = numberOfOrders;
  }

  public int getAisle() {
    return aisle;
  }

  public void setAisle(int aisle) {
    this.aisle = aisle;
  }

  public int getXCoordinate() {
    return xCoordinate;
  }

  public void setXCoordinate(int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public int getYCoordinate() {
    return yCoordinate;
  }

  public void setYCoordinate(int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  public int getZCoordinate() {
    return zCoordinate;
  }

  public void setZCoordinate(int zCoordinate) {
    this.zCoordinate = zCoordinate;
  }

  public int getCurrentPalletTypeFork1() {
    return currentPalletTypeFork1;
  }

  public void setCurrentPalletTypeFork1(int currentPalletTypeFork1) {
    this.currentPalletTypeFork1 = currentPalletTypeFork1;
  }

  public int getCurrentPalletTypeFork2() {
    return currentPalletTypeFork2;
  }

  public void setCurrentPalletTypeFork2(int currentPalletTypeFork2) {
    this.currentPalletTypeFork2 = currentPalletTypeFork2;
  }

  public int getCurrentPalletTypeFork3() {
    return currentPalletTypeFork3;
  }

  public void setCurrentPalletTypeFork3(int currentPalletTypeFork3) {
    this.currentPalletTypeFork3 = currentPalletTypeFork3;
  }

  public int getCurrentPalletTypeFork4() {
    return currentPalletTypeFork4;
  }

  public void setCurrentPalletTypeFork4(int currentPalletTypeFork4) {
    this.currentPalletTypeFork4 = currentPalletTypeFork4;
  }

  public int getActiveOrderFork1TuGoingTo() {
    return activeOrderFork1TuGoingTo;
  }

  public void setActiveOrderFork1TuGoingTo(int activeOrderFork1TuGoingTo) {
    this.activeOrderFork1TuGoingTo = activeOrderFork1TuGoingTo;
  }

  public int getActiveOrderFork2() {
    return activeOrderFork2;
  }

  public void setActiveOrderFork2(int activeOrderFork2) {
    this.activeOrderFork2 = activeOrderFork2;
  }

  public int getActiveOrderFork1PrePositionCarousel() {
    return activeOrderFork1PrePositionCarousel;
  }

  public void setActiveOrderFork1PrePositionCarousel(int activeOrderFork1PrePositionCarousel) {
    this.activeOrderFork1PrePositionCarousel = activeOrderFork1PrePositionCarousel;
  }

  public int getActiveOrderFork4() {
    return activeOrderFork4;
  }

  public void setActiveOrderFork4(int activeOrderFork4) {
    this.activeOrderFork4 = activeOrderFork4;
  }

  public int getBufferStorage1() {
    return bufferStorage1;
  }

  public void setBufferStorage1(int bufferStorage1) {
    this.bufferStorage1 = bufferStorage1;
  }

  public int getBufferStorage2() {
    return bufferStorage2;
  }

  public void setBufferStorage2(int bufferStorage2) {
    this.bufferStorage2 = bufferStorage2;
  }

  public int getBufferStorage3() {
    return bufferStorage3;
  }

  public void setBufferStorage3(int bufferStorage3) {
    this.bufferStorage3 = bufferStorage3;
  }

  public int getBufferStorage4() {
    return bufferStorage4;
  }

  public void setBufferStorage4(int bufferStorage4) {
    this.bufferStorage4 = bufferStorage4;
  }

  public int getBufferRetrieval1() {
    return bufferRetrieval1;
  }

  public void setBufferRetrieval1(int bufferRetrieval1) {
    this.bufferRetrieval1 = bufferRetrieval1;
  }

  public int getBufferRetrieval2() {
    return bufferRetrieval2;
  }

  public void setBufferRetrieval2(int bufferRetrieval2) {
    this.bufferRetrieval2 = bufferRetrieval2;
  }

  public int getBufferRetrieval3() {
    return bufferRetrieval3;
  }

  public void setBufferRetrieval3(int bufferRetrieval3) {
    this.bufferRetrieval3 = bufferRetrieval3;
  }

  public int getBufferRetrieval4() {
    return bufferRetrieval4;
  }

  public void setBufferRetrieval4(int bufferRetrieval4) {
    this.bufferRetrieval4 = bufferRetrieval4;
  }

  public int getBufferFollowUp1() {
    return bufferFollowUp1;
  }

  public void setBufferFollowUp1(int bufferFollowUp1) {
    this.bufferFollowUp1 = bufferFollowUp1;
  }

  public int getBufferFollowUp2() {
    return bufferFollowUp2;
  }

  public void setBufferFollowUp2(int bufferFollowUp2) {
    this.bufferFollowUp2 = bufferFollowUp2;
  }

  public int getBufferFollowUp3() {
    return bufferFollowUp3;
  }

  public void setBufferFollowUp3(int bufferFollowUp3) {
    this.bufferFollowUp3 = bufferFollowUp3;
  }

  public int getBufferFollowUp4() {
    return bufferFollowUp4;
  }

  public void setBufferFollowUp4(int bufferFollowUp4) {
    this.bufferFollowUp4 = bufferFollowUp4;
  }
}
