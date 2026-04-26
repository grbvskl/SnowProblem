package ui;

import controller.GameController;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Snow Problem");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GameController controller = new GameController();
        GamePanel panel = new GamePanel(controller);
        add(panel);
        pack();
    }
}
