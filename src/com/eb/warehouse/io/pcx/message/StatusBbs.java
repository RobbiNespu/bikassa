
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-bbs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="status-bbs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bb" type="{}status-bb" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-bbs", propOrder = {
    "bbs"
})
public class StatusBbs
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "bb")
    protected List<StatusBb> bbs;

    /**
     * Gets the value of the bbs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bbs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBbs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusBb }
     * 
     * 
     */
    public List<StatusBb> getBbs() {
        if (bbs == null) {
            bbs = new ArrayList<StatusBb>();
        }
        return this.bbs;
    }

}
