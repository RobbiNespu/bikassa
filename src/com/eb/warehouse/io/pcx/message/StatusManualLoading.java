package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-manual-loading complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="status-manual-loading">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-manual-loading")
public class StatusManualLoading
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "active")
  protected Boolean active;

  /**
   * Gets the value of the active property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isActive() {
    return active;
  }

  /**
   * Sets the value of the active property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setActive(Boolean value) {
    this.active = value;
  }

}
