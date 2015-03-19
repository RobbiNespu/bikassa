package com.eb.warehouse.io.ngkp.message;

import static com.eb.warehouse.io.ngkp.BytesToInt.*;

/**
 * Abstract extension of the telegram class to represent TT1411 telegrams.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1484 $, $Date: 2013-09-12 16:40:43 +0200 (Do, 12 Sep 2013) $, $Author:
 *          dennis.chong $
 */
public abstract class TT1411 extends TT141x {

  public static TT1411 fromBytes(byte[] bytes, int offset) {
    int subtype = shortFromBytes(bytes[offset + 6], bytes[offset + 7]);
    TT1411 msg = null;
    if (subtype == 1010 || subtype == 1110 || subtype == 1210) {
      msg = TT1411Subtype1010.fromBytes(bytes, offset);
    } else if (subtype == 1020 || subtype == 1120 || subtype == 1220) {
      msg = TT1411Subtype1020.fromBytes(bytes, offset);
    } else if (subtype == 2010 || subtype == 2110 || subtype == 2210) {
      msg = TT1411Subtype2010.fromBytes(bytes, offset);
    } else if (subtype == 2020 || subtype == 2120 || subtype == 2220) {
      msg = TT1411Subtype2020.fromBytes(bytes, offset);
    } else if (subtype == 2040 || subtype == 2140 || subtype == 2240) {
      msg = TT1411Subtype2040.fromBytes(bytes, offset);
    } else if (subtype == 4010 || subtype == 4110 || subtype == 4210) {
      msg = TT1411Subtype4010.fromBytes(bytes, offset);
    }

    msg.setSenderID(shortFromBytes(bytes[offset + 0], bytes[offset + 1]));
    msg.setReceiverID(shortFromBytes(bytes[offset + 2], bytes[offset + 3]));
    msg.setTelegramType(shortFromBytes(bytes[offset + 4], bytes[offset + 5]));
    msg.setVersion(shortFromBytes(bytes[offset + 8], bytes[offset + 9]));
    msg.setRequestID(intFromBytes(bytes[offset + 10], bytes[offset + 11], bytes[offset + 12],
        bytes[offset + 13]));
    msg.setMovementOptions(shortFromBytes(bytes[offset + 14], bytes[offset + 15]));
    return msg;
  }

  private static final long serialVersionUID = 1L;

  protected int movementOptions;

  public TT1411() {
    super();
    telegramType = 1411;
    version = 1;
    subType = 0;
    movementOptions = 0;
    toBlocks = new TT1411TOBlock[getNumberOfTOBlocks()];
    for (int i = 0; i < toBlocks.length; ++i) {
      toBlocks[i] = new TT1411TOBlock(this);
    }
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
    toBlocks = new TT1411TOBlock[getNumberOfTOBlocks()];
    for (int i = 0; i < toBlocks.length; ++i) {
      toBlocks[i] = new TT1411TOBlock(this);
    }
    producerID = 0;
    movementOptions = extractIntFromHex(hex, 14, 2);
    int byteoffset = 16;
    for (int i = 0; i < toBlocks.length; ++i) {
      byteoffset = toBlocks[i].fromHex(hex, byteoffset);
    }
  }

  public static TT1411 createTelegramBySubtype(int subtype) {
    if (subtype == 1010 || subtype == 1110 || subtype == 1210) {
      TT1411 tt1411 = new TT1411Subtype1010();
      tt1411.setSubType(subtype);
      return tt1411;
    }
    if (subtype == 1020 || subtype == 1120 || subtype == 1220) {
      TT1411 tt1411 = new TT1411Subtype1020();
      tt1411.setSubType(subtype);
      return tt1411;
    }
    if (subtype == 2010 || subtype == 2110 || subtype == 2210) {
      TT1411 tt1411 = new TT1411Subtype2010();
      tt1411.setSubType(subtype);
      return tt1411;
    }
    if (subtype == 2020 || subtype == 2120 || subtype == 2220) {
      TT1411 tt1411 = new TT1411Subtype2020();
      tt1411.setSubType(subtype);
      return tt1411;
    }
    if (subtype == 2040 || subtype == 2140 || subtype == 2240) {
      TT1411 tt1411 = new TT1411Subtype2040();
      tt1411.setSubType(subtype);
      return tt1411;
    }
    if (subtype == 4010 || subtype == 4110 || subtype == 4210) {
      TT1411 tt1411 = new TT1411Subtype4010();
      tt1411.setSubType(subtype);
      return tt1411;
    }
    return null;
  }

  public int getMovementOptions() {
    return movementOptions;
  }

  public void setMovementOptions(int movementOptions) {
    this.movementOptions = movementOptions;
  }
}
