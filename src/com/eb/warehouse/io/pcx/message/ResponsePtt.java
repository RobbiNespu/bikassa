package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p> Java class for response-ptt complex type. <p> The following schema fragment specifies the
 * expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-ptt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="pickstart" type="{}response-pickstart" minOccurs="0"/>
 *         &lt;element name="completion" type="{}response-completion" minOccurs="0"/>
 *         &lt;element name="timing" type="{}response-timing" minOccurs="0"/>
 *         &lt;element name="exception" type="{}response-exception" maxOccurs="unbounded"
 * minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-ptt", propOrder = {"exceptions", "timing", "completion", "pickstart"})
public class ResponsePtt implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "exception")
  protected List<ResponseException> exceptions;
  protected ResponseTiming timing;
  protected ResponseCompletion completion;
  protected ResponsePickstart pickstart;
  @XmlAttribute(name = "from")
  protected String from;

  /**
   * Gets the value of the exceptions property. <p> This accessor method returns a reference to the
   * live list, not a snapshot. Therefore any modification you make to the returned list will be
   * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
   * exceptions property. <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getExceptions().add(newItem);
   * </pre>
   * <p> Objects of the following type(s) are allowed in the list {@link ResponseException }
   */
  public List<ResponseException> getExceptions() {
    if (exceptions == null) {
      exceptions = new ArrayList<ResponseException>();
    }
    return exceptions;
  }

  /**
   * Gets the value of the timing property.
   *
   * @return possible object is {@link ResponseTiming }
   */
  public ResponseTiming getTiming() {
    return timing;
  }

  /**
   * Sets the value of the timing property.
   *
   * @param value allowed object is {@link ResponseTiming }
   */
  public void setTiming(ResponseTiming value) {
    timing = value;
  }

  /**
   * Gets the value of the completion property.
   *
   * @return possible object is {@link ResponseCompletion }
   */
  public ResponseCompletion getCompletion() {
    return completion;
  }

  /**
   * Sets the value of the completion property.
   *
   * @param value allowed object is {@link ResponseCompletion }
   */
  public void setCompletion(ResponseCompletion value) {
    completion = value;
  }

  /**
   * Gets the value of the pickstart property.
   *
   * @return possible object is {@link ResponsePickstart }
   */
  public ResponsePickstart getPickstart() {
    return pickstart;
  }

  /**
   * Sets the value of the pickstart property.
   *
   * @param value allowed object is {@link ResponsePickstart }
   */
  public void setPickstart(ResponsePickstart value) {
    pickstart = value;
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

}