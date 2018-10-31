package com.cbse.model;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Generic attribute value
 * @param <T>
 */
@XmlTransient
public abstract class AttributeValue<T>
{
    /** Tied to an attribute. */
    private Attribute parent;

    /**
     * Returns this value.
     * @return the value.
     */
    public abstract T getValue();

    /**
     * Set the value.
     * @param value
     */
    public abstract void setValue(T value);

    /**
     * Returns the tied attribute.
     * @return the attribute.
     */
    @XmlTransient
    public Attribute getParent() {
        return this.parent;
    }

    /**
     * Sets the parent
     */
    public void setParent(Attribute parent) {
        this.parent = parent;
    }
}
