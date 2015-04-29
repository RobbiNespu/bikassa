package com.eb.warehouse.io.ngkp.message;

/**
 * Abstract extension of the telegram class to represent TT1434 telegrams.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author:
 *          dennis.chong $
 */

public abstract class TT1434 {

//  private static final long serialVersionUID = 1L;
//  protected int topic;
//  protected int statusRequestID;
//
//  public TT1434() {
//    super();
//    telegramType = 1434;
//    content = "";
//    for (int i = 0; i < getContentLength(); ++i) {
//      content += "00";
//    }
//  }
//
//  public static TT1434 fromBytes(byte[] bytes, int offset) {
//    NgkpTelegramHeader telegram = new NgkpTelegramHeader();
//    telegram.fromByteArray(bytes, offset);
//    TT1434 msg = null;
//    if (version == 0) {
//      msg = new TT1434Version1();
//    } else if (version == 1) {
//      msg = TT1434Version2.fromBytes(bytes, offset);
//    }
//
//    msg.setTopic(shortFromBytes(bytes[offset + 10], bytes[offset + 11]));
//    return msg;
//  }
//
//  public int getTopic() {
//    return topic;
//  }
//
//  public void setTopic(int topic) {
//    this.topic = topic;
//  }
//
//  public int getStatusRequestID() {
//    return statusRequestID;
//  }
//
//  public void setStatusRequestID(int statusRequestID) {
//    this.statusRequestID = statusRequestID;
//  }
//
//  public String getContent() {
//    return content;
//  }
//
//  public void setContent(String content) {
//    this.content = content;
//  }
}
