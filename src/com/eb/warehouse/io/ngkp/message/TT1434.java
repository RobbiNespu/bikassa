package com.eb.warehouse.io.ngkp.message;

import static com.eb.warehouse.io.ngkp.BytesToInt.shortFromBytes;

/**
 * Abstract extension of the telegram class to represent TT1434 telegrams.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author:
 *          dennis.chong $
 */

public abstract class TT1434 extends NGKPTelegram {

  private static final long serialVersionUID = 1L;
  protected int topic;
  protected int statusRequestID;
  protected String content;

  public TT1434() {
    super();
    telegramType = 1434;
    content = "";
    for (int i = 0; i < getContentLength(); ++i) {
      content += "00";
    }
  }

  public static TT1434 fromBytes(byte[] bytes, int offset) {
    int version = shortFromBytes(bytes[offset + 8], bytes[offset + 9]);
    TT1434 msg = null;
    if (version == 0) {
      msg = new TT1434Version1();
    } else if (version == 1) {
      msg = TT1434Version2.fromBytes(bytes, offset);
    }

    msg.setSenderID(shortFromBytes(bytes[offset + 0], bytes[offset + 1]));
    msg.setReceiverID(shortFromBytes(bytes[offset + 2], bytes[offset + 3]));
    msg.setTelegramType(shortFromBytes(bytes[offset + 4], bytes[offset + 5]));
    msg.setVersion(version);
    msg.setTopic(shortFromBytes(bytes[offset + 10], bytes[offset + 11]));
    return msg;
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
