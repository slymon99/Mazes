import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Simon on 5/4/2018.
 */
public class GamePanel extends JPanel implements KeyListener{


    private Timer timer;
    private Grid grid;


    public GamePanel(){
        addKeyListener(this);

        timer = new Timer(1000 / 2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.onTick();
                repaint();
            }
        });

        grid = new Grid(25, 25);
        timer.start();
    }


    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        grid.render(g2);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        grid.handleKey(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
