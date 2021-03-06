import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Simon on 5/4/2018.
 */
public class CellTest {
    @Test
    public void render() throws Exception {
        Graphics2D gMock = Mockito.mock(Graphics2D.class);
        Cell cell = new Cell();
        HashSet<Cell> visited = new HashSet<Cell>();
        cell.render(gMock, visited);

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
        cell.render(gMock, visited);

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
        cell.render(gMock, visited);

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
        cell.render(gMock, visited);

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
        cell.render(gMock, visited);

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


        //testing cell being visited
        visited.add(cell);
        gMock = Mockito.mock(Graphics2D.class);
        cell.render(gMock, visited);

        Mockito.verify(gMock).setColor(Color.red);
        Mockito.verify(gMock).fillRect(0, 0, Cell.DIMENSIONS, Cell.DIMENSIONS);

    }

    @Test
    public void hasUnvisitedNeighbor() throws Exception {
        Cell a = new Cell();
        Cell b = new Cell();
        Cell c = new Cell();
        Cell d = new Cell();
        Cell e = new Cell();
        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);
        a.addNeighbor(e);

        HashSet<Cell> visited = new HashSet<Cell>();
        visited.add(b);
        visited.add(c);
        visited.add(d);

        assertTrue(a.hasUnvisitedNeighbor(visited));

        visited.add(e);

        assertFalse(a.hasUnvisitedNeighbor(visited));
    }

    @Test
    public void randomNeighbor() throws Exception {
        Cell a = new Cell();
        Cell b = new Cell();
        Cell c = new Cell();
        Cell d = new Cell();
        Cell e = new Cell();
        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);
        a.addNeighbor(e);

        HashSet<Cell> visited = new HashSet<Cell>();
        visited.add(b);
        visited.add(c);

        Random rand = new Random(10);
        assertEquals(e, a.randomNeighbor(visited, rand));
        assertEquals(d, a.randomNeighbor(visited, rand));
        assertEquals(d, a.randomNeighbor(visited, rand));
        assertEquals(d, a.randomNeighbor(visited, rand));
        assertEquals(d, a.randomNeighbor(visited, rand));
        assertEquals(e, a.randomNeighbor(visited, rand));

        visited.add(d);
        assertEquals(e, a.randomNeighbor(visited, rand));
        assertEquals(e, a.randomNeighbor(visited, rand));
    }

    @Test
    public void hasUnvisitedConnectedNeighbor() throws Exception {
        Cell a = new Cell(0, 0);
        Cell b = new Cell();
        Cell c = new Cell();
        Cell d = new Cell();
        Cell e = new Cell(0, 1);
        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);
        a.addNeighbor(e);

        HashSet<Cell> visited = new HashSet<Cell>();
        visited.add(b);
        visited.add(c);
        visited.add(d);

        assertFalse(a.hasUnvisitedConnectedNeighbor(visited));

        a.connect(e);

        assertTrue(a.hasUnvisitedConnectedNeighbor(visited));

        visited.add(e);

        assertFalse(a.hasUnvisitedConnectedNeighbor(visited));
    }

    @Test
    public void randomConnectedNeighbor() throws Exception {
        Cell a = new Cell(0, 0);
        Cell b = new Cell();
        Cell c = new Cell();
        Cell d = new Cell(0, 1);
        Cell e = new Cell(1, 0);
        a.addNeighbor(b);
        a.addNeighbor(c);
        a.addNeighbor(d);
        a.addNeighbor(e);
        a.connect(d);
        a.connect(e);

        HashSet<Cell> visited = new HashSet<Cell>();
        visited.add(b);
        visited.add(c);

        Random rand = new Random(10);
        assertEquals(e, a.randomConnectedNeighbor(visited, rand));
        assertEquals(d, a.randomConnectedNeighbor(visited, rand));
        assertEquals(d, a.randomConnectedNeighbor(visited, rand));
        assertEquals(d, a.randomConnectedNeighbor(visited, rand));
        assertEquals(d, a.randomConnectedNeighbor(visited, rand));
        assertEquals(e, a.randomConnectedNeighbor(visited, rand));

        visited.add(d);
        assertEquals(e, a.randomConnectedNeighbor(visited, rand));
        assertEquals(e, a.randomConnectedNeighbor(visited, rand));
    }
}