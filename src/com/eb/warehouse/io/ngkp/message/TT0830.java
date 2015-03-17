/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 983 $, $Date: 2013-02-21 17:41:18 +0100 (Do, 21 Feb 2013) $, $Author: dennis.chong $
 */

public class TT0830 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  protected int topic;
  protected String content;

  public TT0830() {
    super();
    telegramType = 830;
    subType = 0;
    version = 0;
    topic = 0;
    content = "";
    for (int i = 0; i < getContentLength(); ++i) {
      content += "00";
    }
  }

  public int getContentOffset() {
    return 12;
  }

  public int getContentLength() {
    return 16;
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + " topic=" + topic + ", content=" + content + "]";
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, topic, 2);
    return hex + content;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    version = extractIntFromHex(hex, 8, 2);
    topic = extractIntFromHex(hex, 10, 2);
    int start = getContentOffset() * 2;
    int stop = (getContentOffset() + getContentLength()) * 2;
    content = hex.substring(start, stop);
  }

  public int getTopic() {
    return topic;
  }

  public void setTopic(int topic) {
    this.topic = topic;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
