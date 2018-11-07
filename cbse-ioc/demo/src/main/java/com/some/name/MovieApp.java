package com.some.name;

import com.cbse.config.exceptions.ConfigurationException;
import com.cbse.exceptions.ComponentRealizationException;
import com.cbse.freaky.app.FreakyApp;

import java.net.URL;
import java.util.List;

public class MovieApp
{
    public static void main(String[] args) {
        try {
            URL config = MovieApp.class.getClassLoader().getResource("movie.xml");
            FreakyApp app = new FreakyApp().withXmlConfig(config);
            MovieLister lister = app.resolve("MovieLister");
            Movie[] movieList = lister.moviesDirectedBy("movies1.txt");
            System.out.println(movieList[0]);
        } catch (ConfigurationException|ComponentRealizationException e) {
            //TODO
        }
    }
}
