
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-dimdirect complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="status-dimdirect">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="loads" type="{}status-loads" minOccurs="0"/>
 *         &lt;element name="manual-loading" type="{}status-manual-loading" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-dimdirect", propOrder = {

})
public class StatusDimdirect
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected StatusLoads loads;
    @XmlElement(name = "manual-loading")
    protected StatusManualLoading manualLoading;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the loads property.
     * 
     * @return
     *     possible object is
     *     {@link StatusLoads }
     *     
     */
    public StatusLoads getLoads() {
        return loads;
    }

    /**
     * Sets the value of the loads property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusLoads }
     *     
     */
    public void setLoads(StatusLoads value) {
        this.loads = value;
    }

    /**
     * Gets the value of the manualLoading property.
     * 
     * @return
     *     possible object is
     *     {@link StatusManualLoading }
     *     
     */
    public StatusManualLoading getManualLoading() {
        return manualLoading;
    }

    /**
     * Sets the value of the manualLoading property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusManualLoading }
     *     
     */
    public void setManualLoading(StatusManualLoading value) {
        this.manualLoading = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
