package model;

public class GameBoard {
    private static final int ROWS = 4;
    private static final int COLS = 5;
    private Piece[][] grid;
    private boolean anyStacked = false;

    public GameBoard() {
        grid = new Piece[ROWS][COLS];
    }

    public void loadLevel(Level level) {
        grid = new Piece[ROWS][COLS];
        anyStacked = false;
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

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    public boolean tryStack(int ssRow, int ssCol, int lsRow, int lsCol) {
        Piece piece = grid[ssRow][ssCol];
        if (!(piece instanceof SmallSnowball ss)) return false;
        if (ss.isStacked()) return false;

        int rowDiff = Math.abs(ssRow - lsRow);
        int colDiff = Math.abs(ssCol - lsCol);
        if (rowDiff + colDiff != 1) return false; // not adjacent

        Piece target = grid[lsRow][lsCol];
        if (!(target instanceof LargeSnowball ls)) return false;
        if (ls.hasSmallOnTop()) return false;

        ss.setStacked(true);
        ls.setSmallOnTop(true);
        grid[ssRow][ssCol] = null;
        anyStacked = true;
        System.out.println("Stacked!");
        return true;
    }

    public boolean movePiece(Piece piece, int dRow, int dCol) {
        if (piece.getType() == PieceType.TREE) return false;
        if (piece instanceof SmallSnowball && ((SmallSnowball) piece).isStacked()) return true;
        if (piece instanceof LargeSnowball && ((LargeSnowball) piece).hasSmallOnTop()) return true;

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

    public void checkHeadPlacement() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {

                Piece piece = grid[row][col];

                if (piece instanceof SnowmanHead sh && !sh.isPlaced()) {

                    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

                    for (int[] d : dirs) {
                        int r = row + d[0];
                        int c = col + d[1];

                        if (!isValid(r, c)) continue;

                        Piece adj = grid[r][c];

                        if (adj instanceof LargeSnowball ls
                                && ls.hasSmallOnTop()
                                && !ls.hasHeadOnTop()) {

                            sh.setPlaced(true);
                            ls.setHasHeadOnTop(true);
                            grid[row][col] = null;

                            System.out.println("Snowman head placed!");
                            return;
                        }
                    }
                }
            }
        }
    }

    public boolean checkWin() {
        if (!anyStacked) return false;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Piece p = grid[r][c];

                if (p instanceof SmallSnowball) return false;
                if (p instanceof SnowmanHead) return false;
            }
        }
        return true;
    }
}