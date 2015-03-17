
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-to complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response-to">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="target" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="at" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lump" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reason" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-to")
public class ResponseTo
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "target")
    protected String target;
    @XmlAttribute(name = "at")
    protected String at;
    @XmlAttribute(name = "lump")
    protected String lump;
    @XmlAttribute(name = "mode")
    protected String mode;
    @XmlAttribute(name = "reason")
    protected String reason;

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the at property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAt() {
        return at;
    }

    /**
     * Sets the value of the at property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAt(String value) {
        this.at = value;
    }

    /**
     * Gets the value of the lump property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLump() {
        return lump;
    }

    /**
     * Sets the value of the lump property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLump(String value) {
        this.lump = value;
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
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

}
