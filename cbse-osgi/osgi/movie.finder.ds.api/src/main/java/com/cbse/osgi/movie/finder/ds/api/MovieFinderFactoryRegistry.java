package com.cbse.osgi.movie.finder.ds.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MovieFinderFactoryRegistry
{
    private static final Logger LOG = LoggerFactory.getLogger(MovieFinderFactoryRegistry.class);
    
    private static MovieFinderFactoryRegistry SINGLETON = null;
    
    /** The bound factories. */
    private final SortedSet<MovieFinderFactory> movieFinderFactories = Collections.synchronizedSortedSet(new TreeSet<MovieFinderFactory>(new Comparator<MovieFinderFactory>() {
        @Override
        public int compare(MovieFinderFactory o1, MovieFinderFactory o2) {
            return o1.getPriority() - o2.getPriority();
        }
    }));
    
    public MovieFinderFactoryRegistry()
    {
        if(SINGLETON != null)
            throw new IllegalStateException("Movie finder registry already instantiated!");
        
        SINGLETON = this;
    }

    /**
     * Get a MovieFinderFactory
     * @param type the type.
     * @return a movie finder factory.
     */
    public MovieFinderFactory getMovieFinderFactory(String type)
    {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getMovieFinderFactory( type=" + type + " )");
        }

        for(MovieFinderFactory factory : movieFinderFactories) {
            if(factory.isSupported(type)) {
                return factory;
            }
        }

        return null;
    }

    /**
     * Bind a movie finder factory.
     *
     * Each movie finder factory can only be bound once.
     *
     * Non-static bind/unbind methods as some OSGi containers do not like static ones.
     *
     * @param movieFinderFactory to be bound
     */
    public synchronized void bindMovieFinderFactory(MovieFinderFactory movieFinderFactory)
    {
        if (LOG.isDebugEnabled()) {
            LOG.debug("bindMovieFinderFactory( movieFinderFactory=" + movieFinderFactory + " )");
        }
        Objects.requireNonNull(movieFinderFactory, "Movie Finder Factory is null!");
        if (!this.movieFinderFactories.add(movieFinderFactory)) {
            if (LOG.isErrorEnabled()) {
                LOG.error("An Movie Finder Factory implementation is already registered! This one will be ignored.");
            }
        } else {
            if (LOG.isTraceEnabled()) {
                LOG.trace("There are now " + Integer.toString(this.movieFinderFactories.size()) + " Movie Finder Factory implementations registered.");
            }
        }
    }

    /**
     * Unbind the movie finder factory.
     *
     * Non-static bind/unbind methods as some OSGi containers do not like static ones.
     *
     * @param movieFinderFactory
     */
    public synchronized void unbindMovieFinderFactory(MovieFinderFactory movieFinderFactory)
    {
        if (LOG.isDebugEnabled()) {
            LOG.debug("unbindMovieFinderFactory( movieFinderFactory=" + movieFinderFactory + " )");
        }
        Objects.requireNonNull(movieFinderFactory, "Movie Finder Factory is null!");
        if (!this.movieFinderFactories.remove(movieFinderFactory)) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("The Movie Finder Factory implementation is not registered! This one will be ignored.");
            }
        } else {
            if (LOG.isTraceEnabled()) {
                LOG.trace("There are now " + Integer.toString(this.movieFinderFactories.size()) + " Movie Finder Factory implementations left registered.");
            }
        }
    }

    /**
     * Get the movie finder factory registry singleton instance.
     *
     * @return the movie finder factory registry singleton instance.
     */
    public static MovieFinderFactoryRegistry getSingleton()
    {
        if (SINGLETON == null) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Movie finder factory registry singleton instance is not instantiated by OSGi!" +
                        " Assuming non-OSGi environment so will instantiate one for you!");
            }
            SINGLETON = new MovieFinderFactoryRegistry();
        }
        return SINGLETON;
    }
    
}
