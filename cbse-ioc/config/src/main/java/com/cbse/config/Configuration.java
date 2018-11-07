package com.cbse.config;

import com.cbse.config.exceptions.ConfigurationException;
import com.cbse.model.Component;
import com.cbse.model.Container;

import java.util.List;

/**
 * Defines a valid configuration.
 */
public interface Configuration
{
    /**
     * Returns the parsed components of this configuration.
     * @return the components.
     */
    Container getComponents() throws ConfigurationException;

    /**
     * Initializes this configuration.
     */
    void initialize() throws ConfigurationException;
}
