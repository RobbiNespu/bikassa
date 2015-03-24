package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-op complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-op">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="destlocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="desttote" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="noof" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="desired" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="wmsid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="desttub" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="desttype" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="destcomp" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="remaining" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-op")
public class ResponseOp
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "name")
  protected String name;
  @XmlAttribute(name = "destlocation")
  protected String destlocation;
  @XmlAttribute(name = "desttote")
  protected String desttote;
  @XmlAttribute(name = "noof")
  protected BigInteger noof;
  @XmlAttribute(name = "desired")
  protected BigInteger desired;
  @XmlAttribute(name = "wmsid")
  protected String wmsid;
  @XmlAttribute(name = "desttub")
  protected String desttub;
  @XmlAttribute(name = "desttype")
  protected BigInteger desttype;
  @XmlAttribute(name = "destcomp")
  protected BigInteger destcomp;
  @XmlAttribute(name = "remaining")
  protected BigInteger remaining;

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the destlocation property.
   *
   * @return possible object is {@link String }
   */
  public String getDestlocation() {
    return destlocation;
  }

  /**
   * Sets the value of the destlocation property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDestlocation(String value) {
    this.destlocation = value;
  }

  /**
   * Gets the value of the desttote property.
   *
   * @return possible object is {@link String }
   */
  public String getDesttote() {
    return desttote;
  }

  /**
   * Sets the value of the desttote property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDesttote(String value) {
    this.desttote = value;
  }

  /**
   * Gets the value of the noof property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNoof() {
    return noof;
  }

  /**
   * Sets the value of the noof property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNoof(BigInteger value) {
    this.noof = value;
  }

  /**
   * Gets the value of the desired property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getDesired() {
    return desired;
  }

  /**
   * Sets the value of the desired property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setDesired(BigInteger value) {
    this.desired = value;
  }

  /**
   * Gets the value of the wmsid property.
   *
   * @return possible object is {@link String }
   */
  public String getWmsid() {
    return wmsid;
  }

  /**
   * Sets the value of the wmsid property.
   *
   * @param value allowed object is {@link String }
   */
  public void setWmsid(String value) {
    this.wmsid = value;
  }

  /**
   * Gets the value of the desttub property.
   *
   * @return possible object is {@link String }
   */
  public String getDesttub() {
    return desttub;
  }

  /**
   * Sets the value of the desttub property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDesttub(String value) {
    this.desttub = value;
  }

  /**
   * Gets the value of the desttype property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getDesttype() {
    return desttype;
  }

  /**
   * Sets the value of the desttype property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setDesttype(BigInteger value) {
    this.desttype = value;
  }

  /**
   * Gets the value of the destcomp property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getDestcomp() {
    return destcomp;
  }

  /**
   * Sets the value of the destcomp property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setDestcomp(BigInteger value) {
    this.destcomp = value;
  }

  /**
   * Gets the value of the remaining property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getRemaining() {
    return remaining;
  }

  /**
   * Sets the value of the remaining property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setRemaining(BigInteger value) {
    this.remaining = value;
  }

}
