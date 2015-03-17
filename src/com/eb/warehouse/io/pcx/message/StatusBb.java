
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-bb complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="status-bb">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="tray" type="{}status-tray" minOccurs="0"/>
 *         &lt;element name="loading" type="{}status-loading" minOccurs="0"/>
 *         &lt;element name="devices" type="{}status-devices" minOccurs="0"/>
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
@XmlType(name = "status-bb", propOrder = {

})
public class StatusBb
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected StatusTray tray;
    protected StatusLoading loading;
    protected StatusDevices devices;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the tray property.
     * 
     * @return
     *     possible object is
     *     {@link StatusTray }
     *     
     */
    public StatusTray getTray() {
        return tray;
    }

    /**
     * Sets the value of the tray property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusTray }
     *     
     */
    public void setTray(StatusTray value) {
        this.tray = value;
    }

    /**
     * Gets the value of the loading property.
     * 
     * @return
     *     possible object is
     *     {@link StatusLoading }
     *     
     */
    public StatusLoading getLoading() {
        return loading;
    }

    /**
     * Sets the value of the loading property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusLoading }
     *     
     */
    public void setLoading(StatusLoading value) {
        this.loading = value;
    }

    /**
     * Gets the value of the devices property.
     * 
     * @return
     *     possible object is
     *     {@link StatusDevices }
     *     
     */
    public StatusDevices getDevices() {
        return devices;
    }

    /**
     * Sets the value of the devices property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusDevices }
     *     
     */
    public void setDevices(StatusDevices value) {
        this.devices = value;
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
