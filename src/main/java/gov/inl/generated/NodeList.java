package gov.inl.generated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="node" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="enableDataSending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="enableDataPassThrough" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="isAggregate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="isCollapsed" type="{http://www.w3.org/2001/XMLSchema}boolean" maxOccurs="unbounded"/>
 *                   &lt;element name="payload" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="maxLatency" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="xCoord" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="yCoord" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="long" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="endPoints">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence minOccurs="0">
 *                             &lt;element name="endPoint" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodes", propOrder = {
        "nodes"
})
public class NodeList {

    @XmlElement(required = true, name = "node")
    protected List<Node> nodes;

    /**
     * Gets the value of the node property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the node property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Node }
     *
     *
     */
    public List<Node> getNodes() {
        if (nodes == null) {
            nodes = new ArrayList<Node>();
        }
        return this.nodes;
    }


}
