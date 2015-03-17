/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

public abstract class TT1518 extends NGKPTelegram {
  private static final long serialVersionUID = 1L;
  protected int topic;

  public TT1518() {
    super();
    this.telegramType = 1518;
    this.version = 1;
    this.subType = 0;
    this.topic = 0;
  }

  public int getTopic() {
    return topic;
  }

  public void setTopic(int topic) {
    this.topic = topic;
  }
}