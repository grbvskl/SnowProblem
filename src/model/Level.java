package model;

public class Level {
    public int levelNumber;
    private Piece[] pieces;

    public Level(int levelNumber, Piece[] pieces) {
        this.levelNumber = levelNumber;
        this.pieces = pieces;
    }

    public int getLevelNumber() {return levelNumber; }
    public Piece[] getPieces() {return pieces; }
}
