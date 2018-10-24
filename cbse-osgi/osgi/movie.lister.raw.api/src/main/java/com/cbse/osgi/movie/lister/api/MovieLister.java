package com.cbse.osgi.movie.lister.api;

import com.cbse.osgi.movie.finder.api.Movie;

import java.util.List;

public interface MovieLister
{
    public static final String TYPE = "type";
    public static final String SERVICE_NAME = MovieLister.class.getName();

    List<Movie> getDirectedBy(String name);

    List<Movie> getByTitle(String title);
}
