
package com.eb.warehouse.io.pcx.message;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for query-state.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="query-state">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="waiting"/>
 *     &lt;enumeration value="ready"/>
 *     &lt;enumeration value="error"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "query-state")
@XmlEnum
public enum QueryState {

    @XmlEnumValue("waiting")
    WAITING("waiting"),
    @XmlEnumValue("ready")
    READY("ready"),
    @XmlEnumValue("error")
    ERROR("error");
    private final String value;

    QueryState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QueryState fromValue(String v) {
        for (QueryState c: QueryState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
