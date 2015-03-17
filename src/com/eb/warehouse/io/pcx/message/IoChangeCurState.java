
package com.eb.warehouse.io.pcx.message;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for io-change-cur-state.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="io-change-cur-state">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="high"/>
 *     &lt;enumeration value="low"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "io-change-cur-state")
@XmlEnum
public enum IoChangeCurState {

    @XmlEnumValue("high")
    HIGH("high"),
    @XmlEnumValue("low")
    LOW("low");
    private final String value;

    IoChangeCurState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IoChangeCurState fromValue(String v) {
        for (IoChangeCurState c: IoChangeCurState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
