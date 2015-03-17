
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
 * <p>Java class for query-stock-in complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="query-stock-in">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="box" type="{}query-box" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status" type="{}query-state" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query-stock-in", propOrder = {
    "boxes"
})
public class QueryStockIn
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "box", required = true)
    protected List<QueryBox> boxes;
    @XmlAttribute(name = "from")
    protected String from;
    @XmlAttribute(name = "status")
    protected QueryState status;

    /**
     * Gets the value of the boxes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boxes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoxes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryBox }
     * 
     * 
     */
    public List<QueryBox> getBoxes() {
        if (boxes == null) {
            boxes = new ArrayList<QueryBox>();
        }
        return boxes;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        from = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link QueryState }
     *     
     */
    public QueryState getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryState }
     *     
     */
    public void setStatus(QueryState value) {
        status = value;
    }

}
