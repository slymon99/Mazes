import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Simon on 5/4/2018.
 */

//represents a cell in a maze
public class Cell {
    public static final int DIMENSIONS = 20;
    private boolean connectedUp, connectedLeft, connectedRight, connectedDown;
    private int x, y;
    private ArrayList<Cell> neighbors;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        neighbors = new ArrayList<Cell>();
    }

    public Cell() {
        this(0, 0);
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, DIMENSIONS, DIMENSIONS);

        g2.setColor(Color.black);
        if (!connectedUp) {
            g2.fillRect(x, y, DIMENSIONS, DIMENSIONS / 10);
        }
        if (!connectedLeft) {
            g2.fillRect(x, y, DIMENSIONS / 10, DIMENSIONS);
        }
        if (!connectedRight) {
            g2.fillRect(x + (DIMENSIONS - DIMENSIONS / 10), y, DIMENSIONS / 10, DIMENSIONS);
        }
        if (!connectedDown) {
            g2.fillRect(x, y + (DIMENSIONS - DIMENSIONS / 10), DIMENSIONS, DIMENSIONS / 10);
        }
    }


    public void connectUp() {
        connectedUp = true;
    }

    public void connectDown() {
        connectedDown = true;
    }

    public void connectLeft() {
        connectedLeft = true;
    }

    public void connectRight() {
        connectedRight = true;
    }

    public void addNeighbor(Cell neighbor) {
        neighbors.add(neighbor);
    }

    public boolean hasUnvisitedNeighbor(HashSet<Cell> visited) {
        for(Cell n: neighbors){
            if (!visited.contains(n)){
                return true;
            }
        }

        return false;
    }

    public Cell randomNeighbor(HashSet<Cell> visited, Random rand) {
        //collect all unvisited neighbors
        ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

        for(Cell n: neighbors){
            if(!visited.contains(n)){
                unvisitedNeighbors.add(n);
            }
        }

        //return a random unvisited neighbor
        return unvisitedNeighbors.get(rand.nextInt(unvisitedNeighbors.size()));
    }

}
