/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1636 telegram class.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author: dennis.chong $
 */
public class TT1636Version1 extends TT1636 {
  private static final long serialVersionUID = 1L;

  public TT1636Version1() {
    super();
    this.version = 1;
  }

  @Override
  public String fieldsToString() {
    String s = "senderID=" + senderID + ",";
    s += " receiverID=" + receiverID + ",";
    s += " telegramType=" + telegramType + ",";
    s += " subType=" + subType + ",";
    s += " telegramType=" + telegramType + ",";
    s += " version=" + version + ",";
    s += " topic=" + topic + ",";
    s += " statusRequestID=" + statusRequestID + ",";
    if (topic == 1) {
      s += " emsNumber=" + emsNumber;
      s += " controlStatus1=" + bitsToString(controlStatus1);
      s += " controlStatus2=" + bitsToString(controlStatus2);
      s += " toAmmount=" + toAmmount;
    } else if (topic == 2) {
      s += " emsNumber=" + emsNumber;
      s += " area=" + area;
      s += " location=" + location;
      s += " place=" + place;
      s += " vehicleNumber=" + vehicleNumber;
      s += " vehicleLSD=" + vehicleLSD;
      s += " vehiclePlace=" + vehiclePlace;
      s += " vehcileStatus1=" + bitsToString(vehcileStatus1);
      s += " vehcileStatus2=" + bitsToString(vehcileStatus2);
      s += " lsdStatus1=" + bitsToString(lsdStatus1);
      s += " lsdStatus2=" + bitsToString(lsdStatus2);
      s += " lsdStatus3=" + bitsToString(lsdStatus3);
      s += " lsdStatus4=" + bitsToString(lsdStatus4);
      s += " requestID1=" + requestID1;
      s += " requestID2=" + requestID2;
      s += " requestID3=" + requestID3;
      s += " requestID4=" + requestID4;
    } else if (topic == 3) {
      s += " emsNumber=" + emsNumber;
      s += " area=" + area;
      s += " location=" + location;
      s += " place=" + place;
      s += " vehicleNumber=" + vehicleNumber;
      s += " vehicleLSD=" + vehicleLSD;
      s += " vehiclePlace=" + vehiclePlace;
      s += " type=" + type;
      s += " typeFlag1=" + bitsToString(typeFlags1);
      s += " typeFlag2=" + bitsToString(typeFlags2);
      s += " length=" + length;
      s += " width=" + width;
      s += " height=" + height;
      s += " weight=" + weight;
      s += " errorFlags1=" + bitsToString(errorFlags1);
      s += " errorFlags1=" + bitsToString(errorFlags2);
      s += " id=" + id;
    }
    return s;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, topic, 2);
    hex = insertIntIntoHex(hex, statusRequestID, 4);
    if (topic == 1) {
      hex = insertIntIntoHex(hex, emsNumber, 2);
      hex = insertBitsIntoHex(hex, controlStatus1, 1);
      hex = insertBitsIntoHex(hex, controlStatus2, 1);
      hex = insertIntIntoHex(hex, toAmmount, 2);
    } else if (topic == 2) {
      hex = insertIntIntoHex(hex, emsNumber, 2);
      hex = insertIntIntoHex(hex, area, 2);
      hex = insertIntIntoHex(hex, location, 2);
      hex = insertIntIntoHex(hex, place, 2);
      hex = insertIntIntoHex(hex, vehicleNumber, 2);
      hex = insertIntIntoHex(hex, vehicleLSD, 2);
      hex = insertIntIntoHex(hex, vehiclePlace, 2);
      hex = insertBitsIntoHex(hex, vehcileStatus1, 1);
      hex = insertBitsIntoHex(hex, vehcileStatus2, 1);
      hex = insertBitsIntoHex(hex, lsdStatus1, 1);
      hex = insertBitsIntoHex(hex, lsdStatus2, 1);
      hex = insertBitsIntoHex(hex, lsdStatus3, 1);
      hex = insertBitsIntoHex(hex, lsdStatus4, 1);
      hex = insertIntIntoHex(hex, requestID1, 4);
      hex = insertIntIntoHex(hex, requestID2, 4);
      hex = insertIntIntoHex(hex, requestID3, 4);
      hex = insertIntIntoHex(hex, requestID4, 4);
    } else if (topic == 3) {
      hex = insertIntIntoHex(hex, emsNumber, 2);
      hex = insertIntIntoHex(hex, area, 2);
      hex = insertIntIntoHex(hex, location, 2);
      hex = insertIntIntoHex(hex, place, 2);
      hex = insertIntIntoHex(hex, vehicleNumber, 2);
      hex = insertIntIntoHex(hex, vehicleLSD, 2);
      hex = insertIntIntoHex(hex, vehiclePlace, 2);
      hex = insertIntIntoHex(hex, type, 2);
      hex = insertBitsIntoHex(hex, typeFlags1, 1);
      hex = insertBitsIntoHex(hex, typeFlags2, 1);
      hex = insertIntIntoHex(hex, length, 2);
      hex = insertIntIntoHex(hex, width, 2);
      hex = insertIntIntoHex(hex, height, 2);
      hex = insertIntIntoHex(hex, weight, 2);
      hex = insertBitsIntoHex(hex, errorFlags1, 1);
      hex = insertBitsIntoHex(hex, errorFlags2, 1);
      hex = insertStringIntoHex(hex, id);
    }
    int totalBytes = 422;
    int rest = totalBytes - (hex.length() / 2);
    for (int i = 0; i < rest; ++i) {
      hex += "00";
    }
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    version = extractIntFromHex(hex, 8, 2);
    topic = extractIntFromHex(hex, 10, 2);
    statusRequestID = extractIntFromHex(hex, 12, 4);
    if (topic == 1) {
      emsNumber = extractIntFromHex(hex, 16, 2);
      extractBitsFromHex(hex, controlStatus1, 18, 1);
      extractBitsFromHex(hex, controlStatus2, 19, 1);
      toAmmount = extractIntFromHex(hex, 20, 2);
    } else if (topic == 2) {
      emsNumber = extractIntFromHex(hex, 16, 2);
      area = extractIntFromHex(hex, 18, 2);
      location = extractIntFromHex(hex, 20, 2);
      place = extractIntFromHex(hex, 22, 2);
      vehicleNumber = extractIntFromHex(hex, 24, 2);
      vehicleLSD = extractIntFromHex(hex, 26, 2);
      vehiclePlace = extractIntFromHex(hex, 28, 2);
      extractBitsFromHex(hex, vehcileStatus1, 30, 1);
      extractBitsFromHex(hex, vehcileStatus2, 31, 1);
      extractBitsFromHex(hex, lsdStatus1, 32, 1);
      extractBitsFromHex(hex, lsdStatus2, 33, 1);
      extractBitsFromHex(hex, lsdStatus3, 34, 1);
      extractBitsFromHex(hex, lsdStatus4, 35, 1);
      requestID1 = extractIntFromHex(hex, 36, 4);
      requestID2 = extractIntFromHex(hex, 40, 4);
      requestID3 = extractIntFromHex(hex, 44, 4);
      requestID4 = extractIntFromHex(hex, 48, 4);
    } else if (topic == 3) {
      emsNumber = extractIntFromHex(hex, 16, 2);
      area = extractIntFromHex(hex, 18, 2);
      location = extractIntFromHex(hex, 20, 2);
      place = extractIntFromHex(hex, 22, 2);
      vehicleNumber = extractIntFromHex(hex, 24, 2);
      vehicleLSD = extractIntFromHex(hex, 26, 2);
      vehiclePlace = extractIntFromHex(hex, 28, 2);
      type = extractIntFromHex(hex, 30, 2);
      extractBitsFromHex(hex, typeFlags1, 32, 1);
      extractBitsFromHex(hex, typeFlags2, 33, 1);
      length = extractIntFromHex(hex, 34, 2);
      width = extractIntFromHex(hex, 36, 2);
      height = extractIntFromHex(hex, 38, 2);
      weight = extractIntFromHex(hex, 40, 2);
      extractBitsFromHex(hex, errorFlags1, 42, 1);
      extractBitsFromHex(hex, errorFlags2, 43, 1);
      id = extractStringFromHex(hex, 44, 20);
    }
  }

  @Override
  public int totalBytes() {
    return 422;
  }

}
