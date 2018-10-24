package com.cbse.osgi.movie.finder.alpha.impl;

import com.cbse.osgi.movie.finder.api.Movie;
import com.cbse.osgi.movie.finder.api.MovieFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlphaMovieFinderImpl implements MovieFinder
{
    @Override
    public List<Movie> findAll() {
        return Arrays.asList(new Movie[]{new Movie("Test", "Author1"), new Movie("Test2", "Author2")});
    }
}
