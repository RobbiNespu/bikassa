/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1843 $, $Date: 2014-09-08 14:10:31 +0200 (Mon, 08 Sep 2014) $, $Author:
 *          dennis.chong $
 */

public class TT1214Version1 extends NGKPTelegram {

  public static final int VOID_ORDER = 0;
  public static final int DELETE_TO = 12101;
  public static final int DELETE_ALL_TO = 12103;
  public static final int START_SEQUENCE = 12401;
  public static final int CONTINUE_SEQUENCE = 12402;
  public static final int MOVE_AHEAD_AND_FEEDIN = 12451;
  public static final int MOVE_AHEAD_AND_FEEDIN_AND_SET_SEQUENCE = 12461;
  public static final int MOVE_AHEAD_AND_BLOCK = 12452;
  public static final int NOT_MOVE = 12458;
  public static final int ITEM_REMOVED = 12459;
  public static final int ANNOUNCEMENT = 12011;
  public static final int INFO = 12021;
  public static final int COMPLETION = 12001;
  public static final int DEVIATING_COMPLETION = 12002;
  public static final int UNKNOWN_CWOC_NUMBER = 12121;
  public static final int GENERAL_PLAUSIBILITY_ERROR = 12160;
  public static final int TU_DATA_SETTING = 12301;
  public static final int ITEM_NOT_FOUND = 12003;
  public static final int UNEXPECTED_ITEM_OCCURRED = 12015;
  public static final int TU_REMOVED = 12095;
  public static final int SEQUENCE_ERROR = 12401;
  public static final int SEQUENCE_MISMATCH = 12402;
  public static final int SEQUENCE_ABORT = 12403;
  public static final int WRONG_ORDERCODE = 12130;
  public static final int TOOKAWAY = 12023;
  private static final long serialVersionUID = 1L;
  protected int movementOptions;
  protected int areaNumber;
  protected int source;
  protected int destination;
  protected int lastNotice;
  protected int order;
  protected boolean[] orderExtensions1;
  protected boolean[] orderExtensions2;
  protected int acknowledge;
  protected boolean[] ackExtensions1;
  protected boolean[] ackExtensions2;
  protected int expectedSequenceNumber;
  protected int inputLane1;
  protected int destinationNumber1;
  protected int itemNumber1;
  protected int sequenceNumber;
  protected int length;
  protected int width;
  protected int height;
  protected int requestedAlignment;
  protected int insertDepth;
  protected int turnRequest;
  protected int inputLane2;
  protected int destinationNumber2;
  protected int itemNumber2;
  protected String tuId;

  public TT1214Version1() {
    super();
    this.telegramType = 1214;
    this.subType = 0;
    this.version = 1;
    this.movementOptions = 0;
    this.areaNumber = 0;
    this.source = 0;
    this.destination = 0;
    this.lastNotice = 0;
    this.order = 0;
    this.orderExtensions1 = new boolean[8];
    this.orderExtensions2 = new boolean[8];
    this.acknowledge = 0;
    this.ackExtensions1 = new boolean[8];
    this.ackExtensions2 = new boolean[8];
    this.expectedSequenceNumber = 0;
    this.inputLane1 = 0;
    this.destinationNumber1 = 0;
    this.itemNumber1 = 0;
    this.sequenceNumber = 0;
    this.length = 0;
    this.width = 0;
    this.height = 0;
    this.requestedAlignment = 0;
    this.insertDepth = 0;
    this.turnRequest = 0;
    this.inputLane2 = 0;
    this.destinationNumber2 = 0;
    this.itemNumber2 = 0;
    this.tuId = "                    ";
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + "movementOptions=" + movementOptions + ", number=" + areaNumber
           + ", source=" + source + ", destination=" + destination + ", lastNotice=" + lastNotice
           + ", order=" + order + ", orderExtensions1=" + bitsToString(orderExtensions1)
           + ", orderExtensions2=" + bitsToString(orderExtensions2) + ", acknowledge=" + acknowledge
           + ", ackExtensions1=" + bitsToString(ackExtensions1) + ", ackExtensions2="
           + bitsToString(ackExtensions2) + ", expectedSequenceNumber=" + expectedSequenceNumber
           + ", passNumber1=" + inputLane1 + ", destinationNumber1=" + destinationNumber1
           + ", itemNumber1=" + itemNumber1 + ", sequenceNumber=" + sequenceNumber + ", length="
           + length + ", width=" + width + ", height=" + height + ", requestedAlignment="
           + requestedAlignment + ", insertDepth=" + insertDepth + ", turnRequest=" + turnRequest
           + ", passNumber2=" + inputLane2 + ", destinationNumber2=" + destinationNumber2
           + ", itemNumber2=" + itemNumber2 + ", tuId=" + tuId + "]";
  }

  public String getSequenceId1() {
    return inputLane1 + "/" + destinationNumber1 + "/" + itemNumber1;
  }

  public String getSequenceId2() {
    return inputLane2 + "/" + destinationNumber2 + "/" + itemNumber2;
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = str.substring(0, str.length() - 4);
    str = insertIntIntoHex(str, movementOptions, 2);
    str = insertIntIntoHex(str, areaNumber, 2);
    str = insertIntIntoHex(str, source, 2);
    str = insertIntIntoHex(str, destination, 2);
    str = insertIntIntoHex(str, lastNotice, 2);
    str = insertIntIntoHex(str, order, 2);
    str = insertBitsIntoHex(str, orderExtensions1, 1);
    str = insertBitsIntoHex(str, orderExtensions2, 1);
    str = insertIntIntoHex(str, acknowledge, 2);
    str = insertBitsIntoHex(str, ackExtensions1, 1);
    str = insertBitsIntoHex(str, ackExtensions2, 1);
    str = insertIntIntoHex(str, expectedSequenceNumber, 2);
    str = insertIntIntoHex(str, inputLane1, 2, true);
    str = insertIntIntoHex(str, destinationNumber1, 4, true);
    str = insertIntIntoHex(str, itemNumber1, 2, true);
    str = insertIntIntoHex(str, sequenceNumber, 2);
    str = insertIntIntoHex(str, length, 2);
    str = insertIntIntoHex(str, width, 2);
    str = insertIntIntoHex(str, height, 2);
    str = insertIntIntoHex(str, requestedAlignment, 2);
    str = insertIntIntoHex(str, insertDepth, 2);
    str = insertIntIntoHex(str, turnRequest, 2);
    str = insertIntIntoHex(str, inputLane2, 2, true);
    str = insertIntIntoHex(str, destinationNumber2, 4, true);
    str = insertIntIntoHex(str, itemNumber2, 2, true);
    if (subType == 1) {
      str = insertStringIntoHex(str, tuId);
    }
    return str;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    orderExtensions1 = new boolean[8];
    orderExtensions2 = new boolean[8];
    ackExtensions1 = new boolean[8];
    ackExtensions2 = new boolean[8];
    movementOptions = extractIntFromHex(hex, 14, 2);
    areaNumber = extractIntFromHex(hex, 16, 2);
    source = extractIntFromHex(hex, 18, 2);
    destination = extractIntFromHex(hex, 20, 2);
    lastNotice = extractIntFromHex(hex, 22, 2);
    order = extractIntFromHex(hex, 24, 2);
    extractBitsFromHex(hex, orderExtensions1, 26, 1);
    extractBitsFromHex(hex, orderExtensions2, 27, 1);
    acknowledge = extractIntFromHex(hex, 28, 2);
    extractBitsFromHex(hex, ackExtensions1, 30, 1);
    extractBitsFromHex(hex, ackExtensions2, 31, 1);
    expectedSequenceNumber = extractIntFromHex(hex, 32, 2);
    inputLane1 = extractIntFromHex(hex, 34, 2);
    destinationNumber1 = extractIntFromHex(hex, 36, 4);
    itemNumber1 = extractIntFromHex(hex, 40, 2);
    sequenceNumber = extractIntFromHex(hex, 42, 2);
    length = extractIntFromHex(hex, 44, 2);
    width = extractIntFromHex(hex, 46, 2);
    height = extractIntFromHex(hex, 48, 2);
    requestedAlignment = extractIntFromHex(hex, 50, 2);
    insertDepth = extractIntFromHex(hex, 52, 2);
    turnRequest = extractIntFromHex(hex, 54, 2);
    inputLane2 = extractIntFromHex(hex, 56, 2);
    destinationNumber2 = extractIntFromHex(hex, 58, 4);
    itemNumber2 = extractIntFromHex(hex, 62, 2);
    if (subType == 1) {
      tuId = extractStringFromHex(hex, 64, 20);
    }
  }

  public int getMovementOptions() {
    return movementOptions;
  }

  public void setMovementOptions(int movementOptions) {
    this.movementOptions = movementOptions;
  }

  public int getAreaNumber() {
    return areaNumber;
  }

  public void setAreaNumber(int areaNumber) {
    this.areaNumber = areaNumber;
  }

  public int getSource() {
    return source;
  }

  public void setSource(int source) {
    this.source = source;
  }

  public int getDestination() {
    return destination;
  }

  public void setDestination(int destination) {
    this.destination = destination;
  }

  public int getLastNotice() {
    return lastNotice;
  }

  public void setLastNotice(int lastNotice) {
    this.lastNotice = lastNotice;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
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

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
  }

  public boolean[] getAckExtensions1() {
    return ackExtensions1;
  }

  public void setAckExtensions1(boolean[] ackExtensions1) {
    this.ackExtensions1 = ackExtensions1;
  }

  public boolean[] getAckExtensions2() {
    return ackExtensions2;
  }

  public void setAckExtensions2(boolean[] ackExtensions2) {
    this.ackExtensions2 = ackExtensions2;
  }

  public int getExpectedSequenceNumber() {
    return expectedSequenceNumber;
  }

  public void setExpectedSequenceNumber(int expectedSequenceNumber) {
    this.expectedSequenceNumber = expectedSequenceNumber;
  }

  public int getInputLane1() {
    return inputLane1;
  }

  public void setInputLane1(int inputLane1) {
    this.inputLane1 = inputLane1;
  }

  public int getDestinationNumber1() {
    return destinationNumber1;
  }

  public void setDestinationNumber1(int destinationNumber1) {
    this.destinationNumber1 = destinationNumber1;
  }

  public int getItemNumber1() {
    return itemNumber1;
  }

  public void setItemNumber1(int itemNumber1) {
    this.itemNumber1 = itemNumber1;
  }

  public int getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(int sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getRequestedAlignment() {
    return requestedAlignment;
  }

  public void setRequestedAlignment(int requestedAlignment) {
    this.requestedAlignment = requestedAlignment;
  }

  public int getInsertDepth() {
    return insertDepth;
  }

  public void setInsertDepth(int insertDepth) {
    this.insertDepth = insertDepth;
  }

  public int getTurnRequest() {
    return turnRequest;
  }

  public void setTurnRequest(int turnRequest) {
    this.turnRequest = turnRequest;
  }

  public int getInputLane2() {
    return inputLane2;
  }

  public void setInputLane2(int inputLane2) {
    this.inputLane2 = inputLane2;
  }

  public int getDestinationNumber2() {
    return destinationNumber2;
  }

  public void setDestinationNumber2(int destinationNumber2) {
    this.destinationNumber2 = destinationNumber2;
  }

  public int getItemNumber2() {
    return itemNumber2;
  }

  public void setItemNumber2(int itemNumber2) {
    this.itemNumber2 = itemNumber2;
  }

  public String getTuId() {
    return tuId;
  }

  public void setTuId(String tuId) {
    this.tuId = tuId;
  }

}
