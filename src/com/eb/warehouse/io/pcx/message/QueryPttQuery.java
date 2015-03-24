package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for query-ptt-query complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="query-ptt-query">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="at" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query-ptt-query")
public class QueryPttQuery
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "box")
  protected String box;
  @XmlAttribute(name = "from")
  protected String from;
  @XmlAttribute(name = "at")
  protected String at;
  @XmlAttribute(name = "orientation")
  protected BigInteger orientation;

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
   * Gets the value of the at property.
   *
   * @return possible object is {@link String }
   */
  public String getAt() {
    return at;
  }

  /**
   * Sets the value of the at property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAt(String value) {
    at = value;
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
    orientation = value;
  }

}
