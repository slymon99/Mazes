import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;

public class DFSTest {
    @Test
    public void tick() throws Exception {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        Cell a = new Cell(0, 0);
        Cell b = new Cell(0, 1);
        Cell c = new Cell(0, 2);
        Cell d = new Cell(0, 3);
        Cell e = new Cell(1, 1);

        a.addNeighbor(b);
        b.addNeighbor(c);
        c.addNeighbor(d);
        b.addNeighbor(e);
        a.connect(b);
        b.connect(c);
        c.connect(d);
        b.connect(e);


        cells.addAll(Arrays.asList(a, b, c, d, e));
        DFS dfs = new DFS(cells, new Random(10));
        assertEquals(new HashSet<Cell>(), dfs.getVisited());
        dfs.tick();
        assertEquals(new HashSet<Cell>(), dfs.getVisited());
        dfs.start();
        dfs.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a)), dfs.getVisited());
        dfs.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b)),dfs.getVisited());
        dfs.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b, c)), dfs.getVisited());
        dfs.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b, c, d)), dfs.getVisited());
        dfs.tick();
        dfs.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b, c, d, e)), dfs.getVisited());


        //depending on the seed DFS can go in multiple ways

        DFS dfs2 = new DFS(cells, new Random(11));
        dfs2.start();
        assertEquals(new HashSet<Cell>(), dfs2.getVisited());
        dfs2.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a)), dfs2.getVisited());
        dfs2.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b)),dfs2.getVisited());
        dfs2.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b, e)), dfs2.getVisited());
        dfs2.tick();
        dfs2.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b, e, c)), dfs2.getVisited());
        dfs2.tick();
        assertEquals(new HashSet<Cell>(Arrays.asList(a, b, c, d, e)), dfs2.getVisited());
    }
}