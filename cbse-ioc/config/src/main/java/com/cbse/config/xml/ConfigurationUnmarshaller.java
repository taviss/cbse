package com.cbse.config.xml;

import com.cbse.config.exceptions.ConfigurationException;
import com.cbse.model.Attribute;
import com.cbse.model.AttributeValue;
import com.cbse.model.Component;
import com.cbse.model.Container;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;

public class ConfigurationUnmarshaller
{
    public static Container getContainer(File f) throws ConfigurationException
    {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Container.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Container container = (Container) jaxbUnmarshaller.unmarshal(f);
            return container;
        } catch (JAXBException e) {
            throw new ConfigurationException("Unable to unmarshal file " + f.getName(), e);
        }
    }

    public static Container getContainer(URL url) throws ConfigurationException
    {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Container.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Container container = (Container) jaxbUnmarshaller.unmarshal(url);
            afterUnmarshal(container);
            return container;
        } catch (JAXBException e) {
            throw new ConfigurationException("Unable to unmarshal file " + url.getPath(), e);
        }
    }

    private static void afterUnmarshal(Container container)
    {
        for(Component component : container.getComponentList())
        {
            for(Attribute attribute : component.getAttributes()) {
                attribute.getValue().setParent(attribute);
                attribute.setParent(component);
            }
            component.setContainer(container);
        }
    }
}
