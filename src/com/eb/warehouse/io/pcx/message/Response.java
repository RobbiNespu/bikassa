package com.eb.warehouse.io.pcx.message;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p> Java class for response complex type. <p> The following schema fragment specifies the
 * expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="station" type="{}response-station" minOccurs="0"/>
 *         &lt;element name="bb" type="{}response-bb" minOccurs="0"/>
 *         &lt;element name="query" type="{}response-query" minOccurs="0"/>
 *         &lt;element name="labeling" type="{}response-labeling" minOccurs="0"/>
 *         &lt;element name="ptt" type="{}response-ptt" minOccurs="0"/>
 *         &lt;element name="listen-io" type="{}response-listen-io" minOccurs="0"/>
 *         &lt;element name="compare" type="{}response-compare" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {"compare", "listenIo", "ptt", "labeling", "query", "bb",
                                         "station"})
@XmlRootElement(name = "response")
public class Response implements Serializable {

  private final static long serialVersionUID = 1L;
  protected ResponseCompare compare;
  @XmlElement(name = "listen-io")
  protected ResponseListenIo listenIo;
  protected ResponsePtt ptt;
  protected ResponseLabeling labeling;
  protected ResponseQuery query;
  protected ResponseBb bb;
  protected ResponseStation station;

  /**
   * Gets the value of the compare property.
   *
   * @return possible object is {@link ResponseCompare }
   */
  public ResponseCompare getCompare() {
    return compare;
  }

  /**
   * Sets the value of the compare property.
   *
   * @param value allowed object is {@link ResponseCompare }
   */
  public void setCompare(ResponseCompare value) {
    compare = value;
  }

  /**
   * Gets the value of the listenIo property.
   *
   * @return possible object is {@link ResponseListenIo }
   */
  public ResponseListenIo getListenIo() {
    return listenIo;
  }

  /**
   * Sets the value of the listenIo property.
   *
   * @param value allowed object is {@link ResponseListenIo }
   */
  public void setListenIo(ResponseListenIo value) {
    listenIo = value;
  }

  /**
   * Gets the value of the ptt property.
   *
   * @return possible object is {@link ResponsePtt }
   */
  public ResponsePtt getPtt() {
    return ptt;
  }

  /**
   * Sets the value of the ptt property.
   *
   * @param value allowed object is {@link ResponsePtt }
   */
  public void setPtt(ResponsePtt value) {
    ptt = value;
  }

  /**
   * Gets the value of the labeling property.
   *
   * @return possible object is {@link ResponseLabeling }
   */
  public ResponseLabeling getLabeling() {
    return labeling;
  }

  /**
   * Sets the value of the labeling property.
   *
   * @param value allowed object is {@link ResponseLabeling }
   */
  public void setLabeling(ResponseLabeling value) {
    labeling = value;
  }

  /**
   * Gets the value of the query property.
   *
   * @return possible object is {@link ResponseQuery }
   */
  public ResponseQuery getQuery() {
    return query;
  }

  /**
   * Sets the value of the query property.
   *
   * @param value allowed object is {@link ResponseQuery }
   */
  public void setQuery(ResponseQuery value) {
    query = value;
  }

  /**
   * Gets the value of the bb property.
   *
   * @return possible object is {@link ResponseBb }
   */
  public ResponseBb getBb() {
    return bb;
  }

  /**
   * Sets the value of the bb property.
   *
   * @param value allowed object is {@link ResponseBb }
   */
  public void setBb(ResponseBb value) {
    bb = value;
  }

  /**
   * Gets the value of the station property.
   *
   * @return possible object is {@link ResponseStation }
   */
  public ResponseStation getStation() {
    return station;
  }

  /**
   * Sets the value of the station property.
   *
   * @param value allowed object is {@link ResponseStation }
   */
  public void setStation(ResponseStation value) {
    station = value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("station", station)
        .add("query", query)
        .add("labeling", labeling)
        .add("bb", bb)
        .add("ptt", ptt)
        .add("compare", compare)
        .add("listenIo", listenIo)
        .omitNullValues()
        .toString();
  }
}
