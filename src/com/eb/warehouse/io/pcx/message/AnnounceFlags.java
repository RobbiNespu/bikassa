package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for announce-flags complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="announce-flags">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="doublebox" type="{}announce-doublebox" minOccurs="0"/>
 *         &lt;element name="label" type="{}announce-flagslabel" minOccurs="0"/>
 *         &lt;element name="rena" type="{}announce-rena" minOccurs="0"/>
 *         &lt;element name="skip" type="{}announce-skip" minOccurs="0"/>
 *         &lt;element name="once" type="{}announce-once" minOccurs="0"/>
 *         &lt;element name="unchangeable" type="{}announce-unchangeable" minOccurs="0"/>
 *         &lt;element name="lid" type="{}announce-lid" minOccurs="0"/>
 *         &lt;element name="strap" type="{}announce-strap" minOccurs="0"/>
 *         &lt;element name="urgent" type="{}announce-urgent" minOccurs="0"/>
 *         &lt;element name="action1" type="{}announce-action1" minOccurs="0"/>
 *         &lt;element name="action2" type="{}announce-action2" minOccurs="0"/>
 *         &lt;element name="action3" type="{}announce-action3" minOccurs="0"/>
 *         &lt;element name="button" type="{}announce-button" minOccurs="0"/>
 *         &lt;element name="invoice" type="{}announce-invoice" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-flags", propOrder = {

})
public class AnnounceFlags
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected AnnounceDoublebox doublebox;
  protected AnnounceFlagslabel label;
  protected AnnounceRena rena;
  protected AnnounceSkip skip;
  protected AnnounceOnce once;
  protected AnnounceUnchangeable unchangeable;
  protected AnnounceLid lid;
  protected AnnounceStrap strap;
  protected AnnounceUrgent urgent;
  protected AnnounceAction1 action1;
  protected AnnounceAction2 action2;
  protected AnnounceAction3 action3;
  protected AnnounceButton button;
  protected AnnounceInvoice invoice;

  /**
   * Gets the value of the doublebox property.
   *
   * @return possible object is {@link AnnounceDoublebox }
   */
  public AnnounceDoublebox getDoublebox() {
    return doublebox;
  }

  /**
   * Sets the value of the doublebox property.
   *
   * @param value allowed object is {@link AnnounceDoublebox }
   */
  public void setDoublebox(AnnounceDoublebox value) {
    doublebox = value;
  }

  /**
   * Gets the value of the label property.
   *
   * @return possible object is {@link AnnounceFlagslabel }
   */
  public AnnounceFlagslabel getLabel() {
    return label;
  }

  /**
   * Sets the value of the label property.
   *
   * @param value allowed object is {@link AnnounceFlagslabel }
   */
  public void setLabel(AnnounceFlagslabel value) {
    label = value;
  }

  /**
   * Gets the value of the rena property.
   *
   * @return possible object is {@link AnnounceRena }
   */
  public AnnounceRena getRena() {
    return rena;
  }

  /**
   * Sets the value of the rena property.
   *
   * @param value allowed object is {@link AnnounceRena }
   */
  public void setRena(AnnounceRena value) {
    rena = value;
  }

  /**
   * Gets the value of the skip property.
   *
   * @return possible object is {@link AnnounceSkip }
   */
  public AnnounceSkip getSkip() {
    return skip;
  }

  /**
   * Sets the value of the skip property.
   *
   * @param value allowed object is {@link AnnounceSkip }
   */
  public void setSkip(AnnounceSkip value) {
    skip = value;
  }

  /**
   * Gets the value of the once property.
   *
   * @return possible object is {@link AnnounceOnce }
   */
  public AnnounceOnce getOnce() {
    return once;
  }

  /**
   * Sets the value of the once property.
   *
   * @param value allowed object is {@link AnnounceOnce }
   */
  public void setOnce(AnnounceOnce value) {
    once = value;
  }

  /**
   * Gets the value of the unchangeable property.
   *
   * @return possible object is {@link AnnounceUnchangeable }
   */
  public AnnounceUnchangeable getUnchangeable() {
    return unchangeable;
  }

  /**
   * Sets the value of the unchangeable property.
   *
   * @param value allowed object is {@link AnnounceUnchangeable }
   */
  public void setUnchangeable(AnnounceUnchangeable value) {
    unchangeable = value;
  }

  /**
   * Gets the value of the lid property.
   *
   * @return possible object is {@link AnnounceLid }
   */
  public AnnounceLid getLid() {
    return lid;
  }

  /**
   * Sets the value of the lid property.
   *
   * @param value allowed object is {@link AnnounceLid }
   */
  public void setLid(AnnounceLid value) {
    lid = value;
  }

  /**
   * Gets the value of the strap property.
   *
   * @return possible object is {@link AnnounceStrap }
   */
  public AnnounceStrap getStrap() {
    return strap;
  }

  /**
   * Sets the value of the strap property.
   *
   * @param value allowed object is {@link AnnounceStrap }
   */
  public void setStrap(AnnounceStrap value) {
    strap = value;
  }

  /**
   * Gets the value of the urgent property.
   *
   * @return possible object is {@link AnnounceUrgent }
   */
  public AnnounceUrgent getUrgent() {
    return urgent;
  }

  /**
   * Sets the value of the urgent property.
   *
   * @param value allowed object is {@link AnnounceUrgent }
   */
  public void setUrgent(AnnounceUrgent value) {
    urgent = value;
  }

  /**
   * Gets the value of the action1 property.
   *
   * @return possible object is {@link AnnounceAction1 }
   */
  public AnnounceAction1 getAction1() {
    return action1;
  }

  /**
   * Sets the value of the action1 property.
   *
   * @param value allowed object is {@link AnnounceAction1 }
   */
  public void setAction1(AnnounceAction1 value) {
    action1 = value;
  }

  /**
   * Gets the value of the action2 property.
   *
   * @return possible object is {@link AnnounceAction2 }
   */
  public AnnounceAction2 getAction2() {
    return action2;
  }

  /**
   * Sets the value of the action2 property.
   *
   * @param value allowed object is {@link AnnounceAction2 }
   */
  public void setAction2(AnnounceAction2 value) {
    action2 = value;
  }

  /**
   * Gets the value of the action3 property.
   *
   * @return possible object is {@link AnnounceAction3 }
   */
  public AnnounceAction3 getAction3() {
    return action3;
  }

  /**
   * Sets the value of the action3 property.
   *
   * @param value allowed object is {@link AnnounceAction3 }
   */
  public void setAction3(AnnounceAction3 value) {
    action3 = value;
  }

  /**
   * Gets the value of the button property.
   *
   * @return possible object is {@link AnnounceButton }
   */
  public AnnounceButton getButton() {
    return button;
  }

  /**
   * Sets the value of the button property.
   *
   * @param value allowed object is {@link AnnounceButton }
   */
  public void setButton(AnnounceButton value) {
    button = value;
  }

  /**
   * Gets the value of the invoice property.
   *
   * @return possible object is {@link AnnounceInvoice }
   */
  public AnnounceInvoice getInvoice() {
    return invoice;
  }

  /**
   * Sets the value of the invoice property.
   *
   * @param value allowed object is {@link AnnounceInvoice }
   */
  public void setInvoice(AnnounceInvoice value) {
    invoice = value;
  }

}
