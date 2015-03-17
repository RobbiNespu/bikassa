
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for announce-compare complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-compare">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-compare")
public class AnnounceCompare implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "barcode")
  protected String barcode;
  @XmlAttribute(name = "box")
  protected String box;
  @XmlAttribute(name = "order")
  protected String order;
  @XmlAttribute(name = "from")
  protected String from;

  /**
   * Gets the value of the barcode property.
   * 
   * @return possible object is {@link String }
   */
  public String getBarcode() {
    return barcode;
  }

  /**
   * Sets the value of the barcode property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setBarcode(String value) {
    barcode = value;
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