package controller;

import model.*;
import javax.swing.JOptionPane;
// Controls game logic and interactions between UI and model
public class GameController {
    private GameBoard board;
    private Piece selectedPiece;
    private boolean gameOver;
    private int moveCount;
    private int currentLevel;
    private ScoreManager scoreManager;

    //constructor to initialize the game
    public GameController() {
        board = new GameBoard();
        selectedPiece = null;
        gameOver = false;
        currentLevel = 1;
        loadLevel(currentLevel);
        moveCount = 0;
        scoreManager = new ScoreManager();
    }

    public void resetLevel() {
        moveCount = 0;
        gameOver = false;
        selectedPiece = null;
        loadLevel(currentLevel);
    }

    public void Level(int levelNumber) {
        currentLevel = levelNumber;
        moveCount = 0;
        gameOver = false;
        selectedPiece = null;
        Level level = LevelManager.getLevel(currentLevel);
        board.loadLevel(level);
    }

    //loads a specific level
    public void loadLevel(int levelNumber) {
        currentLevel = levelNumber;
        moveCount = 0;
        gameOver = false;
        selectedPiece = null;
        // get level data and load into board
        Level level = LevelManager.getLevel(levelNumber);
        board.loadLevel(level);
    }

    public void handleClick(int row, int col) {
        if (gameOver) return;

        if (selectedPiece == null) {
            Piece clicked = board.getPiece(row, col);
            //ignore empty tile
            if (clicked == null) return;

            if (clicked.getType() != PieceType.TREE && clicked.getType() != PieceType.SNOWMAN_HEAD) {
                selectedPiece = clicked;
            }

        } else {
            Piece target = board.getPiece(row, col);

            if (selectedPiece instanceof SmallSnowball ss && !ss.isStacked()
                    && target instanceof LargeSnowball ls && !ls.hasSmallOnTop()) {
                if (board.tryStack(selectedPiece.getRow(), selectedPiece.getCol(), row, col)) {
                    moveCount++;
                    //check if head can be placed now
                    board.checkHeadPlacement();
                    if (board.checkWin()) {
                        gameOver = true;
                        scoreManager.submitScore(currentLevel, moveCount);
                        JOptionPane.showMessageDialog(null,
                                "You win!\nMoves: " + moveCount + "\nBest: " + scoreManager.getBestScore(currentLevel));
                    }
                    selectedPiece = null;
                    return;
                }
            }
            
            int dRow = row - selectedPiece.getRow();
            int dCol = col - selectedPiece.getCol();

            //prevent diagonal movement
            if (dRow != 0 && dCol != 0) {
                selectedPiece = null;
                return;
            }

            if (dRow != 0) dRow = dRow / Math.abs(dRow);
            if (dCol != 0) dCol = dCol / Math.abs(dCol);

            boolean survived = board.movePiece(selectedPiece, dRow, dCol);
            moveCount++;
            board.checkHeadPlacement();

            if (board.checkWin()) {
                gameOver = true;
                scoreManager.submitScore(currentLevel, moveCount);
                JOptionPane.showMessageDialog(null,
                        "You win!\nMoves: " + moveCount + "\nBest: " + scoreManager.getBestScore(currentLevel));
            } else if (!survived) {
                gameOver = true;
                JOptionPane.showMessageDialog(null, "Game Over! A piece fell off the board!");
            }

            selectedPiece = null;
        }

    }

    //getters for ui
    public GameBoard getBoard() { return board; }
    public Piece getSelectedPiece() { return selectedPiece; }
    public boolean isGameOver() { return gameOver; }
    public int getMoveCount() { return moveCount; }
    public int getBestScore(int level) { return scoreManager.getBestScore(level); }
    public int getCurrentLevel() { return currentLevel; }
}