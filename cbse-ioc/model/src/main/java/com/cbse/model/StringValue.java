package com.cbse.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * A string value.
 */
@XmlRootElement(name = "value")
public class StringValue extends AttributeValue<String>
{
    private String value;

    @Override
    @XmlValue
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
