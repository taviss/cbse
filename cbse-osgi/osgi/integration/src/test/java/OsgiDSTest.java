import com.cbse.osgi.movie.finder.ds.api.MovieFinder;
import com.cbse.osgi.movie.finder.ds.api.MovieFinderFactoryRegistry;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class OsgiDSTest
{

    @Test
    public void testMovieFinderDS()
    {
        MovieFinder movieFinder = MovieFinderFactoryRegistry.getSingleton().getMovieFinderFactory("misc").createFinder();
        assertNotNull(movieFinder);
        assertNotNull(movieFinder.findAll());
    }
}
