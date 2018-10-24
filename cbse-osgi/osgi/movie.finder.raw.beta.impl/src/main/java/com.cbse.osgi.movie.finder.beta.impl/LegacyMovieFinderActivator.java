package com.cbse.osgi.movie.finder.beta.impl;

import com.cbse.osgi.movie.finder.api.MovieFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Properties;

public class LegacyMovieFinderActivator implements BundleActivator
{
    private ServiceRegistration registration;

    public void start(BundleContext context) {
        MovieFinder finder = new LegacyMovieFinderImpl();

        Dictionary props = new Properties();
        props.put(MovieFinder.TYPE, "misc");
        //FIXME: Is it 'priority'?
        props.put("service.ranking", "100");

        registration = context.registerService(
                MovieFinder.SERVICE_NAME,
                finder, props);
    }

    public void stop(BundleContext context) {
        registration.unregister();
    }
}
