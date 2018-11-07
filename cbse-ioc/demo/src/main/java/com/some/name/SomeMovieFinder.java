package com.some.name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SomeMovieFinder implements MovieFinder
{
    private String filename;

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(Arrays.asList(new Movie[] {new Movie(filename, "test"), new Movie("test2", "test2")}));
    }
}
