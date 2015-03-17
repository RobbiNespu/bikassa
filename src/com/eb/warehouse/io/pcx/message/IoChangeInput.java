
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for io-change-input complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="io-change-input">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="device" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cur-state" type="{}io-change-cur-state" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "io-change-input")
public class IoChangeInput
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "device")
    protected String device;
    @XmlAttribute(name = "cur-state")
    protected IoChangeCurState curState;

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevice(String value) {
        device = value;
    }

    /**
     * Gets the value of the curState property.
     * 
     * @return
     *     possible object is
     *     {@link IoChangeCurState }
     *     
     */
    public IoChangeCurState getCurState() {
        return curState;
    }

    /**
     * Sets the value of the curState property.
     * 
     * @param value
     *     allowed object is
     *     {@link IoChangeCurState }
     *     
     */
    public void setCurState(IoChangeCurState value) {
        curState = value;
    }

}
