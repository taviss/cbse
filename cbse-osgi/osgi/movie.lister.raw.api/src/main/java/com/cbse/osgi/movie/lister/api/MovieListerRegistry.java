package com.cbse.osgi.movie.lister.api;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieListerRegistry
{
    private static final Logger LOG = LoggerFactory.getLogger(MovieListerRegistry.class);

    private static BundleContext bundleContext;

    public static MovieLister getMovieLister(String type)
    {
        if(bundleContext == null) {
            bundleContext = FrameworkUtil.getBundle(MovieLister.class).getBundleContext();
        }

        try {
            String filter = "(" + MovieLister.TYPE + "=" + type + ")";
            ServiceReference[] serviceReferences = bundleContext.getServiceReferences(MovieLister.SERVICE_NAME, filter);
            if (serviceReferences != null && serviceReferences.length > 0) {
                ServiceReference reference = serviceReferences[0];
                return (MovieLister) bundleContext.getService(reference);
            }
        } catch (InvalidSyntaxException e) {
            LOG.error("Unable to get MovieLister for type=" + type);
            throw new RuntimeException(e);
        }

        return null;
    }
}
