/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1611 telegram class.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author: dennis.chong $
 */
public class TT1611Subtype1010Version1 extends TT1611 {

  private static final long serialVersionUID = 1L;

  public TT1611Subtype1010Version1() {
    super();
    this.version = 1;
    this.subType = 1010;
  }

  @Override
  public int getNumberOfTOBlocks() {
    return 1;
  }

  @Override
  public int getNumberOfTUBlocks() {
    return 1;
  }
}
