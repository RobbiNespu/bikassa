package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for query complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="query">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ptt" type="{}query-ptt-query" minOccurs="0"/>
 *         &lt;element name="labeling" type="{}query-labeling" minOccurs="0"/>
 *         &lt;element name="bb" type="{}query-bb" minOccurs="0"/>
 *         &lt;element name="compare" type="{}query-compare" minOccurs="0"/>
 *         &lt;element name="stock-in" type="{}query-stock-in" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query", propOrder = {

})
@XmlRootElement(name = "query")
public class Query
    implements Serializable {

  private final static long serialVersionUID = 1L;
  protected QueryPttQuery ptt;
  protected QueryLabeling labeling;
  protected QueryBb bb;
  protected QueryCompare compare;
  @XmlElement(name = "stock-in")
  protected QueryStockIn stockIn;

  /**
   * Gets the value of the ptt property.
   *
   * @return possible object is {@link QueryPttQuery }
   */
  public QueryPttQuery getPtt() {
    return ptt;
  }

  /**
   * Sets the value of the ptt property.
   *
   * @param value allowed object is {@link QueryPttQuery }
   */
  public void setPtt(QueryPttQuery value) {
    ptt = value;
  }

  /**
   * Gets the value of the labeling property.
   *
   * @return possible object is {@link QueryLabeling }
   */
  public QueryLabeling getLabeling() {
    return labeling;
  }

  /**
   * Sets the value of the labeling property.
   *
   * @param value allowed object is {@link QueryLabeling }
   */
  public void setLabeling(QueryLabeling value) {
    labeling = value;
  }

  /**
   * Gets the value of the bb property.
   *
   * @return possible object is {@link QueryBb }
   */
  public QueryBb getBb() {
    return bb;
  }

  /**
   * Sets the value of the bb property.
   *
   * @param value allowed object is {@link QueryBb }
   */
  public void setBb(QueryBb value) {
    bb = value;
  }

  /**
   * Gets the value of the compare property.
   *
   * @return possible object is {@link QueryCompare }
   */
  public QueryCompare getCompare() {
    return compare;
  }

  /**
   * Sets the value of the compare property.
   *
   * @param value allowed object is {@link QueryCompare }
   */
  public void setCompare(QueryCompare value) {
    compare = value;
  }

  /**
   * Gets the value of the stockIn property.
   *
   * @return possible object is {@link QueryStockIn }
   */
  public QueryStockIn getStockIn() {
    return stockIn;
  }

  /**
   * Sets the value of the stockIn property.
   *
   * @param value allowed object is {@link QueryStockIn }
   */
  public void setStockIn(QueryStockIn value) {
    stockIn = value;
  }

}
