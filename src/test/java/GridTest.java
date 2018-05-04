import org.junit.Test;

import java.util.Random;

/**
 * Created by Simon on 5/4/2018.
 */
public class GridTest {
    @Test
    public void buildMaze() throws Exception {
        Grid g = new Grid(3, 3, new Random(10));
        g.buildMaze();

    }
}
