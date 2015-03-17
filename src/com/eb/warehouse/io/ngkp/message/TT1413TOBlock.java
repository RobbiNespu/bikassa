/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1484 $, $Date: 2013-09-12 16:40:43 +0200 (Do, 12 Sep 2013) $, $Author: dennis.chong $
 */

public class TT1413TOBlock extends TT141xTOBlock {
  private static final long serialVersionUID = 1L;

  protected int fingerActivation;
  protected int reserve;

  public TT1413TOBlock() {
    this(null);
  }

  public TT1413TOBlock(TT141x parent) {
    super(parent);
    this.fingerActivation = 0;
    this.reserve = 0;
    int tuCount = 1;
    if (parent != null) {
      tuCount = parent.getNumberOfTUBlocks();
    }
    this.tuBlocks = new TT1413TUBlock[tuCount];
    for (int i = 0; i < tuBlocks.length; ++i) {
      tuBlocks[i] = new TT1413TUBlock();
    }
  }

  @Override
  public String fieldsToString(int index) {
    String s = " order[" + index + "]=" + order + "," + " acknowledge[" + index + "]=" + acknowledge + "," + " tuAmount[" + index + "]=" + tuAmount + "," + " orderExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions1) + "," + " orderExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions2) + "," + " acknowledgeExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions1) + "," + " acknowledgeExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions2) + "," + " aisle[" + index + "]=" + aisle + "," + " x[" + index + "]=" + x + "," + " y[" + index + "]=" + y + "," + " side[" + index + "]=" + side + "," + " depth[" + index + "]=" + depth + "," + " srm[" + index + "]=" + srm + "," + " lsd[" + index + "]=" + lsd + "," + " place[" + index + "]=" + place + "," + " fingerActivation[" + index + "]=" + fingerActivation + " reserve[" + index + "]=" + reserve + ",";
    for (int i = 0; i < tuBlocks.length; ++i) {
      s += tuBlocks[i].fieldsToString(index, i + 1);
    }
    return s;
  }

  @Override
  public String toHex() {
    String str = "";
    str = NGKPTelegram.insertIntIntoHex(str, aisle, 2);
    if (parent != null && parent.getVersion() == 1) {
      str = NGKPTelegram.insertIntIntoHex(str, x, 2);
    }
    if (parent != null && parent.getVersion() == 2) {
      str = NGKPTelegram.insertIntIntoHex(str, x, 4);
    }
    str = NGKPTelegram.insertIntIntoHex(str, y, 2);
    str = NGKPTelegram.insertIntIntoHex(str, side, 2);
    str = NGKPTelegram.insertIntIntoHex(str, depth, 2);
    str = NGKPTelegram.insertIntIntoHex(str, srm, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lsd, 2);
    str = NGKPTelegram.insertIntIntoHex(str, place, 2);
    str = NGKPTelegram.insertIntIntoHex(str, fingerActivation, 2);
    str = NGKPTelegram.insertIntIntoHex(str, reserve, 2);
    str = NGKPTelegram.insertIntIntoHex(str, tuAmount, 2);
    str = NGKPTelegram.insertIntIntoHex(str, order, 2);
    str = NGKPTelegram.insertBitsIntoHex(str, orderExtensions1, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, orderExtensions2, 1);
    str = NGKPTelegram.insertIntIntoHex(str, acknowledge, 2);
    str = NGKPTelegram.insertBitsIntoHex(str, acknowledgeExtensions1, 1);
    str = NGKPTelegram.insertBitsIntoHex(str, acknowledgeExtensions2, 1);
    for (int j = 0; j < tuBlocks.length; ++j) {
      str = str + tuBlocks[j].toHex();
    }
    return str;
  }

  @Override
  public int fromHex(String hex, int byteoffset) {
    aisle = NGKPTelegram.extractIntFromHex(hex, byteoffset + 0, 2);
    if (parent != null && parent.getVersion() == 1) {
      x = NGKPTelegram.extractIntFromHex(hex, byteoffset + 2, 2);
    }
    if (parent != null && parent.getVersion() == 2) {
      x = NGKPTelegram.extractIntFromHex(hex, byteoffset + 2, 4);
      byteoffset += 2;
    }
    y = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 2);
    side = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 2);
    depth = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 2);
    srm = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 2);
    lsd = NGKPTelegram.extractIntFromHex(hex, byteoffset + 12, 2);
    place = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 2);
    fingerActivation = NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 2);
    reserve = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 2);
    tuAmount = NGKPTelegram.extractIntFromHex(hex, byteoffset + 20, 2);
    order = NGKPTelegram.extractIntFromHex(hex, byteoffset + 22, 2);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions1, byteoffset + 24, 1);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions2, byteoffset + 25, 1);
    acknowledge = NGKPTelegram.extractIntFromHex(hex, byteoffset + 26, 2);
    NGKPTelegram.extractBitsFromHex(hex, acknowledgeExtensions1, byteoffset + 28, 1);
    NGKPTelegram.extractBitsFromHex(hex, acknowledgeExtensions2, byteoffset + 29, 1);
    byteoffset += 30;
    for (int i = 0; i < tuBlocks.length; ++i) {
      byteoffset = tuBlocks[i].fromHex(hex, byteoffset);
    }
    return byteoffset;
  }

  public int getFingerActivation() {
    return fingerActivation;
  }

  public void setFingerActivation(int fingerActivation) {
    this.fingerActivation = fingerActivation;
  }

  public int getReserve() {
    return reserve;
  }

  public void setReserve(int reserve) {
    this.reserve = reserve;
  }
}
