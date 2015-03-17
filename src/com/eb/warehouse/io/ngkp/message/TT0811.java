/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1834 $, $Date: 2014-09-05 17:31:59 +0200 (Fri, 05 Sep 2014) $, $Author: dennis.chong $
 */

public class TT0811 extends TT081x {
  private static final long serialVersionUID = 1L;

  protected int reserve;
  protected TT0811Part[] parts;

  public TT0811() {
    this(1);
  }

  public TT0811(int subType) {
    super();
    senderID = 201;
    receiverID = 0;
    telegramType = 811;
    this.subType = subType;
    version = 0;
    requestID = 0;
    reserve = 0;
    parts = new TT0811Part[subType];
    for (int i = 0; i < parts.length; ++i) {
      parts[i] = new TT0811Part();
    }
  }

  @Override
  public String fieldsToString() {
    String str = super.fieldsToString();
    for (int i = 0; i < parts.length; ++i) {
      str += parts[i].fieldsToString(i + 1);
    }
    str += "]";
    return str;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, reserve, 2);
    for (int i = 0; i < parts.length; ++i) {
      hex += parts[i].toHex();
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
    reserve = extractIntFromHex(hex, 10, 2);
    parts = new TT0811Part[subType];
    int byteOffset = 12;
    for (int i = 0; i < parts.length; ++i) {
      parts[i] = new TT0811Part();
      parts[i].fromHex(hex, byteOffset);
      byteOffset += 40;
    }
  }

  public TT0811Part getPart(int index) {
    if (index < 0 || index > parts.length - 1) {
      return null;
    } else {
      return parts[index];
    }
  }

  public int getReserve() {
    return reserve;
  }

  public void setReserve(int reserve) {
    this.reserve = reserve;
  }

  public TT0811Part[] getParts() {
    return parts;
  }

  public void setParts(TT0811Part[] parts) {
    this.parts = parts;
  }

  @Override
  public int getSubType() {
    return parts.length;
  }
}
