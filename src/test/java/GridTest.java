import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.Random;

/**
 * Created by Simon on 5/4/2018.
 */
public class GridTest {
    @Test
    public void buildMaze() throws Exception {
        Grid g = new Grid(5, 5, new Random(10));
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        g.render(gMock);

        int closeToEdge = Cell.DIMENSIONS - Cell.DIMENSIONS / 10;
        //top
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);
        //left
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //right
        Mockito.verify(gMock).fillRect(closeToEdge, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //bottom
        Mockito.verify(gMock, Mockito.never()).fillRect(0, closeToEdge, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);

    }

}
