package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-operations complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-operations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="op" type="{}response-op" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="compartment" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="remaining" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="error" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-operations", propOrder = {
    "ops"
})
public class ResponseOperations
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "op", required = true)
  protected List<ResponseOp> ops;
  @XmlAttribute(name = "name")
  protected String name;
  @XmlAttribute(name = "compartment")
  protected BigInteger compartment;
  @XmlAttribute(name = "remaining")
  protected BigInteger remaining;
  @XmlAttribute(name = "error")
  protected String error;

  /**
   * Gets the value of the ops property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the ops property.
   *
   * <p> For example, to add a new item, do as follows:
   * <pre>
   *    getOps().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link ResponseOp }
   */
  public List<ResponseOp> getOps() {
    if (ops == null) {
      ops = new ArrayList<ResponseOp>();
    }
    return this.ops;
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

  /**
   * Gets the value of the compartment property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getCompartment() {
    return compartment;
  }

  /**
   * Sets the value of the compartment property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setCompartment(BigInteger value) {
    this.compartment = value;
  }

  /**
   * Gets the value of the remaining property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getRemaining() {
    return remaining;
  }

  /**
   * Sets the value of the remaining property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setRemaining(BigInteger value) {
    this.remaining = value;
  }

  /**
   * Gets the value of the error property.
   *
   * @return possible object is {@link String }
   */
  public String getError() {
    return error;
  }

  /**
   * Sets the value of the error property.
   *
   * @param value allowed object is {@link String }
   */
  public void setError(String value) {
    this.error = value;
  }

}
