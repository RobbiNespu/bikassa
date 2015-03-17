/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT39 telegrams.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1565 $, $Date: 2013-11-14 14:41:26 +0100 (Do, 14 Nov 2013) $, $Author: dennis.chong $
 */
public class TT39 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  public static final int NOORDER = 0;
  public static final int PARAMETER_WRITE = 51;
  public static final int PARAMETER_READ = 151;
  public static final int PARAMETER_REPLY = 151;
  public static final int PARAMETER_REQUEST = 152;
  public static final int STATUS_REQUEST = 231;
  public static final int STATUS_REPLY = 231;
  public static final char PARAMETER_SET_DUMMY = '0';
  public static final char PARAMETER_SET_1 = '1';
  public static final char PARAMETER_SET_2 = '2';
  public static final char PARAMETER_SET_S = 'S';
  public static final char PARAMETER_SET_UNDEFINED = ' ';
  public static final char STRIPE_CONTINUE = '+';
  public static final char STRIPE_END_OF_CHAIN = '-';
  public static final char STRIPE_NOTE_USED = ' ';
  public static final String BARCODE_EMPTY = "                    ";
  protected TT39Stripe[] stripes;
  protected int byteoffset;

  public TT39() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 39;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.stripes = new TT39Stripe[8];
    for (int i = 0; i < stripes.length; ++i) {
      stripes[i] = new TT39Stripe();
    }
  }

  @Override
  public String fieldsToString() {
    String s = "senderID=" + senderID + ",";
    s += " receiverID=" + receiverID + ",";
    s += " telegramType=" + telegramType + ",";
    s += " producerID=" + producerID + ",";
    for (int i = 0; i < stripes.length; ++i) {
      s += stripes[i].fieldsToString(i + 1);
    }
    return s;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 1);
    hex = insertIntIntoHex(hex, receiverID, 1);
    hex = insertIntIntoHex(hex, telegramType, 1);
    hex = insertIntIntoHex(hex, producerID, 1);
    for (int i = 0; i < stripes.length; ++i) {
      hex = hex + stripes[i].toHex();
    }
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 1);
    receiverID = extractIntFromHex(hex, 1, 1);
    telegramType = extractIntFromHex(hex, 2, 1);
    producerID = extractIntFromHex(hex, 3, 1);
    this.stripes = new TT39Stripe[8];
    for (int i = 0; i < stripes.length; ++i) {
      stripes[i] = new TT39Stripe();
    }
    byteoffset = 4;
    for (int i = 0; i < stripes.length; ++i) {
      byteoffset = stripes[i].fromHex(hex, byteoffset);
    }
  }

  public TT39Stripe[] getStripes() {
    return stripes;
  }

  public void setStripes(TT39Stripe[] stripes) {
    this.stripes = stripes;
  }

  public int getByteoffset() {
    return byteoffset;
  }

  public void setByteoffset(int byteoffset) {
    this.byteoffset = byteoffset;
  }
}
