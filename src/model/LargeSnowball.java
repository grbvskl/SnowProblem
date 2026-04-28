package model;

public class LargeSnowball extends Piece {
    private boolean hasSmallOnTop;
    private boolean hasHeadOnTop;

    public boolean hasHeadOnTop() {return hasHeadOnTop;}
    public void setHasHeadOnTop(boolean value) { this.hasHeadOnTop = value; }
    public LargeSnowball(int row, int col) {
        super(row, col, PieceType.LARGE_SNOWBALL);
        this.hasSmallOnTop = false;
    }

    public boolean hasSmallOnTop() {return hasSmallOnTop; }
    public void setSmallOnTop(boolean value) { this.hasSmallOnTop = value; }
}
