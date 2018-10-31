package com.cbse.realizator.api;

import com.cbse.exceptions.ComponentRealizationException;
import com.cbse.model.Component;

/**
 * A class that knows how to resolve a {@link com.cbse.model.Component} to its actual underlying implementation.
 */
public interface ComponentRealizator
{
    /**
     * Resolve a {@link Component} to the actual implementation.
     * @param component the component to be resolved.
     * @param <T>
     * @return the implementation.
     */
    <T> T resolveComponent(Component<Class<T>> component) throws ComponentRealizationException;
}
