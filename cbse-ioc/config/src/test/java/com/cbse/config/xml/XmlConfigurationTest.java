package com.cbse.config.xml;

import com.cbse.config.Configuration;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertNotNull;

public class XmlConfigurationTest
{
    private static final String DEMO_CONFIG = "demo_config.xml";

    @Test
    public void testConfigLoad() throws Exception
    {
        URL xml = getClass().getClassLoader().getResource(DEMO_CONFIG);
        Configuration config = new XmlConfiguration(xml);
        assertNotNull(config);
    }
}
