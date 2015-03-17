/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1215 $, $Date: 2013-05-13 12:24:22 +0200 (Mo, 13 Mai 2013) $, $Author: dennis.chong $
 */

public class TT1243Version1 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  public static final int STATE_WC = 2;
  public static final int STATE_OS = 12;
  public static final int OCCUPANCY_WC = 4;
  public static final int OCCUPANCY_OS = 14;
  public static final int STATE_REQUES = 11;

  protected int topic;
  protected int statusRequestID;
  protected String content;

  public TT1243Version1() {
    super();
    this.telegramType = 1243;
    this.version = 1;
    this.content = "";
    for (int i = 0; i < getContentLength(); ++i) {
      content += "00";
    }
  }

  @Override
  public String fieldsToString() {
    String result = super.fieldsToString();
    result += " topic=" + topic + ",";
    result += " statusRequestID=" + statusRequestID + ",";
    result += " content=" + content + ",";
    return result;
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = str.substring(0, str.length() - 12);
    str = insertIntIntoHex(str, topic, 2);
    str = insertIntIntoHex(str, statusRequestID, 4);
    return str + content;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    requestID = 0;
    producerID = 0;
    topic = extractIntFromHex(hex, 10, 2);
    statusRequestID = extractIntFromHex(hex, 12, 4);
    int start = getContentOffset() * 2;
    int stop = (getContentOffset() + getContentLength()) * 2;
    content = hex.substring(start, stop);
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

  public int getTopic() {
    return topic;
  }

  public void setTopic(int topic) {
    this.topic = topic;
  }

  public int getStatusRequestID() {
    return statusRequestID;
  }

  public void setStatusRequestID(int statusRequestID) {
    this.statusRequestID = statusRequestID;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getContentOffset() {
    return 16;
  }

  public int getContentLength() {
    return 218 - 16;
  }
}
