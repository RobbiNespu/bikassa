
package com.eb.warehouse.io.pcx.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for action complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="action">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="reboot" type="{}action-reboot" minOccurs="0"/>
 *         &lt;element name="restart" type="{}action-restart" minOccurs="0"/>
 *         &lt;element name="reset" type="{}action-reset" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "action", propOrder = {

})
@XmlRootElement(name = "action")
public class Action
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected ActionReboot reboot;
    protected ActionRestart restart;
    protected ActionReset reset;

    /**
     * Gets the value of the reboot property.
     * 
     * @return
     *     possible object is
     *     {@link ActionReboot }
     *     
     */
    public ActionReboot getReboot() {
        return reboot;
    }

    /**
     * Sets the value of the reboot property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionReboot }
     *     
     */
    public void setReboot(ActionReboot value) {
        reboot = value;
    }

    /**
     * Gets the value of the restart property.
     * 
     * @return
     *     possible object is
     *     {@link ActionRestart }
     *     
     */
    public ActionRestart getRestart() {
        return restart;
    }

    /**
     * Sets the value of the restart property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionRestart }
     *     
     */
    public void setRestart(ActionRestart value) {
        restart = value;
    }

    /**
     * Gets the value of the reset property.
     * 
     * @return
     *     possible object is
     *     {@link ActionReset }
     *     
     */
    public ActionReset getReset() {
        return reset;
    }

    /**
     * Sets the value of the reset property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionReset }
     *     
     */
    public void setReset(ActionReset value) {
        reset = value;
    }

}
