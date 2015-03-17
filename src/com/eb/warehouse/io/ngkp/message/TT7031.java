/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7031 telegrams.
 * 
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1576 $, $Date: 2013-11-29 13:17:05 +0100 (Fr, 29 Nov 2013) $, $Author: dennis.chong $
 */
public class TT7031 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  public final static int ACK_NOT_USED = 0;
  public final static int ACK_OK = 1;
  public final static int ACK_TRAY_IN_USE = 2;
  public final static int ACK_INVALID_TRAY_NUMBER = 3;
  public final static int ACK_INVALID_OPENING = 4;
  public final static int ACK_LOCATION_OCCUPIED = 5;
  public final static int ACK_ACTIVE_ORDER_TOWARDS_OPENING = 6;

  protected int trayNo;
  protected String trayBarcode;
  protected byte openingNo;
  protected int acknowledge;

  public TT7031() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 7031;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
    this.trayBarcode = "000000000000000000000000000";
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " trayNo=" + trayNo + ",";
    s += " trayBarcode=" + trayBarcode + ",";
    s += " openingNo=" + openingNo + ",";
    s += " acknowledge=" + acknowledge;
    return s;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, requestID, 4);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, trayNo, 2);
    hex = insertStringIntoHex(hex, trayBarcode);
    hex = insertStringIntoHex(hex, " ");
    hex = insertIntIntoHex(hex, openingNo, 1);
    hex = insertIntIntoHex(hex, 0, 1);
    hex = insertIntIntoHex(hex, acknowledge, 2);
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    requestID = extractIntFromHex(hex, 8, 4);
    version = extractIntFromHex(hex, 12, 2);
    trayNo = extractIntFromHex(hex, 14, 2);
    trayBarcode = extractStringFromHex(hex, 16, 27);
    // res 1
    openingNo = (byte) extractIntFromHex(hex, 44, 1);
    // res 1
    acknowledge = extractIntFromHex(hex, 46, 2);
  }

  public int getTrayNo() {
    return trayNo;
  }

  public void setTrayNo(int trayNo) {
    this.trayNo = trayNo;
  }

  public String getTrayBarcode() {
    return trayBarcode;
  }

  public void setTrayBarcode(String trayBarcode) {
    this.trayBarcode = trayBarcode;
  }

  public byte getOpeningNo() {
    return openingNo;
  }

  public void setOpeningNo(byte openingNo) {
    this.openingNo = openingNo;
  }

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
  }
}
