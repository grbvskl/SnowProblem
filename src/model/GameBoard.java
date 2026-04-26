package model;

public class GameBoard {
    private static final int ROWS = 4;
    private static final int COLS = 5;
    private Piece[][] grid;

    public GameBoard() {
        grid = new Piece[ROWS][COLS];
    }

    public void loadLevel(Level level) {
        grid = new Piece[ROWS][COLS];
        for (Piece piece : level.getPieces()) {
            grid[piece.getRow()][piece.getCol()] = piece;
        }
    }

    public Piece getPiece(int row, int col) {
        return grid[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        grid[row][col] = piece;
    }

    public int getRows() { return ROWS; }
    public int getCols() { return COLS; }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    public boolean movePiece(Piece piece, int dRow, int dCol) {
        if (piece.getType() == PieceType.TREE) return true;
        if (piece instanceof LargeSnowball && ((LargeSnowball) piece).hasSmallOnTop()) return true;
        if (piece instanceof SmallSnowball && ((SmallSnowball) piece).isStacked()) return true;

        int currentRow = piece.getRow();
        int currentCol = piece.getCol();
        int nextRow = currentRow + dRow;
        int nextCol = currentCol + dCol;

        while (isValid(nextRow, nextCol) && grid[nextRow][nextCol] == null) {
            nextRow += dRow;
            nextCol += dCol;
        }

        if (!isValid(nextRow, nextCol)) {
            grid[currentRow][currentCol] = null;
            return false;
        }

        int stopRow = nextRow - dRow;
        int stopCol = nextCol - dCol;

        if (stopRow == currentRow && stopCol == currentCol) return true;

        grid[currentRow][currentCol] = null;
        grid[stopRow][stopCol] = piece;
        piece.setRow(stopRow);
        piece.setCol(stopCol);

        return true;
    }

    public void checkStacking() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Piece piece = grid[row][col];
                if (piece instanceof SmallSnowball && !((SmallSnowball) piece).isStacked()) {
                    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
                    for (int[] dir : directions) {
                        int adjRow = row + dir[0];
                        int adjCol = col + dir[1];
                        if (isValid(adjRow, adjCol)) {
                            Piece adjacent = grid[adjRow][adjCol];
                            if (adjacent instanceof LargeSnowball && !((LargeSnowball) adjacent).hasSmallOnTop()) {
                                ((SmallSnowball) piece).setStacked(true);
                                ((LargeSnowball) adjacent).setSmallOnTop(true);
                                System.out.println("Stacked!");
                            }
                        }
                    }
                }
            }
        }
    }

    public void checkHeadPlacement() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Piece piece = grid[row][col];
                if (piece instanceof SnowmanHead && !((SnowmanHead) piece).isPlaced()) {
                    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
                    for (int[] dir : directions) {
                        int adjRow = row + dir[0];
                        int adjCol = col + dir[1];
                        if (isValid(adjRow, adjCol)) {
                            Piece adjacent = grid[adjRow][adjCol];
                            if (adjacent instanceof LargeSnowball && ((LargeSnowball) adjacent).hasSmallOnTop()) {
                                ((SnowmanHead) piece).setPlaced(true);
                                System.out.println("Snowman head placed!");
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkWin() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Piece piece = grid[row][col];
                if (piece instanceof SnowmanHead && !((SnowmanHead) piece).isPlaced()) {
                    return false;
                }
            }
        }
        return true;
    }
}