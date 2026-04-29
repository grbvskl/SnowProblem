import ui.GameWindow;

public class Main {
    //starts the program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameWindow window = new GameWindow();
            window.setVisible(true);
        });
    }
}