package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-occupied complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-occupied">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="to" type="{}response-to" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-occupied", propOrder = {
    "to"
})
public class ResponseOccupied
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected ResponseTo to;

  /**
   * Gets the value of the to property.
   *
   * @return possible object is {@link ResponseTo }
   */
  public ResponseTo getTo() {
    return to;
  }

  /**
   * Sets the value of the to property.
   *
   * @param value allowed object is {@link ResponseTo }
   */
  public void setTo(ResponseTo value) {
    this.to = value;
  }

}
