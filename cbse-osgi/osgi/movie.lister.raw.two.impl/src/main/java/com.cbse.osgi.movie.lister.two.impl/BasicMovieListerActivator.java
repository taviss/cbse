package com.cbse.osgi.movie.lister.two.impl;

import com.cbse.osgi.movie.finder.api.MovieFinder;
import com.cbse.osgi.movie.lister.api.MovieLister;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import java.util.Dictionary;
import java.util.Properties;

public class BasicMovieListerActivator implements BundleActivator
{
    private ServiceTracker finderTracker;
    private ServiceRegistration registration;

    public void start(BundleContext context) {
        // Create and open the MovieFinder ServiceTracker
        finderTracker = new ServiceTracker(context, MovieFinder.SERVICE_NAME, null);
        finderTracker.open();

        MovieLister lister = new BasicMovieListerImpl(finderTracker);

        Dictionary props = new Properties();
        props.put(MovieLister.TYPE, "misc");

        registration = context.registerService(
                MovieLister.SERVICE_NAME,
                lister, props);
    }

    public void stop(BundleContext context) {
        registration.unregister();
    }
}
