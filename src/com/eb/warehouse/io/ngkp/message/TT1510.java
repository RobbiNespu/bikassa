/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Abstract extension of the telegram class to represent TT1510 telegrams.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1812 $, $Date: 2014-08-25 09:40:11 +0200 (Mon, 25 Aug 2014) $, $Author: dennis.chong $
 */
public abstract class TT1510 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  public static final int TRANSPORT_ORDER = 15002;
  public static final int TRANSPORT_ORDER_LOW_PRIORITY = 15001;
  public static final int TRANSPORT_ORDER_HIGH_PRIORITY = 15003;
  public static final int TRANSPORT_ORDER_UPDATE = 15012;
  public static final int ANNOUNCEMENT = 15011;
  public static final int TU_CREATED_MANUALLY = 15015;
  public static final int INFO = 15021;
  public static final int COMPLETION = 15001;
  public static final int DEVIATING_COMPLETION = 15002;
  public static final int SOURCE_POSITION_EMPTY = 15271;
  public static final int TU_DELETED_MANUALLY = 15091;
  public static final int UNKOWN_ORDER = 15130;
  public static final int GENERAL_PLAUSIBILIYT_ERROR = 15160;

  protected int sourceSystem;
  protected int sourceUnit;
  protected int sourcePlace;
  protected int destinationSystem;
  protected int destinationUnit;
  protected int destinationPlace;
  protected int lastSystem;
  protected int lastUnit;
  protected int lastPlace;
  protected int order;
  protected int acknowledge;
  protected boolean[] orderExtensions1;
  protected boolean[] orderExtensions2;
  protected boolean[] ackExtensions1;
  protected boolean[] ackExtensions2;
  protected int tuType;
  protected boolean[] tuFlags1;
  protected boolean[] tuFlags2;
  protected int length;
  protected int width;
  protected int height;
  protected int weight;
  protected boolean[] errorFlags1;
  protected boolean[] errorFlags2;
  protected String tuID;

  public TT1510() {
    super();
    this.telegramType = 1510;
    this.subType = 0;
    this.version = 1;
    this.sourceSystem = 0;
    this.sourceUnit = 0;
    this.sourcePlace = 0;
    this.destinationSystem = 0;
    this.destinationUnit = 0;
    this.destinationPlace = 0;
    this.lastSystem = 0;
    this.lastUnit = 0;
    this.lastPlace = 0;
    this.order = 0;
    this.acknowledge = 0;
    this.tuType = 0;
    this.length = 0;
    this.width = 0;
    this.height = 0;
    this.weight = 0;
    this.tuID = "                    ";
    this.orderExtensions1 = new boolean[8];
    this.orderExtensions2 = new boolean[8];
    this.ackExtensions1 = new boolean[8];
    this.ackExtensions2 = new boolean[8];
    this.tuFlags1 = new boolean[8];
    this.tuFlags2 = new boolean[8];
    this.errorFlags1 = new boolean[8];
    this.errorFlags2 = new boolean[8];
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + " sourceSystem=" + sourceSystem + "," + " sourceUnit=" + sourceUnit + "," + " sourcePlace=" + sourcePlace + "," + " destinationSystem=" + destinationSystem + "," + " destinationUnit=" + destinationUnit + "," + " destinationPlace=" + destinationPlace + "," + " lastSystem=" + lastSystem + "," + " lastUnit=" + lastUnit + "," + " lastPlace=" + lastPlace + "," + " order=" + order + "," + " orderExtensions1=" + bitsToString(orderExtensions1) + ", " + " orderExtensions2=" + bitsToString(orderExtensions2) + ", " + " acknowledge=" + acknowledge + "," + " ackExtensions1=" + bitsToString(ackExtensions1) + ", " + " ackExtensions2=" + bitsToString(ackExtensions2) + ", " + " tuType=" + tuType + "," + " tuFlags1=" + bitsToString(tuFlags1) + ", " + " tuFlags2=" + bitsToString(tuFlags2) + ", " + " length=" + length + "," + " width=" + width + "," + " height=" + height + "," + " weight=" + weight + "," + " errorFlags1=" + bitsToString(errorFlags1) + ", "
        + " errorFlags2=" + bitsToString(errorFlags2) + ", " + " tuID=" + tuID + ",";
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = insertIntIntoHex(str, sourceSystem, 2);
    str = insertIntIntoHex(str, sourceUnit, 2);
    str = insertIntIntoHex(str, sourcePlace, 2);
    str = insertIntIntoHex(str, destinationSystem, 2);
    str = insertIntIntoHex(str, destinationUnit, 2);
    str = insertIntIntoHex(str, destinationPlace, 2);
    str = insertIntIntoHex(str, lastSystem, 2);
    str = insertIntIntoHex(str, lastUnit, 2);
    str = insertIntIntoHex(str, lastPlace, 2);
    str = insertIntIntoHex(str, order, 2);
    str = insertBitsIntoHex(str, orderExtensions1, 1);
    str = insertBitsIntoHex(str, orderExtensions2, 1);
    str = insertIntIntoHex(str, acknowledge, 2);
    str = insertBitsIntoHex(str, ackExtensions1, 1);
    str = insertBitsIntoHex(str, ackExtensions2, 1);
    str = insertIntIntoHex(str, tuType, 2);
    str = insertBitsIntoHex(str, tuFlags1, 1);
    str = insertBitsIntoHex(str, tuFlags2, 1);
    str = insertIntIntoHex(str, length, 2);
    str = insertIntIntoHex(str, width, 2);
    str = insertIntIntoHex(str, height, 2);
    str = insertIntIntoHex(str, weight, 2);
    str = insertBitsIntoHex(str, errorFlags1, 1);
    str = insertBitsIntoHex(str, errorFlags2, 1);
    str = insertStringIntoHex(str, formatTUID(tuID));
    return str;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    orderExtensions1 = new boolean[8];
    orderExtensions2 = new boolean[8];
    ackExtensions1 = new boolean[8];
    ackExtensions2 = new boolean[8];
    tuFlags1 = new boolean[8];
    tuFlags2 = new boolean[8];
    errorFlags1 = new boolean[8];
    errorFlags2 = new boolean[8];
    sourceSystem = extractIntFromHex(hex, 16, 2);
    sourceUnit = extractIntFromHex(hex, 18, 2);
    sourcePlace = extractIntFromHex(hex, 20, 2);
    destinationSystem = extractIntFromHex(hex, 22, 2);
    destinationUnit = extractIntFromHex(hex, 24, 2);
    destinationPlace = extractIntFromHex(hex, 26, 2);
    lastSystem = extractIntFromHex(hex, 28, 2);
    lastUnit = extractIntFromHex(hex, 30, 2);
    lastPlace = extractIntFromHex(hex, 32, 2);
    order = extractIntFromHex(hex, 34, 2);
    extractBitsFromHex(hex, orderExtensions1, 36, 1);
    extractBitsFromHex(hex, orderExtensions2, 37, 1);
    acknowledge = extractIntFromHex(hex, 38, 2);
    extractBitsFromHex(hex, ackExtensions1, 40, 1);
    extractBitsFromHex(hex, ackExtensions2, 41, 1);
    tuType = extractIntFromHex(hex, 42, 2);
    extractBitsFromHex(hex, tuFlags1, 44, 1);
    extractBitsFromHex(hex, tuFlags2, 45, 1);
    length = extractIntFromHex(hex, 46, 2);
    width = extractIntFromHex(hex, 48, 2);
    height = extractIntFromHex(hex, 50, 2);
    weight = extractIntFromHex(hex, 52, 2);
    extractBitsFromHex(hex, errorFlags1, 54, 1);
    extractBitsFromHex(hex, errorFlags2, 55, 1);
    tuID = extractStringFromHex(hex, 56, 20).trim();
  }

  public String formatTUID(String id) {
    if (id.length() > 20) {
      return id.substring(0, 20);
    } else {
      return String.format("%-20s", id);
    }
  }

  public boolean isTransportOrder() {
    return order == TRANSPORT_ORDER || order == TRANSPORT_ORDER_LOW_PRIORITY || order == TRANSPORT_ORDER_HIGH_PRIORITY || order == TRANSPORT_ORDER_UPDATE;
  }

  public String getSourceID() {
    return getSourceSystem() + "/" + getSourceUnit() + "/" + getSourcePlace();
  }

  public String getDestinationID() {
    return getDestinationSystem() + "/" + getDestinationUnit() + "/" + getDestinationPlace();
  }

  public String getLastNoticeID() {
    return getLastSystem() + "/" + getLastUnit() + "/" + getLastPlace();
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

  public void setOrderExtensionBit(int extension, int bit, boolean value) {
    if (extension == 1) {
      getOrderExtensions1()[bit] = value;
    }
    if (extension == 2) {
      getOrderExtensions2()[bit] = value;
    }
  }

  public boolean getAckExtensionBit(int extension, int bit) {
    if (extension == 1) {
      return getAckExtensions1()[bit];
    }
    if (extension == 2) {
      return getAckExtensions2()[bit];
    }
    return false;
  }

  public void setAckExtensionBit(int extension, int bit, boolean value) {
    if (extension == 1) {
      getAckExtensions1()[bit] = value;
    }
    if (extension == 2) {
      getAckExtensions2()[bit] = value;
    }
  }

  public static TT1510 createTelegramBySubtype(int subtype) {
    if (subtype == 1) {
      return new TT1510Subtype1();
    }
    if (subtype == 3) {
      return new TT1510Subtype3();
    }
    if (subtype == 5) {
      return new TT1510Subtype5();
    }
    if (subtype == 7) {
      return new TT1510Subtype7();
    }
    if (subtype == 11) {
      return new TT1510Subtype11();
    }
    return null;
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

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
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

  public int getTuType() {
    return tuType;
  }

  public void setTuType(int tuType) {
    this.tuType = tuType;
  }

  public boolean[] getTuFlags1() {
    return tuFlags1;
  }

  public void setTuFlags1(boolean[] tuFlags1) {
    this.tuFlags1 = tuFlags1;
  }

  public boolean[] getTuFlags2() {
    return tuFlags2;
  }

  public void setTuFlags2(boolean[] tuFlags2) {
    this.tuFlags2 = tuFlags2;
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

  public boolean[] getErrorFlags1() {
    return errorFlags1;
  }

  public void setErrorFlags1(boolean[] errorFlags1) {
    this.errorFlags1 = errorFlags1;
  }

  public boolean[] getErrorFlags2() {
    return errorFlags2;
  }

  public void setErrorFlags2(boolean[] errorFlags2) {
    this.errorFlags2 = errorFlags2;
  }

  public String getTuID() {
    return tuID;
  }

  public void setTuID(String tuID) {
    this.tuID = tuID;
  }
}
