package com.cbse.osgi.movie.finder.ds.api;

public class Movie
{
    public Movie(String name, String director) {
        this.title = name;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    private String title;
    private String director;
}
