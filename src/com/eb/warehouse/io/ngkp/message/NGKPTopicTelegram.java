/*
 * Copyright (c) 2014 SSI Schaefer Noell GmbH
 */

package com.eb.warehouse.io.ngkp.message;

public abstract class NGKPTopicTelegram extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  protected int topic;
  protected int statusRequestId;
  protected String content;

  public NGKPTopicTelegram() {
    super();
    telegramType = 0;
    version = 0;
    subType = 0;
    content = "";
    for (int i = 0; i < getContentLength(); ++i) {
      content += "00";
    }
  }

  @Override
  public String fieldsToString() {
    String result = super.fieldsToString();
    result += " topic=" + topic + ",";
    result += " statusRequestId=" + statusRequestId + ",";
    result += " content=" + content + ",";
    return result;
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = str.substring(0, str.length() - 12);
    str = insertIntIntoHex(str, topic, 2);
    str = insertIntIntoHex(str, statusRequestId, 4);
    return str + content;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    requestID = 0;
    producerID = 0;
    topic = extractIntFromHex(hex, 10, 2);
    statusRequestId = extractIntFromHex(hex, 12, 4);
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

  public int getStatusRequestId() {
    return statusRequestId;
  }

  public void setStatusRequestId(int statusRequestId) {
    this.statusRequestId = statusRequestId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public abstract int getContentLength();

  public abstract int getContentOffset();
}
