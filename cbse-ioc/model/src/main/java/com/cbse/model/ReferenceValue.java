package com.cbse.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * A {@link Component} reference based value.
 */
@XmlRootElement(name = "ref")
public class ReferenceValue extends AttributeValue<String>
{
    private String component;

    @Override
    @XmlValue
    public String getValue() {
        return this.component;
    }

    @Override
    public void setValue(String value) {
        this.component = value;
    }
}
