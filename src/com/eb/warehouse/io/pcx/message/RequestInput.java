package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for request-input complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="request-input">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="device" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "request-input")
public class RequestInput
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "device")
  protected String device;

  /**
   * Gets the value of the device property.
   *
   * @return possible object is {@link String }
   */
  public String getDevice() {
    return device;
  }

  /**
   * Sets the value of the device property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDevice(String value) {
    this.device = value;
  }

}
