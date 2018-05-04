import javax.swing.*;

/**
 * Created by Simon on 5/4/2018.
 */
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Mazes");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 900, 900);

        GamePanel panel = new GamePanel();
        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
    }
}
