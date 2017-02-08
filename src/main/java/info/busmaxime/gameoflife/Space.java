package info.busmaxime.gameoflife;

public class Space {

    private Cell[][] state;
    private final int maxRowsZeroBased;
    private final int maxColumnsZeroBased;

    public Space(Cell[][] space) {
        this.state = space;
        this.maxRowsZeroBased = space.length - 1;
        this.maxColumnsZeroBased = space[this.maxRowsZeroBased].length - 1;
    }

    public Cell[] getNeighbors(int x, int y) {
        if (isBottomEdge(x, y)) {
            return new Cell[]{topNeighbor(x, y), leftNeighbor(x, y), rightNeighbor(x, y),
                    cornerTopLeftNeighbor(x, y), cornerTopRightNeighbor(x, y)};
        }

        if (isRightEdge(x, y)) {
            return new Cell[]{topNeighbor(x, y), leftNeighbor(x, y), bottomNeighbor(x, y),
                    cornerTopLeftNeighbor(x, y), cornerBottomLeftNeighbor(x, y)};
        }

        if (isTopEdge(x, y)) {
            return new Cell[]{leftNeighbor(x, y), rightNeighbor(x, y), bottomNeighbor(x, y),
                    cornerBottomLeftNeighbor(x, y), cornerBottomRightNeighbor(x, y)};
        }

        if (isLeftEdge(x, y)) {
            return new Cell[]{topNeighbor(x, y), rightNeighbor(x, y), bottomNeighbor(x, y),
                    cornerTopRightNeighbor(x, y), cornerBottomRightNeighbor(x, y)};
        }

        if (isCornerBottomLeft(x, y)) {
            return new Cell[]{topNeighbor(x, y), rightNeighbor(x, y), cornerTopRightNeighbor(x, y)};
        }

        if (isCornerBottomRight(x, y)) {
            return new Cell[]{topNeighbor(x, y), leftNeighbor(x, y), cornerTopLeftNeighbor(x, y)};
        }

        if (isCornerTopRight(x, y)) {
            return new Cell[]{bottomNeighbor(x, y), leftNeighbor(x, y), cornerBottomLeftNeighbor(x, y)};
        }

        if (isCornerTopLeft(x, y)) {
            return new Cell[]{bottomNeighbor(x, y), rightNeighbor(x, y), cornerBottomRightNeighbor(x, y)};
        }

        return new Cell[]{
                topNeighbor(x, y), cornerTopRightNeighbor(x, y), rightNeighbor(x, y),
                cornerBottomRightNeighbor(x, y), bottomNeighbor(x, y), cornerBottomLeftNeighbor(x, y),
                leftNeighbor(x, y), cornerTopLeftNeighbor(x, y)};
    }

    public void computeNewSpace() {
        Cell[][] newState = new Cell[maxRowsZeroBased + 1][maxColumnsZeroBased + 1];

        for (int i = 0; i <= this.getMaxRowsZeroBased(); i++) {
            for (int j = 0; j <= this.getMaxColumnsZeroBased(); j++) {
                newState[i][j] = GameOfLife.getNewCellFromNeighbors(this.state[i][j], getNeighbors(i, j));
            }
        }

        this.state = newState;
    }

    public Cell[][] getState() {
        return state;
    }

    public int getMaxRowsZeroBased() {
        return maxRowsZeroBased;
    }

    public int getMaxColumnsZeroBased() {
        return maxColumnsZeroBased;
    }

    private boolean isBottomEdge(int x, int y) {
        return (x > 0 && x < this.maxRowsZeroBased) && y == this.maxRowsZeroBased;
    }

    private boolean isRightEdge(int x, int y) {
        return x == this.maxRowsZeroBased && (y > 0 && y < this.maxColumnsZeroBased);
    }

    private boolean isTopEdge(int x, int y) {
        return x > 0 && x < this.maxRowsZeroBased && y == 0;
    }

    private boolean isLeftEdge(int x, int y) {
        return x == 0 && y > 0 && y < this.maxColumnsZeroBased;
    }

    private boolean isCornerTopLeft(int x, int y) {
        return x == 0 && y == 0;
    }

    private boolean isCornerBottomLeft(int x, int y) {
        return x == 0 && y == this.maxColumnsZeroBased;
    }

    private boolean isCornerBottomRight(int x, int y) {
        return x == this.maxRowsZeroBased && y == this.maxColumnsZeroBased;
    }

    private boolean isCornerTopRight(int x, int y) {
        return x == this.maxRowsZeroBased && y == 0;
    }

    private Cell leftNeighbor(int x, int y) {
        return this.state[x - 1][y];
    }

    private Cell cornerTopLeftNeighbor(int x, int y) {
        return this.state[x - 1][y - 1];
    }

    private Cell topNeighbor(int x, int y) {
        return this.state[x][y - 1];
    }

    private Cell cornerTopRightNeighbor(int x, int y) {
        return this.state[x + 1][y - 1];
    }

    private Cell rightNeighbor(int x, int y) {
        return this.state[x + 1][y];
    }

    private Cell cornerBottomRightNeighbor(int x, int y) {
        return this.state[x + 1][y + 1];
    }

    private Cell bottomNeighbor(int x, int y) {
        return this.state[x][y + 1];
    }

    private Cell cornerBottomLeftNeighbor(int x, int y) {
        return this.state[x - 1][y + 1];
    }
}
