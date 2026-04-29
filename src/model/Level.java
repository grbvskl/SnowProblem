package model;

public class Level {
    // level identifier
    public int levelNumber;
    //array of pieces belong to level
    private Piece[] pieces;

    // constructor for creating a level
    public Level(int levelNumber, Piece[] pieces) {
        this.levelNumber = levelNumber;
        this.pieces = pieces;
    }

    public int getLevelNumber() {return levelNumber; }
    public Piece[] getPieces() {return pieces; }
}
