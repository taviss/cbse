package com.cbse.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A {@link Component} reference based value.
 */
@XmlRootElement(name = "ref")
public class ReferenceValue extends AttributeValue<Component>
{
    private Component component;

    @Override
    public Component getValue() {
        return this.component;
    }

    @Override
    public void setValue(Component value) {
        this.component = value;
    }
}
