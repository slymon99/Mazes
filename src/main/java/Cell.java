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
    private int col, row;
    private ArrayList<Cell> neighbors;

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;
        neighbors = new ArrayList<Cell>();
    }

    public Cell() {
        this(0, 0);
    }

    public void render(Graphics2D g2) {
        int x = col * DIMENSIONS;
        int y = row * DIMENSIONS;

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

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int numNeighbors() {
        return neighbors.size();
    }


    public boolean hasUnvisitedNeighbor(HashSet<Cell> visited) {
        for (Cell n : neighbors) {
            if (!visited.contains(n)) {
                return true;
            }
        }

        return false;
    }

    public Cell randomNeighbor(HashSet<Cell> visited, Random rand) {
        //collect all unvisited neighbors
        ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

        for (Cell n : neighbors) {
            if (!visited.contains(n)) {
                unvisitedNeighbors.add(n);
            }
        }

        //return a random unvisited neighbor
        return unvisitedNeighbors.get(rand.nextInt(unvisitedNeighbors.size()));
    }

    public void connect(Cell other) {
        if (other.getRow() == this.row) {
            if (other.getCol() == this.col - 1) {
                other.connectRight();
                this.connectedLeft = true;
            }
            if (other.getCol() == this.col + 1) {
                other.connectLeft();
                this.connectedRight = true;
            }
        }
        if (other.getCol() == this.col) {
            if (other.getRow() == this.row - 1) {
                other.connectDown();
                this.connectedUp = true;
            }
            if (other.getRow() == this.row + 1) {
                other.connectUp();
                this.connectedDown = true;
            }
        }
    }

    private ArrayList<Cell> connectedNeighbors() {
        ArrayList<Cell> result = new ArrayList<Cell>();

        for (Cell n : neighbors) {
            if (n.getRow() == this.row) {
                if ((n.getCol() == this.col - 1 && this.connectedLeft)
                        || (n.getCol() == this.col + 1 && this.connectedRight)) {
                    result.add(n);
                }
            }
            if (n.getCol() == this.col) {
                if ((n.getRow() == this.row - 1 && this.connectedUp)
                        || (n.getRow() == this.row + 1 && this.connectedDown)) {
                    result.add(n);
                }
            }
        }

        return result;
    }

    public boolean hasUnvisitedConnectedNeighbor(HashSet<Cell> visited) {
        for (Cell n : connectedNeighbors()) {
            if (!visited.contains(n)) {
                return true;
            }
        }

        return false;
    }

    public Cell randomConnectedNeighbor(HashSet<Cell> visited, Random rand) {
        //collect all unvisited neighbors
        ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

        for (Cell n : connectedNeighbors()) {
            if (!visited.contains(n)) {
                unvisitedNeighbors.add(n);
            }
        }

        //return a random unvisited neighbor
        return unvisitedNeighbors.get(rand.nextInt(unvisitedNeighbors.size()));
    }
}
