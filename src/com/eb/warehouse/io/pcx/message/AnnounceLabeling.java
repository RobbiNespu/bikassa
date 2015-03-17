
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for announce-labeling complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-labeling">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{}announce-value" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="flags" type="{}announce-flags" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="layout" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-labeling", propOrder = {"values", "flags"})
public class AnnounceLabeling implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "value")
  protected List<AnnounceValue> values;
  protected AnnounceFlags flags;
  @XmlAttribute(name = "barcode")
  protected String barcode;
  @XmlAttribute(name = "box")
  protected String box;
  @XmlAttribute(name = "from")
  protected String from;
  @XmlAttribute(name = "order")
  protected String order;
  @XmlAttribute(name = "layout")
  protected String layout;
  @XmlAttribute(name = "name")
  protected String name;

  /**
   * Gets the value of the values property.
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the values property.
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getValues().add(newItem);
   * </pre>
   * <p>
   * Objects of the following type(s) are allowed in the list {@link AnnounceValue }
   */
  public List<AnnounceValue> getValues() {
    if (values == null) {
      values = new ArrayList<AnnounceValue>();
    }
    return values;
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
   * Gets the value of the layout property.
   * 
   * @return possible object is {@link String }
   */
  public String getLayout() {
    return layout;
  }

  /**
   * Sets the value of the layout property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setLayout(String value) {
    layout = value;
  }

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
    name = value;
  }

}