package com.cbse.realizator.impl;

import com.cbse.config.Configuration;
import com.cbse.config.xml.XmlConfiguration;
import com.cbse.global.GlobalContext;
import com.cbse.model.Component;
import com.cbse.realizator.api.ComponentRealizator;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertNotNull;

public class BasicRealizatorTest {

    private static final String DEMO_CONFIG = "demo_config.xml";

    @Test
    public void basicTest() throws Exception
    {
        URL xml = getClass().getClassLoader().getResource(DEMO_CONFIG);
        Configuration config = new XmlConfiguration(xml);
        assertNotNull(config);

        GlobalContext context = GlobalContext.from(config);
        assertNotNull(context);

        ComponentRealizator realizator = new ComponentRealizatorImpl();
        RefDummyClass dummy = realizator.resolveComponent(context.getComponent("test2"), context);
        assertNotNull(dummy);
    }
}
