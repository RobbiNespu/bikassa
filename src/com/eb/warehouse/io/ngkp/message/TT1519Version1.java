/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1519 telegram class.
 * 
 * @author <a href="mailto:moos@ssi-schaefer-noell.com">moos</a>
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author: dennis.chong $
 */
public class TT1519Version1 extends TT1519 {

  private static final long serialVersionUID = 1L;

  public TT1519Version1() {
    super();
    this.version = 1;
    this.subType = 0;
    this.topic = 4;
  }

  @Override
  public int getContentOffset() {
    return 12;
  }

  @Override
  public int getContentLength() {
    return 34;
  }

  @Override
  public String fieldsToString() {
    String result = super.fieldsToString();
    result += " topic=" + topic + ",";
    result += " content=" + content + ",";
    return result;
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = str.substring(0, str.length() - 12);
    str = insertIntIntoHex(str, topic, 2);
    return str + content;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    topic = extractIntFromHex(hex, 10, 2);
    int start = getContentOffset() * 2;
    int stop = (getContentOffset() + getContentLength()) * 2;
    content = hex.substring(start, stop);
  }
}