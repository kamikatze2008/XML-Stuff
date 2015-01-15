//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.06 at 09:18:22 PM EET 
//


package generated;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}stem_color"/>
 *         &lt;element ref="{}flower_color"/>
 *         &lt;element ref="{}average_size"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "stemColor",
    "flowerColor",
    "averageSize"
})
@XmlRootElement(name = "visual_parameters")
public class VisualParameters {

    @XmlElement(name = "stem_color", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "Name")
    protected String stemColor;
    @XmlElement(name = "flower_color", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "Name")
    protected String flowerColor;
    @XmlElement(name = "average_size")
    protected float averageSize;

    /**
     * Gets the value of the stemColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStemColor() {
        return stemColor;
    }

    /**
     * Sets the value of the stemColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStemColor(String value) {
        this.stemColor = value;
    }

    /**
     * Gets the value of the flowerColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlowerColor() {
        return flowerColor;
    }

    /**
     * Sets the value of the flowerColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlowerColor(String value) {
        this.flowerColor = value;
    }

    /**
     * Gets the value of the averageSize property.
     * 
     */
    public float getAverageSize() {
        return averageSize;
    }

    /**
     * Sets the value of the averageSize property.
     * 
     */
    public void setAverageSize(float value) {
        this.averageSize = value;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "stemColor='" + stemColor + '\'' +
                ", flowerColor='" + flowerColor + '\'' +
                ", averageSize=" + averageSize +
                '}';
    }
}
