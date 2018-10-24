import com.cbse.osgi.movie.finder.api.Movie;
import com.cbse.osgi.movie.lister.api.MovieLister;
import com.cbse.osgi.movie.lister.api.MovieListerRegistry;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class OsgiRawServicesTest
{
    @Test
    public void testMovieListerRegistry()
    {
        MovieLister movieLister = MovieListerRegistry.getMovieLister("misc");
        assertNotNull(movieLister);
        List<Movie> movies = movieLister.getByTitle("Test");
        assertNotNull(movies);
    }
}
