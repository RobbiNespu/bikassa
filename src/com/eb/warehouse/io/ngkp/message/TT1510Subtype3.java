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
public class TT1510Subtype3 extends TT1510 {

  private static final long serialVersionUID = 1L;
  protected int tuExtra1Detail1;
  protected int tuExtra1Detail2;

  public TT1510Subtype3() {
    super();
    this.subType = 3;
    this.tuExtra1Detail1 = 0;
    this.tuExtra1Detail2 = 0;
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + " tuExtra1Detail1=" + tuExtra1Detail1 + ","
           + " tuExtra1Detail2=" + tuExtra1Detail2 + ",";
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = insertIntIntoHex(str, tuExtra1Detail1, 2);
    str = insertIntIntoHex(str, tuExtra1Detail2, 2);
    return str;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    tuExtra1Detail1 = extractIntFromHex(hex, 76, 2);
    tuExtra1Detail2 = extractIntFromHex(hex, 78, 2);
  }

  public int getTuExtra1Detail1() {
    return tuExtra1Detail1;
  }

  public void setTuExtra1Detail1(int tuExtra1Detail1) {
    this.tuExtra1Detail1 = tuExtra1Detail1;
  }

  public int getTuExtra1Detail2() {
    return tuExtra1Detail2;
  }

  public void setTuExtra1Detail2(int tuExtra1Detail2) {
    this.tuExtra1Detail2 = tuExtra1Detail2;
  }
}
