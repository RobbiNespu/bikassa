
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for announce-logondata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="announce-logondata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="login-terminal" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="username" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="auth-medium" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announce-logondata")
public class AnnounceLogondata
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "login-terminal")
    protected String loginTerminal;
    @XmlAttribute(name = "username")
    protected String username;
    @XmlAttribute(name = "auth-medium")
    protected String authMedium;

    /**
     * Gets the value of the loginTerminal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginTerminal() {
        return loginTerminal;
    }

    /**
     * Sets the value of the loginTerminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginTerminal(String value) {
        loginTerminal = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        username = value;
    }

    /**
     * Gets the value of the authMedium property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthMedium() {
        return authMedium;
    }

    /**
     * Sets the value of the authMedium property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthMedium(String value) {
        authMedium = value;
    }

}
