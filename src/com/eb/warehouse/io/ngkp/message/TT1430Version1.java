/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1430 telegram class.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author:
 *          dennis.chong $
 */
public class TT1430Version1 extends TT1430 {

  private static final long serialVersionUID = 1L;

  public TT1430Version1() {
    super();
    this.version = 1;
    this.subType = 0;
    this.topic = 1;
    this.statusRequestID = 0;
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