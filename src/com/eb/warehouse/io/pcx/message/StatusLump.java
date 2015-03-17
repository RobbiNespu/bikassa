
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-lump complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="status-lump">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="info" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="error" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lost" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="crash" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="blocked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="error-signal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="motor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="readerr" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="off" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-lump")
public class StatusLump
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "info")
    protected String info;
    @XmlAttribute(name = "state")
    protected String state;
    @XmlAttribute(name = "error")
    protected Boolean error;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "lost")
    protected String lost;
    @XmlAttribute(name = "crash")
    protected Boolean crash;
    @XmlAttribute(name = "blocked")
    protected Boolean blocked;
    @XmlAttribute(name = "error-signal")
    protected Boolean errorSignal;
    @XmlAttribute(name = "motor")
    protected String motor;
    @XmlAttribute(name = "readerr")
    protected Boolean readerr;
    @XmlAttribute(name = "box")
    protected String box;
    @XmlAttribute(name = "off")
    protected Boolean off;
    @XmlAttribute(name = "order")
    protected String order;

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

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setError(Boolean value) {
        this.error = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the lost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLost() {
        return lost;
    }

    /**
     * Sets the value of the lost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLost(String value) {
        this.lost = value;
    }

    /**
     * Gets the value of the crash property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrash() {
        return crash;
    }

    /**
     * Sets the value of the crash property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrash(Boolean value) {
        this.crash = value;
    }

    /**
     * Gets the value of the blocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlocked(Boolean value) {
        this.blocked = value;
    }

    /**
     * Gets the value of the errorSignal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isErrorSignal() {
        return errorSignal;
    }

    /**
     * Sets the value of the errorSignal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setErrorSignal(Boolean value) {
        this.errorSignal = value;
    }

    /**
     * Gets the value of the motor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotor() {
        return motor;
    }

    /**
     * Sets the value of the motor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotor(String value) {
        this.motor = value;
    }

    /**
     * Gets the value of the readerr property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReaderr() {
        return readerr;
    }

    /**
     * Sets the value of the readerr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReaderr(Boolean value) {
        this.readerr = value;
    }

    /**
     * Gets the value of the box property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBox() {
        return box;
    }

    /**
     * Sets the value of the box property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBox(String value) {
        this.box = value;
    }

    /**
     * Gets the value of the off property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOff() {
        return off;
    }

    /**
     * Sets the value of the off property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOff(Boolean value) {
        this.off = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

}
