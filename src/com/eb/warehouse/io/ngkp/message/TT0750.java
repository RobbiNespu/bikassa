/*
 * Copyright (c) 2014 SSI Schaefer Noell GmbH
 */

package com.eb.warehouse.io.ngkp.message;

public class TT0750 extends NGKPTopicTelegram {

  private static final long serialVersionUID = 1L;

  public TT0750() {
    super();
    telegramType = 750;
    version = 0;
    subType = 0;
  }

  @Override
  public int getContentOffset() {
    return 16;
  }

  @Override
  public int getContentLength() {
    return 200 - getContentOffset();
  }
}
