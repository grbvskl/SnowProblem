package model;

public class SmallSnowball extends Piece {
    private boolean isStacked;

    public SmallSnowball(int row, int col) {
        super(row, col, PieceType.SMALL_SNOWBALL);
        this.isStacked = false;
    }

    public boolean isStacked() { return isStacked; }
    public void setStacked(boolean value) { this.isStacked = value; }
}
