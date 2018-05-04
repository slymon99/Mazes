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

    public Grid(int rows, int cols, Random rand) {
        this.rows = rows;
        this.cols = cols;
        this.rand = rand;

        initialize();
    }

    private void initialize(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell c = new Cell(j * Cell.DIMENSIONS, i * Cell.DIMENSIONS);
                cells.add(c);
            }
        }
    }

    public void buildMaze() {
        HashSet<Cell> visited = new HashSet<Cell>();
        Stack<Cell> worklist = new Stack<Cell>();

        worklist.push(cells.get(0));

        while(!worklist.isEmpty()){

        }
    }
}
