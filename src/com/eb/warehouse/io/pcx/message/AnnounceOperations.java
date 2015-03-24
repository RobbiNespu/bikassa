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
 * <p>Java class for announce-operations complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="announce-operations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="op" type="{}announce-op" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sequence" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="compartment" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="contains" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="parallel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-operations", propOrder = {
    "ops"
})
public class AnnounceOperations
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "op", required = true)
  protected List<AnnounceOp> ops;
  @XmlAttribute(name = "name")
  protected String name;
  @XmlAttribute(name = "sequence")
  protected BigInteger sequence;
  @XmlAttribute(name = "compartment")
  protected BigInteger compartment;
  @XmlAttribute(name = "contains")
  protected BigInteger contains;
  @XmlAttribute(name = "parallel")
  protected String parallel;
  @XmlAttribute(name = "source")
  protected String source;

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
   * <p> Objects of the following type(s) are allowed in the list {@link AnnounceOp }
   */
  public List<AnnounceOp> getOps() {
    if (ops == null) {
      ops = new ArrayList<AnnounceOp>();
    }
    return ops;
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

  /**
   * Gets the value of the sequence property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getSequence() {
    return sequence;
  }

  /**
   * Sets the value of the sequence property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setSequence(BigInteger value) {
    sequence = value;
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
    compartment = value;
  }

  /**
   * Gets the value of the contains property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getContains() {
    return contains;
  }

  /**
   * Sets the value of the contains property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setContains(BigInteger value) {
    contains = value;
  }

  /**
   * Gets the value of the parallel property.
   *
   * @return possible object is {@link String }
   */
  public String getParallel() {
    return parallel;
  }

  /**
   * Sets the value of the parallel property.
   *
   * @param value allowed object is {@link String }
   */
  public void setParallel(String value) {
    parallel = value;
  }

  /**
   * Gets the value of the source property.
   *
   * @return possible object is {@link String }
   */
  public String getSource() {
    return source;
  }

  /**
   * Sets the value of the source property.
   *
   * @param value allowed object is {@link String }
   */
  public void setSource(String value) {
    source = value;
  }

}
