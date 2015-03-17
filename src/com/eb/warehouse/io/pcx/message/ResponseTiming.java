
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-timing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response-timing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="time-order" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="time-pick" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="timing-count" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="timing-pack" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="timing-din" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="timing-dout" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response-timing")
public class ResponseTiming
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "time-order")
    protected BigInteger timeOrder;
    @XmlAttribute(name = "time-pick")
    protected BigInteger timePick;
    @XmlAttribute(name = "timing-count")
    protected BigInteger timingCount;
    @XmlAttribute(name = "timing-pack")
    protected BigInteger timingPack;
    @XmlAttribute(name = "timing-din")
    protected BigInteger timingDin;
    @XmlAttribute(name = "timing-dout")
    protected BigInteger timingDout;

    /**
     * Gets the value of the timeOrder property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeOrder() {
        return timeOrder;
    }

    /**
     * Sets the value of the timeOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeOrder(BigInteger value) {
        this.timeOrder = value;
    }

    /**
     * Gets the value of the timePick property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimePick() {
        return timePick;
    }

    /**
     * Sets the value of the timePick property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimePick(BigInteger value) {
        this.timePick = value;
    }

    /**
     * Gets the value of the timingCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimingCount() {
        return timingCount;
    }

    /**
     * Sets the value of the timingCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimingCount(BigInteger value) {
        this.timingCount = value;
    }

    /**
     * Gets the value of the timingPack property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimingPack() {
        return timingPack;
    }

    /**
     * Sets the value of the timingPack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimingPack(BigInteger value) {
        this.timingPack = value;
    }

    /**
     * Gets the value of the timingDin property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimingDin() {
        return timingDin;
    }

    /**
     * Sets the value of the timingDin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimingDin(BigInteger value) {
        this.timingDin = value;
    }

    /**
     * Gets the value of the timingDout property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimingDout() {
        return timingDout;
    }

    /**
     * Sets the value of the timingDout property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimingDout(BigInteger value) {
        this.timingDout = value;
    }

}
