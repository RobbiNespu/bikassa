package com.eb.warehouse.io.pcx.message;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p> Java class for response-station complex type. <p> The following schema fragment specifies the
 * expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-station">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="scale" type="{}response-scale" minOccurs="0"/>
 *         &lt;element name="flags" type="{}response-flags" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="to" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="at" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-station", propOrder = {

})
public class ResponseStation implements Serializable {

  private final static long serialVersionUID = 1L;
  protected ResponseScale scale;
  protected ResponseFlags flags;
  @XmlAttribute(name = "box")
  protected String box;
  @XmlAttribute(name = "order")
  protected String order;
  @XmlAttribute(name = "from")
  protected String from;
  @XmlAttribute(name = "to")
  protected String to;
  @XmlAttribute(name = "at")
  protected String at;
  @XmlAttribute(name = "type")
  protected BigInteger type;

  /**
   * Gets the value of the scale property.
   *
   * @return possible object is {@link ResponseScale }
   */
  public ResponseScale getScale() {
    return scale;
  }

  /**
   * Sets the value of the scale property.
   *
   * @param value allowed object is {@link ResponseScale }
   */
  public void setScale(ResponseScale value) {
    scale = value;
  }

  /**
   * Gets the value of the flags property.
   *
   * @return possible object is {@link ResponseFlags }
   */
  public ResponseFlags getFlags() {
    return flags;
  }

  /**
   * Sets the value of the flags property.
   *
   * @param value allowed object is {@link ResponseFlags }
   */
  public void setFlags(ResponseFlags value) {
    flags = value;
  }

  /**
   * Gets the value of the box property.
   *
   * @return possible object is {@link String }
   */
  public String getBox() {
    return box;
  }

  /**
   * Sets the value of the box property.
   *
   * @param value allowed object is {@link String }
   */
  public void setBox(String value) {
    box = value;
  }

  /**
   * Gets the value of the order property.
   *
   * @return possible object is {@link String }
   */
  public String getOrder() {
    return order;
  }

  /**
   * Sets the value of the order property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOrder(String value) {
    order = value;
  }

  /**
   * Gets the value of the from property.
   *
   * @return possible object is {@link String }
   */
  public String getFrom() {
    return from;
  }

  /**
   * Sets the value of the from property.
   *
   * @param value allowed object is {@link String }
   */
  public void setFrom(String value) {
    from = value;
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
    at = value;
  }

  /**
   * Gets the value of the type property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getType() {
    return type;
  }

  /**
   * Sets the value of the type property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setType(BigInteger value) {
    type = value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("box", box)
        .add("from", from)
        .add("to", to)
        .add("at", at)
        .add("type", type)
        .add("order", order)
        .add("flags", flags)
        .add("scale", scale)
        .omitNullValues()
        .toString();
  }
}