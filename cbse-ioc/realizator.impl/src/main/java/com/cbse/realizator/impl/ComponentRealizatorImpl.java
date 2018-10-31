package com.cbse.realizator.impl;

import com.cbse.model.Component;
import com.cbse.realizator.api.ComponentRealizator;

public class ComponentRealizatorImpl implements ComponentRealizator
{
    @Override
    public <T> T resolveComponent(Component<Class<T>> component) {
        return null;
    }
}
