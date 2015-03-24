package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-flags complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response-flags">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="readerr" type="{}response-readerr" minOccurs="0"/>
 *         &lt;element name="readwrong" type="{}response-readwrong" minOccurs="0"/>
 *         &lt;element name="readlabel" type="{}response-readlabel" minOccurs="0"/>
 *         &lt;element name="weight" type="{}response-weight" minOccurs="0"/>
 *         &lt;element name="lost" type="{}response-lost" minOccurs="0"/>
 *         &lt;element name="occupied" type="{}response-occupied" minOccurs="0"/>
 *         &lt;element name="ghost" type="{}response-ghost" minOccurs="0"/>
 *         &lt;element name="unknown" type="{}response-unknown" minOccurs="0"/>
 *         &lt;element name="skip" type="{}response-skip" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="full" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hospital" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="audit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="empty-dirty" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="filled-dirty" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="missing" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="short" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="removed" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-flags", propOrder = {

})
public class ResponseFlags
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected ResponseReaderr readerr;
  protected ResponseReadwrong readwrong;
  protected ResponseReadlabel readlabel;
  protected ResponseWeight weight;
  protected ResponseLost lost;
  protected ResponseOccupied occupied;
  protected ResponseGhost ghost;
  protected ResponseUnknown unknown;
  protected ResponseSkip skip;
  @XmlAttribute(name = "full")
  protected String full;
  @XmlAttribute(name = "hospital")
  protected String hospital;
  @XmlAttribute(name = "audit")
  protected String audit;
  @XmlAttribute(name = "empty-dirty")
  protected String emptyDirty;
  @XmlAttribute(name = "filled-dirty")
  protected String filledDirty;
  @XmlAttribute(name = "missing")
  protected String missing;
  @XmlAttribute(name = "short")
  protected String _short;
  @XmlAttribute(name = "removed")
  protected String removed;

  /**
   * Gets the value of the readerr property.
   *
   * @return possible object is {@link ResponseReaderr }
   */
  public ResponseReaderr getReaderr() {
    return readerr;
  }

  /**
   * Sets the value of the readerr property.
   *
   * @param value allowed object is {@link ResponseReaderr }
   */
  public void setReaderr(ResponseReaderr value) {
    this.readerr = value;
  }

  /**
   * Gets the value of the readwrong property.
   *
   * @return possible object is {@link ResponseReadwrong }
   */
  public ResponseReadwrong getReadwrong() {
    return readwrong;
  }

  /**
   * Sets the value of the readwrong property.
   *
   * @param value allowed object is {@link ResponseReadwrong }
   */
  public void setReadwrong(ResponseReadwrong value) {
    this.readwrong = value;
  }

  /**
   * Gets the value of the readlabel property.
   *
   * @return possible object is {@link ResponseReadlabel }
   */
  public ResponseReadlabel getReadlabel() {
    return readlabel;
  }

  /**
   * Sets the value of the readlabel property.
   *
   * @param value allowed object is {@link ResponseReadlabel }
   */
  public void setReadlabel(ResponseReadlabel value) {
    this.readlabel = value;
  }

  /**
   * Gets the value of the weight property.
   *
   * @return possible object is {@link ResponseWeight }
   */
  public ResponseWeight getWeight() {
    return weight;
  }

  /**
   * Sets the value of the weight property.
   *
   * @param value allowed object is {@link ResponseWeight }
   */
  public void setWeight(ResponseWeight value) {
    this.weight = value;
  }

  /**
   * Gets the value of the lost property.
   *
   * @return possible object is {@link ResponseLost }
   */
  public ResponseLost getLost() {
    return lost;
  }

  /**
   * Sets the value of the lost property.
   *
   * @param value allowed object is {@link ResponseLost }
   */
  public void setLost(ResponseLost value) {
    this.lost = value;
  }

  /**
   * Gets the value of the occupied property.
   *
   * @return possible object is {@link ResponseOccupied }
   */
  public ResponseOccupied getOccupied() {
    return occupied;
  }

  /**
   * Sets the value of the occupied property.
   *
   * @param value allowed object is {@link ResponseOccupied }
   */
  public void setOccupied(ResponseOccupied value) {
    this.occupied = value;
  }

  /**
   * Gets the value of the ghost property.
   *
   * @return possible object is {@link ResponseGhost }
   */
  public ResponseGhost getGhost() {
    return ghost;
  }

  /**
   * Sets the value of the ghost property.
   *
   * @param value allowed object is {@link ResponseGhost }
   */
  public void setGhost(ResponseGhost value) {
    this.ghost = value;
  }

  /**
   * Gets the value of the unknown property.
   *
   * @return possible object is {@link ResponseUnknown }
   */
  public ResponseUnknown getUnknown() {
    return unknown;
  }

  /**
   * Sets the value of the unknown property.
   *
   * @param value allowed object is {@link ResponseUnknown }
   */
  public void setUnknown(ResponseUnknown value) {
    this.unknown = value;
  }

  /**
   * Gets the value of the skip property.
   *
   * @return possible object is {@link ResponseSkip }
   */
  public ResponseSkip getSkip() {
    return skip;
  }

  /**
   * Sets the value of the skip property.
   *
   * @param value allowed object is {@link ResponseSkip }
   */
  public void setSkip(ResponseSkip value) {
    this.skip = value;
  }

  /**
   * Gets the value of the full property.
   *
   * @return possible object is {@link String }
   */
  public String getFull() {
    return full;
  }

  /**
   * Sets the value of the full property.
   *
   * @param value allowed object is {@link String }
   */
  public void setFull(String value) {
    this.full = value;
  }

  /**
   * Gets the value of the hospital property.
   *
   * @return possible object is {@link String }
   */
  public String getHospital() {
    return hospital;
  }

  /**
   * Sets the value of the hospital property.
   *
   * @param value allowed object is {@link String }
   */
  public void setHospital(String value) {
    this.hospital = value;
  }

  /**
   * Gets the value of the audit property.
   *
   * @return possible object is {@link String }
   */
  public String getAudit() {
    return audit;
  }

  /**
   * Sets the value of the audit property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAudit(String value) {
    this.audit = value;
  }

  /**
   * Gets the value of the emptyDirty property.
   *
   * @return possible object is {@link String }
   */
  public String getEmptyDirty() {
    return emptyDirty;
  }

  /**
   * Sets the value of the emptyDirty property.
   *
   * @param value allowed object is {@link String }
   */
  public void setEmptyDirty(String value) {
    this.emptyDirty = value;
  }

  /**
   * Gets the value of the filledDirty property.
   *
   * @return possible object is {@link String }
   */
  public String getFilledDirty() {
    return filledDirty;
  }

  /**
   * Sets the value of the filledDirty property.
   *
   * @param value allowed object is {@link String }
   */
  public void setFilledDirty(String value) {
    this.filledDirty = value;
  }

  /**
   * Gets the value of the missing property.
   *
   * @return possible object is {@link String }
   */
  public String getMissing() {
    return missing;
  }

  /**
   * Sets the value of the missing property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMissing(String value) {
    this.missing = value;
  }

  /**
   * Gets the value of the short property.
   *
   * @return possible object is {@link String }
   */
  public String getShort() {
    return _short;
  }

  /**
   * Sets the value of the short property.
   *
   * @param value allowed object is {@link String }
   */
  public void setShort(String value) {
    this._short = value;
  }

  /**
   * Gets the value of the removed property.
   *
   * @return possible object is {@link String }
   */
  public String getRemoved() {
    return removed;
  }

  /**
   * Sets the value of the removed property.
   *
   * @param value allowed object is {@link String }
   */
  public void setRemoved(String value) {
    this.removed = value;
  }

}
