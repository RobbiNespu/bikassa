
package com.eb.warehouse.io.pcx.message;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response-error.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="response-error">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="no-device"/>
 *     &lt;enumeration value="invalid"/>
 *     &lt;enumeration value="listen-fail"/>
 *     &lt;enumeration value="double"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "response-error")
@XmlEnum
public enum ResponseError {

    @XmlEnumValue("no-device")
    NO_DEVICE("no-device"),
    @XmlEnumValue("invalid")
    INVALID("invalid"),
    @XmlEnumValue("listen-fail")
    LISTEN_FAIL("listen-fail"),
    @XmlEnumValue("double")
    DOUBLE("double");
    private final String value;

    ResponseError(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResponseError fromValue(String v) {
        for (ResponseError c: ResponseError.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
