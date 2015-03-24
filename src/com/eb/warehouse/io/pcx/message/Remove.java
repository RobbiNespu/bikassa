package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for remove complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="remove">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="station" type="{}remove-station" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remove", propOrder = {
    "station"
})
@XmlRootElement(name = "remove")
public class Remove
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected RemoveStation station;

  /**
   * Gets the value of the station property.
   *
   * @return possible object is {@link RemoveStation }
   */
  public RemoveStation getStation() {
    return station;
  }

  /**
   * Sets the value of the station property.
   *
   * @param value allowed object is {@link RemoveStation }
   */
  public void setStation(RemoveStation value) {
    this.station = value;
  }

}
