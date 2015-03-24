package com.eb.warehouse.io.pcx.message;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p> Java class for announce complex type. <p> The following schema fragment specifies the
 * expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="announce">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="station" type="{}announce-station" minOccurs="0"/>
 *         &lt;element name="labeling" type="{}announce-labeling" minOccurs="0"/>
 *         &lt;element name="bb" type="{}announce-bb" minOccurs="0"/>
 *         &lt;element name="ptt" type="{}announce-ptt" minOccurs="0"/>
 *         &lt;element name="compare" type="{}announce-compare" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce", propOrder = {"compare", "ptt", "bb", "labeling", "station"})
@XmlRootElement(name = "announce")
public class Announce implements Serializable {

  private final static long serialVersionUID = 1L;
  protected AnnounceCompare compare;
  protected AnnouncePtt ptt;
  protected AnnounceBb bb;
  protected AnnounceLabeling labeling;
  protected AnnounceStation station;

  /**
   * Gets the value of the compare property.
   *
   * @return possible object is {@link AnnounceCompare }
   */
  public AnnounceCompare getCompare() {
    return compare;
  }

  /**
   * Sets the value of the compare property.
   *
   * @param value allowed object is {@link AnnounceCompare }
   */
  public void setCompare(AnnounceCompare value) {
    compare = value;
  }

  /**
   * Gets the value of the ptt property.
   *
   * @return possible object is {@link AnnouncePtt }
   */
  public AnnouncePtt getPtt() {
    return ptt;
  }

  /**
   * Sets the value of the ptt property.
   *
   * @param value allowed object is {@link AnnouncePtt }
   */
  public void setPtt(AnnouncePtt value) {
    ptt = value;
  }

  /**
   * Gets the value of the bb property.
   *
   * @return possible object is {@link AnnounceBb }
   */
  public AnnounceBb getBb() {
    return bb;
  }

  /**
   * Sets the value of the bb property.
   *
   * @param value allowed object is {@link AnnounceBb }
   */
  public void setBb(AnnounceBb value) {
    bb = value;
  }

  /**
   * Gets the value of the labeling property.
   *
   * @return possible object is {@link AnnounceLabeling }
   */
  public AnnounceLabeling getLabeling() {
    return labeling;
  }

  /**
   * Sets the value of the labeling property.
   *
   * @param value allowed object is {@link AnnounceLabeling }
   */
  public void setLabeling(AnnounceLabeling value) {
    labeling = value;
  }

  /**
   * Gets the value of the station property.
   *
   * @return possible object is {@link AnnounceStation }
   */
  public AnnounceStation getStation() {
    return station;
  }

  /**
   * Sets the value of the station property.
   *
   * @param value allowed object is {@link AnnounceStation }
   */
  public void setStation(AnnounceStation value) {
    station = value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("station", station)
        .add("labeling", labeling)
        .add("bb", bb)
        .add("ptt", ptt)
        .add("compare", compare)
        .omitNullValues()
        .toString();
  }
}