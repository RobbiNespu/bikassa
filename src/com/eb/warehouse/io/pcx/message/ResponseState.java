package com.eb.warehouse.io.pcx.message;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-state.
 *
 * <p>The following schema fragment specifies the expected content contained within this class. <p>
 * <pre>
 * &lt;simpleType name="response-state">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ok"/>
 *     &lt;enumeration value="rejected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "response-state")
@XmlEnum
public enum ResponseState {

  @XmlEnumValue("ok")
  OK("ok"),
  @XmlEnumValue("rejected")
  REJECTED("rejected");
  private final String value;

  ResponseState(String v) {
    value = v;
  }

  public static ResponseState fromValue(String v) {
    for (ResponseState c : ResponseState.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

  public String value() {
    return value;
  }

}
