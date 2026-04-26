package model;

public abstract class Piece {
    protected int row;
    protected int col;
    protected PieceType type;

    public Piece(int row, int col, PieceType type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public int getRow() {return row; }
    public int getCol() {return col; }
    public PieceType getType() { return type; }

    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
}