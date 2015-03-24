package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-dimdirects complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="status-dimdirects">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dimdirect" type="{}status-dimdirect" maxOccurs="unbounded"
 * minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-dimdirects", propOrder = {
    "dimdirects"
})
public class StatusDimdirects
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "dimdirect")
  protected List<StatusDimdirect> dimdirects;

  /**
   * Gets the value of the dimdirects property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the dimdirects property.
   *
   * <p> For example, to add a new item, do as follows:
   * <pre>
   *    getDimdirects().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link StatusDimdirect }
   */
  public List<StatusDimdirect> getDimdirects() {
    if (dimdirects == null) {
      dimdirects = new ArrayList<StatusDimdirect>();
    }
    return this.dimdirects;
  }

}
