package com.cbse.config.xml;

import com.cbse.config.Configuration;
import com.cbse.config.exceptions.ConfigurationException;
import com.cbse.model.Component;
import com.cbse.model.Container;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class XmlConfiguration implements Configuration
{
    private URL xml;
    private Container container = null;

    public XmlConfiguration(String path) throws ConfigurationException
    {
        try {
            xml = new File(path).toURL();
            initialize();
        } catch (MalformedURLException e) {
            throw new ConfigurationException("Unable to initialize " + path, e);
        }
    }

    public XmlConfiguration(URL url) throws ConfigurationException
    {
        xml = url;
        initialize();
    }

    @Override
    public Container getComponents() throws ConfigurationException {
        if(container != null) {
            return this.container;
        } else {
            throw new ConfigurationException("Container not initialized for " + xml.getPath());
        }
    }

    @Override
    public void initialize() throws ConfigurationException {
        this.container = ConfigurationUnmarshaller.getContainer(xml);
    }
}
