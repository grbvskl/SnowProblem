package model;

public class SnowmanHead extends Piece {
    private boolean isPlaced;

    public SnowmanHead(int row, int col) {
        super(row, col, PieceType.SNOWMAN_HEAD);
        this.isPlaced = false;
    }

    public boolean isPlaced() {return isPlaced; }
    public void setPlaced(boolean value) { this.isPlaced = value; }
}
