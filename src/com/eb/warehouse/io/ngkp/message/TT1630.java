/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Abstract extension of the telegram class to represent TT1630 telegrams.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */
public abstract class TT1630 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  protected int topic;
  protected boolean[] requestFlags;
  protected int reserve;
  protected int requestDetails;

  public TT1630() {
    super();
    this.telegramType = 1630;
    this.version = 0;
    this.subType = 0;
    this.topic = 0;
    this.requestFlags = new boolean[8];
    this.reserve = 0;
    this.requestDetails = 0;
  }

  public abstract int totalBytes();

  public int getTopic() {
    return topic;
  }

  public void setTopic(int topic) {
    this.topic = topic;
  }

  public boolean[] getRequestFlags() {
    return requestFlags;
  }

  public void setRequestFlags(boolean[] requestFlags) {
    this.requestFlags = requestFlags;
  }

  public int getReserve() {
    return reserve;
  }

  public void setReserve(int reserve) {
    this.reserve = reserve;
  }

  public int getRequestDetails() {
    return requestDetails;
  }

  public void setRequestDetails(int requestDetails) {
    this.requestDetails = requestDetails;
  }
}
