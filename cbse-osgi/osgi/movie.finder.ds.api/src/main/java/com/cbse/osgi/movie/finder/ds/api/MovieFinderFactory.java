package com.cbse.osgi.movie.finder.ds.api;

public interface MovieFinderFactory
{
    int getPriority();

    MovieFinder createFinder();

    boolean isSupported(String type);
}
