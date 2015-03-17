/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

public class TT1413Subtype1020 extends TT1413 {

  private static final long serialVersionUID = 1L;

  public TT1413Subtype1020() {
    super();
    this.subType = 1020;
  }

  @Override
  public int getNumberOfTOBlocks() {
    return 1;
  }

  @Override
  public int getNumberOfTUBlocks() {
    return 2;
  }
}
