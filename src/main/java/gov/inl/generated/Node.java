package gov.inl.generated;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enableDataSending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enableDataPassThrough" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isAggregate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isCollapsed" type="{http://www.w3.org/2001/XMLSchema}boolean" maxOccurs="unbounded"/>
 *         &lt;element name="payload" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="maxLatency" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="xCoord" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="yCoord" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="long" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="endPoints">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence minOccurs="0">
 *                   &lt;element name="endPoint" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" maxOccurs="unbounded"/>
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
@XmlType(name = "", propOrder = {
    "id",
    "type",
    "enableDataSending",
    "enableDataPassThrough",
    "isAggregate",
    "isCollapsed",
    "payload",
    "maxLatency",
    "xCoord",
    "yCoord",
    "lat",
    "_long",
    "name",
    "endPoints"
})
public class Node {

    @XmlSchemaType(name = "integer")
    protected int id;
    @XmlElement(required = true)
    protected String type;
    protected boolean enableDataSending;
    protected boolean enableDataPassThrough;
    protected boolean isAggregate;
    @XmlElement(type = Boolean.class)
    protected List<Boolean> isCollapsed;
    @XmlSchemaType(name = "integer")
    protected int payload;
    @XmlSchemaType(name = "integer")
    protected int maxLatency;
    @XmlElement(required = true)
    protected BigDecimal xCoord;
    @XmlElement(required = true)
    protected BigDecimal yCoord;
    @XmlElement(required = true)
    protected BigDecimal lat;
    @XmlElement(name = "long", required = true)
    protected BigDecimal _long;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected EndPoints endPoints;

    public int getId() {
        return id;
    }
    public void setId(int value) {
        this.id = value;
    }

    public String getType() {
        return type;
    }
    public void setType(String value) {
        this.type = value;
    }

    public boolean isEnableDataSending() {
        return enableDataSending;
    }
    public void setEnableDataSending(boolean value) {
        this.enableDataSending = value;
    }

    public boolean isEnableDataPassThrough() {
        return enableDataPassThrough;
    }
    public void setEnableDataPassThrough(boolean value) {
        this.enableDataPassThrough = value;
    }

    public boolean isIsAggregate() {
        return isAggregate;
    }
    public void setIsAggregate(boolean value) {
        this.isAggregate = value;
    }

    /**
     * Gets the value of the isCollapsed property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isCollapsed property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIsCollapsed().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boolean }
     *
     *
     */
    public List<Boolean> getIsCollapsed() {
        if (isCollapsed == null) {
            isCollapsed = new ArrayList<Boolean>();
        }
        return this.isCollapsed;
    }

    public int getPayload() {
        return payload;
    }
    public void setPayload(int value) {
        this.payload = value;
    }

    public int getMaxLatency() {
        return maxLatency;
    }
    public void setMaxLatency(int value) {
        this.maxLatency = value;
    }

    public BigDecimal getXCoord() {
        return xCoord;
    }
    public void setXCoord(BigDecimal value) {
        this.xCoord = value;
    }

    public BigDecimal getYCoord() {
        return yCoord;
    }
    public void setYCoord(BigDecimal value) {
        this.yCoord = value;
    }

    public BigDecimal getLat() { return lat; }
    public void setLat(BigDecimal value) {
        this.lat = value;
    }

    public BigDecimal getLong() {
        return _long;
    }
    public void setLong(BigDecimal value) {
        this._long = value;
    }

    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }

    public EndPoints getEndPoints() {
        return endPoints;
    }
    public void setEndPoints(EndPoints value) {
        this.endPoints = value;
    }


}
