/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1630 telegram class.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */
public class TT1630Version1 extends TT1630 {
  private static final long serialVersionUID = 1L;
  protected int statusRequestID;

  public TT1630Version1() {
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
    s += " requestFlags=" + bitsToString(requestFlags) + ",";
    s += " requestDetails=" + requestDetails + ",";
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
    hex = insertBitsIntoHex(hex, requestFlags, 1);
    hex = insertIntIntoHex(hex, reserve, 1);
    hex = insertIntIntoHex(hex, requestDetails, 2);
    int rest = totalBytes() - (hex.length() / 2);
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
    extractBitsFromHex(hex, requestFlags, 16, 1);
    reserve = extractIntFromHex(hex, 17, 1);
    requestDetails = extractIntFromHex(hex, 18, 2);
  }

  @Override
  public int totalBytes() {
    return 100;
  }

  public int getStatusRequestID() {
    return statusRequestID;
  }

  public void setStatusRequestID(int statusRequestID) {
    this.statusRequestID = statusRequestID;
  }
}
