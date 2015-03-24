package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-reader complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-reader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="at" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="slot" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reason" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-reader")
public class ResponseReader
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "at")
  protected String at;
  @XmlAttribute(name = "slot")
  protected String slot;
  @XmlAttribute(name = "reason")
  protected String reason;

  /**
   * Gets the value of the at property.
   *
   * @return possible object is {@link String }
   */
  public String getAt() {
    return at;
  }

  /**
   * Sets the value of the at property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAt(String value) {
    this.at = value;
  }

  /**
   * Gets the value of the slot property.
   *
   * @return possible object is {@link String }
   */
  public String getSlot() {
    return slot;
  }

  /**
   * Sets the value of the slot property.
   *
   * @param value allowed object is {@link String }
   */
  public void setSlot(String value) {
    this.slot = value;
  }

  /**
   * Gets the value of the reason property.
   *
   * @return possible object is {@link String }
   */
  public String getReason() {
    return reason;
  }

  /**
   * Sets the value of the reason property.
   *
   * @param value allowed object is {@link String }
   */
  public void setReason(String value) {
    this.reason = value;
  }

}
