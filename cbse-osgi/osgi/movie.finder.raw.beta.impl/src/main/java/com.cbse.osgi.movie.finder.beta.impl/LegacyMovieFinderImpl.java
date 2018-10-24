package com.cbse.osgi.movie.finder.beta.impl;

import com.cbse.osgi.movie.finder.api.Movie;
import com.cbse.osgi.movie.finder.api.MovieFinder;

import java.util.Arrays;
import java.util.List;

public class LegacyMovieFinderImpl implements MovieFinder
{
    @Override
    public List<Movie> findAll() {
        return Arrays.asList(new Movie[]{new Movie("LegacyTest", "Author1"), new Movie("LegacyTest2", "Author2")});
    }
}
