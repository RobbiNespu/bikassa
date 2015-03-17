/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 983 $, $Date: 2013-02-21 17:41:18 +0100 (Do, 21 Feb 2013) $, $Author: dennis.chong $
 */

public class TT0833 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  protected int topic;
  protected int reserve;
  protected String content;

  public TT0833() {
    super();
    telegramType = 833;
    subType = 0;
    version = 0;
    topic = 0;
    reserve = 0;
    content = "";
    for (int i = 0; i < getContentLength(); ++i) {
      content += "00";
    }
  }

  public int getContentOffset() {
    return 16;
  }

  public int getContentLength() {
    return 84;
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + " topic=" + topic + " reserve=" + reserve + ", content=" + content + "]";
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
    hex = insertIntIntoHex(hex, reserve, 4);
    return hex + content;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    version = extractIntFromHex(hex, 8, 2);
    topic = extractIntFromHex(hex, 10, 2);
    reserve = extractIntFromHex(hex, 12, 4);
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
