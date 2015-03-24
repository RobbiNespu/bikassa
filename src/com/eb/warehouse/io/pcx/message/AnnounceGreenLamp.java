package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for announce-green-lamp complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="announce-green-lamp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="action" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-green-lamp")
public class AnnounceGreenLamp
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "action")
  protected String action;

  /**
   * Gets the value of the action property.
   *
   * @return possible object is {@link String }
   */
  public String getAction() {
    return action;
  }

  /**
   * Sets the value of the action property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAction(String value) {
    action = value;
  }

}
