package com.cbse.freaky.app;

import com.cbse.config.Configuration;
import com.cbse.config.exceptions.ConfigurationException;
import com.cbse.config.xml.XmlConfiguration;
import com.cbse.exceptions.ComponentRealizationException;
import com.cbse.global.GlobalContext;
import com.cbse.model.Component;
import com.cbse.realizator.api.ComponentRealizator;
import com.cbse.realizator.impl.ComponentRealizatorImpl;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FreakyApp
{
    /** The global context. */
    private GlobalContext context;

    /** The component realizator. */
    private ComponentRealizator realizator;

    /** The list of configurations to load components from. */
    private List<Configuration> configs;

    /** Is this app initialized and ready for use? */
    private boolean initialized = false;

    public FreakyApp()
    {
        this.configs = new ArrayList<>();
        this.realizator = new ComponentRealizatorImpl();
        this.initialized = false;
    }

    public FreakyApp withXmlConfig(String path) throws ConfigurationException
    {
        XmlConfiguration xmlConfiguration = new XmlConfiguration(path);
        addConfig(xmlConfiguration);
        return this;
    }

    public FreakyApp withXmlConfig(URL url) throws ConfigurationException
    {
        XmlConfiguration xmlConfiguration = new XmlConfiguration(url);
        addConfig(xmlConfiguration);
        return this;
    }

    public FreakyApp withConfig(Configuration config)
    {
        addConfig(config);
        return this;
    }

    private void addConfig(Configuration config)
    {
        configs.add(config);
    }

    private void initialize() throws ConfigurationException
    {
        if(!initialized) {
            this.context = GlobalContext.from(configs);
            initialized = true;
        }
    }

    public <T> T resolve(String component) throws ConfigurationException, ComponentRealizationException
    {
        if(!initialized)
            initialize();

        Component actualComp = context.getComponent(component);
        return realizator.resolveComponent(actualComp, context);
    }


}
