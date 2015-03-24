package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p> Java class for response-compare complex type. <p> The following schema fragment specifies the
 * expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-compare">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="flags" type="{}response-flags" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-compare", propOrder = {

})
public class ResponseCompare implements Serializable {

  private final static long serialVersionUID = 1L;
  protected ResponseFlags flags;
  @XmlAttribute(name = "box")
  protected String box;
  @XmlAttribute(name = "order")
  protected String order;
  @XmlAttribute(name = "from")
  protected String from;

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

}