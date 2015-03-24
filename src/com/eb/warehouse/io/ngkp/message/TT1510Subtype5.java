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
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author:
 *          dennis.chong $
 */
public class TT1510Subtype5 extends TT1510 {

  private static final long serialVersionUID = 1L;
  protected int tuExtra2;

  public TT1510Subtype5() {
    super();
    this.subType = 5;
    this.tuExtra2 = 0;
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + " tuExtra2=" + tuExtra2 + ",";
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = insertIntIntoHex(str, tuExtra2, 2);
    return str;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    tuExtra2 = extractIntFromHex(hex, 76, 2);
  }

  public int getTuExtra2() {
    return tuExtra2;
  }

  public void setTuExtra2(int tuExtra2) {
    this.tuExtra2 = tuExtra2;
  }
}
