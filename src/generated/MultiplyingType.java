//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.06 at 09:18:22 PM EET 
//


package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for multiplyingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="multiplyingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Leaves"/>
 *     &lt;enumeration value="Cuttings"/>
 *     &lt;enumeration value="Seeds"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "multiplyingType")
@XmlEnum
public enum MultiplyingType {

    @XmlEnumValue("Leaves")
    LEAVES("Leaves"),
    @XmlEnumValue("Cuttings")
    CUTTINGS("Cuttings"),
    @XmlEnumValue("Seeds")
    SEEDS("Seeds");
    private final String value;

    MultiplyingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultiplyingType fromValue(String v) {
        for (MultiplyingType c: MultiplyingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
