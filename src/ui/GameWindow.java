package ui;

import controller.GameController;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class GameWindow extends JFrame {
    private JLabel moveLabel;
    private GameController controller;
    private GamePanel panel;
    private JLabel levelLabel;

    public GameWindow() {
        setTitle("Snow Problem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controller = new GameController();
        panel = new GamePanel(controller, this);

        moveLabel = new JLabel("Moves: 0");

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            controller.resetLevel();
            updateMoveCount(0);
            updateLevelLabel(controller.getCurrentLevel());
            panel.repaint();
        });

        levelLabel = new JLabel("Level: 1");

        JButton levelButton = new JButton("Level");
        levelButton.addActionListener(e -> {
            String result = JOptionPane.showInputDialog(this, "Enter level number (1-80):");
            if (result != null) {
                try {
                    int level = Integer.parseInt(result);
                    controller.loadLevel(level);
                    updateMoveCount(0);
                    panel.repaint();
                    updateLevelLabel(level);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid level number!");
                }
            }
        });

        JButton prevButton = new JButton("<");
        prevButton.addActionListener(e -> {
            int current = controller.getCurrentLevel();
            if (current > 1) {
                controller.loadLevel(current - 1);
                updateMoveCount(0);
                updateLevelLabel(current - 1);
                panel.repaint();
            }
        });

        JButton nextButton = new JButton(">");
        nextButton.addActionListener(e -> {
            int current = controller.getCurrentLevel();
            if (current < 80) {
                controller.loadLevel(current + 1);
                updateMoveCount(0);
                updateLevelLabel(current + 1);
                panel.repaint();
            }
        });

        JButton scoresButton = new JButton("Best Scores");
        scoresButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Best Scores:\n");
            for (int i = 1; i <= 80; i++) {
                int best = controller.getBestScore(i);
                if (best != -1) {
                    sb.append("Level ").append(i).append(": ").append(best).append(" moves\n");
                }
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        JPanel topBar = new JPanel();
        JPanel bottomBar = new JPanel();
        bottomBar.add(levelLabel);

        topBar.add(moveLabel);
        topBar.add(resetButton);
        topBar.add(levelButton);
        topBar.add(scoresButton);
        topBar.add(prevButton);
        topBar.add(nextButton);

        add(topBar, BorderLayout.NORTH);
        add(bottomBar, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public void updateLevelLabel(int level) {
        levelLabel.setText("Level: " + level);
    }

    public void updateMoveCount(int count) {
        moveLabel.setText("Moves: " + count);
    }
}