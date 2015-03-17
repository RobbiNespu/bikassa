/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1484 $, $Date: 2013-09-12 16:40:43 +0200 (Do, 12 Sep 2013) $, $Author: dennis.chong $
 */

public class TT1413Subtype2020 extends TT1413 {
  private static final long serialVersionUID = 1L;

  public TT1413Subtype2020() {
    super();
    this.subType = 2020;
  }

  @Override
  public int getNumberOfTOBlocks() {
    return 2;
  }

  @Override
  public int getNumberOfTUBlocks() {
    return 2;
  }
}
