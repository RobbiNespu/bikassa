/*
 * Copyright (c) 2013 SSI Schaefer Noell GmbH
 */

package com.eb.warehouse.io.ngkp.message;

import static com.eb.warehouse.io.ngkp.BytesToInt.shortFromBytes;

import com.google.common.base.Charsets;

public abstract class TT141x extends NGKPTelegram {

  static void intoTUBlock(byte[] bytes, int offset, TT141xTUBlock tuBlock) {
    tuBlock.setTuType(shortFromBytes(bytes[offset], bytes[offset + 1]));
    // TODO: add type flags
    tuBlock.setLength(shortFromBytes(bytes[offset + 4], bytes[offset + 5]));
    tuBlock.setWidth(shortFromBytes(bytes[offset + 6], bytes[offset + 7]));
    tuBlock.setHeight(shortFromBytes(bytes[offset + 8], bytes[offset + 9]));
    tuBlock.setWeight(shortFromBytes(bytes[offset + 10], bytes[offset + 11]));
    // TODO: add error flags
    tuBlock.setTuId(new String(bytes, offset + 12, 20, Charsets.US_ASCII));
  }

  static void intoTOBlock(byte[] bytes, int offset, TT141xTOBlock toBlock) {
    toBlock.setAisle(shortFromBytes(bytes[offset], bytes[offset + 1]));
    toBlock.setX(shortFromBytes(bytes[offset + 2], bytes[offset + 3]));
    toBlock.setY(shortFromBytes(bytes[offset + 4], bytes[offset + 5]));
    toBlock.setSide(shortFromBytes(bytes[offset + 6], bytes[offset + 7]));
    toBlock.setDepth(shortFromBytes(bytes[offset + 8], bytes[offset + 9]));
    toBlock.setSrm(shortFromBytes(bytes[offset + 10], bytes[offset + 11]));
    toBlock.setLsd(shortFromBytes(bytes[offset + 12], bytes[offset + 13]));
    toBlock.setPlace(shortFromBytes(bytes[offset + 14], bytes[offset + 15]));
    toBlock.setTuAmount(shortFromBytes(bytes[offset + 16], bytes[offset + 17]));
    toBlock.setOrder(shortFromBytes(bytes[offset + 18], bytes[offset + 19]));
    // TODO: add orderExtensions
    toBlock.setAcknowledge(shortFromBytes(bytes[offset + 22], bytes[offset + 23]));
    // TODO: add ackExtensions
  }

  private static final long serialVersionUID = 1L;

  public static final int GET_ORDER = 14011;
  public static final int PUT_ORDER = 14021;
  public static final int FOLLOW_UP_GET_ORDER = 14012;
  public static final int FOLLOW_UP_PUT_ORDER = 14022;
  public static final int COMPLETION = 14001;
  public static final int VOID_ORDER = 14000;
  public static final int EMPTY_ORDER = 0;
  public static final int FO_EXPECTED = 14281;
  public static final int TO_EXPECTED = 14282;
  public static final int FORK_EMPTY = 14271;
  public static final int FORK_NOT_ENOUGH_TUS = 14272;
  public static final int FORK_TOO_MUCH_TUS = 14273;
  public static final int TU_ID_MISMATCH = 14253;
  public static final int TU_TYPE_MISMATCH = 14254;
  public static final int MISSING_STORAGE_SIGNAL = 14231;
  public static final int MISSING_RETRIEVAL_SIGNAL = 14232;
  public static final int GENERAL_PLAUSIBILITY_ERROR = 14160;
  public static final int SUBTYPE_ERROR = 14103;
  public static final int VERSION_ERROR = 14104;
  public static final int LENGTH_ERROR = 14144;
  public static final int WIDTH_ERROR = 14145;
  public static final int HEIGHT_ERROR = 14146;
  public static final int WEIGHT_ERROR = 14147;
  public static final int POSITIONING_ORDER = 14031;
  public static final int FOLLOW_UP_POSITIONING_ORDER = 14032;
  public static final int FORK_CLEARANCE_ORDER = 14023;
  public static final int RACK_CLEARANCE_ORDER = 14013;
  public static final int WRONG_AISLE_NUMBER = 14121;
  public static final int WRONG_X_COORDINATE = 14122;
  public static final int WRONG_Y_COORDINATE = 14123;
  public static final int WRONG_SIDE_COORDINATE = 14124;
  public static final int WRONG_DEPTH_COORDINATE = 14125;
  public static final int WRONG_SRM_NUMBER = 14126;
  public static final int WRONG_FORK_NUMBER = 14127;
  public static final int WRONG_PLACE_NUMBER = 14128;
  public static final int WRONG_TU_AMOUNT = 14129;
  public static final int WRONG_ORDER_CODE = 14130;
  public static final int MANUAL_INTERVENTION = 14092;
  public static final int RACK_LOCATION_OCCUPIED = 14211;
  public static final int RACK_LOCATION_EMPTY = 14212;
  public static final int RACK_LOCATION_IN_BLOCKED_AREA = 14161;

  protected TT141xTOBlock[] toBlocks;

  public TT141x() {
    super();
  }

  /**
   * Returns the number of TO blocks of the telegram.
   * 
   * @return the number of TO blocks
   */
  public abstract int getNumberOfTOBlocks();

  /**
   * Returns the number of TO blocks per TO blocks of the telegram.
   * 
   * @return the number of TO blocks per TO blocks
   */
  public abstract int getNumberOfTUBlocks();

  public TT141xTOBlock[] getToBlocks() {
    return toBlocks;
  }

  public void setToBlocks(TT141xTOBlock[] lsdBlocks) {
    toBlocks = lsdBlocks;
  }
}
