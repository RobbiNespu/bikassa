/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7030 telegrams.
 *
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1376 $, $Date: 2013-07-23 14:54:34 +0200 (Di, 23 Jul 2013) $, $Author:
 *          dennis.chong $
 */
public class TT7030 extends NGKPTelegram {

  public final static byte REQUEST_STATUS = 1;
  public final static byte REQUEST_STOCK_IMAGE = 2;
  public final static byte REQUEST_RACK_IMAGE = 3;
  public final static byte REQUEST_ERRORS = 4;
  private static final long serialVersionUID = 1L;
  protected byte requestType;

  public TT7030() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 7030;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " requestType=" + requestType;
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
    hex = insertIntIntoHex(hex, requestType, 1);
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
    requestType = (byte) extractIntFromHex(hex, 14, 1);
  }

  public byte getRequestType() {
    return requestType;
  }

  public void setRequestType(byte requestType) {
    this.requestType = requestType;
  }
}
