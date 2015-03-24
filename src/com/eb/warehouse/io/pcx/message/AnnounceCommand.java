package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for announce-command complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="announce-command">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="red-lamp" type="{}announce-red-lamp" minOccurs="0"/>
 *         &lt;element name="yellow-lamp" type="{}announce-yellow-lamp" minOccurs="0"/>
 *         &lt;element name="green-lamp" type="{}announce-green-lamp" minOccurs="0"/>
 *         &lt;element name="logondata" type="{}announce-logondata" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-command", propOrder = {

})
public class AnnounceCommand
    implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "red-lamp")
  protected AnnounceRedLamp redLamp;
  @XmlElement(name = "yellow-lamp")
  protected AnnounceYellowLamp yellowLamp;
  @XmlElement(name = "green-lamp")
  protected AnnounceGreenLamp greenLamp;
  protected AnnounceLogondata logondata;

  /**
   * Gets the value of the redLamp property.
   *
   * @return possible object is {@link AnnounceRedLamp }
   */
  public AnnounceRedLamp getRedLamp() {
    return redLamp;
  }

  /**
   * Sets the value of the redLamp property.
   *
   * @param value allowed object is {@link AnnounceRedLamp }
   */
  public void setRedLamp(AnnounceRedLamp value) {
    redLamp = value;
  }

  /**
   * Gets the value of the yellowLamp property.
   *
   * @return possible object is {@link AnnounceYellowLamp }
   */
  public AnnounceYellowLamp getYellowLamp() {
    return yellowLamp;
  }

  /**
   * Sets the value of the yellowLamp property.
   *
   * @param value allowed object is {@link AnnounceYellowLamp }
   */
  public void setYellowLamp(AnnounceYellowLamp value) {
    yellowLamp = value;
  }

  /**
   * Gets the value of the greenLamp property.
   *
   * @return possible object is {@link AnnounceGreenLamp }
   */
  public AnnounceGreenLamp getGreenLamp() {
    return greenLamp;
  }

  /**
   * Sets the value of the greenLamp property.
   *
   * @param value allowed object is {@link AnnounceGreenLamp }
   */
  public void setGreenLamp(AnnounceGreenLamp value) {
    greenLamp = value;
  }

  /**
   * Gets the value of the logondata property.
   *
   * @return possible object is {@link AnnounceLogondata }
   */
  public AnnounceLogondata getLogondata() {
    return logondata;
  }

  /**
   * Sets the value of the logondata property.
   *
   * @param value allowed object is {@link AnnounceLogondata }
   */
  public void setLogondata(AnnounceLogondata value) {
    logondata = value;
  }

}
