
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
 * <p>
 * Java class for announce-bb complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-bb">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="job" type="{}announce-job" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-bb", propOrder = {"jobs"})
public class AnnounceBb implements Serializable {

  private final static long serialVersionUID = 1L;
  @XmlElement(name = "job")
  protected List<AnnounceJob> jobs;
  @XmlAttribute(name = "from")
  protected String from;
  @XmlAttribute(name = "box")
  protected String box;
  @XmlAttribute(name = "order")
  protected String order;

  /**
   * Gets the value of the jobs property.
   * <p>
   * This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the jobs property.
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getJobs().add(newItem);
   * </pre>
   * <p>
   * Objects of the following type(s) are allowed in the list {@link AnnounceJob }
   */
  public List<AnnounceJob> getJobs() {
    if (jobs == null) {
      jobs = new ArrayList<AnnounceJob>();
    }
    return jobs;
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

  /**
   * Gets the value of the box property.
   * 
   * @return possible object is {@link String }
   */
  public String getBox() {
    return box;
  }

  /**
   * Sets the value of the box property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setBox(String value) {
    box = value;
  }

  /**
   * Gets the value of the order property.
   * 
   * @return possible object is {@link String }
   */
  public String getOrder() {
    return order;
  }

  /**
   * Sets the value of the order property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setOrder(String value) {
    order = value;
  }

}