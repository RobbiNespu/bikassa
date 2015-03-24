package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="stations" type="{}status-stations" minOccurs="0"/>
 *         &lt;element name="reports" type="{}status-reports" minOccurs="0"/>
 *         &lt;element name="counters" type="{}status-counters" minOccurs="0"/>
 *         &lt;element name="bbs" type="{}status-bbs" minOccurs="0"/>
 *         &lt;element name="dimdirects" type="{}status-dimdirects" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="uptime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status", propOrder = {

})
@XmlRootElement(name = "status")
public class Status
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected StatusStations stations;
  protected StatusReports reports;
  protected StatusCounters counters;
  protected StatusBbs bbs;
  protected StatusDimdirects dimdirects;
  @XmlAttribute(name = "name")
  protected String name;
  @XmlAttribute(name = "version")
  protected String version;
  @XmlAttribute(name = "uptime")
  protected String uptime;

  /**
   * Gets the value of the stations property.
   *
   * @return possible object is {@link StatusStations }
   */
  public StatusStations getStations() {
    return stations;
  }

  /**
   * Sets the value of the stations property.
   *
   * @param value allowed object is {@link StatusStations }
   */
  public void setStations(StatusStations value) {
    this.stations = value;
  }

  /**
   * Gets the value of the reports property.
   *
   * @return possible object is {@link StatusReports }
   */
  public StatusReports getReports() {
    return reports;
  }

  /**
   * Sets the value of the reports property.
   *
   * @param value allowed object is {@link StatusReports }
   */
  public void setReports(StatusReports value) {
    this.reports = value;
  }

  /**
   * Gets the value of the counters property.
   *
   * @return possible object is {@link StatusCounters }
   */
  public StatusCounters getCounters() {
    return counters;
  }

  /**
   * Sets the value of the counters property.
   *
   * @param value allowed object is {@link StatusCounters }
   */
  public void setCounters(StatusCounters value) {
    this.counters = value;
  }

  /**
   * Gets the value of the bbs property.
   *
   * @return possible object is {@link StatusBbs }
   */
  public StatusBbs getBbs() {
    return bbs;
  }

  /**
   * Sets the value of the bbs property.
   *
   * @param value allowed object is {@link StatusBbs }
   */
  public void setBbs(StatusBbs value) {
    this.bbs = value;
  }

  /**
   * Gets the value of the dimdirects property.
   *
   * @return possible object is {@link StatusDimdirects }
   */
  public StatusDimdirects getDimdirects() {
    return dimdirects;
  }

  /**
   * Sets the value of the dimdirects property.
   *
   * @param value allowed object is {@link StatusDimdirects }
   */
  public void setDimdirects(StatusDimdirects value) {
    this.dimdirects = value;
  }

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the version property.
   *
   * @return possible object is {@link String }
   */
  public String getVersion() {
    return version;
  }

  /**
   * Sets the value of the version property.
   *
   * @param value allowed object is {@link String }
   */
  public void setVersion(String value) {
    this.version = value;
  }

  /**
   * Gets the value of the uptime property.
   *
   * @return possible object is {@link String }
   */
  public String getUptime() {
    return uptime;
  }

  /**
   * Sets the value of the uptime property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUptime(String value) {
    this.uptime = value;
  }

}
