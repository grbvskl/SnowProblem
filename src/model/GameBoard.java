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

    public boolean movePiece(Piece piece, int dRow, int dCol) {

        if (piece.getType() == PieceType.TREE) return false;

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
            if (piece instanceof SmallSnowball ss) {
                ss.setStacked(false);
            }

            if (piece instanceof LargeSnowball ls) {
                ls.setSmallOnTop(false);
                ls.setHasHeadOnTop(false);
            }

            grid[currentRow][currentCol] = null;

            return false;
        }

        Piece target = grid[nextRow][nextCol];

        if (piece instanceof SmallSnowball ss && target instanceof LargeSnowball ls) {
            if (!ls.hasSmallOnTop() && !ss.isStacked()) {
                ss.setStacked(true);
                ls.setSmallOnTop(true);
                grid[currentRow][currentCol] = null;
                anyStacked = true;
                System.out.println("Stacked!");
                return true;
            }
        }

        if (piece instanceof SnowmanHead sh && target instanceof LargeSnowball ls) {
            if (ls.hasSmallOnTop() && !ls.hasHeadOnTop()) {
                sh.setPlaced(true);
                ls.setHasHeadOnTop(true);
                grid[currentRow][currentCol] = null;
                System.out.println("Snowman head placed!");
                return true;
            }
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

                if (piece instanceof SmallSnowball ss && !ss.isStacked()) {

                    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

                    for (int[] d : dirs) {
                        int r = row + d[0];
                        int c = col + d[1];

                        if (!isValid(r, c)) continue;

                        Piece adj = grid[r][c];

                        if (adj instanceof LargeSnowball ls && !ls.hasSmallOnTop()) {
                            ss.setStacked(true);
                            ls.setSmallOnTop(true);
                            grid[row][col] = null;

                            anyStacked = true;
                            System.out.println("Stacked!");
                            return;
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