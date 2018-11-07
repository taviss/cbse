package com.cbse.global;

import com.cbse.config.Configuration;
import com.cbse.config.exceptions.ConfigurationException;
import com.cbse.model.Component;
import com.cbse.model.Container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global context
 */
public class GlobalContext
{
    /** Component container. */
    private List<Container> componentContainer = new ArrayList<>();

    /** Already solved components. */
    private Map<Component, Object> solvedComponents = new HashMap<>();

    /**
     * Create a GlobalContext from a series of configurations.
     * @param configs the configs.
     * @return a new context.
     * @throws ConfigurationException
     */
    public static GlobalContext from(Configuration... configs) throws ConfigurationException
    {
        GlobalContext globalContext = new GlobalContext();
        for(Configuration config : configs) {
            globalContext.addComponents(config.getComponents());
        }
        return globalContext;
    }

    /**
     * Create a GlobalContext from a series of configurations.
     * @param configs the configs.
     * @return a new context.
     * @throws ConfigurationException
     */
    public static GlobalContext from(List<Configuration> configs) throws ConfigurationException
    {
        GlobalContext globalContext = new GlobalContext();
        for(Configuration config : configs) {
            globalContext.addComponents(config.getComponents());
        }
        return globalContext;
    }

    protected void addComponents(Container container)
    {
        componentContainer.add(container);
    }

    public List<Component> getAllComponents()
    {
        List<Component> components = new ArrayList<>();
        for(Container container : componentContainer) {
            components.addAll(container.getComponentList());
        }

        return components;
    }

    public Map<Component, Object> getSolvedComponents() {
        return solvedComponents;
    }

    public Component getComponent(String name)
    {
        for(Container container : componentContainer) {
            for(Component component : container.getComponentList()) {
                if(component.getId().equals(name))
                    return component;
            }
        }

        return null;
    }
}
