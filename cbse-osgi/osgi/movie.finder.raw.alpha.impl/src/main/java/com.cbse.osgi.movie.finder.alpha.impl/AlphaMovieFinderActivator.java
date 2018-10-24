package com.cbse.osgi.movie.finder.alpha.impl;

import com.cbse.osgi.movie.finder.api.MovieFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Properties;

public class AlphaMovieFinderActivator implements BundleActivator
{
    private ServiceRegistration registration;

    public void start(BundleContext context) {
        MovieFinder finder = new AlphaMovieFinderImpl();

        Dictionary props = new Properties();
        props.put(MovieFinder.TYPE, "misc");
        props.put("service.ranking", "500");

        registration = context.registerService(
                MovieFinder.SERVICE_NAME,
                finder, props);
    }

    public void stop(BundleContext context) {
        registration.unregister();
    }
}
