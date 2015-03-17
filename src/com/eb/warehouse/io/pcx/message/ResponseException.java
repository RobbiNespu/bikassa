
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-exception complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response-exception">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="flags" type="{}response-flags" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="object" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="idfyer" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="destlocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-exception", propOrder = {

})
public class ResponseException
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected ResponseFlags flags;
    @XmlAttribute(name = "object")
    protected String object;
    @XmlAttribute(name = "idfyer")
    protected String idfyer;
    @XmlAttribute(name = "destlocation")
    protected String destlocation;

    /**
     * Gets the value of the flags property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseFlags }
     *     
     */
    public ResponseFlags getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseFlags }
     *     
     */
    public void setFlags(ResponseFlags value) {
        this.flags = value;
    }

    /**
     * Gets the value of the object property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the value of the object property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObject(String value) {
        this.object = value;
    }

    /**
     * Gets the value of the idfyer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdfyer() {
        return idfyer;
    }

    /**
     * Sets the value of the idfyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdfyer(String value) {
        this.idfyer = value;
    }

    /**
     * Gets the value of the destlocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestlocation() {
        return destlocation;
    }

    /**
     * Sets the value of the destlocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestlocation(String value) {
        this.destlocation = value;
    }

}
