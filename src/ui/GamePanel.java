package ui;

import controller.GameController;
import model.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel {
    private static final int COLS = 5;
    private static final int ROWS = 4;
    private static final int TILE_SIZE = 80;

    private GameController controller;

    public GamePanel(GameController controller) {
        this.controller = controller;
        setPreferredSize(new java.awt.Dimension(COLS * TILE_SIZE, ROWS * TILE_SIZE));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = e.getX() / TILE_SIZE;
                int row = e.getY() / TILE_SIZE;
                controller.handleClick(row, col);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawGrid(g2d);
        drawPieces(g2d);
    }

    private void drawGrid(Graphics2D g2d) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int x = col * TILE_SIZE;
                int y = row * TILE_SIZE;
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                g2d.setColor(Color.DARK_GRAY);
                g2d.drawRect(x, y, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private void drawPieces(Graphics2D g2d) {
        GameBoard board = controller.getBoard();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null) {
                    drawPiece(g2d, piece, row, col);
                }
            }
        }
    }

    private void drawPiece(Graphics2D g2d, Piece piece, int row, int col) {
        int x = col * TILE_SIZE;
        int y = row * TILE_SIZE;
        int padding = 10;

        // highlight selected piece with yellow background
        if (piece == controller.getSelectedPiece()) {
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }

        // draw stacked snowball differently
        if (piece instanceof LargeSnowball && ((LargeSnowball) piece).hasSmallOnTop()) {
            g2d.setColor(new Color(200, 230, 255));
            g2d.fillOval(x + padding, y + padding, TILE_SIZE - padding * 2, TILE_SIZE - padding * 2);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawOval(x + padding, y + padding, TILE_SIZE - padding * 2, TILE_SIZE - padding * 2);
            g2d.setColor(Color.WHITE);
            g2d.fillOval(x + padding + 10, y + padding + 10, TILE_SIZE - padding * 2 - 20, TILE_SIZE - padding * 2 - 20);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawOval(x + padding + 10, y + padding + 10, TILE_SIZE - padding * 2 - 20, TILE_SIZE - padding * 2 - 20);
            g2d.setColor(Color.BLACK);
            g2d.drawString("ST", x + TILE_SIZE / 2 - 8, y + TILE_SIZE / 2 + 5);
            return;
        }

        switch (piece.getType()) {
            case TREE:
                g2d.setColor(new Color(34, 139, 34));
                break;
            case LARGE_SNOWBALL:
                g2d.setColor(new Color(200, 230, 255));
                break;
            case SMALL_SNOWBALL:
                g2d.setColor(Color.WHITE);
                break;
            case SNOWMAN_HEAD:
                g2d.setColor(new Color(255, 200, 100));
                break;
        }

        g2d.fillOval(x + padding, y + padding, TILE_SIZE - padding * 2, TILE_SIZE - padding * 2);
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawOval(x + padding, y + padding, TILE_SIZE - padding * 2, TILE_SIZE - padding * 2);
        g2d.setColor(Color.BLACK);
        String label;
        switch (piece.getType()) {
            case SMALL_SNOWBALL: label = "SS"; break;
            case LARGE_SNOWBALL: label = "LS"; break;
            case SNOWMAN_HEAD:   label = "SH"; break;
            case TREE:           label = "TR"; break;
            default:             label = "??"; break;
        }
        g2d.drawString(label, x + TILE_SIZE / 2 - 8, y + TILE_SIZE / 2 + 5);
    }
}