/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1835 $, $Date: 2014-09-08 11:40:40 +0200 (Mon, 08 Sep 2014) $, $Author:
 *          dennis.chong $
 */

public class TT0839 extends NGKPTelegram {

  public static final int TOPIC_PARAMETER_REQUEST = 4;
  public static final int STATUS_REQUEST = 8302;
  public static final int PARAMETER_WRITE = 8350;
  public static final int PARAMETER_REQUEST = 8351;
  private static final long serialVersionUID = 1L;
  protected int topic;
  protected int order;
  protected int acknowledge;

  // topic 1
  protected int conveyorUnitNumber;
  protected int conveyorPosition;
  protected int defaultConveyorUnit;
  protected int defaultConveyorPosition;
  protected int transportMovementTimout;
  protected boolean[] controlFlags1;
  protected boolean[] controlFlags2;
  protected int time;
  // topic 2
  protected int pairBuilingTime;
  protected int maxAcceleration;
  protected int maxVelocity;
  // topic 3
  protected int year;
  protected int month;
  protected int day;
  protected int hours;
  protected int minutes;
  protected int seconds;
  protected int miliseconds;
  // topic 4
  protected boolean[] parameterRequest;

  protected String content;

  public TT0839() {
    super();
    senderID = 201;
    receiverID = 0;
    telegramType = 839;
    subType = 0;
    version = 0;
    topic = 0;
    order = 0;
    acknowledge = 0;
    conveyorUnitNumber = 0;
    conveyorPosition = 1;
    defaultConveyorUnit = 0;
    defaultConveyorPosition = 0;
    transportMovementTimout = 0;
    controlFlags1 = new boolean[8];
    controlFlags2 = new boolean[8];
    time = 0;
    pairBuilingTime = 0;
    maxAcceleration = 0;
    maxVelocity = 0;
    year = 0;
    month = 0;
    day = 0;
    hours = 0;
    minutes = 0;
    seconds = 0;
    miliseconds = 0;
    parameterRequest = new boolean[8];
    content = "";
  }

  public int getContentOffset() {
    return 16;
  }

  public int getContentLength() {
    return 84;
  }

  @Override
  public String fieldsToString() {
    String str = super.fieldsToString();
    str += " topic=" + topic;
    str += ", order=" + order;
    str += ", acknowledge=" + acknowledge;
    str += ", conveyorUnitNumber=" + conveyorUnitNumber;
    str += ", conveyorPosition=" + conveyorPosition;
    str += ", defaultConveyorUnit=" + defaultConveyorUnit;
    str += ", defaultConveyorPosition=" + defaultConveyorPosition;
    str += ", transportMovementTimout=" + transportMovementTimout;
    str += ", controlFlags1=" + NGKPTelegram.bitsToString(controlFlags1);
    str += ", controlFlags2=" + NGKPTelegram.bitsToString(controlFlags2);
    str += ", time=" + time;
    str += ", pairBuilingTime=" + pairBuilingTime;
    str += ", maxAcceleration=" + maxAcceleration;
    str += ", maxVelocity=" + maxVelocity;
    str += ", year=" + year;
    str += ", month=" + month;
    str += ", day=" + day;
    str += ", hours=" + hours;
    str += ", minutes=" + minutes;
    str += ", seconds=" + seconds;
    str += ", miliseconds=" + miliseconds;
    str += ", parameterRequest=" + NGKPTelegram.bitsToString(parameterRequest);
    return str;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, topic, 2);
    hex = insertIntIntoHex(hex, order, 2);
    hex = insertIntIntoHex(hex, acknowledge, 2);
    int offset = 16;
    if (topic == 1) {
      hex = insertIntIntoHex(hex, conveyorUnitNumber, 2);
      hex = insertIntIntoHex(hex, conveyorPosition, 2);
      hex = insertIntIntoHex(hex, defaultConveyorUnit, 2);
      hex = insertIntIntoHex(hex, defaultConveyorPosition, 2);
      hex = insertIntIntoHex(hex, transportMovementTimout, 2);
      hex = insertBitsIntoHex(hex, controlFlags1, 1);
      hex = insertBitsIntoHex(hex, controlFlags2, 1);
      hex = insertIntIntoHex(hex, time, 2);
      offset = 14;
    }
    if (topic == 2) {
      hex = insertIntIntoHex(hex, conveyorUnitNumber, 2);
      hex = insertBitsIntoHex(hex, controlFlags1, 1);
      hex = insertBitsIntoHex(hex, controlFlags2, 1);
      hex = insertIntIntoHex(hex, pairBuilingTime, 2);
      hex = insertIntIntoHex(hex, maxAcceleration, 2);
      hex = insertIntIntoHex(hex, maxVelocity, 2);
      offset = 10;
    }
    if (topic == 3) {
      hex = insertIntIntoHex(hex, year, 2);
      hex = insertIntIntoHex(hex, month, 2);
      hex = insertIntIntoHex(hex, day, 2);
      hex = insertIntIntoHex(hex, hours, 2);
      hex = insertIntIntoHex(hex, minutes, 2);
      hex = insertIntIntoHex(hex, seconds, 2);
      hex = insertIntIntoHex(hex, miliseconds, 2);
      offset = 14;
    }
    if (topic == 4) {
      hex = insertBitsIntoHex(hex, parameterRequest, 1);
      offset = 1;
    }
    for (int i = offset; i < getContentLength(); ++i) {
      content += "00";
    }
    return hex + content;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    version = extractIntFromHex(hex, 8, 2);
    topic = extractIntFromHex(hex, 10, 2);
    order = extractIntFromHex(hex, 12, 2);
    acknowledge = extractIntFromHex(hex, 14, 2);
    int offset = 16;
    if (topic == 1) {
      conveyorUnitNumber = extractIntFromHex(hex, offset + 0, 2);
      conveyorPosition = extractIntFromHex(hex, offset + 2, 2);
      defaultConveyorUnit = extractIntFromHex(hex, offset + 4, 2);
      defaultConveyorPosition = extractIntFromHex(hex, offset + 6, 2);
      transportMovementTimout = extractIntFromHex(hex, offset + 8, 2);
      extractBitsFromHex(hex, controlFlags1, offset + 10, 1);
      extractBitsFromHex(hex, controlFlags2, offset + 11, 1);
      time = extractIntFromHex(hex, offset + 12, 2);
    }
    if (topic == 2) {
      conveyorUnitNumber = extractIntFromHex(hex, offset + 0, 2);
      extractBitsFromHex(hex, controlFlags1, offset + 2, 1);
      extractBitsFromHex(hex, controlFlags2, offset + 3, 1);
      pairBuilingTime = extractIntFromHex(hex, offset + 4, 2);
      maxAcceleration = extractIntFromHex(hex, offset + 6, 2);
      maxVelocity = extractIntFromHex(hex, offset + 8, 2);
    }
    if (topic == 3) {
      year = extractIntFromHex(hex, offset + 0, 2);
      month = extractIntFromHex(hex, offset + 2, 2);
      day = extractIntFromHex(hex, offset + 4, 2);
      hours = extractIntFromHex(hex, offset + 6, 2);
      minutes = extractIntFromHex(hex, offset + 8, 2);
      seconds = extractIntFromHex(hex, offset + 10, 2);
      miliseconds = extractIntFromHex(hex, offset + 12, 2);
    }
    if (topic == 4) {
      extractBitsFromHex(hex, parameterRequest, offset + 0, 1);
    }
  }

  public String getSourceID() {
    return "/" + conveyorUnitNumber + "/" + conveyorPosition;
  }

  public int getAckType() {
    if (controlFlags1[0]) {
      return 1;
    } else {
      return 0;
    }
  }

  public int getTopic() {
    return topic;
  }

  public void setTopic(int topic) {
    this.topic = topic;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
  }

  public int getTransportMovementTimeout() {
    return transportMovementTimout;
  }

  public void setTransportMovementTimeout(int transportMovementTimout) {
    this.transportMovementTimout = transportMovementTimout;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public int getMaxAcceleration() {
    return maxAcceleration;
  }

  public void setMaxAcceleration(int maxAcceleration) {
    this.maxAcceleration = maxAcceleration;
  }

  public int getMaxVelocity() {
    return maxVelocity;
  }

  public void setMaxVelocity(int maxVelocity) {
    this.maxVelocity = maxVelocity;
  }

  public boolean[] getControlFlags1() {
    return controlFlags1;
  }

  public void setControlFlags1(boolean[] controlFlags1) {
    this.controlFlags1 = controlFlags1;
  }

  public boolean[] getControlFlags2() {
    return controlFlags2;
  }

  public void setControlFlags2(boolean[] controlFlags2) {
    this.controlFlags2 = controlFlags2;
  }

  public int getConveyorUnit() {
    return conveyorUnitNumber;
  }

  public void setConveyorUnit(int conveyorUnitNumber) {
    this.conveyorUnitNumber = conveyorUnitNumber;
  }

  public int getConveyorPosition() {
    return conveyorPosition;
  }

  public void setConveyorPosition(int conveyorPosition) {
    this.conveyorPosition = conveyorPosition;
  }

  public int getDefaultConveyorUnit() {
    return defaultConveyorUnit;
  }

  public void setDefaultConveyorUnit(int destinationUnitNumber) {
    defaultConveyorUnit = destinationUnitNumber;
  }

  public int getDefaultConveyorPosition() {
    return defaultConveyorPosition;
  }

  public void setDefaultConveyorPosition(int destinationPosition) {
    defaultConveyorPosition = destinationPosition;
  }

  public int getPairBuildingTime() {
    return pairBuilingTime;
  }

  public void setPairBuildingTime(int pairBuilingTime) {
    this.pairBuilingTime = pairBuilingTime;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

  public int getSeconds() {
    return seconds;
  }

  public void setSeconds(int seconds) {
    this.seconds = seconds;
  }

  public int getMiliseconds() {
    return miliseconds;
  }

  public void setMiliseconds(int miliseconds) {
    this.miliseconds = miliseconds;
  }

  public boolean[] getParameterRequest() {
    return parameterRequest;
  }

  public void setParameterRequest(boolean[] parameterRequest) {
    this.parameterRequest = parameterRequest;
  }
}
