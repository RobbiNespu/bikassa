package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-loading complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="status-loading">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="info" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="statenum" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-loading")
public class StatusLoading
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "status")
  protected String status;
  @XmlAttribute(name = "info")
  protected String info;
  @XmlAttribute(name = "statenum")
  protected String statenum;
  @XmlAttribute(name = "state")
  protected String state;

  /**
   * Gets the value of the status property.
   *
   * @return possible object is {@link String }
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the value of the status property.
   *
   * @param value allowed object is {@link String }
   */
  public void setStatus(String value) {
    this.status = value;
  }

  /**
   * Gets the value of the info property.
   *
   * @return possible object is {@link String }
   */
  public String getInfo() {
    return info;
  }

  /**
   * Sets the value of the info property.
   *
   * @param value allowed object is {@link String }
   */
  public void setInfo(String value) {
    this.info = value;
  }

  /**
   * Gets the value of the statenum property.
   *
   * @return possible object is {@link String }
   */
  public String getStatenum() {
    return statenum;
  }

  /**
   * Sets the value of the statenum property.
   *
   * @param value allowed object is {@link String }
   */
  public void setStatenum(String value) {
    this.statenum = value;
  }

  /**
   * Gets the value of the state property.
   *
   * @return possible object is {@link String }
   */
  public String getState() {
    return state;
  }

  /**
   * Sets the value of the state property.
   *
   * @param value allowed object is {@link String }
   */
  public void setState(String value) {
    this.state = value;
  }

}
