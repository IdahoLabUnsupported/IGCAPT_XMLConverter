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
    @XmlSchemaType(name = "integer")
    protected int id;
    @XmlAttribute(name = "source", required = true)
    @XmlSchemaType(name = "integer")
    protected int source;
    @XmlAttribute(name = "target", required = true)
    @XmlSchemaType(name = "integer")
    protected int target;

    public BigDecimal getCapacity() {
        return capacity;
    }
    public void setCapacity(BigDecimal value) {
        this.capacity = value;
    }

    public int getId() {
        return id;
    }
    public void setId(int value) {
        this.id = value;
    }

    public int getSource() {
        return source;
    }
    public void setSource(int value) {
        this.source = value;
    }

    public int getTarget() {
        return target;
    }
    public void setTarget(int value) {
        this.target = value;
    }

}
