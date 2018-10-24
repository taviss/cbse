package com.cbse.osgi.movie.lister.two.impl;

import com.cbse.osgi.movie.finder.api.Movie;
import com.cbse.osgi.movie.finder.api.MovieFinder;
import com.cbse.osgi.movie.lister.api.MovieLister;
import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

public class BasicMovieListerImpl implements MovieLister
{
    private ServiceTracker finderTracker;
    private MovieFinder movieFinder;

    public BasicMovieListerImpl(ServiceTracker finderTracker) {
        this.finderTracker = finderTracker;
    }

    @Override
    public List<Movie> getDirectedBy(String name) {
        if(movieFinder == null)
            movieFinder = (MovieFinder) finderTracker.getService();

        return movieFinder.findAll();
    }

    @Override
    public List<Movie> getByTitle(String title) {
        if(movieFinder == null)
            movieFinder = (MovieFinder) finderTracker.getService();

        return movieFinder.findAll();
    }
}
