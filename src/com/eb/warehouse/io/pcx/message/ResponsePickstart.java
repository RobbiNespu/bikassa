package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-pickstart complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-pickstart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="operations" type="{}response-operations" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="tub" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="location" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-pickstart", propOrder = {

})
public class ResponsePickstart
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected ResponseOperations operations;
  @XmlAttribute(name = "tub")
  protected String tub;
  @XmlAttribute(name = "location")
  protected String location;
  @XmlAttribute(name = "type")
  protected BigInteger type;
  @XmlAttribute(name = "orientation")
  protected BigInteger orientation;

  /**
   * Gets the value of the operations property.
   *
   * @return possible object is {@link ResponseOperations }
   */
  public ResponseOperations getOperations() {
    return operations;
  }

  /**
   * Sets the value of the operations property.
   *
   * @param value allowed object is {@link ResponseOperations }
   */
  public void setOperations(ResponseOperations value) {
    this.operations = value;
  }

  /**
   * Gets the value of the tub property.
   *
   * @return possible object is {@link String }
   */
  public String getTub() {
    return tub;
  }

  /**
   * Sets the value of the tub property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTub(String value) {
    this.tub = value;
  }

  /**
   * Gets the value of the location property.
   *
   * @return possible object is {@link String }
   */
  public String getLocation() {
    return location;
  }

  /**
   * Sets the value of the location property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLocation(String value) {
    this.location = value;
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
    this.type = value;
  }

  /**
   * Gets the value of the orientation property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getOrientation() {
    return orientation;
  }

  /**
   * Sets the value of the orientation property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setOrientation(BigInteger value) {
    this.orientation = value;
  }

}
