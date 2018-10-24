package com.cbse.osgi.movie.finder.ds.impl;

import com.cbse.osgi.movie.finder.ds.api.Movie;
import com.cbse.osgi.movie.finder.ds.api.MovieFinder;

import java.util.Arrays;
import java.util.List;

public class DsMovieFinderImpl implements MovieFinder
{
    @Override
    public List<Movie> findAll() {
        return Arrays.asList(new Movie[]{new Movie("Test", "Author1"), new Movie("Test2", "Author2")});
    }
}
