package model;

// piece placement, movement, stacking, win conditions
public class GameBoard {
    private static final int ROWS = 4;
    private static final int COLS = 5;
    private Piece[][] grid;
    private boolean anyStacked = false;

    public GameBoard() {
        grid = new Piece[ROWS][COLS];
    }

    public void loadLevel(Level level) {
        //reset grid and stacking state
        grid = new Piece[ROWS][COLS];
        anyStacked = false;
        //place each piece at its position
        for (Piece piece : level.getPieces()) {
            grid[piece.getRow()][piece.getCol()] = piece;
        }
    }

    //returns piece at given position
    public Piece getPiece(int row, int col) {
        return grid[row][col];
    }

    //sets a piece at given position
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

    //stacking small snowball on large one
    public boolean tryStack(int ssRow, int ssCol, int lsRow, int lsCol) {
        Piece piece = grid[ssRow][ssCol];
        if (!(piece instanceof SmallSnowball ss)) return false;
        //cannot stack if already stacked
        if (ss.isStacked()) return false;

        //must be adjacent
        int rowDiff = Math.abs(ssRow - lsRow);
        int colDiff = Math.abs(ssCol - lsCol);
        if (rowDiff + colDiff != 1) return false;

        Piece target = grid[lsRow][lsCol];
        if (!(target instanceof LargeSnowball ls)) return false;
        if (ls.hasSmallOnTop()) return false;

        ss.setStacked(true);
        ls.setSmallOnTop(true);
        //remove small snowball
        grid[ssRow][ssCol] = null;
        anyStacked = true;
        System.out.println("Stacked!");
        return true;
    }

    //move a piece until it hits an obstacle
    //return false if fell off the board
    public boolean movePiece(Piece piece, int dRow, int dCol) {
        if (piece.getType() == PieceType.TREE) return false;
        if (piece instanceof SmallSnowball && ((SmallSnowball) piece).isStacked()) return true;
        if (piece instanceof LargeSnowball && ((LargeSnowball) piece).hasSmallOnTop()) return true;

        int currentRow = piece.getRow();
        int currentCol = piece.getCol();
        int nextRow = currentRow + dRow;
        int nextCol = currentCol + dCol;

        //move a piece until it hits an obstacle
        while (isValid(nextRow, nextCol) && grid[nextRow][nextCol] == null) {
            nextRow += dRow;
            nextCol += dCol;
        }

        //falling off the board
        if (!isValid(nextRow, nextCol)) {
            grid[currentRow][currentCol] = null;
            return false;
        }

        //stop before obstacle
        int stopRow = nextRow - dRow;
        int stopCol = nextCol - dCol;

        //update movement
        if (stopRow == currentRow && stopCol == currentCol) return true;

        //update grid position
        grid[currentRow][currentCol] = null;
        grid[stopRow][stopCol] = piece;
        //update piece coordinates
        piece.setRow(stopRow);
        piece.setCol(stopCol);

        return true;
    }

    //check if any snowman head can be placed on a valid stack
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

                        //check if it's a validly stacked large snowball
                        if (adj instanceof LargeSnowball ls
                                && ls.hasSmallOnTop()
                                && !ls.hasHeadOnTop()) {

                            //place head onto snowman
                            sh.setPlaced(true);
                            ls.setHasHeadOnTop(true);
                            //remove head from grid
                            grid[row][col] = null;

                            System.out.println("Snowman head placed!");
                            return;
                        }
                    }
                }
            }
        }
    }

    //check if the player has won the level
    public boolean checkWin() {
        //at least 1 stack
        if (!anyStacked) return false;

        //ensure no loose snowballs and heads remain
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