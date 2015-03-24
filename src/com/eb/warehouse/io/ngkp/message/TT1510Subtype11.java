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
public class TT1510Subtype11 extends TT1510 {

  private static final long serialVersionUID = 1L;
  protected int tuExtra1Detail1;
  protected int tuExtra1Detail2;
  protected int tuExtra3Detail1;
  protected int tuExtra3Detail2;
  protected int tuExtra3Detail3;
  protected int tuExtra3Detail4;

  public TT1510Subtype11() {
    super();
    this.subType = 11;
    this.tuExtra1Detail1 = 0;
    this.tuExtra1Detail2 = 0;
    this.tuExtra3Detail1 = 0;
    this.tuExtra3Detail2 = 0;
    this.tuExtra3Detail3 = 0;
    this.tuExtra3Detail4 = 0;
  }

  @Override
  public String fieldsToString() {
    return super.fieldsToString() + " tuExtra1Detail1=" + tuExtra1Detail1 + ","
           + " tuExtra1Detail2=" + tuExtra1Detail2 + "," + " tuExtra3Detail1=" + tuExtra3Detail1
           + "," + " tuExtra3Detail2=" + tuExtra3Detail2 + "," + " tuExtra3Detail3="
           + tuExtra3Detail3 + "," + " tuExtra3Detail4=" + tuExtra3Detail4 + ",";
  }

  @Override
  public String toHex() {
    String str = super.toHex();
    str = insertIntIntoHex(str, tuExtra1Detail1, 2);
    str = insertIntIntoHex(str, tuExtra1Detail2, 2);
    str = insertIntIntoHex(str, tuExtra3Detail1, 2);
    str = insertIntIntoHex(str, tuExtra3Detail2, 2);
    str = insertIntIntoHex(str, tuExtra3Detail3, 2);
    str = insertIntIntoHex(str, tuExtra3Detail4, 4);
    return str;
  }

  @Override
  public void fromHex(String hex) {
    super.fromHex(hex);
    tuExtra1Detail1 = extractIntFromHex(hex, 76, 2);
    tuExtra1Detail2 = extractIntFromHex(hex, 78, 2);
    tuExtra3Detail1 = extractIntFromHex(hex, 80, 2);
    tuExtra3Detail2 = extractIntFromHex(hex, 82, 2);
    tuExtra3Detail3 = extractIntFromHex(hex, 84, 2);
    tuExtra3Detail4 = extractIntFromHex(hex, 86, 4);
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

  public int getTuExtra3Detail1() {
    return tuExtra3Detail1;
  }

  public void setTuExtra3Detail1(int tuExtra3Detail1) {
    this.tuExtra3Detail1 = tuExtra3Detail1;
  }

  public int getTuExtra3Detail2() {
    return tuExtra3Detail2;
  }

  public void setTuExtra3Detail2(int tuExtra3Detail2) {
    this.tuExtra3Detail2 = tuExtra3Detail2;
  }

  public int getTuExtra3Detail3() {
    return tuExtra3Detail3;
  }

  public void setTuExtra3Detail3(int tuExtra3Detail3) {
    this.tuExtra3Detail3 = tuExtra3Detail3;
  }

  public int getTuExtra3Detail4() {
    return tuExtra3Detail4;
  }

  public void setTuExtra3Detail4(int tuExtra3Detail4) {
    this.tuExtra3Detail4 = tuExtra3Detail4;
  }
}
