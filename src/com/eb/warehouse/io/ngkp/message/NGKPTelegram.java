/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

// import com.ssn.simulation.telegrams.Telegram;

/**
 * Base class of all ngkp telegram types. Contains all common header telegram parameters.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1662 $, $Date: 2014-02-10 08:56:54 +0100 (Mo, 10 Feb 2014) $, $Author:
 *          dennis.chong $
 */

public class NGKPTelegram implements /*Telegram,*/ Serializable {

  private static final long serialVersionUID = 1L;
  protected int senderID;
  protected int receiverID;
  protected int telegramType;
  protected int subType;
  protected int version;
  protected int requestID;
  protected int producerID;
  protected int port;

  /**
   * Constructor. Initialise the common header telegram parameters.
   */
  public NGKPTelegram() {
    super();
    senderID = 201;
    receiverID = 0;
    telegramType = 0;
    subType = 0;
    version = 0;
    requestID = 0;
    producerID = 0;
    port = 0;
  }

  /**
   * Helper method to extract an integer value from a given hex representation of a telegram.
   *
   * @param hex    the hex representation of the telegram
   * @param start  the index of the first byte of the integer in the hex value
   * @param length the count of bytes of the integer in the hex value
   * @return the extracted integer
   */
  public static int extractIntFromHex(String hex, int start, int length) {
    hex = hex.substring((start * 2), (start * 2) + (length * 2));
    int value = Integer.parseInt(hex, 16);
    return value;
  }

  /**
   * Helper method to extract a bit array from a given hex representation of a telegram.
   *
   * @param hex    hex the hex representation of the telegram
   * @param bits   the reference of the bit array, where to write the bits, null not allowed
   * @param start  the index of the first byte of the bit array in the hex value
   * @param length the count of bytes of the bit array in the hex value
   */
  public static void extractBitsFromHex(String hex, boolean[] bits, int start, int length) {
    int value = extractIntFromHex(hex, start, length);
    for (int i = 0; i < bits.length; ++i) {
      bits[i] = (value & 1 << i) != 0;
    }
  }

  /**
   * Helper method to Extract a string from a given hex representation of a telegram.
   *
   * @param hex    hex the hex representation of the telegram
   * @param start  the index of the first byte of the string in the hex value
   * @param length the count of bytes of the string in the hex value
   * @return the extracted string
   */
  public static String extractStringFromHex(String hex, int start, int length) {
    String s = "";
    for (int i = 0; i < length; ++i) {
      int value = extractIntFromHex(hex, start + i, 1);
      // REMOVED: does not work for TT13
      // if (value >= 32 && value <= 126) {
      //   value = 32;
      //  }
      s += (char) value + "";
    }
    return s;
  }

  /**
   * Helper method to insert an integer to end of a given hex value. Negatives are now allowed.
   *
   * @param hex    the hex value to complete
   * @param value  the integer value to insert
   * @param length the count of bytes of the integer in the hex value
   * @return the completed hex value
   */
  public static String insertIntIntoHex(String hex, int value, int length) {
    return insertIntIntoHex(hex, value, length, false);
  }

  /**
   * Helper method to insert an long to end of a given hex value. Negatives are now allowed.
   *
   * @param hex    the hex value to complete
   * @param value  the long value to insert
   * @param length the count of bytes of the integer in the hex value
   * @return the completed hex value
   */
  public static String insertLongIntoHex(String hex, long value, int length) {
    return insertLongIntoHex(hex, value, length, false);
  }

  /**
   * Helper method to insert an integer to end of a given hex value.
   *
   * @param hex    the hex value to complete
   * @param value  the integer value to insert
   * @param length the count of bytes of the integer in the hex value
   * @return the completed hex value
   */
  public static String insertIntIntoHex(String hex, int value, int length, boolean negatives) {
    if (!negatives) {
      if (value < 0) {
        throw new IllegalArgumentException("illegal value: " + value);
      }
      String s = String.format("%0" + (length * 2) + "X", value);
      return hex + s;
    } else { // see ASIM-204
      long bitMask = 0xFF;
      for (int i = 1; i < length; i++) {
        bitMask = (bitMask << 8) | 0xFF;
      }
      String s = String.format("%0" + (length * 2) + "X", (bitMask & value));
      return hex + s;
    }
  }

  /**
   * Helper method to insert an integer to end of a given hex value.
   *
   * @param hex    the hex value to complete
   * @param value  the integer value to insert
   * @param length the count of bytes of the integer in the hex value
   * @return the completed hex value
   */
  public static String insertLongIntoHex(String hex, long value, int length, boolean negatives) {
    if (!negatives) {
      if (value < 0) {
        throw new IllegalArgumentException("illegal value: " + value);
      }
      String s = String.format("%0" + (length * 2) + "X", value);
      return hex + s;
    } else { // see ASIM-204
      long bitMask = 0xFF;
      for (int i = 1; i < length; i++) {
        bitMask = (bitMask << 8) | 0xFF;
      }
      String s = String.format("%0" + (length * 2) + "X", (bitMask & value));
      return hex + s;
    }
  }

  /**
   * Helper method to insert a bit array to the end of a given hex value.
   *
   * @param hex    the hex value to complete
   * @param bits   the bit array to insert
   * @param length the count of bytes of the integer in the hex value
   * @return the completed hex value
   */
  public static String insertBitsIntoHex(String hex, boolean[] bits, int length) {
    int value = 0;
    for (int i = 0; i < bits.length; ++i) {
      value = bits[i] ? value | (1 << i) : value;
    }
    return insertIntIntoHex(hex, value, length);
  }

  /**
   * Helper method to insert a string to the end of a given hex value.
   *
   * @param hex the hex value to complete
   * @param str the string to insert
   * @return the completed hex value
   */
  public static String insertStringIntoHex(String hex, String str) {
    for (int i = 0; i < str.length(); ++i) {
      int value = str.charAt(i);
      hex = insertIntIntoHex(hex, value, 1);
    }
    return hex;
  }

  /**
   * Helper method to convert a bit array into a string.
   *
   * @param bits the bit array to convert
   * @return the to-string-representation of the bit array
   */
  public static String bitsToString(boolean[] bits) {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < bits.length; ++i) {
      s.append(bits[i] ? "1" : "0");
    }
    return s.toString();
  }

  /**
   * Formats the given string to have the given length. If needed, the string is filled with
   * blanks.
   *
   * @param str    the string to format
   * @param length the desired length of the string
   * @return the formatted string
   */
  public static String formatString(String str, int length) {
    if (str.length() < length) {
      StringBuilder res = new StringBuilder();
      res.append(str);
      int n = length - str.length();
      for (int i = 0; i < n; ++i) {
        res.append(" ");
      }
      return res.toString(); // TODO: fixed!
    } else if (str.length() > length) {
      return str.substring(0, length);
    } else {
      return str;
    }
  }

  /**
   * Fills the given string with the given character up to the given length.
   *
   * @param str           the string to fill up
   * @param fillCharacter the fill character
   * @param totalLength   the desired length of the result
   * @return the filled string
   */
  public static String fillUpToLength(String str, char fillCharacter, int totalLength) {
    int count = totalLength - str.length();
    if (count > 0) {
      StringBuilder s = new StringBuilder();
      s.append(str);
      for (int i = 0; i < count; ++i) {
        s.append(fillCharacter);
      }
      return s.toString();
    } else {
      return str;
    }
  }

  /**
   * Converts the telegram into a string.
   *
   * @return the to-string-representation of the telegram
   */

  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" + fieldsToString() + "]";
  }

  /**
   * Converts the fields of the telegram into a string. Overridden in the different telegram sub
   * types.
   *
   * @return the to-string-representation of the fields of the telegram
   */
  public String fieldsToString() {
    return "senderId=" + senderID + "," + " receiverId=" + receiverID + "," + " telegramType="
           + telegramType + "," + " subType=" + subType + "," + " version=" + version + ","
           + " requestID=" + requestID + "," + " producerID=" + producerID + ",";
  }

  /**
   * Converts the telegram into a hex value. Overridden in the different telegram sub types.
   *
   * @return the hex representation of the telegram
   */
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, requestID, 4);
    hex = insertIntIntoHex(hex, producerID, 2);
    return hex;
  }

  /**
   * Converts a hex value into a telegram. Overridden in the different telegram sub types.
   *
   * @param hex the hex value of the telegram
   */
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    version = extractIntFromHex(hex, 8, 2);
    requestID = extractIntFromHex(hex, 10, 4);
    producerID = extractIntFromHex(hex, 14, 2);
  }

  public int getSenderID() {
    return senderID;
  }

  public void setSenderID(int senderID) {
    this.senderID = senderID;
  }

  public int getReceiverID() {
    return receiverID;
  }

  public void setReceiverID(int receiverID) {
    this.receiverID = receiverID;
  }

  public int getTelegramType() {
    return telegramType;
  }

  public void setTelegramType(int telegramType) {
    this.telegramType = telegramType;
  }

  public int getSubType() {
    return subType;
  }

  public void setSubType(int subType) {
    this.subType = subType;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public int getRequestID() {
    return requestID;
  }

  public void setRequestID(int requestID) {
    this.requestID = requestID;
  }

  public int getProducerID() {
    return producerID;
  }

  public void setProducerID(int producerID) {
    this.producerID = producerID;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
