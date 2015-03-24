package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for request complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="status" type="{}status" minOccurs="0"/>
 *         &lt;element name="listen-io" type="{}request-listen-io" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "request", propOrder = {

})
@XmlRootElement(name = "request")
public class Request
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected Status status;
  @XmlElement(name = "listen-io")
  protected RequestListenIo listenIo;

  /**
   * Gets the value of the status property.
   *
   * @return possible object is {@link Status }
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Sets the value of the status property.
   *
   * @param value allowed object is {@link Status }
   */
  public void setStatus(Status value) {
    this.status = value;
  }

  /**
   * Gets the value of the listenIo property.
   *
   * @return possible object is {@link RequestListenIo }
   */
  public RequestListenIo getListenIo() {
    return listenIo;
  }

  /**
   * Sets the value of the listenIo property.
   *
   * @param value allowed object is {@link RequestListenIo }
   */
  public void setListenIo(RequestListenIo value) {
    this.listenIo = value;
  }

}
