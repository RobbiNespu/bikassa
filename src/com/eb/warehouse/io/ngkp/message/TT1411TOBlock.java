/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Simple class to represent a load storage device block of the TT1411 telegram.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author: dennis.chong $
 */
public class TT1411TOBlock extends TT141xTOBlock {
  private static final long serialVersionUID = 1L;

  public TT1411TOBlock() {
    this(null);
  }

  public TT1411TOBlock(TT141x parent) {
    super(parent);
    int tuCount = 1;
    if (parent != null) {
      tuCount = parent.getNumberOfTUBlocks();
    }
    this.tuBlocks = new TT1411TUBlock[tuCount];
    for (int i = 0; i < tuBlocks.length; ++i) {
      tuBlocks[i] = new TT1411TUBlock();
    }
  }

  @Override
  public String fieldsToString(int index) {
    String s = " order[" + index + "]=" + order + "," + " acknowledge[" + index + "]=" + acknowledge + "," + " tuAmount[" + index + "]=" + tuAmount + "," + " orderExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions1) + "," + " orderExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(orderExtensions2) + "," + " acknowledgeExtensions1[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions1) + "," + " acknowledgeExtensions2[" + index + "]=" + NGKPTelegram.bitsToString(acknowledgeExtensions2) + "," + " aisle[" + index + "]=" + aisle + "," + " x[" + index + "]=" + x + "," + " y[" + index + "]=" + y + "," + " side[" + index + "]=" + side + "," + " depth[" + index + "]=" + depth + "," + " srm[" + index + "]=" + srm + "," + " lsd[" + index + "]=" + lsd + "," + " place[" + index + "]=" + place + ",";
    for (int i = 0; i < tuBlocks.length; ++i) {
      s += tuBlocks[i].fieldsToString(index, i + 1);
    }
    return s;
  }

  @Override
  public String toHex() {
    String str = "";
    str = NGKPTelegram.insertIntIntoHex(str, aisle, 2);
    str = NGKPTelegram.insertIntIntoHex(str, x, 2);
    str = NGKPTelegram.insertIntIntoHex(str, y, 2);
    str = NGKPTelegram.insertIntIntoHex(str, side, 2);
    str = NGKPTelegram.insertIntIntoHex(str, depth, 2);
    str = NGKPTelegram.insertIntIntoHex(str, srm, 2);
    str = NGKPTelegram.insertIntIntoHex(str, lsd, 2);
    str = NGKPTelegram.insertIntIntoHex(str, place, 2);
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
    x = NGKPTelegram.extractIntFromHex(hex, byteoffset + 2, 2);
    y = NGKPTelegram.extractIntFromHex(hex, byteoffset + 4, 2);
    side = NGKPTelegram.extractIntFromHex(hex, byteoffset + 6, 2);
    depth = NGKPTelegram.extractIntFromHex(hex, byteoffset + 8, 2);
    srm = NGKPTelegram.extractIntFromHex(hex, byteoffset + 10, 2);
    lsd = NGKPTelegram.extractIntFromHex(hex, byteoffset + 12, 2);
    place = NGKPTelegram.extractIntFromHex(hex, byteoffset + 14, 2);
    tuAmount = NGKPTelegram.extractIntFromHex(hex, byteoffset + 16, 2);
    order = NGKPTelegram.extractIntFromHex(hex, byteoffset + 18, 2);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions1, byteoffset + 20, 1);
    NGKPTelegram.extractBitsFromHex(hex, orderExtensions2, byteoffset + 21, 1);
    acknowledge = NGKPTelegram.extractIntFromHex(hex, byteoffset + 22, 2);
    NGKPTelegram.extractBitsFromHex(hex, acknowledgeExtensions1, byteoffset + 24, 1);
    NGKPTelegram.extractBitsFromHex(hex, acknowledgeExtensions2, byteoffset + 25, 1);
    byteoffset += 26;
    for (int i = 0; i < tuBlocks.length; ++i) {
      byteoffset = tuBlocks[i].fromHex(hex, byteoffset);
    }
    return byteoffset;
  }
}