package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for remove-station complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="remove-station">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remove-station")
public class RemoveStation
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "box")
  protected String box;
  @XmlAttribute(name = "from")
  protected String from;

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
    this.box = value;
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
    this.from = value;
  }

}
