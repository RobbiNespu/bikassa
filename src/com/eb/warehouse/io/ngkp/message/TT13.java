/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT13 telegrams.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1689 $, $Date: 2014-03-18 10:06:29 +0100 (Di, 18 Mrz 2014) $, $Author:
 *          dennis.chong $
 */
public class TT13 extends NGKPTelegram {

  public static final int NOORDER = 0;
  public static final int DELETE_ORDER_BY_BC = 201;
  public static final int DELETE_ORDER_BY_FP = 203;
  public static final int DELETE_ORDER_ALL = 204;
  public static final int SOURCE_EMPTY = 224;
  public static final int TU_ID_MISMATCH = 225;
  public static final int UPDATE_NOT_POSSIBLE = 227;
  public static final int ACKNOWLEDGE_USED_STRIPE = 255;
  public static final char PARAMETER_SET_B = 'B';
  public static final char PARAMETER_SET_L = 'L';
  public static final char PARAMETER_SET_C = 'C';
  public static final char PARAMETER_SET_A = 'A';
  public static final char PARAMETER_SET_U = 'U';
  public static final char PARAMETER_SET_UNDEFINED = ' ';
  public static final String BARCODE_EMPTY = "                    ";
  public static final String BARCODE_NOREAD = "NOREAD              ";
  public static final String BARCODE_NOSCAN = "NoScan              ";
  public static final String BARCODE_NODATA = "Error               ";
  public static final String BARCODE_NOPAIR = "NoPair              ";
  public static final char STRIPE_CONTINUE = '+';
  public static final char STRIPE_END_OF_CHAIN = '-';
  public static final char STRIPE_NOTE_USED = ' ';
  private static final long serialVersionUID = 1L;
  protected TT13Stripe[] stripes;
  protected int byteoffset;

  public TT13() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 13;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.stripes = new TT13Stripe[8];
    for (int i = 0; i < stripes.length; ++i) {
      stripes[i] = new TT13Stripe();
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
    this.stripes = new TT13Stripe[8];
    for (int i = 0; i < stripes.length; ++i) {
      stripes[i] = new TT13Stripe();
    }
    byteoffset = 4;
    for (int i = 0; i < stripes.length; ++i) {
      byteoffset = stripes[i].fromHex(hex, byteoffset);
    }
  }

  public TT13Stripe[] getStripes() {
    return stripes;
  }

  public void setStripes(TT13Stripe[] stripes) {
    this.stripes = stripes;
  }

  public int getByteoffset() {
    return byteoffset;
  }

  public void setByteoffset(int byteoffset) {
    this.byteoffset = byteoffset;
  }
}
