/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7032 telegrams.
 *
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1376 $, $Date: 2013-07-23 14:54:34 +0200 (Di, 23 Jul 2013) $, $Author:
 *          dennis.chong $
 */
public class TT7032 extends NGKPTelegram {

  private static final long serialVersionUID = 1L;

  protected int openingNo;
  protected int x;
  protected int z;
  protected int height;

  public TT7032() {
    super();
    this.senderID = 20001;
    this.receiverID = 0;
    this.telegramType = 7032;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " openingNo=" + openingNo + ",";
    s += " x=" + x + ",";
    s += " z=" + z + ",";
    s += " height=" + height;
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
    hex = insertIntIntoHex(hex, openingNo, 2);
    hex = insertIntIntoHex(hex, x, 2);
    hex = insertIntIntoHex(hex, z, 2);
    hex = insertIntIntoHex(hex, height, 2);
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    requestID = extractIntFromHex(hex, 10, 4);
    version = extractIntFromHex(hex, 8, 2);
    openingNo = extractIntFromHex(hex, 14, 2);
    x = extractIntFromHex(hex, 16, 2);
    z = extractIntFromHex(hex, 18, 2);
    height = extractIntFromHex(hex, 20, 2);
  }

  public int getOpeningNo() {
    return openingNo;
  }

  public void setOpeningNo(int openingNo) {
    this.openingNo = openingNo;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
