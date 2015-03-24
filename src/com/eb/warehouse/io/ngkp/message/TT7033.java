/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: /home/cvs/data1/ExternalProjects/WalMartLaurens/ImplementationSimulation/WmlauSimulation/src/java/impl/com/ssn/simulation/telegrams/ngkp/TT13.java,v 1.1 2011/12/02 08:36:30 cdraeger Exp $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the telegram class to represent TT7033 telegrams.
 *
 * @author <a href="mailto:fluture.cristian@ssi-schaefer.ro">fluture.cristian</a>
 * @version $Revision: 1376 $, $Date: 2013-07-23 14:54:34 +0200 (Di, 23 Jul 2013) $, $Author:
 *          dennis.chong $
 */
public class TT7033 extends NGKPTelegram {

  public final static int COMMAND_LIGHT = 11;
  public final static int COMMAND_STUB = 12;
  public final static int COMMAND_SAFE = 13;
  public final static int COMMAND_DELETE_ORDERS = 14;
  public final static int COMMAND_ALARM_ACK = 15;
  public final static int COMMAND_DELETE_TRAY = 16;
  public final static int COMMAND_SPEED_LIMIT = 17;
  public final static int COMMAND_REORGANIZATION = 18;
  public final static int COMMAND_AUTOMATIC_MODE = 19;
  public final static int COMMAND_LIGHT_MODE = 20;
  public final static int COMMAND_LIGHT_TIMEOUT = 21;
  public final static int COMMAND_INNER_DOOR_CLOSE = 22;
  public final static int COMMAND_LIFT_POSITION = 23;
  public final static int COMMAND_POP_UP = 24;
  public final static int COMMAND_RESET_TRAY_COUNTER = 25;
  public final static int COMMAND_CONFIRMATION_BUTTON = 101;
  public final static int VALUE_OFF = 0;
  public final static int VALUE_ON = 1;
  public final static int LIGHT_MODE_ON = 1;
  public final static int LIGHT_MODE_AUTO_OFF = 2;
  public final static int LIGHT_MODE_WAMAS = 3;
  private static final long serialVersionUID = 1L;
  protected int openingNo;
  protected int command;
  protected int value;

  public TT7033() {
    super();
    this.senderID = 201;
    this.receiverID = 0;
    this.telegramType = 7033;
    this.subType = 0;
    this.version = 0;
    this.requestID = 0;
    this.producerID = 0;
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " openingNo=" + openingNo + ",";
    s += " command=" + command + ",";
    s += " value=" + value;
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
    hex = insertIntIntoHex(hex, command, 2);
    hex = insertIntIntoHex(hex, value, 2);
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
    openingNo = extractIntFromHex(hex, 14, 2);
    command = extractIntFromHex(hex, 16, 2);
    value = extractIntFromHex(hex, 18, 2);
  }

  public int getOpeningNo() {
    return openingNo;
  }

  public void setOpeningNo(int openingNo) {
    this.openingNo = openingNo;
  }

  public int getCommand() {
    return command;
  }

  public void setCommand(int command) {
    this.command = command;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
