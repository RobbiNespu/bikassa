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

public abstract class TT1413 extends TT141x {
  private static final long serialVersionUID = 1L;

  protected int movementOptions1;
  protected int xRate;
  protected int yRate;
  protected int zRate;
  protected int reserve;
  protected int byteoffset;

  public TT1413() {
    super();
    this.telegramType = 1413;
    this.version = 1;
    this.subType = 0;
    this.toBlocks = new TT1413TOBlock[getNumberOfTOBlocks()];
    for (int i = 0; i < toBlocks.length; ++i) {
      toBlocks[i] = new TT1413TOBlock(this);
    }
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " movementOptions1=" + movementOptions1 + ",";
    s += " xRate=" + xRate + ",";
    s += " yRate=" + yRate + ",";
    s += " zRate=" + zRate + ",";
    s += " reserve=" + reserve + ",";
    for (int i = 0; i < toBlocks.length; ++i) {
      s += toBlocks[i].fieldsToString(i + 1);
    }
    return s;
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = str.substring(0, str.length() - 4);
    str = insertIntIntoHex(str, movementOptions1, 2);
    str = insertIntIntoHex(str, xRate, 2);
    str = insertIntIntoHex(str, yRate, 2);
    str = insertIntIntoHex(str, zRate, 2);
    str = insertIntIntoHex(str, reserve, 2);
    for (int i = 0; i < toBlocks.length; ++i) {
      str = str + toBlocks[i].toHex();
    }
    return str;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    toBlocks = new TT1413TOBlock[getNumberOfTOBlocks()];
    for (int i = 0; i < toBlocks.length; ++i) {
      toBlocks[i] = new TT1413TOBlock(this);
    }
    producerID = 0;
    movementOptions1 = extractIntFromHex(hex, 14, 2);
    xRate = extractIntFromHex(hex, 16, 2);
    yRate = extractIntFromHex(hex, 18, 2);
    zRate = extractIntFromHex(hex, 20, 2);
    reserve = extractIntFromHex(hex, 22, 2);
    byteoffset = 24;
    for (int i = 0; i < toBlocks.length; ++i) {
      byteoffset = toBlocks[i].fromHex(hex, byteoffset);
    }
  }

  public static TT1413 createTelegramBySubtype(int subtype) {
    if (subtype == 1020) {
      return new TT1413Subtype1020();
    }
    if (subtype == 2020) {
      return new TT1413Subtype2020();
    }
    return null;
  }

  public int getMovementOptions1() {
    return movementOptions1;
  }

  public void setMovementOptions1(int movementOptions1) {
    this.movementOptions1 = movementOptions1;
  }

  public int getxRate() {
    return xRate;
  }

  public void setxRate(int xRate) {
    this.xRate = xRate;
  }

  public int getyRate() {
    return yRate;
  }

  public void setyRate(int yRate) {
    this.yRate = yRate;
  }

  public int getzRate() {
    return zRate;
  }

  public void setzRate(int zRate) {
    this.zRate = zRate;
  }

  public int getReserve() {
    return reserve;
  }

  public void setReserve(int reserve) {
    this.reserve = reserve;
  }
}
