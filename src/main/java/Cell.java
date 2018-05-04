import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Simon on 5/4/2018.
 */

//represents a cell in a maze
public class Cell {
    public static final int DIMENSIONS = 20;
    private boolean connectedUp, connectedLeft, connectedRight, connectedDown;
    private int x, y;

    public Cell() {
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, DIMENSIONS, DIMENSIONS);

        g2.setColor(Color.black);
        if(!connectedUp){
            g2.fillRect(x, y, DIMENSIONS, DIMENSIONS / 10);
        }
        if(!connectedLeft){
            g2.fillRect(x, y, DIMENSIONS / 10, DIMENSIONS);
        }
        if(!connectedRight){
            g2.fillRect(x + (DIMENSIONS - DIMENSIONS/10), y, DIMENSIONS / 10, DIMENSIONS);
        }
        if(!connectedDown){
            g2.fillRect(x, y + (DIMENSIONS - DIMENSIONS/10), DIMENSIONS, DIMENSIONS / 10);
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
}
