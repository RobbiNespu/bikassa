
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for announce-job complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-job">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="file" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sheets" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-job")
public class AnnounceJob implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlAttribute(name = "mode")
  protected String mode;
  @XmlAttribute(name = "type")
  protected String type;
  @XmlAttribute(name = "barcode")
  protected String barcode;
  @XmlAttribute(name = "file")
  protected String file;
  @XmlAttribute(name = "sheets")
  protected BigInteger sheets;

  /**
   * Gets the value of the mode property.
   * 
   * @return possible object is {@link String }
   */
  public String getMode() {
    return mode;
  }

  /**
   * Sets the value of the mode property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setMode(String value) {
    mode = value;
  }

  /**
   * Gets the value of the type property.
   * 
   * @return possible object is {@link String }
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the value of the type property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setType(String value) {
    type = value;
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
   * Gets the value of the file property.
   * 
   * @return possible object is {@link String }
   */
  public String getFile() {
    return file;
  }

  /**
   * Sets the value of the file property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setFile(String value) {
    file = value;
  }

  /**
   * Gets the value of the sheets property.
   * 
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getSheets() {
    return sheets;
  }

  /**
   * Sets the value of the sheets property.
   * 
   * @param value allowed object is {@link BigInteger }
   */
  public void setSheets(BigInteger value) {
    sheets = value;
  }

}