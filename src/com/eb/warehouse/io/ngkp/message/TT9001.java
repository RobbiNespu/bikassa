/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author:
 *          dennis.chong $
 */

public class TT9001 extends NGKPTelegram {

  private static final long serialVersionUID = 1L;
  protected String xmlContent;

  public TT9001() {
    super();
    this.telegramType = 9001;
    this.xmlContent = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n";
    this.xmlContent += "<announce>\n";
    this.xmlContent += "  <station box=\"Bin\" order=\"string\" from=\"SM01\">\n";
    this.xmlContent += "    <target to=\"13\" mode=\"STOP\" prio=\"0\" timeout=\"0\" />\n";
    this.xmlContent += "  </station>\n";
    this.xmlContent += "</announce>\n";
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + " xmlContent=" + xmlContent.replaceAll("\n", "\0") + ",";
  }

  @Override
  public String toHex() {
    return insertStringIntoHex("", xmlContent);
  }

  @Override
  public void fromHex(String hex) {
    xmlContent = extractStringFromHex(hex, 0, (hex.length() / 2));
  }

  public String getXmlContent() {
    return xmlContent;
  }

  public void setXmlContent(String xmlContent) {
    this.xmlContent = xmlContent;
  }
}
