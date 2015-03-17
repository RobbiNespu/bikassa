/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */
public class TT31 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  protected int reserve;
  protected int area;
  protected String content;
  protected boolean normalize;

  public TT31() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 31;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.reserve = 0;
    this.area = 0;
    this.content = "";
    for (int i = 0; i < getContentLength(); ++i) {
      content += "00";
    }
    this.normalize = false;
  }

  @Override
  public String fieldsToString() {
    String s = "senderID=" + senderID + ",";
    s += " receiverID=" + receiverID + ",";
    s += " telegramType=" + telegramType + ",";
    s += " producerID=" + producerID + ",";
    s += " reserve=" + reserve + ",";
    s += " area=" + area + ",";
    s += " content=" + content + ",";
    s += " normalize=" + normalize + ",";
    return s;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 1);
    hex = insertIntIntoHex(hex, receiverID, 1);
    hex = insertIntIntoHex(hex, telegramType, 1);
    hex = insertIntIntoHex(hex, producerID, 1);
    hex = insertIntIntoHex(hex, reserve, 2);
    hex = insertIntIntoHex(hex, area, 2);
    hex += content;
    if (normalize) {
      return fillUpToLength(hex, '0', 200);
    } else {
      return hex;
    }
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 1);
    receiverID = extractIntFromHex(hex, 1, 1);
    telegramType = extractIntFromHex(hex, 2, 1);
    producerID = extractIntFromHex(hex, 3, 1);
    reserve = extractIntFromHex(hex, 4, 2);
    area = extractIntFromHex(hex, 6, 2);
    int start = getContentOffset() * 2;
    int stop = (getContentOffset() + getContentLength()) * 2;
    content = hex.substring(start, stop);
  }

  public static int getContentOffset() {
    return 8;
  }

  public static int getContentLength() {
    return 32;
  }

  public void setInt2Byte(int value, int byteIndex) {
    setInt(value, byteIndex, 2);
  }

  public void setInt4Byte(int value, int byteIndex) {
    setInt(value, byteIndex, 4);
  }

  public void setInt(int value, int byteIndex, int length) {
    byteIndex = (byteIndex - getContentOffset()) * 2;
    String prefix = content.substring(0, byteIndex);
    String suffix = content.substring(byteIndex + (length * 2));
    content = prefix + insertIntIntoHex("", value, length) + suffix;
  }

  public int getInt2Byte(int byteIndex) {
    return getInt(byteIndex, 2);
  }

  public int getInt4Byte(int byteIndex) {
    return getInt(byteIndex, 4);
  }

  public int getInt(int byteIndex, int length) {
    byteIndex = byteIndex - getContentOffset();
    return extractIntFromHex(content, byteIndex, length);
  }

  public void setBit(boolean value, int byteIndex, int bitIndex) {
    byteIndex = byteIndex - getContentOffset();
    boolean[] bits = new boolean[8];
    extractBitsFromHex(content, bits, byteIndex, 1);
    bits[bitIndex] = value;
    byteIndex *= 2;
    String prefix = content.substring(0, byteIndex);
    String suffix = content.substring(byteIndex + 2);
    content = prefix + insertBitsIntoHex("", bits, 1) + suffix;
  }

  public boolean getBit(int byteIndex, int bitIndex) {
    byteIndex = byteIndex - getContentOffset();
    boolean[] bits = new boolean[8];
    extractBitsFromHex(content, bits, byteIndex, 1);
    return bits[bitIndex];
  }

  public int getReserve() {
    return reserve;
  }

  public void setReserve(int reserve) {
    this.reserve = reserve;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isNormalize() {
    return normalize;
  }

  public void setNormalize(boolean normalize) {
    this.normalize = normalize;
  }
}
