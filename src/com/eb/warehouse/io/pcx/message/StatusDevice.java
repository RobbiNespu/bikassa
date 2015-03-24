package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-device complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="status-device">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="printer" type="{}status-printer" minOccurs="0"/>
 *         &lt;element name="funnel" type="{}status-funnel" minOccurs="0"/>
 *         &lt;element name="shafts" type="{}status-shafts" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-device", propOrder = {

})
public class StatusDevice
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected StatusPrinter printer;
  protected StatusFunnel funnel;
  protected StatusShafts shafts;
  @XmlAttribute(name = "name")
  protected String name;

  /**
   * Gets the value of the printer property.
   *
   * @return possible object is {@link StatusPrinter }
   */
  public StatusPrinter getPrinter() {
    return printer;
  }

  /**
   * Sets the value of the printer property.
   *
   * @param value allowed object is {@link StatusPrinter }
   */
  public void setPrinter(StatusPrinter value) {
    this.printer = value;
  }

  /**
   * Gets the value of the funnel property.
   *
   * @return possible object is {@link StatusFunnel }
   */
  public StatusFunnel getFunnel() {
    return funnel;
  }

  /**
   * Sets the value of the funnel property.
   *
   * @param value allowed object is {@link StatusFunnel }
   */
  public void setFunnel(StatusFunnel value) {
    this.funnel = value;
  }

  /**
   * Gets the value of the shafts property.
   *
   * @return possible object is {@link StatusShafts }
   */
  public StatusShafts getShafts() {
    return shafts;
  }

  /**
   * Sets the value of the shafts property.
   *
   * @param value allowed object is {@link StatusShafts }
   */
  public void setShafts(StatusShafts value) {
    this.shafts = value;
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
    this.name = value;
  }

}
