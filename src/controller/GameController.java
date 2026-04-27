package controller;

import model.*;
import javax.swing.JOptionPane;

public class GameController {
    private GameBoard board;
    private Piece selectedPiece;
    private boolean gameOver;

    public GameController() {
        board = new GameBoard();
        selectedPiece = null;
        gameOver = false;
        loadLevel(1);
    }

    private void loadLevel(int levelNumber) {
        Level level = LevelManager.getLevel(levelNumber);
        board.loadLevel(level);
    }

    public void handleClick(int row, int col) {
        System.out.println("Clicked at row " + row + " and col " + col);
        if (gameOver) return;

        if (selectedPiece == null) {
            Piece clicked = board.getPiece(row, col);
            if (clicked != null && clicked.getType() != PieceType.TREE) {
                selectedPiece = clicked;
                System.out.println("Selected: " + clicked.getType() + " at " + row + "," + col);
            }
        } else {
            int dRow = row - selectedPiece.getRow();
            int dCol = col - selectedPiece.getCol();

            if (dRow != 0 && dCol != 0) {
                selectedPiece = null;
                return;
            }

            if (dRow != 0) dRow = dRow / Math.abs(dRow);
            if (dCol != 0) dCol = dCol / Math.abs(dCol);

            System.out.println("Moving: dRow" + dRow + " dCol=" + dCol);
            boolean survived = board.movePiece(selectedPiece, dRow, dCol);
            System.out.println("Checking stacking...");
            board.checkStacking();
            board.checkHeadPlacement();
            System.out.println("Win check: " + board.checkWin());

            System.out.println("survived=" + survived + " win=" + board.checkWin());
            if (board.checkWin()) {
                gameOver = true;
                JOptionPane.showMessageDialog(null, "You win! All snowmen complete!");
            } else if (!survived) {
                gameOver = true;
                JOptionPane.showMessageDialog(null, "Game Over! A piece fell off the board!");
            }

            selectedPiece = null;
        }
    }

    public GameBoard getBoard() { return board; }
    public Piece getSelectedPiece() { return selectedPiece; }
    public boolean isGameOver() { return gameOver; }
}