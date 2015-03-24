package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-printer complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="status-printer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="info" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="statenum" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="error" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="warning" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="connected" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="simulated" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="status-code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="display" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status-code2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="display2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-printer")
public class StatusPrinter
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "status")
  protected String status;
  @XmlAttribute(name = "info")
  protected String info;
  @XmlAttribute(name = "statenum")
  protected String statenum;
  @XmlAttribute(name = "error")
  protected Boolean error;
  @XmlAttribute(name = "warning")
  protected Boolean warning;
  @XmlAttribute(name = "connected")
  protected Boolean connected;
  @XmlAttribute(name = "simulated")
  protected Boolean simulated;
  @XmlAttribute(name = "status-code")
  protected String statusCode;
  @XmlAttribute(name = "display")
  protected String display;
  @XmlAttribute(name = "status-code2")
  protected String statusCode2;
  @XmlAttribute(name = "display2")
  protected String display2;

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
   * Gets the value of the error property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isError() {
    return error;
  }

  /**
   * Sets the value of the error property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setError(Boolean value) {
    this.error = value;
  }

  /**
   * Gets the value of the warning property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isWarning() {
    return warning;
  }

  /**
   * Sets the value of the warning property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setWarning(Boolean value) {
    this.warning = value;
  }

  /**
   * Gets the value of the connected property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isConnected() {
    return connected;
  }

  /**
   * Sets the value of the connected property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setConnected(Boolean value) {
    this.connected = value;
  }

  /**
   * Gets the value of the simulated property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isSimulated() {
    return simulated;
  }

  /**
   * Sets the value of the simulated property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setSimulated(Boolean value) {
    this.simulated = value;
  }

  /**
   * Gets the value of the statusCode property.
   *
   * @return possible object is {@link String }
   */
  public String getStatusCode() {
    return statusCode;
  }

  /**
   * Sets the value of the statusCode property.
   *
   * @param value allowed object is {@link String }
   */
  public void setStatusCode(String value) {
    this.statusCode = value;
  }

  /**
   * Gets the value of the display property.
   *
   * @return possible object is {@link String }
   */
  public String getDisplay() {
    return display;
  }

  /**
   * Sets the value of the display property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDisplay(String value) {
    this.display = value;
  }

  /**
   * Gets the value of the statusCode2 property.
   *
   * @return possible object is {@link String }
   */
  public String getStatusCode2() {
    return statusCode2;
  }

  /**
   * Sets the value of the statusCode2 property.
   *
   * @param value allowed object is {@link String }
   */
  public void setStatusCode2(String value) {
    this.statusCode2 = value;
  }

  /**
   * Gets the value of the display2 property.
   *
   * @return possible object is {@link String }
   */
  public String getDisplay2() {
    return display2;
  }

  /**
   * Sets the value of the display2 property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDisplay2(String value) {
    this.display2 = value;
  }

}
