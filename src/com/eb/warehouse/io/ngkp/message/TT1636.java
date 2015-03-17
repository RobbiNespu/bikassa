/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Abstract extension of the telegram class to represent TT1411 telegrams.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */
public abstract class TT1636 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  protected int topic;
  protected int statusRequestID;
  // topic 1
  protected int emsNumber;
  protected boolean[] controlStatus1;
  protected boolean[] controlStatus2;
  protected int toAmmount;
  // only topic 2
  protected int area;
  protected int location;
  protected int place;
  protected int vehicleNumber;
  protected int vehicleLSD;
  protected int vehiclePlace;
  protected boolean[] vehcileStatus1;
  protected boolean[] vehcileStatus2;
  protected boolean[] lsdStatus1;
  protected boolean[] lsdStatus2;
  protected boolean[] lsdStatus3;
  protected boolean[] lsdStatus4;
  protected int requestID1;
  protected int requestID2;
  protected int requestID3;
  protected int requestID4;
  // only topic 3
  protected int type;
  protected boolean[] typeFlags1;
  protected boolean[] typeFlags2;
  protected int length;
  protected int width;
  protected int height;
  protected int weight;
  protected boolean[] errorFlags1;
  protected boolean[] errorFlags2;
  protected String id;

  public TT1636() {
    super();
    this.telegramType = 1636;
    this.version = 0;
    this.subType = 0;
    this.topic = 0;
    this.statusRequestID = 0;
    this.emsNumber = 0;
    this.controlStatus1 = new boolean[8];
    this.controlStatus2 = new boolean[8];
    this.toAmmount = 0;
    this.area = 0;
    this.location = 0;
    this.place = 0;
    this.vehicleNumber = 0;
    this.vehicleLSD = 0;
    this.vehiclePlace = 0;
    this.vehcileStatus1 = new boolean[8];
    this.vehcileStatus2 = new boolean[8];
    this.lsdStatus1 = new boolean[8];
    this.lsdStatus2 = new boolean[8];
    this.lsdStatus3 = new boolean[8];
    this.lsdStatus4 = new boolean[8];
    this.requestID1 = 0;
    this.requestID2 = 0;
    this.requestID3 = 0;
    this.requestID4 = 0;
    this.type = 0;
    this.typeFlags1 = new boolean[8];
    this.typeFlags2 = new boolean[8];
    this.length = 0;
    this.width = 0;
    this.height = 0;
    this.weight = 0;
    this.errorFlags1 = new boolean[8];
    this.errorFlags2 = new boolean[8];
    this.id = "                    ";
  }

  public abstract int totalBytes();

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

  public int getEmsNumber() {
    return emsNumber;
  }

  public void setEmsNumber(int emsNumber) {
    this.emsNumber = emsNumber;
  }

  public boolean[] getControlStatus1() {
    return controlStatus1;
  }

  public void setControlStatus1(boolean[] controlStatus1) {
    this.controlStatus1 = controlStatus1;
  }

  public boolean[] getControlStatus2() {
    return controlStatus2;
  }

  public void setControlStatus2(boolean[] controlStatus2) {
    this.controlStatus2 = controlStatus2;
  }

  public int getToAmmount() {
    return toAmmount;
  }

  public void setToAmmount(int toAmmount) {
    this.toAmmount = toAmmount;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public int getLocation() {
    return location;
  }

  public void setLocation(int location) {
    this.location = location;
  }

  public int getPlace() {
    return place;
  }

  public void setPlace(int place) {
    this.place = place;
  }

  public int getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(int vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public int getVehicleLSD() {
    return vehicleLSD;
  }

  public void setVehicleLSD(int vehicleLSD) {
    this.vehicleLSD = vehicleLSD;
  }

  public int getVehiclePlace() {
    return vehiclePlace;
  }

  public void setVehiclePlace(int vehiclePlace) {
    this.vehiclePlace = vehiclePlace;
  }

  public boolean[] getVehcileStatus1() {
    return vehcileStatus1;
  }

  public void setVehcileStatus1(boolean[] vehcileStatus1) {
    this.vehcileStatus1 = vehcileStatus1;
  }

  public boolean[] getVehcileStatus2() {
    return vehcileStatus2;
  }

  public void setVehcileStatus2(boolean[] vehcileStatus2) {
    this.vehcileStatus2 = vehcileStatus2;
  }

  public boolean[] getLsdStatus1() {
    return lsdStatus1;
  }

  public void setLsdStatus1(boolean[] lsdStatus1) {
    this.lsdStatus1 = lsdStatus1;
  }

  public boolean[] getLsdStatus2() {
    return lsdStatus2;
  }

  public void setLsdStatus2(boolean[] lsdStatus2) {
    this.lsdStatus2 = lsdStatus2;
  }

  public boolean[] getLsdStatus3() {
    return lsdStatus3;
  }

  public void setLsdStatus3(boolean[] lsdStatus3) {
    this.lsdStatus3 = lsdStatus3;
  }

  public boolean[] getLsdStatus4() {
    return lsdStatus4;
  }

  public void setLsdStatus4(boolean[] lsdStatus4) {
    this.lsdStatus4 = lsdStatus4;
  }

  public int getRequestID1() {
    return requestID1;
  }

  public void setRequestID1(int requestID1) {
    this.requestID1 = requestID1;
  }

  public int getRequestID2() {
    return requestID2;
  }

  public void setRequestID2(int requestID2) {
    this.requestID2 = requestID2;
  }

  public int getRequestID3() {
    return requestID3;
  }

  public void setRequestID3(int requestID3) {
    this.requestID3 = requestID3;
  }

  public int getRequestID4() {
    return requestID4;
  }

  public void setRequestID4(int requestID4) {
    this.requestID4 = requestID4;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public boolean[] getTypeFlags1() {
    return typeFlags1;
  }

  public void setTypeFlags1(boolean[] typeFlags1) {
    this.typeFlags1 = typeFlags1;
  }

  public boolean[] getTypeFlags2() {
    return typeFlags2;
  }

  public void setTypeFlags2(boolean[] typeFlags2) {
    this.typeFlags2 = typeFlags2;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public boolean[] getErrorFlags1() {
    return errorFlags1;
  }

  public void setErrorFlags1(boolean[] errorFlags1) {
    this.errorFlags1 = errorFlags1;
  }

  public boolean[] getErrorFlags2() {
    return errorFlags2;
  }

  public void setErrorFlags2(boolean[] errorFlags2) {
    this.errorFlags2 = errorFlags2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
