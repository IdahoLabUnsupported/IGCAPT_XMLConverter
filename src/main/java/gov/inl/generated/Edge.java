package gov.inl.generated;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

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
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "capacity"
})
public class Edge {

    @XmlElement(required = true)
    protected BigDecimal capacity;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "unsignedByte")
    protected short id;
    @XmlAttribute(name = "source", required = true)
    @XmlSchemaType(name = "unsignedByte")
    protected short source;
    @XmlAttribute(name = "target", required = true)
    @XmlSchemaType(name = "unsignedByte")
    protected short target;

    public BigDecimal getCapacity() {
        return capacity;
    }
    public void setCapacity(BigDecimal value) {
        this.capacity = value;
    }

    public short getId() {
        return id;
    }
    public void setId(short value) {
        this.id = value;
    }

    public short getSource() {
        return source;
    }
    public void setSource(short value) {
        this.source = value;
    }

    public short getTarget() {
        return target;
    }
    public void setTarget(short value) {
        this.target = value;
    }

}
