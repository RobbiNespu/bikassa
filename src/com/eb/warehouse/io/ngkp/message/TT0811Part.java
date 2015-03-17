/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1834 $, $Date: 2014-09-05 17:31:59 +0200 (Fri, 05 Sep 2014) $, $Author: dennis.chong $
 */

public class TT0811Part implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int requestId;
  protected int transportNumber;
  protected int transportId;
  protected int currentUnit;
  protected int currentPosition;
  protected int[] destinationUnit;
  protected int[] destinationPosition;
  protected int order;
  protected boolean[] orderExtensions1;
  protected boolean[] orderExtensions2;
  protected int acknowledge;
  protected boolean[] ackExtensions1;
  protected boolean[] ackExtensions2;

  public TT0811Part() {
    super();
    requestId = 0;
    transportNumber = 0;
    transportId = 0;
    currentUnit = 0;
    currentPosition = 0;
    destinationUnit = new int[5];
    destinationPosition = new int[5];
    order = 0;
    orderExtensions1 = new boolean[8];
    orderExtensions2 = new boolean[8];
    acknowledge = 0;
    ackExtensions1 = new boolean[8];
    ackExtensions2 = new boolean[8];
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" + fieldsToString(0) + "]";
  }

  public String fieldsToString(int index) {
    String s = "";
    s += " requestId[" + index + "]=" + requestId + ",";
    s += " transportNumber[" + index + "]=" + transportNumber + ",";
    s += " transportId[" + index + "]=" + transportId + ",";
    s += " currentUnit[" + index + "]=" + currentUnit + ",";
    s += " currentPosition[" + index + "]=" + currentPosition + ",";
    s += " destinationUnit1[" + index + "]=" + destinationUnit[0] + ",";
    s += " destinationPosition1[" + index + "]=" + destinationPosition[0] + ",";
    s += " destinationUnit2[" + index + "]=" + destinationUnit[1] + ",";
    s += " destinationPosition2[" + index + "]=" + destinationPosition[1] + ",";
    s += " destinationUnit3[" + index + "]=" + destinationUnit[2] + ",";
    s += " destinationPosition3[" + index + "]=" + destinationPosition[2] + ",";
    s += " destinationUnit4[" + index + "]=" + destinationUnit[3] + ",";
    s += " destinationPosition4[" + index + "]=" + destinationPosition[3] + ",";
    s += " destinationUnit5[" + index + "]=" + destinationUnit[4] + ",";
    s += " destinationPosition5[" + index + "]=" + destinationPosition[4] + ",";
    s += " order[" + index + "]=" + order + ",";
    s += " orderExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions1) + ",";
    s += " orderExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions2) + ",";
    s += " acknowledge[" + index + "]=" + acknowledge + ",";
    s += " ackExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(ackExtensions1) + ",";
    s += " ackExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(ackExtensions2) + ",";
    return s;
  }

  public String toHex() {
    String hex = "";
    hex = NGKPTelegram.insertIntIntoHex(hex, requestId, 4);
    hex = NGKPTelegram.insertIntIntoHex(hex, transportNumber, 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, transportId, 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, currentUnit, 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, currentPosition, 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationUnit[0], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationPosition[0], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationUnit[1], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationPosition[1], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationUnit[2], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationPosition[2], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationUnit[3], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationPosition[3], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationUnit[4], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, destinationPosition[4], 2);
    hex = NGKPTelegram.insertIntIntoHex(hex, order, 2);
    hex = NGKPTelegram.insertBitsIntoHex(hex, orderExtensions1, 1);
    hex = NGKPTelegram.insertBitsIntoHex(hex, orderExtensions2, 1);
    hex = NGKPTelegram.insertIntIntoHex(hex, acknowledge, 2);
    hex = NGKPTelegram.insertBitsIntoHex(hex, ackExtensions1, 1);
    hex = NGKPTelegram.insertBitsIntoHex(hex, ackExtensions2, 1);
    return hex;
  }

  public void fromHex(String hex, int byteoffset) {
    requestId = NGKPTelegram.extractIntFromHex(hex, byteoffset + 0, 4);
    transportNumber = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 2);
    transportId = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 2);
    currentUnit = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 2);
    currentPosition = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 2);
    destinationUnit[0] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 12, 2);
    destinationPosition[0] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 2);
    destinationUnit[1] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 2);
    destinationPosition[1] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 2);
    destinationUnit[2] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 20, 2);
    destinationPosition[2] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 22, 2);
    destinationUnit[3] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 24, 2);
    destinationPosition[3] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 26, 2);
    destinationUnit[4] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 28, 2);
    destinationPosition[4] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 30, 2);
    order = NGKPTelegram.extractIntFromHex(hex, byteoffset + 32, 2);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions1, byteoffset + 34, 1);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions2, byteoffset + 35, 1);
    acknowledge = NGKPTelegram.extractIntFromHex(hex, byteoffset + 36, 2);
    NGKPTelegram.extractBitsFromHex(hex, ackExtensions1, byteoffset + 38, 1);
    NGKPTelegram.extractBitsFromHex(hex, ackExtensions2, byteoffset + 39, 1);
  }

  public boolean isTransportOrder() {
    return order == TT081x.NEW;
  }

  public boolean isTransportUpdate() {
    return order == TT081x.UPDATE;
  }

  public boolean isTransportOverwrite() {
    return order == TT081x.OVERWRITE;
  }

  public boolean isTransportDelete() {
    return order == TT081x.DELETE;
  }

  public boolean isTransportRequest() {
    return order == TT081x.REQUEST;
  }

  public String getSourceID() {
    return "/" + getCurrentUnit() + "/" + getCurrentPosition();
  }

  public int getRequestId() {
    return requestId;
  }

  public void setRequestId(int requestId) {
    this.requestId = requestId;
  }

  public int getTransportNumber() {
    return transportNumber;
  }

  public void setTransportNumber(int transportNumber) {
    this.transportNumber = transportNumber;
  }

  public int getTransportId() {
    return transportId;
  }

  public void setTransportId(int transportId) {
    this.transportId = transportId;
  }

  public int getCurrentUnit() {
    return currentUnit;
  }

  public void setCurrentUnit(int currentUnit) {
    this.currentUnit = currentUnit;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int currentPosition) {
    this.currentPosition = currentPosition;
  }

  public int[] getDestinationUnit() {
    return destinationUnit;
  }

  public void setDestinationUnit(int[] destinationUnit) {
    this.destinationUnit = destinationUnit;
  }

  public int[] getDestinationPosition() {
    return destinationPosition;
  }

  public void setDestinationPosition(int[] destinationPosition) {
    this.destinationPosition = destinationPosition;
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

  public boolean getOrderExtensionBit(int extension, int bit) {
    if (extension == 1) {
      return getOrderExtensions1()[bit];
    }
    if (extension == 2) {
      return getOrderExtensions2()[bit];
    }
    return false;
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
}
