package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for announce-scale complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="announce-scale">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="err" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-scale")
public class AnnounceScale
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "err")
  protected String err;
  @XmlAttribute(name = "min")
  protected BigInteger min;
  @XmlAttribute(name = "max")
  protected BigInteger max;

  /**
   * Gets the value of the err property.
   *
   * @return possible object is {@link String }
   */
  public String getErr() {
    return err;
  }

  /**
   * Sets the value of the err property.
   *
   * @param value allowed object is {@link String }
   */
  public void setErr(String value) {
    err = value;
  }

  /**
   * Gets the value of the min property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMin() {
    return min;
  }

  /**
   * Sets the value of the min property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMin(BigInteger value) {
    min = value;
  }

  /**
   * Gets the value of the max property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMax() {
    return max;
  }

  /**
   * Sets the value of the max property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMax(BigInteger value) {
    max = value;
  }

}
