package com.cbse.model;

import javax.xml.bind.annotation.*;

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

    private Component parent;

    @XmlElements({
            @XmlElement(name="ref", type=ReferenceValue.class),
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

    /**
     * Returns the tied attribute.
     * @return the attribute.
     */
    @XmlTransient
    public Component getParent() {
        return this.parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }
}
