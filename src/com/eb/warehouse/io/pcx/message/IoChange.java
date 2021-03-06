package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for io-change complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="io-change">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="input" type="{}io-change-input" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "io-change", propOrder = {
    "inputs"
})
@XmlRootElement(name = "io-change")
public class IoChange
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "input", required = true)
  protected List<IoChangeInput> inputs;

  /**
   * Gets the value of the inputs property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the inputs property.
   *
   * <p> For example, to add a new item, do as follows:
   * <pre>
   *    getInputs().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IoChangeInput }
   */
  public List<IoChangeInput> getInputs() {
    if (inputs == null) {
      inputs = new ArrayList<IoChangeInput>();
    }
    return inputs;
  }

}
