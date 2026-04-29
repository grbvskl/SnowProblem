package ui;

import controller.GameController;
import model.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;

//drawing game board, rendering pieces, handling mouse input
public class GamePanel extends JPanel {
    private static final int COLS = 5;
    private static final int ROWS = 4;
    private static final int TILE_SIZE = 80;

    private GameController controller;
    private GameWindow window;

    private BufferedImage imgLargeSnowball;
    private BufferedImage imgSmallSnowball;
    private BufferedImage imgTree;
    private BufferedImage imgHeadBlue;
    private BufferedImage imgHeadRed;
    private BufferedImage imgHeadYellow;
    private BufferedImage imgSnowmanStack;
    private BufferedImage imgSnowmanBlue;
    private BufferedImage imgSnowmanRed;
    private BufferedImage imgSnowmanYellow;
    private BufferedImage imgHole;

    public GamePanel(GameController controller, GameWindow window) {
        this.controller = controller;
        this.window = window;
        setPreferredSize(new java.awt.Dimension(COLS * TILE_SIZE, ROWS * TILE_SIZE));
        setBackground(Color.WHITE);
        loadImages();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = e.getX() / TILE_SIZE;
                int row = e.getY() / TILE_SIZE;
                controller.handleClick(row, col);
                window.updateMoveCount(controller.getMoveCount());
                repaint();
            }
        });
    }

    private void loadImages() {
        System.out.println("Looking for assets in: " + new File("assets").getAbsolutePath());
        try {
            imgLargeSnowball = ImageIO.read(new File("assets/snowball_large.png"));
            imgSmallSnowball = ImageIO.read(new File("assets/snowball_small.png"));
            imgTree          = ImageIO.read(new File("assets/tree.png"));
            imgHeadBlue      = ImageIO.read(new File("assets/head_blue.png"));
            imgHeadRed       = ImageIO.read(new File("assets/head_red.png"));
            imgHeadYellow    = ImageIO.read(new File("assets/head_yellow.png"));
            imgSnowmanStack  = ImageIO.read(new File("assets/snowman_stack.png"));
            imgSnowmanBlue   = ImageIO.read(new File("assets/snowman_blue.png"));
            imgSnowmanRed    = ImageIO.read(new File("assets/snowman_red.png"));
            imgSnowmanYellow = ImageIO.read(new File("assets/snowman_yellow.png"));
            imgHole          = ImageIO.read(new File("assets/hole.png"));
        } catch (IOException e) {
            System.out.println("Could not load images: " + e.getMessage());
        }
    }

    //rendering method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2d);
        drawPieces(g2d);
    }

    private void drawGrid(Graphics2D g2d) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int x = col * TILE_SIZE;
                int y = row * TILE_SIZE;
                g2d.setColor(new Color(220, 235, 255));
                g2d.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                g2d.setColor(new Color(180, 200, 230));
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
        int padding = 4;

        //highlight selected piece
        if (piece == controller.getSelectedPiece()) {
            g2d.setColor(new Color(255, 230, 0, 150));
            g2d.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }

        BufferedImage img = null;

        //choose image
        if (piece instanceof LargeSnowball ls) {
            if (ls.hasHeadOnTop()) {
                img = getSnowmanImage(ls);
            } else if (ls.hasSmallOnTop()) {
                img = imgSnowmanStack;
            } else {
                img = imgLargeSnowball;
            }
        } else if (piece instanceof SmallSnowball) {
            img = imgSmallSnowball;
        } else if (piece instanceof Tree) {
            img = imgTree;
        } else if (piece instanceof SnowmanHead) {
            img = getHeadImage(piece);
        }

        if (img != null) {
            g2d.drawImage(img, x + padding, y + padding, TILE_SIZE - padding * 2, TILE_SIZE - padding * 2, null);
        }
    }

    private BufferedImage getHeadImage(Piece piece) {
        int id = System.identityHashCode(piece) % 3;
        if (id == 0) return imgHeadBlue;
        if (id == 1) return imgHeadRed;
        return imgHeadYellow;
    }

    private BufferedImage getSnowmanImage(LargeSnowball ls) {
        int id = System.identityHashCode(ls) % 3;
        if (id == 0) return imgSnowmanBlue;
        if (id == 1) return imgSnowmanRed;
        return imgSnowmanYellow;
    }
}