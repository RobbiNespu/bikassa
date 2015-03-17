
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for announce-order complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="operations" type="{}announce-operations" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="tub" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="last" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="testmode" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-order", propOrder = {

})
public class AnnounceOrder
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected AnnounceOperations operations;
    @XmlAttribute(name = "tub")
    protected String tub;
    @XmlAttribute(name = "type")
    protected BigInteger type;
    @XmlAttribute(name = "last")
    protected Boolean last;
    @XmlAttribute(name = "testmode")
    protected BigInteger testmode;

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link AnnounceOperations }
     *     
     */
    public AnnounceOperations getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnounceOperations }
     *     
     */
    public void setOperations(AnnounceOperations value) {
        operations = value;
    }

    /**
     * Gets the value of the tub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTub() {
        return tub;
    }

    /**
     * Sets the value of the tub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTub(String value) {
        tub = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setType(BigInteger value) {
        type = value;
    }

    /**
     * Gets the value of the last property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLast() {
        return last;
    }

    /**
     * Sets the value of the last property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLast(Boolean value) {
        last = value;
    }

    /**
     * Gets the value of the testmode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTestmode() {
        return testmode;
    }

    /**
     * Sets the value of the testmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTestmode(BigInteger value) {
        testmode = value;
    }

}
