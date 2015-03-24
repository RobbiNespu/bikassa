package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p> Java class for announce-ptt complex type. <p> The following schema fragment specifies the
 * expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="announce-ptt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="command" type="{}announce-command" minOccurs="0"/>
 *         &lt;element name="order" type="{}announce-order" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-ptt", propOrder = {"order", "command"})
public class AnnouncePtt implements Serializable {

  private final static long serialVersionUID = 1L;
  protected AnnounceOrder order;
  protected AnnounceCommand command;
  @XmlAttribute(name = "from")
  protected String from;

  /**
   * Gets the value of the order property.
   *
   * @return possible object is {@link AnnounceOrder }
   */
  public AnnounceOrder getOrder() {
    return order;
  }

  /**
   * Sets the value of the order property.
   *
   * @param value allowed object is {@link AnnounceOrder }
   */
  public void setOrder(AnnounceOrder value) {
    order = value;
  }

  /**
   * Gets the value of the command property.
   *
   * @return possible object is {@link AnnounceCommand }
   */
  public AnnounceCommand getCommand() {
    return command;
  }

  /**
   * Sets the value of the command property.
   *
   * @param value allowed object is {@link AnnounceCommand }
   */
  public void setCommand(AnnounceCommand value) {
    command = value;
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