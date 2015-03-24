/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

/**
 * Simple class to represent a stripe of the TT39 telegram.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1664 $, $Date: 2014-02-11 09:31:45 +0100 (Di, 11 Feb 2014) $, $Author:
 *          dennis.chong $
 */
public class TT39Stripe implements Serializable {

  private static final long serialVersionUID = 1L;
  protected String functionPoint;
  protected boolean[] controlFlags;
  protected boolean[] modeFlags;
  protected int order;
  protected boolean[] orderExtensions;
  protected int acknowledge;
  protected boolean[] acknowledgeExtensions;
  protected char dataFieldIdentifier;
  protected char telegramDetail;
  // parameter set 1
  protected int noreadDirection;
  protected int noscanDirection;
  protected int nodataDirection;
  protected int cerrorDirection;
  protected int werrorDirection;
  protected int derrorDirection;
  protected int overflowDirection;
  protected int priority1;
  protected int priority2;
  protected int priority3;
  protected int overflowDirectionForDefaultDirections;
  protected int reserve14;
  protected int time3;
  protected int time2;
  protected int time1;
  //parameter set 2
  protected int minimumLength;
  protected int maximumLength;
  protected int minimumWidth;
  protected int maximumWidth;
  protected int minimumHeight;
  protected int maximumHeight;
  protected int minimumWeight;
  protected int maximumWeight;
  protected int reserve17;
  protected int reserve18;
  protected int reserve19;
  protected int reserve20;
  //parameter set S
  protected String barcode;
  //not specified
  protected int notspecified;

  public TT39Stripe() {
    this.functionPoint = "0000";
    this.controlFlags = new boolean[8];
    this.modeFlags = new boolean[8];
    this.noreadDirection = 0;
    this.noscanDirection = 0;
    this.nodataDirection = 0;
    this.cerrorDirection = 0;
    this.werrorDirection = 0;
    this.derrorDirection = 0;
    this.overflowDirection = 0;
    this.priority1 = 0;
    this.priority2 = 0;
    this.priority3 = 0;
    this.overflowDirectionForDefaultDirections = 0;
    this.reserve14 = 0;
    this.time3 = 0;
    this.time2 = 0;
    this.time1 = 0;
    this.minimumLength = 0;
    this.maximumLength = 0;
    this.minimumWidth = 0;
    this.maximumWidth = 0;
    this.minimumHeight = 0;
    this.maximumHeight = 0;
    this.minimumWeight = 0;
    this.maximumWeight = 0;
    this.reserve17 = 0;
    this.reserve18 = 0;
    this.reserve19 = 0;
    this.reserve20 = 0;
    this.barcode = TT39.BARCODE_EMPTY;
    this.order = TT39.NOORDER;
    this.orderExtensions = new boolean[8];
    this.acknowledge = 0;
    this.acknowledgeExtensions = new boolean[8];
    this.dataFieldIdentifier = TT39.PARAMETER_SET_UNDEFINED;
    this.telegramDetail = TT39.STRIPE_END_OF_CHAIN;
    this.notspecified = 0;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" + fieldsToString(0) + "]";
  }

  public String fieldsToString(int index) {
    String s = "";
    s += " functionPoint[" + index + "]=" + functionPoint + ",";
    if (dataFieldIdentifier == TT39.PARAMETER_SET_1) {
      s += " controlFlags[" + index + "]=" + NGKPTelegram.bitsToString(controlFlags) + ",";
      s += " modeFlags[" + index + "]=" + NGKPTelegram.bitsToString(modeFlags) + ",";
      s += " noreadDirection[" + index + "]=" + noreadDirection + ",";
      s += " noscanDirection[" + index + "]=" + noscanDirection + ",";
      s += " nodatatDirection[" + index + "]=" + nodataDirection + ",";
      s += " cerrorDirection[" + index + "]=" + cerrorDirection + ",";
      s += " werrorDirection[" + index + "]=" + werrorDirection + ",";
      s += " derrorDirection[" + index + "]=" + derrorDirection + ",";
      s += " overflowDirection[" + index + "]=" + overflowDirection + ",";
      s += " priority1[" + index + "]=" + priority1 + ",";
      s += " priority2[" + index + "]=" + priority2 + ",";
      s += " priority3[" + index + "]=" + priority3 + ",";
      s +=
          " overflowDirectionForDefault[" + index + "]=" + overflowDirectionForDefaultDirections
          + ",";
      s += " reserve14[" + index + "]=" + reserve14 + ",";
      s += " time3[" + index + "]=" + time3 + ",";
      s += " time2[" + index + "]=" + time2 + ",";
      s += " time1[" + index + "]=" + time1 + ",";
    } else if (dataFieldIdentifier == TT39.PARAMETER_SET_2) {
      s += " minimumLength[" + index + "]=" + minimumLength + ",";
      s += " maximumLength[" + index + "]=" + maximumLength + ",";
      s += " minimumWidth[" + index + "]=" + minimumWidth + ",";
      s += " maximumWidth[" + index + "]=" + maximumWidth + ",";
      s += " minimumHeight[" + index + "]=" + minimumHeight + ",";
      s += " maximumHeight[" + index + "]=" + maximumHeight + ",";
      s += " minimumWeight[" + index + "]=" + minimumWeight + ",";
      s += " maximumWeight[" + index + "]=" + maximumWeight + ",";
      s += " reserve17[" + index + "]=" + reserve17 + ",";
      s += " reserve18[" + index + "]=" + reserve18 + ",";
      s += " reserve19[" + index + "]=" + reserve19 + ",";
      s += " reserve20[" + index + "]=" + reserve20 + ",";
    } else if (dataFieldIdentifier == TT39.PARAMETER_SET_S) {
      s += " barcode[" + index + "]=" + barcode + ",";
    } else {
      s += " notspecified[" + index + "]=" + notspecified + ",";
    }
    s += " order[" + index + "]=" + order + ",";
    s += " orderExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions) + ",";
    s += " acknowledge[" + index + "]=" + acknowledge + ",";
    s +=
        " acknowledgeExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions)
        + ",";
    s += " dataFieldIdentifier[" + index + "]=" + dataFieldIdentifier + ",";
    s += " telegramDetail[" + index + "]=" + telegramDetail + ",";
    return s;
  }

  public String toHex() {
    String str = "";
    str = NGKPTelegram.insertStringIntoHex(str, functionPoint);
    if (dataFieldIdentifier == TT39.PARAMETER_SET_1) {
      str = NGKPTelegram.insertBitsIntoHex(str, controlFlags, 1);
      str = NGKPTelegram.insertBitsIntoHex(str, modeFlags, 1);
      str = NGKPTelegram.insertIntIntoHex(str, noreadDirection, 1);
      str = NGKPTelegram.insertIntIntoHex(str, noscanDirection, 1);
      str = NGKPTelegram.insertIntIntoHex(str, nodataDirection, 1);
      str = NGKPTelegram.insertIntIntoHex(str, cerrorDirection, 1);
      str = NGKPTelegram.insertIntIntoHex(str, werrorDirection, 1);
      str = NGKPTelegram.insertIntIntoHex(str, derrorDirection, 1);
      str = NGKPTelegram.insertIntIntoHex(str, overflowDirection, 1);
      str = NGKPTelegram.insertIntIntoHex(str, priority1, 1);
      str = NGKPTelegram.insertIntIntoHex(str, priority2, 1);
      str = NGKPTelegram.insertIntIntoHex(str, priority3, 1);
      str = NGKPTelegram.insertIntIntoHex(str, overflowDirectionForDefaultDirections, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve14, 1);
      str = NGKPTelegram.insertIntIntoHex(str, time3, 2);
      str = NGKPTelegram.insertIntIntoHex(str, time2, 2);
      str = NGKPTelegram.insertIntIntoHex(str, time1, 2);
    } else if (dataFieldIdentifier == TT39.PARAMETER_SET_2) {
      str = NGKPTelegram.insertIntIntoHex(str, minimumLength, 2);
      str = NGKPTelegram.insertIntIntoHex(str, maximumLength, 2);
      str = NGKPTelegram.insertIntIntoHex(str, minimumWidth, 2);
      str = NGKPTelegram.insertIntIntoHex(str, maximumWidth, 2);
      str = NGKPTelegram.insertIntIntoHex(str, minimumHeight, 2);
      str = NGKPTelegram.insertIntIntoHex(str, maximumHeight, 2);
      str = NGKPTelegram.insertIntIntoHex(str, minimumWeight, 2);
      str = NGKPTelegram.insertIntIntoHex(str, maximumWeight, 2);
      str = NGKPTelegram.insertIntIntoHex(str, reserve17, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve18, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve19, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve20, 1);
    } else if (dataFieldIdentifier == TT39.PARAMETER_SET_S) {
      str = NGKPTelegram.insertStringIntoHex(str, barcode);
    } else {
      str = NGKPTelegram.insertIntIntoHex(str, notspecified, 20);
    }
    str = NGKPTelegram.insertIntIntoHex(str, order, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, orderExtensions, 1);
    str = NGKPTelegram.insertIntIntoHex(str, acknowledge, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, acknowledgeExtensions, 1);
    str = NGKPTelegram.insertIntIntoHex(str, dataFieldIdentifier, 1);
    str = NGKPTelegram.insertIntIntoHex(str, telegramDetail, 1);
    return str;
  }

  public int fromHex(String hex, int byteoffset) {
    functionPoint = NGKPTelegram.extractStringFromHex(hex, byteoffset + 0, 4);
    order = NGKPTelegram.extractIntFromHex(hex, byteoffset + 24, 1);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions, byteoffset + 25, 1);
    acknowledge = NGKPTelegram.extractIntFromHex(hex, byteoffset + 26, 1);
    NGKPTelegram.extractBitsFromHex(hex, acknowledgeExtensions, byteoffset + 27, 1);
    dataFieldIdentifier = (char) NGKPTelegram.extractIntFromHex(hex, byteoffset + 28, 1);
    telegramDetail = (char) NGKPTelegram.extractIntFromHex(hex, byteoffset + 29, 1);
    if (dataFieldIdentifier == TT39.PARAMETER_SET_1) {
      NGKPTelegram.extractBitsFromHex(hex, controlFlags, byteoffset + 4, 1);
      NGKPTelegram.extractBitsFromHex(hex, modeFlags, byteoffset + 5, 1);
      noreadDirection = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 1);
      noscanDirection = NGKPTelegram.extractIntFromHex(hex, byteoffset + 7, 1);
      nodataDirection = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 1);
      cerrorDirection = NGKPTelegram.extractIntFromHex(hex, byteoffset + 9, 1);
      werrorDirection = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 1);
      derrorDirection = NGKPTelegram.extractIntFromHex(hex, byteoffset + 11, 1);
      overflowDirection = NGKPTelegram.extractIntFromHex(hex, byteoffset + 12, 1);
      priority1 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 13, 1);
      priority2 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 1);
      priority3 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 15, 1);
      overflowDirectionForDefaultDirections =
          NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 1);
      reserve14 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 17, 1);
      time3 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 2);
      time2 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 20, 2);
      time1 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 22, 2);
    } else if (dataFieldIdentifier == TT39.PARAMETER_SET_2) {
      minimumLength = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 2);
      maximumLength = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 2);
      minimumWidth = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 2);
      maximumWidth = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 2);
      minimumHeight = NGKPTelegram.extractIntFromHex(hex, byteoffset + 12, 2);
      maximumHeight = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 2);
      minimumWeight = NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 2);
      maximumWeight = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 2);
      reserve17 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 20, 1);
      reserve18 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 21, 1);
      reserve19 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 22, 1);
      reserve20 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 23, 1);
    } else if (dataFieldIdentifier == TT39.PARAMETER_SET_S) {
      barcode = NGKPTelegram.extractStringFromHex(hex, byteoffset + 4, 20);
    } else {
      notspecified = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 20);
    }
    byteoffset += 30;
    return byteoffset;
  }

  public void merge(TT39Stripe stripe) {
    int identifier = stripe.getDataFieldIdentifier();
    if (identifier == TT39.PARAMETER_SET_1) {
      this.noreadDirection = stripe.nodataDirection;
      this.noscanDirection = stripe.noscanDirection;
      this.nodataDirection = stripe.nodataDirection;
      this.cerrorDirection = stripe.cerrorDirection;
      this.werrorDirection = stripe.werrorDirection;
      this.derrorDirection = stripe.derrorDirection;
      this.overflowDirection = stripe.overflowDirection;
      this.priority1 = stripe.priority1;
      this.priority2 = stripe.priority2;
      this.priority3 = stripe.priority3;
      this.overflowDirectionForDefaultDirections = stripe.overflowDirectionForDefaultDirections;
      this.reserve14 = stripe.reserve14;
      this.time3 = stripe.time3;
      this.time2 = stripe.time2;
      this.time1 = stripe.time1;
    } else if (identifier == TT39.PARAMETER_SET_2) {
      this.minimumLength = stripe.minimumLength;
      this.maximumLength = stripe.maximumLength;
      this.minimumWidth = stripe.minimumWidth;
      this.maximumWidth = stripe.maximumWidth;
      this.minimumHeight = stripe.minimumHeight;
      this.maximumHeight = stripe.maximumHeight;
      this.minimumWeight = stripe.minimumWeight;
      this.maximumWeight = stripe.maximumWeight;
      this.reserve17 = stripe.reserve17;
      this.reserve18 = stripe.reserve18;
      this.reserve19 = stripe.reserve19;
      this.reserve20 = stripe.reserve20;
    } else if (identifier == TT39.PARAMETER_SET_S) {
      this.barcode = stripe.barcode;
    }
  }

  public String getFunctionPoint() {
    return functionPoint;
  }

  public void setFunctionPoint(String functionPoint) {
    this.functionPoint = functionPoint;
  }

  public boolean[] getControlFlags() {
    return controlFlags;
  }

  public void setControlFlags(boolean[] controlFlags) {
    this.controlFlags = controlFlags;
  }

  public boolean[] getModeFlags() {
    return modeFlags;
  }

  public void setModeFlags(boolean[] modeFlags) {
    this.modeFlags = modeFlags;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public boolean[] getOrderExtensions() {
    return orderExtensions;
  }

  public void setOrderExtensions(boolean[] orderExtensions) {
    this.orderExtensions = orderExtensions;
  }

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
  }

  public boolean[] getAcknowledgeExtensions() {
    return acknowledgeExtensions;
  }

  public void setAcknowledgeExtensions(boolean[] acknowledgeExtensions) {
    this.acknowledgeExtensions = acknowledgeExtensions;
  }

  public char getDataFieldIdentifier() {
    return dataFieldIdentifier;
  }

  public void setDataFieldIdentifier(char dataFieldIdentifier) {
    this.dataFieldIdentifier = dataFieldIdentifier;
  }

  public char getTelegramDetail() {
    return telegramDetail;
  }

  public void setTelegramDetail(char telegramDetail) {
    this.telegramDetail = telegramDetail;
  }

  public int getNoreadDirection() {
    return noreadDirection;
  }

  public void setNoreadDirection(int noreadDirection) {
    this.noreadDirection = noreadDirection;
  }

  public int getNoscanDirection() {
    return noscanDirection;
  }

  public void setNoscanDirection(int noscanDirection) {
    this.noscanDirection = noscanDirection;
  }

  public int getNodataDirection() {
    return nodataDirection;
  }

  public void setNodataDirection(int nodataDirection) {
    this.nodataDirection = nodataDirection;
  }

  public int getCerrorDirection() {
    return cerrorDirection;
  }

  public void setCerrorDirection(int cerrorDirection) {
    this.cerrorDirection = cerrorDirection;
  }

  public int getWerrorDirection() {
    return werrorDirection;
  }

  public void setWerrorDirection(int werrorDirection) {
    this.werrorDirection = werrorDirection;
  }

  public int getDerrorDirection() {
    return derrorDirection;
  }

  public void setDerrorDirection(int derrorDirection) {
    this.derrorDirection = derrorDirection;
  }

  public int getOverflowDirection() {
    return overflowDirection;
  }

  public void setOverflowDirection(int overflowDirection) {
    this.overflowDirection = overflowDirection;
  }

  public int getPriority1() {
    return priority1;
  }

  public void setPriority1(int priority1) {
    this.priority1 = priority1;
  }

  public int getPriority2() {
    return priority2;
  }

  public void setPriority2(int priority2) {
    this.priority2 = priority2;
  }

  public int getPriority3() {
    return priority3;
  }

  public void setPriority3(int priority3) {
    this.priority3 = priority3;
  }

  public int getOverflowDirectionForDefaultDirections() {
    return overflowDirectionForDefaultDirections;
  }

  public void setOverflowDirectionForDefaultDirections(int overflowDirectionForDefaultDirections) {
    this.overflowDirectionForDefaultDirections = overflowDirectionForDefaultDirections;
  }

  public int getReserve14() {
    return reserve14;
  }

  public void setReserve14(int reserve14) {
    this.reserve14 = reserve14;
  }

  public int getTime3() {
    return time3;
  }

  public void setTime3(int time3) {
    this.time3 = time3;
  }

  public int getTime2() {
    return time2;
  }

  public void setTime2(int time2) {
    this.time2 = time2;
  }

  public int getTime1() {
    return time1;
  }

  public void setTime1(int time1) {
    this.time1 = time1;
  }

  public int getMinimumLength() {
    return minimumLength;
  }

  public void setMinimumLength(int minimumLength) {
    this.minimumLength = minimumLength;
  }

  public int getMaximumLength() {
    return maximumLength;
  }

  public void setMaximumLength(int maximumLength) {
    this.maximumLength = maximumLength;
  }

  public int getMinimumWidth() {
    return minimumWidth;
  }

  public void setMinimumWidth(int minimumWidth) {
    this.minimumWidth = minimumWidth;
  }

  public int getMaximumWidth() {
    return maximumWidth;
  }

  public void setMaximumWidth(int maximumWidth) {
    this.maximumWidth = maximumWidth;
  }

  public int getMinimumHeight() {
    return minimumHeight;
  }

  public void setMinimumHeight(int minimumHeight) {
    this.minimumHeight = minimumHeight;
  }

  public int getMaximumHeight() {
    return maximumHeight;
  }

  public void setMaximumHeight(int maximumHeight) {
    this.maximumHeight = maximumHeight;
  }

  public int getMinimumWeight() {
    return minimumWeight;
  }

  public void setMinimumWeight(int minimumWeight) {
    this.minimumWeight = minimumWeight;
  }

  public int getMaximumWeight() {
    return maximumWeight;
  }

  public void setMaximumWeight(int maximumWeight) {
    this.maximumWeight = maximumWeight;
  }

  public int getReserve17() {
    return reserve17;
  }

  public void setReserve17(int reserve17) {
    this.reserve17 = reserve17;
  }

  public int getReserve18() {
    return reserve18;
  }

  public void setReserve18(int reserve18) {
    this.reserve18 = reserve18;
  }

  public int getReserve19() {
    return reserve19;
  }

  public void setReserve19(int reserve19) {
    this.reserve19 = reserve19;
  }

  public int getReserve20() {
    return reserve20;
  }

  public void setReserve20(int reserve20) {
    this.reserve20 = reserve20;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public int getNotspecified() {
    return notspecified;
  }

  public void setNotspecified(int notspecified) {
    this.notspecified = notspecified;
  }
}
