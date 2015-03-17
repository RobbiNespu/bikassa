/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT30.java,v 1.2 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT30 telegrams.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */
public class TT30 extends NGKPTelegram {
  public static final int CONTENTOFFSET = 10;
  private static final long serialVersionUID = 1L;
  protected int reserve;
  protected int area;
  protected int actionReserve;
  protected boolean[] actions;
  protected String content;
  protected boolean normalize;

  public TT30() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 30;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.reserve = 0;
    this.area = 0;
    this.actions = new boolean[8];
    this.actionReserve = 0;
    this.content = "";
  }

  @Override
  public String fieldsToString() {
    String s = "senderID=" + senderID + ",";
    s += " receiverID=" + receiverID + ",";
    s += " telegramType=" + telegramType + ",";
    s += " producerID=" + producerID + ",";
    s += " reserve=" + reserve + ",";
    s += " area=" + area + ",";
    s += " actionReserve=" + actionReserve + ",";
    s += " area=" + bitsToString(actions) + ",";
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
    hex = insertIntIntoHex(hex, actionReserve, 1);
    hex = insertBitsIntoHex(hex, actions, 1);
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
    actionReserve = extractIntFromHex(hex, 8, 1);
    extractBitsFromHex(hex, actions, 9, 1);
    content = hex.substring(2 * CONTENTOFFSET, hex.length());
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

  public boolean[] getActions() {
    return actions;
  }

  public void setActions(boolean[] actions) {
    this.actions = actions;
  }

  public int getActionReserve() {
    return actionReserve;
  }

  public void setActionReserve(int actionReserve) {
    this.actionReserve = actionReserve;
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

  public int getContentByteAsInt(int number) {
    return extractIntFromHex(content, number - CONTENTOFFSET, 1);
  }

  public boolean[] getContentByteAsBitField(int number) {
    final boolean[] result = new boolean[8];
    extractBitsFromHex(content, result, number - CONTENTOFFSET, 1);
    return result;
  }

  public void setContentByteFromBitField(int number, boolean[] bits) {
    final String statusByte = insertBitsIntoHex("", bits, 1);
    StringBuilder sb = new StringBuilder(content);

    for (int i = 0; i < statusByte.length(); i++) {
      final int index = i % 2 == 0 ? 2 * (number + i) : 2 * (number + i - 1) + 1;
      sb.setCharAt(index, statusByte.charAt(i));
    }
    content = sb.toString();
  }
}
