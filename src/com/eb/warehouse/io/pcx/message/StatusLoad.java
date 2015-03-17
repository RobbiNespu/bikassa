
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-load complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="status-load">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="buffer-tray" type="{}status-buffer-tray" minOccurs="0"/>
 *         &lt;element name="loading" type="{}status-loading" minOccurs="0"/>
 *         &lt;element name="printer" type="{}status-printer" minOccurs="0"/>
 *         &lt;element name="error-list" type="{}status-error-list" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cur-boxnum" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cur-ordernum" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-load", propOrder = {

})
public class StatusLoad
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "buffer-tray")
    protected StatusBufferTray bufferTray;
    protected StatusLoading loading;
    protected StatusPrinter printer;
    @XmlElement(name = "error-list")
    protected StatusErrorList errorList;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "state")
    protected String state;
    @XmlAttribute(name = "mode")
    protected String mode;
    @XmlAttribute(name = "cur-boxnum")
    protected String curBoxnum;
    @XmlAttribute(name = "cur-ordernum")
    protected String curOrdernum;

    /**
     * Gets the value of the bufferTray property.
     * 
     * @return
     *     possible object is
     *     {@link StatusBufferTray }
     *     
     */
    public StatusBufferTray getBufferTray() {
        return bufferTray;
    }

    /**
     * Sets the value of the bufferTray property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusBufferTray }
     *     
     */
    public void setBufferTray(StatusBufferTray value) {
        this.bufferTray = value;
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
     * Gets the value of the printer property.
     * 
     * @return
     *     possible object is
     *     {@link StatusPrinter }
     *     
     */
    public StatusPrinter getPrinter() {
        return printer;
    }

    /**
     * Sets the value of the printer property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusPrinter }
     *     
     */
    public void setPrinter(StatusPrinter value) {
        this.printer = value;
    }

    /**
     * Gets the value of the errorList property.
     * 
     * @return
     *     possible object is
     *     {@link StatusErrorList }
     *     
     */
    public StatusErrorList getErrorList() {
        return errorList;
    }

    /**
     * Sets the value of the errorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusErrorList }
     *     
     */
    public void setErrorList(StatusErrorList value) {
        this.errorList = value;
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
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * Gets the value of the curBoxnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurBoxnum() {
        return curBoxnum;
    }

    /**
     * Sets the value of the curBoxnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurBoxnum(String value) {
        this.curBoxnum = value;
    }

    /**
     * Gets the value of the curOrdernum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurOrdernum() {
        return curOrdernum;
    }

    /**
     * Sets the value of the curOrdernum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurOrdernum(String value) {
        this.curOrdernum = value;
    }

}
