/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1510 telegram class.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 719 $, $Date: 2012-09-06 18:04:47 +0200 (Do, 06 Sep 2012) $, $Author:
 *          dennis.chong $
 */
public class TT1510Subtype1 extends TT1510 {

  private static final long serialVersionUID = 1L;

  public TT1510Subtype1() {
    super();
    this.subType = 1;
  }
}
