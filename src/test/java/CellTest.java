import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Simon on 5/4/2018.
 */
public class CellTest {
    @Test
    public void render() throws Exception {
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        Cell cell = new Cell();
        cell.render(gMock);

        Mockito.verify(gMock).setColor(Color.white);
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS);

        int closeToEdge = Cell.DIMENSIONS - Cell.DIMENSIONS / 10;
        
        Mockito.verify(gMock).setColor(Color.black);
        //top
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);
        //left
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //right
        Mockito.verify(gMock).fillRect(closeToEdge, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //bottom
        Mockito.verify(gMock).fillRect(0, closeToEdge, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);



        gMock = Mockito.mock(Graphics2D.class);
        cell.connectUp();
        cell.render(gMock);

        Mockito.verify(gMock).setColor(Color.white);
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS);

        Mockito.verify(gMock).setColor(Color.black);
        //top
        Mockito.verify(gMock, Mockito.never()).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);
        //left
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //right
        Mockito.verify(gMock).fillRect(closeToEdge, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //bottom
        Mockito.verify(gMock).fillRect(0, closeToEdge, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);



        gMock = Mockito.mock(Graphics2D.class);
        cell.connectLeft();
        cell.render(gMock);

        Mockito.verify(gMock).setColor(Color.white);
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS);

        Mockito.verify(gMock).setColor(Color.black);
        //top
        Mockito.verify(gMock, Mockito.never()).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);
        //left
        Mockito.verify(gMock, Mockito.never()).fillRect(0, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //right
        Mockito.verify(gMock).fillRect(closeToEdge, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //bottom
        Mockito.verify(gMock).fillRect(0, closeToEdge, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);



        gMock = Mockito.mock(Graphics2D.class);
        cell.connectRight();
        cell.render(gMock);

        Mockito.verify(gMock).setColor(Color.white);
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS);

        Mockito.verify(gMock).setColor(Color.black);
        //top
        Mockito.verify(gMock, Mockito.never()).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);
        //left
        Mockito.verify(gMock, Mockito.never()).fillRect(0, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //right
        Mockito.verify(gMock, Mockito.never()).fillRect(closeToEdge, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //bottom
        Mockito.verify(gMock).fillRect(0, closeToEdge, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);


        gMock = Mockito.mock(Graphics2D.class);
        cell.connectDown();
        cell.render(gMock);

        Mockito.verify(gMock).setColor(Color.white);
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS);

        Mockito.verify(gMock).setColor(Color.black);
        //top
        Mockito.verify(gMock, Mockito.never()).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);
        //left
        Mockito.verify(gMock, Mockito.never()).fillRect(0, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //right
        Mockito.verify(gMock, Mockito.never()).fillRect(closeToEdge, 0, Cell.DIMENSIONS / 10, Cell.DIMENSIONS);
        //bottom
        Mockito.verify(gMock, Mockito.never()).fillRect(0, closeToEdge, Cell.DIMENSIONS, Cell.DIMENSIONS / 10);
    }

}