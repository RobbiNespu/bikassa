/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13Stripe.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

/**
 * Simple class to represent a stripe of the TT13 telegram.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1548 $, $Date: 2013-10-31 13:56:14 +0100 (Do, 31 Okt 2013) $, $Author: dennis.chong $
 */
public class TT13Stripe implements Serializable {
  private static final long serialVersionUID = 1L;

  protected String functionPoint;
  protected int order;
  protected boolean[] orderExtensions;
  protected int acknowledge;
  protected boolean[] acknowledgeExtensions;
  protected char dataFieldIdentifier;
  protected char telegramDetail;
  // parameter set B
  protected String barcode;
  // parameter set L
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
  // parameter set C
  protected int length;
  protected int width;
  protected int height;
  protected int weight;
  protected int reserve9;
  protected int reserve10;
  protected int reserve11;
  protected int reserve12;
  protected int reserve13;
  protected int reserve14;
  protected int reserve15;
  protected int reserve16;
  protected boolean[] specialInfoFlags1;
  protected boolean[] specialInfoFlags2;
  protected int tuTypeID;
  // parameter set A
  protected int[] alternative;
  // parameter set U 
  protected int trayNumber;
  protected int trayNumberAtSetupDevice;
  protected int timestampMinutes;
  protected int timestampSeconds;
  protected boolean[] infoFlags;
  protected int recirculationCounter;
  protected boolean[] infoFlags2;
  // parameter set not specified
  protected String notspecified;

  public TT13Stripe() {
    this.functionPoint = "0000";
    this.barcode = TT13.BARCODE_EMPTY;
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
    this.length = 0;
    this.width = 0;
    this.height = 0;
    this.weight = 0;
    this.reserve9 = 0;
    this.reserve10 = 0;
    this.reserve11 = 0;
    this.reserve12 = 0;
    this.reserve13 = 0;
    this.reserve14 = 0;
    this.reserve15 = 0;
    this.reserve16 = 0;
    this.specialInfoFlags1 = new boolean[8];
    this.specialInfoFlags2 = new boolean[8];
    this.tuTypeID = 0;
    this.alternative = new int[20];
    this.notspecified = "00000000000000000000";
    this.order = 0;
    this.orderExtensions = new boolean[8];
    this.acknowledge = 0;
    this.acknowledgeExtensions = new boolean[8];
    this.dataFieldIdentifier = TT13.PARAMETER_SET_UNDEFINED;
    this.telegramDetail = TT13.STRIPE_END_OF_CHAIN;
    this.infoFlags = new boolean[8];
    this.infoFlags2 = new boolean[8];
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" + fieldsToString(0) + "]";
  }

  public String fieldsToString(int index) {
    String s = "";
    s += " functionPoint[" + index + "]=" + functionPoint + ",";
    if (dataFieldIdentifier == TT13.PARAMETER_SET_B) {
      s += " barcode[" + index + "]=" + barcode + ",";
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_L) {
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
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_C) {
      s += " length[" + index + "]=" + length + ",";
      s += " width[" + index + "]=" + width + ",";
      s += " height[" + index + "]=" + height + ",";
      s += " weight[" + index + "]=" + weight + ",";
      s += " reserve9[" + index + "]=" + reserve9 + ",";
      s += " reserve10[" + index + "]=" + reserve10 + ",";
      s += " reserve11[" + index + "]=" + reserve11 + ",";
      s += " reserve12[" + index + "]=" + reserve12 + ",";
      s += " reserve13[" + index + "]=" + reserve13 + ",";
      s += " reserve14[" + index + "]=" + reserve14 + ",";
      s += " reserve15[" + index + "]=" + reserve15 + ",";
      s += " reserve16[" + index + "]=" + reserve16 + ",";
      s += " reserve17[" + index + "]=" + reserve17 + ",";
      s += " specialInfoFlags1[" + index + "]=" + NGKPTelegram.bitsToString(specialInfoFlags1) + ",";
      s += " specialInfoFlags2[" + index + "]=" + NGKPTelegram.bitsToString(specialInfoFlags2) + ",";
      s += " tuTyoeID[" + index + "]=" + tuTypeID + ",";
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_A) {
      for (int i = 0; i < alternative.length; ++i) {
        s += " alternative" + (i + 1) + "[" + index + "]=" + alternative[i] + ",";
      }
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_U) {
      s += " barcode[" + index + "]= " + barcode + ", ";
      s += " trayNumber[" + index + "]= " + trayNumber + ", ";
      s += " trayNumberAtSetupDevice[" + index + "]= " + trayNumberAtSetupDevice + ", ";
    } else {
      s += " notspecified[" + index + "]=" + notspecified + ",";
    }
    s += " order[" + index + "]=" + order + ",";
    s += " orderExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions) + ",";
    s += " acknowledge[" + index + "]=" + acknowledge + ",";
    s += " acknowledgeExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions) + ",";
    s += " dataFieldIdentifier[" + index + "]=" + dataFieldIdentifier + ",";
    s += " telegramDetail[" + index + "]=" + telegramDetail + ",";
    return s;
  }

  public String toHex() {
    String str = "";
    str = NGKPTelegram.insertStringIntoHex(str, functionPoint);
    if (dataFieldIdentifier == TT13.PARAMETER_SET_B) {
      str = NGKPTelegram.insertStringIntoHex(str, barcode);
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_L) {
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
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_C) {
      str = NGKPTelegram.insertIntIntoHex(str, length, 2);
      str = NGKPTelegram.insertIntIntoHex(str, width, 2);
      str = NGKPTelegram.insertIntIntoHex(str, height, 2);
      str = NGKPTelegram.insertIntIntoHex(str, weight, 2);
      str = NGKPTelegram.insertIntIntoHex(str, reserve9, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve10, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve11, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve12, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve13, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve14, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve15, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve16, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve17, 1);
      str = NGKPTelegram.insertBitsIntoHex(str, specialInfoFlags2, 1);
      str = NGKPTelegram.insertBitsIntoHex(str, specialInfoFlags1, 1);
      str = NGKPTelegram.insertIntIntoHex(str, tuTypeID, 1);
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_A) {
      for (int i = 0; i < alternative.length; ++i) {
        str = NGKPTelegram.insertIntIntoHex(str, alternative[i], 1);
      }
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_U) {
      str = NGKPTelegram.insertStringIntoHex(str, barcode);
      str = NGKPTelegram.insertIntIntoHex(str, trayNumber, 2);
      str = NGKPTelegram.insertIntIntoHex(str, trayNumberAtSetupDevice, 2);
      str = NGKPTelegram.insertIntIntoHex(str, timestampMinutes, 1);
      str = NGKPTelegram.insertIntIntoHex(str, timestampSeconds, 1);
      str = NGKPTelegram.insertBitsIntoHex(str, infoFlags, 1);
      str = NGKPTelegram.insertIntIntoHex(str, recirculationCounter, 1);
      str = NGKPTelegram.insertBitsIntoHex(str, infoFlags2, 1);
      str = NGKPTelegram.insertIntIntoHex(str, reserve20, 1);
    } else {
      str = NGKPTelegram.insertStringIntoHex(str, notspecified);
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
    if (dataFieldIdentifier == TT13.PARAMETER_SET_B) {
      barcode = NGKPTelegram.extractStringFromHex(hex, byteoffset + 4, 20);
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_L) {
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
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_C) {
      length = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 2);
      width = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 2);
      height = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 2);
      weight = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 2);
      reserve9 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 12, 1);
      reserve10 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 13, 1);
      reserve11 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 1);
      reserve12 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 15, 1);
      reserve13 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 1);
      reserve14 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 17, 1);
      reserve15 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 1);
      reserve16 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 19, 1);
      reserve17 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 20, 1);
      NGKPTelegram.extractBitsFromHex(hex, specialInfoFlags2, byteoffset + 21, 1);
      NGKPTelegram.extractBitsFromHex(hex, specialInfoFlags1, byteoffset + 22, 1);
      tuTypeID = NGKPTelegram.extractIntFromHex(hex, byteoffset + 23, 1);
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_A) {
      for (int i = 0; i < alternative.length; ++i) {
        alternative[i] = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4 + i, 1);
      }
    } else if (dataFieldIdentifier == TT13.PARAMETER_SET_U) {
      barcode = NGKPTelegram.extractStringFromHex(hex, byteoffset + 4, 10);
      trayNumber = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 2);
      trayNumberAtSetupDevice = NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 2);
      timestampMinutes = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 1);
      timestampSeconds = NGKPTelegram.extractIntFromHex(hex, byteoffset + 19, 1);
      NGKPTelegram.extractBitsFromHex(hex, infoFlags, byteoffset + 20, 1);
      recirculationCounter = NGKPTelegram.extractIntFromHex(hex, byteoffset + 21, 1);
      NGKPTelegram.extractBitsFromHex(hex, infoFlags2, byteoffset + 22, 1);
      reserve20 = NGKPTelegram.extractIntFromHex(hex, byteoffset + 23, 1);
    } else {
      notspecified = NGKPTelegram.extractStringFromHex(hex, byteoffset + 4, 20);
    }
    byteoffset += 30;
    return byteoffset;
  }

  public void merge(TT13Stripe stripe) {
    int identifier = stripe.getDataFieldIdentifier();
    if (identifier == TT13.PARAMETER_SET_B) {
      this.barcode = stripe.barcode;
    } else if (identifier == TT13.PARAMETER_SET_L) {
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
    } else if (identifier == TT13.PARAMETER_SET_C) {
      this.length = stripe.length;
      this.width = stripe.width;
      this.height = stripe.height;
      this.weight = stripe.weight;
      this.reserve9 = stripe.reserve9;
      this.reserve10 = stripe.reserve10;
      this.reserve11 = stripe.reserve11;
      this.reserve12 = stripe.reserve12;
      this.reserve13 = stripe.reserve13;
      this.reserve14 = stripe.reserve14;
      this.reserve15 = stripe.reserve15;
      this.reserve16 = stripe.reserve16;
      this.specialInfoFlags1 = stripe.specialInfoFlags1;
      this.specialInfoFlags2 = stripe.specialInfoFlags2;
      this.tuTypeID = stripe.tuTypeID;
    } else if (identifier == TT13.PARAMETER_SET_A) {
      this.alternative = stripe.alternative;
    } else if (identifier == TT13.PARAMETER_SET_U) {
      this.barcode = stripe.barcode;
      this.trayNumber = stripe.trayNumber;
      this.trayNumberAtSetupDevice = stripe.trayNumberAtSetupDevice;
      this.timestampMinutes = stripe.timestampMinutes;
      this.timestampSeconds = stripe.timestampSeconds;
      this.infoFlags = stripe.infoFlags;
      this.recirculationCounter = stripe.recirculationCounter;
      this.infoFlags2 = stripe.infoFlags2;
      this.reserve20 = stripe.reserve20;
    }
  }

  public String getFunctionPoint() {
    return functionPoint;
  }

  public void setFunctionPoint(String functionPoint) {
    this.functionPoint = functionPoint;
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

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
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

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getReserve9() {
    return reserve9;
  }

  public void setReserve9(int reserve9) {
    this.reserve9 = reserve9;
  }

  public int getReserve10() {
    return reserve10;
  }

  public void setReserve10(int reserve10) {
    this.reserve10 = reserve10;
  }

  public int getReserve11() {
    return reserve11;
  }

  public void setReserve11(int reserve11) {
    this.reserve11 = reserve11;
  }

  public int getReserve12() {
    return reserve12;
  }

  public void setReserve12(int reserve12) {
    this.reserve12 = reserve12;
  }

  public int getReserve13() {
    return reserve13;
  }

  public void setReserve13(int reserve13) {
    this.reserve13 = reserve13;
  }

  public int getReserve14() {
    return reserve14;
  }

  public void setReserve14(int reserve14) {
    this.reserve14 = reserve14;
  }

  public int getReserve15() {
    return reserve15;
  }

  public void setReserve15(int reserve15) {
    this.reserve15 = reserve15;
  }

  public int getReserve16() {
    return reserve16;
  }

  public void setReserve16(int reserve16) {
    this.reserve16 = reserve16;
  }

  public boolean[] getSpecialInfoFlags1() {
    return specialInfoFlags1;
  }

  public void setSpecialInfoFlags1(boolean[] specialInfoFlags1) {
    this.specialInfoFlags1 = specialInfoFlags1;
  }

  public boolean[] getSpecialInfoFlags2() {
    return specialInfoFlags2;
  }

  public void setSpecialInfoFlags2(boolean[] specialInfoFlags2) {
    this.specialInfoFlags2 = specialInfoFlags2;
  }

  public int getTuTypeID() {
    return tuTypeID;
  }

  public void setTuTypeID(int tuTypeID) {
    this.tuTypeID = tuTypeID;
  }

  public int[] getAlternative() {
    return alternative;
  }

  public void setAlternative(int[] alternative) {
    this.alternative = alternative;
  }

  public String getNotspecified() {
    return notspecified;
  }

  public void setNotspecified(String notspecified) {
    this.notspecified = notspecified;
  }

  public int getTrayNumber() {
    return trayNumber;
  }

  public void setTrayNumber(int trayNumber) {
    this.trayNumber = trayNumber;
  }

  public int getTrayNumberAtSetupDevice() {
    return trayNumberAtSetupDevice;
  }

  public void setTrayNumberAtSetupDevice(int trayNumberAtSetupDevice) {
    this.trayNumberAtSetupDevice = trayNumberAtSetupDevice;
  }

  public int getTimestampMinutes() {
    return timestampMinutes;
  }

  public void setTimestampMinutes(int timestampMinutes) {
    this.timestampMinutes = timestampMinutes;
  }

  public int getTimestampSeconds() {
    return timestampSeconds;
  }

  public void setTimestampSeconds(int timestampSeconds) {
    this.timestampSeconds = timestampSeconds;
  }

  public boolean[] getInfoFlags() {
    return infoFlags;
  }

  public void setInfoFlags(boolean[] infoFlags) {
    this.infoFlags = infoFlags;
  }

  public int getRecirculationCounter() {
    return recirculationCounter;
  }

  public void setRecirculationCounter(int recirculationCounter) {
    this.recirculationCounter = recirculationCounter;
  }

  public boolean[] getInfoFlags2() {
    return infoFlags2;
  }

  public void setInfoFlags2(boolean[] infoFlags2) {
    this.infoFlags2 = infoFlags2;
  }
}
