package com.cbse.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents an attribute(property) of a {@link Component}
 */
@XmlRootElement(name = "property")
public class Attribute
{
    /** This attribute's unique identifier. */
    private String id;

    /** This attribute's value. */
    private AttributeValue value;

    @XmlElements({
            @XmlElement(name="ref", type=StringValue.class),
            @XmlElement(name="value", type=StringValue.class)
    })
    public AttributeValue getValue() {
        return value;
    }

    public void setValue(AttributeValue value) {
        this.value = value;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
