
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-completion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response-completion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operations" type="{}response-operations" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="tub" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="location" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="testmode" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-completion", propOrder = {
    "operations"
})
public class ResponseCompletion
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected List<ResponseOperations> operations;
    @XmlAttribute(name = "tub")
    protected String tub;
    @XmlAttribute(name = "location")
    protected String location;
    @XmlAttribute(name = "type")
    protected BigInteger type;
    @XmlAttribute(name = "orientation")
    protected BigInteger orientation;
    @XmlAttribute(name = "testmode")
    protected BigInteger testmode;

    /**
     * Gets the value of the operations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseOperations }
     * 
     * 
     */
    public List<ResponseOperations> getOperations() {
        if (operations == null) {
            operations = new ArrayList<ResponseOperations>();
        }
        return this.operations;
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
        this.tub = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
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
        this.type = value;
    }

    /**
     * Gets the value of the orientation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrientation(BigInteger value) {
        this.orientation = value;
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
        this.testmode = value;
    }

}
