package model;

public class LargeSnowball extends Piece {
    private boolean hasSmallOnTop;

    public LargeSnowball(int row, int col) {
        super(row, col, PieceType.LARGE_SNOWBALL);
        this.hasSmallOnTop = false;
    }

    public boolean hasSmallOnTop() {return hasSmallOnTop; }
    public void setSmallOnTop(boolean value) { this.hasSmallOnTop = value; }
}
