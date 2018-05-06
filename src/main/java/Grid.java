import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Simon on 5/4/2018.
 */
public class Grid {

    private ArrayList<Cell> cells;
    private int rows, cols;
    private Random rand;
    private DFS dfs;

    public Grid(int rows, int cols, Random rand) {
        this.rows = rows;
        this.cols = cols;
        this.rand = rand;

        cells = new ArrayList<Cell>();

        initialize();
        buildMaze();

        dfs = new DFS(cells, rand);

    }

    public Grid(int rows, int cols){
        this(rows, cols, new Random());
    }

    private void initialize(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell c = new Cell(j, i);
                cells.add(c);
                int curIdx = cells.indexOf(c);

                if (j > 0){
                    Cell left = cells.get(curIdx - 1);
                    left.addNeighbor(c);
                    c.addNeighbor(left);
                }

                if (i > 0){
                    Cell above = cells.get(curIdx - cols);
                    above.addNeighbor(c);
                    c.addNeighbor(above);
                }
            }
        }
    }

    public void render(Graphics2D g2){
        for(Cell c: cells){
            c.render(g2, dfs.getVisited());
        }

    }

    public void onTick(){
        dfs.tick();
    }

    public void buildMaze() {
        HashSet<Cell> visited = new HashSet<Cell>();
        Stack<Cell> worklist = new Stack<Cell>();

        worklist.push(cells.get(0));

        while(!worklist.isEmpty()){
            Cell current = worklist.peek();
            visited.add(current);
            if (current.hasUnvisitedNeighbor(visited)){
                Cell next = current.randomNeighbor(visited, rand);
                current.connect(next);
                worklist.push(next);
            } else {
                worklist.pop();
            }
        }
    }


    public void handleKey(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            dfs.start();
        }
    }
}
