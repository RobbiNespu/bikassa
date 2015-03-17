
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for query-flags complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="query-flags">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ghost" type="{}query-ghost"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "query-flags", propOrder = {

})
public class QueryFlags
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected QueryGhost ghost;

    /**
     * Gets the value of the ghost property.
     * 
     * @return
     *     possible object is
     *     {@link QueryGhost }
     *     
     */
    public QueryGhost getGhost() {
        return ghost;
    }

    /**
     * Sets the value of the ghost property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryGhost }
     *     
     */
    public void setGhost(QueryGhost value) {
        ghost = value;
    }

}
