
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import com.google.common.base.MoreObjects;

/**
 * <p>
 * Java class for announce-target complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-target">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="scale" type="{}announce-scale" minOccurs="0"/>
 *         &lt;element name="flags" type="{}announce-flags" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="to" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="prio" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="timeout" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-target", propOrder = {

})
public class AnnounceTarget implements Serializable {

  private final static long serialVersionUID = 1L;
  public static final String MODE_OVER = "OVER";
  public static final String MODE_STOP = "STOP";
  public static final String MODE_NEXT = "NEXT";
  public static final String MODE_TIMEOUT = "TIMEOUT";

  protected AnnounceScale scale;
  protected AnnounceFlags flags;
  @XmlAttribute(name = "to")
  protected String to;
  @XmlAttribute(name = "prio")
  protected BigInteger prio;
  @XmlAttribute(name = "timeout")
  protected BigInteger timeout;
  @XmlAttribute(name = "mode")
  protected String mode;

  /**
   * Gets the value of the scale property.
   * 
   * @return possible object is {@link AnnounceScale }
   */
  public AnnounceScale getScale() {
    return scale;
  }

  /**
   * Sets the value of the scale property.
   * 
   * @param value allowed object is {@link AnnounceScale }
   */
  public void setScale(AnnounceScale value) {
    scale = value;
  }

  /**
   * Gets the value of the flags property.
   * 
   * @return possible object is {@link AnnounceFlags }
   */
  public AnnounceFlags getFlags() {
    return flags;
  }

  /**
   * Sets the value of the flags property.
   * 
   * @param value allowed object is {@link AnnounceFlags }
   */
  public void setFlags(AnnounceFlags value) {
    flags = value;
  }

  /**
   * Gets the value of the to property.
   * 
   * @return possible object is {@link String }
   */
  public String getTo() {
    return to;
  }

  /**
   * Sets the value of the to property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setTo(String value) {
    to = value;
  }

  /**
   * Gets the value of the prio property.
   * 
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getPrio() {
    return prio;
  }

  /**
   * Sets the value of the prio property.
   * 
   * @param value allowed object is {@link BigInteger }
   */
  public void setPrio(BigInteger value) {
    prio = value;
  }

  /**
   * Gets the value of the timeout property.
   * 
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getTimeout() {
    return timeout;
  }

  /**
   * Sets the value of the timeout property.
   * 
   * @param value allowed object is {@link BigInteger }
   */
  public void setTimeout(BigInteger value) {
    timeout = value;
  }

  /**
   * Gets the value of the mode property.
   * 
   * @return possible object is {@link String }
   */
  public String getMode() {
    return mode;
  }

  /**
   * Sets the value of the mode property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setMode(String value) {
    mode = value;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
                      .add("scale", scale)
                      .add("flags", flags)
                      .add("to", to)
                      .add("prio", prio)
                      .add("timeout", timeout)
                      .add("mode", mode)
                      .omitNullValues()
                      .toString();
  }
}