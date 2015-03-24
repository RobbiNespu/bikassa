package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p> Java class for life complex type. <p> The following schema fragment specifies the expected
 * content contained within this class.
 *
 * <pre>
 * &lt;complexType name="life">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "life")
@XmlRootElement(name = "life")
public class Life implements Serializable {

  private final static long serialVersionUID = 1L;

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return Life.class.getSimpleName();
  }
}
