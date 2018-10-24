package com.cbse.osgi.movie.finder.ds.api;

import java.util.List;

public interface MovieFinder
{
    public static final String TYPE = "type";
    public static final String SERVICE_NAME = MovieFinder.class.getName();

    List<Movie> findAll();
}
