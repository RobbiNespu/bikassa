
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for announce-op complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-op">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pickorder" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="noof" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="destlocation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="desttote" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="desttub" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bulk" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="wmsid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="disable-lc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="destcomp" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="desttype" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="contains" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-op")
public class AnnounceOp
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "pickorder")
    protected BigInteger pickorder;
    @XmlAttribute(name = "noof")
    protected BigInteger noof;
    @XmlAttribute(name = "destlocation")
    protected String destlocation;
    @XmlAttribute(name = "desttote")
    protected String desttote;
    @XmlAttribute(name = "desttub")
    protected String desttub;
    @XmlAttribute(name = "bulk")
    protected String bulk;
    @XmlAttribute(name = "wmsid")
    protected String wmsid;
    @XmlAttribute(name = "disable-lc")
    protected String disableLc;
    @XmlAttribute(name = "destcomp")
    protected BigInteger destcomp;
    @XmlAttribute(name = "desttype")
    protected BigInteger desttype;
    @XmlAttribute(name = "contains")
    protected BigInteger contains;

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
        name = value;
    }

    /**
     * Gets the value of the pickorder property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPickorder() {
        return pickorder;
    }

    /**
     * Sets the value of the pickorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPickorder(BigInteger value) {
        pickorder = value;
    }

    /**
     * Gets the value of the noof property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNoof() {
        return noof;
    }

    /**
     * Sets the value of the noof property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNoof(BigInteger value) {
        noof = value;
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
        destlocation = value;
    }

    /**
     * Gets the value of the desttote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesttote() {
        return desttote;
    }

    /**
     * Sets the value of the desttote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesttote(String value) {
        desttote = value;
    }

    /**
     * Gets the value of the desttub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesttub() {
        return desttub;
    }

    /**
     * Sets the value of the desttub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesttub(String value) {
        desttub = value;
    }

    /**
     * Gets the value of the bulk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBulk() {
        return bulk;
    }

    /**
     * Sets the value of the bulk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBulk(String value) {
        bulk = value;
    }

    /**
     * Gets the value of the wmsid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWmsid() {
        return wmsid;
    }

    /**
     * Sets the value of the wmsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWmsid(String value) {
        wmsid = value;
    }

    /**
     * Gets the value of the disableLc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisableLc() {
        return disableLc;
    }

    /**
     * Sets the value of the disableLc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisableLc(String value) {
        disableLc = value;
    }

    /**
     * Gets the value of the destcomp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDestcomp() {
        return destcomp;
    }

    /**
     * Sets the value of the destcomp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDestcomp(BigInteger value) {
        destcomp = value;
    }

    /**
     * Gets the value of the desttype property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDesttype() {
        return desttype;
    }

    /**
     * Sets the value of the desttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDesttype(BigInteger value) {
        desttype = value;
    }

    /**
     * Gets the value of the contains property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getContains() {
        return contains;
    }

    /**
     * Sets the value of the contains property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setContains(BigInteger value) {
        contains = value;
    }

}
