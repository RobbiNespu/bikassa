/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Abstract extension of the telegram class to represent TT1611 telegrams.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author:
 *          dennis.chong $
 */
public abstract class TT1611 extends NGKPTelegram {

  public static final int TRANSPORT_ORDER = 16002;
  public static final int TRANSPORT_ORDER_LOW_PRIORITY = 16001;
  public static final int TRANSPORT_ORDER_HIGH_PRIORITY = 16003;
  public static final int TRANSPORT_ORDER_FOLLOW_UP = 16004;
  public static final int TRANSPORT_ORDER_UPDATE = 16012;
  public static final int COMPLETION = 16001;
  public static final int INFO = 16021;
  public static final int STORAGE_SIGNAL_MISSING = 16231;
  public static final int RETRIEVAL_SIGNAL_MISSING = 16232;
  public static final int TRANSPORT_ORDER_ALREADY_PENDING = 16201;
  public static final int FORK_EMPTY = 16271;
  public static final int SOURCE_OR_DESTINATION_MISUSED = 16171;
  private static final long serialVersionUID = 1L;
  protected int movementOptions;
  protected TT1611TOBlock[] toBlocks;
  protected int bitoffset;

  public TT1611() {
    super();
    this.telegramType = 1611;
    this.version = 1;
    this.subType = 0;
    this.toBlocks = new TT1611TOBlock[getNumberOfTOBlocks()];
    for (int i = 0; i < toBlocks.length; ++i) {
      toBlocks[i] = new TT1611TOBlock(getNumberOfTUBlocks());
    }
  }

  public abstract int getNumberOfTOBlocks();

  public abstract int getNumberOfTUBlocks();

  public TT1611TOBlock getFirstBlock() {
    return toBlocks[0];
  }

  public String getSourceID() {
    return getFirstBlock().getSourceID();
  }

  public String getDestinationID() {
    return getFirstBlock().getDestinationID();
  }

  public String getLastNoticeID() {
    return getFirstBlock().getLastNoticeID();
  }

  @Override
  public String fieldsToString() {
    String s = super.fieldsToString();
    s += " movementOptions=" + movementOptions + ",";
    for (int i = 0; i < toBlocks.length; ++i) {
      s += toBlocks[i].fieldsToString(i + 1);
    }
    return s;
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = str.substring(0, str.length() - 4);
    str = insertIntIntoHex(str, movementOptions, 2);
    for (int i = 0; i < toBlocks.length; ++i) {
      str = str + toBlocks[i].toHex();
    }
    return str;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    toBlocks = new TT1611TOBlock[getNumberOfTOBlocks()];
    for (int i = 0; i < toBlocks.length; ++i) {
      toBlocks[i] = new TT1611TOBlock(getNumberOfTUBlocks());
    }
    producerID = 0;
    movementOptions = extractIntFromHex(hex, 14, 2);
    bitoffset = 16;
    for (int i = 0; i < toBlocks.length; ++i) {
      bitoffset = toBlocks[i].fromHex(hex, bitoffset);
    }
  }

  public int getMovementOptions() {
    return movementOptions;
  }

  public void setMovementOptions(int movementOptions) {
    this.movementOptions = movementOptions;
  }

  public TT1611TOBlock[] getToBlocks() {
    return toBlocks;
  }

  public void setToBlocks(TT1611TOBlock[] toBlocks) {
    this.toBlocks = toBlocks;
  }
}
