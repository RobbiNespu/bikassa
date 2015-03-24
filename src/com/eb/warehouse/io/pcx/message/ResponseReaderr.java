package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-readerr complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-readerr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="reader" type="{}response-reader" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-readerr", propOrder = {

})
public class ResponseReaderr
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected ResponseReader reader;

  /**
   * Gets the value of the reader property.
   *
   * @return possible object is {@link ResponseReader }
   */
  public ResponseReader getReader() {
    return reader;
  }

  /**
   * Sets the value of the reader property.
   *
   * @param value allowed object is {@link ResponseReader }
   */
  public void setReader(ResponseReader value) {
    this.reader = value;
  }

}
