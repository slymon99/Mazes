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
        Cell a = new Cell();
        Cell b = new Cell();
        Cell c = new Cell();
        Cell d = new Cell();
        Cell e = new Cell();

        a.addNeighbor(b);
        b.addNeighbor(c);
        c.addNeighbor(d);
        b.addNeighbor(e);

        cells.addAll(Arrays.asList(a, b, c, d));
        DFS dfs = new DFS(cells, new Random(10));
        assertEquals(dfs.getVisited(), new HashSet<Cell>());
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b, c)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b, c, d)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b, c, d, e)));


        DFS dfs2 = new DFS(cells, new Random(11));
        assertEquals(dfs.getVisited(), new HashSet<Cell>());
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b, e)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b, e, c)));
        dfs.tick();
        assertEquals(dfs.getVisited(), new HashSet<Cell>(Arrays.asList(a, b, e, c, d)));



    }
}