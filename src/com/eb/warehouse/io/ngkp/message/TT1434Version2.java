package com.eb.warehouse.io.ngkp.message;

import static com.eb.warehouse.io.ngkp.BytesToInt.intFromBytes;

/**
 * Concrete extension of the TT1434 telegram class.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1687 $, $Date: 2014-03-14 15:35:59 +0100 (Fr, 14 Mrz 2014) $, $Author:
 *          dennis.chong $
 */

public class TT1434Version2 extends TT1434 {

  private static final long serialVersionUID = 1L;

  public TT1434Version2() {
    super();
    version = 2;
    subType = 0;
    statusRequestID = 0;
  }

  public static TT1434Version2 fromBytes(byte[] bytes, int offset) {
    TT1434Version2 msg = new TT1434Version2();
    msg.setStatusRequestID(intFromBytes(bytes[offset + 12], bytes[offset + 13], bytes[offset + 14],
                                        bytes[offset + 15]));
    return msg;
  }

  @Override
  public int getContentOffset() {
    return 16;
  }

  @Override
  public int getContentLength() {
    return 84;
  }

  @Override
  public String fieldsToString() {
    String result = super.fieldsToString();
    result += " topic=" + topic + ",";
    result += " statusRequestID=" + statusRequestID + ",";
    result += " content=" + content + ",";
    return result;
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = str.substring(0, str.length() - 12);
    str = insertIntIntoHex(str, topic, 2);
    str = insertIntIntoHex(str, statusRequestID, 4);
    return str + content;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    requestID = 0;
    producerID = 0;
    topic = extractIntFromHex(hex, 10, 2);
    statusRequestID = extractIntFromHex(hex, 12, 4);
    int start = getContentOffset() * 2;
    int stop = (getContentOffset() + getContentLength()) * 2;
    content = hex.substring(start, stop);
  }
}
