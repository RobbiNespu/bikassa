
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status-error complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="status-error">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="err-class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="need-conf" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="text" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "status-error")
public class StatusError
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "err-class")
    protected String errClass;
    @XmlAttribute(name = "need-conf")
    protected Boolean needConf;
    @XmlAttribute(name = "text")
    protected String text;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the errClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrClass() {
        return errClass;
    }

    /**
     * Sets the value of the errClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrClass(String value) {
        this.errClass = value;
    }

    /**
     * Gets the value of the needConf property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedConf() {
        return needConf;
    }

    /**
     * Sets the value of the needConf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedConf(Boolean value) {
        this.needConf = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
