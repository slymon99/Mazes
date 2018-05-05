import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

public class DFS {
    private ArrayList<Cell> cells;
    private HashSet<Cell> visited;
    private Random rand;
    private Stack<Cell> worklist;

    public DFS(ArrayList<Cell> cells, Random rand) {
        this.cells = cells;
        this.rand = rand;
        this.visited = new HashSet<Cell>();
        this.worklist = new Stack<Cell>();

        if(cells.size() > 0){
            worklist.push(cells.get(0));
        }
    }

    public HashSet<Cell> getVisited() {
        return visited;
    }

    public void tick() {
        if(!worklist.isEmpty()){
            Cell current = worklist.pop();
            visited.add(current);


        }
    }
}
