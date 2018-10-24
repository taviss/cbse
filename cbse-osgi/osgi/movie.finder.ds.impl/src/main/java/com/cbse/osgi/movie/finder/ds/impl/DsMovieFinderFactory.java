package com.cbse.osgi.movie.finder.ds.impl;

import com.cbse.osgi.movie.finder.ds.api.MovieFinder;
import com.cbse.osgi.movie.finder.ds.api.MovieFinderFactory;

public class DsMovieFinderFactory implements MovieFinderFactory
{
    private static final int DS_PRIORITY = 100;

    private static final String[] SUPPORTED_TYPES = {
        "misc",
        "others"
    };

    @Override
    public int getPriority() {
        return DS_PRIORITY;
    }

    @Override
    public MovieFinder createFinder() {
        return new DsMovieFinderImpl();
    }

    @Override
    public boolean isSupported(String type) {
        for(String string : SUPPORTED_TYPES) {
            if(string.equals(type))
                return true;
        }

        return false;
    }
}
