/*
 * Copyright (c) 2013 SSI Schaefer Noell GmbH
 */

package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

public class TT141xTUBlock implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int tuType;
  protected String tuId;
  protected boolean[] tuTypeFlags1;
  protected boolean[] tuTypeFlags2;
  protected int length;
  protected int width;
  protected int height;
  protected int weight;
  protected boolean[] errorFlags1;
  protected boolean[] errorFlags2;

  public TT141xTUBlock() {
    super();
    this.tuType = 0;
    this.tuId = "                    ";
    this.length = 1;
    this.width = 1;
    this.height = 1;
    this.weight = 1;
    this.tuTypeFlags1 = new boolean[8];
    this.tuTypeFlags2 = new boolean[8];
    this.errorFlags1 = new boolean[8];
    this.errorFlags2 = new boolean[8];
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" + fieldsToString(0, 0) + "]";
  }

  public String fieldsToString(int mainindex, int index) {
    return " tuType[" + mainindex + "," + index + "]=" + tuType + "," + " tuId[" + mainindex + "," + index + "]=" + tuId + "," + " length[" + mainindex + "," + index + "]=" + length + "," + " width[" + mainindex + "," + index + "]=" + width + "," + " height[" + mainindex + "," + index + "]=" + height + "," + " weight[" + mainindex + "," + index + "]=" + weight + "," + " tuTypeFlags1[" + mainindex + "," + index + "]=" + NGKPTelegram.bitsToString(tuTypeFlags1) + "," + " tuTypeFlags2[" + mainindex + "," + index + "]=" + NGKPTelegram.bitsToString(tuTypeFlags2) + "," + " errorFlags1[" + mainindex + "," + index + "]=" + NGKPTelegram.bitsToString(errorFlags1) + "," + " errorFlags2[" + mainindex + "," + index + "]=" + NGKPTelegram.bitsToString(errorFlags2) + ",";
  }

  public String toHex() {
    String str = "";
    str = NGKPTelegram.insertIntIntoHex(str, tuType, 2);
    str = NGKPTelegram.insertBitsIntoHex(str, tuTypeFlags1, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, tuTypeFlags2, 1);
    str = NGKPTelegram.insertIntIntoHex(str, length, 2);
    str = NGKPTelegram.insertIntIntoHex(str, width, 2);
    str = NGKPTelegram.insertIntIntoHex(str, height, 2);
    str = NGKPTelegram.insertIntIntoHex(str, weight, 2);
    str = NGKPTelegram.insertBitsIntoHex(str, errorFlags1, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, errorFlags2, 1);
    str = NGKPTelegram.insertStringIntoHex(str, tuId);
    return str;
  }

  public int fromHex(String hex, int byteoffset) {
    tuType = NGKPTelegram.extractIntFromHex(hex, byteoffset + 0, 2);
    NGKPTelegram.extractBitsFromHex(hex, tuTypeFlags1, byteoffset + 2, 1);
    NGKPTelegram.extractBitsFromHex(hex, tuTypeFlags2, byteoffset + 3, 1);
    length = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 2);
    width = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 2);
    height = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 2);
    weight = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 2);
    NGKPTelegram.extractBitsFromHex(hex, errorFlags1, byteoffset + 12, 1);
    NGKPTelegram.extractBitsFromHex(hex, errorFlags2, byteoffset + 13, 1);
    tuId = NGKPTelegram.extractStringFromHex(hex, byteoffset + 14, 20);
    return byteoffset + 34;
  }

  public int getTuType() {
    return tuType;
  }

  public void setTuType(int tuType) {
    this.tuType = tuType;
  }

  public String getTuId() {
    return tuId;
  }

  public void setTuId(String tuId) {
    this.tuId = tuId;
  }

  public boolean[] getTuTypeFlags1() {
    return tuTypeFlags1;
  }

  public void setTuTypeFlags1(boolean[] tuTypeFlags1) {
    this.tuTypeFlags1 = tuTypeFlags1;
  }

  public boolean[] getTuTypeFlags2() {
    return tuTypeFlags2;
  }

  public void setTuTypeFlags2(boolean[] tuTypeFlags2) {
    this.tuTypeFlags2 = tuTypeFlags2;
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
}
