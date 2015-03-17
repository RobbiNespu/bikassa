/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Abstract extension of the telegram class to represent TT1430 telegrams.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */
public abstract class TT1430 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  protected int topic;
  protected int statusRequestID;
  protected String content;

  public TT1430() {
    super();
    this.telegramType = 1430;
    this.content = "";
    for (int i = 0; i < getContentLength(); ++i) {
      content += "00";
    }
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

  public abstract int getContentOffset();

  public abstract int getContentLength();
}
