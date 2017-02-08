package info.busmaxime.gameoflife;

public class Space {

    private boolean[][] state;
    private final int maxRowsZeroBased;
    private final int maxColumnsZeroBased;

    public Space(boolean[][] space) {
        this.state = deepCopyIntMatrix(space);
        this.maxRowsZeroBased = space.length - 1;
        this.maxColumnsZeroBased = space[this.maxRowsZeroBased].length - 1;
    }

    public boolean[] getNeighbors(int x, int y) {
        if (isBottomEdge(x, y)) {
            return new boolean[]{topNeighbor(x, y), leftNeighbor(x, y), rightNeighbor(x, y),
                    cornerTopLeftNeighbor(x, y), cornerTopRightNeighbor(x, y)};
        }

        if (isRightEdge(x, y)) {
            return new boolean[]{topNeighbor(x, y), leftNeighbor(x, y), bottomNeighbor(x, y),
                    cornerTopLeftNeighbor(x, y), cornerBottomLeftNeighbor(x, y)};
        }

        if (isTopEdge(x, y)) {
            return new boolean[]{leftNeighbor(x, y), rightNeighbor(x, y), bottomNeighbor(x, y),
                    cornerBottomLeftNeighbor(x, y), cornerBottomRightNeighbor(x, y)};
        }

        if (isLeftEdge(x, y)) {
            return new boolean[]{topNeighbor(x, y), rightNeighbor(x, y), bottomNeighbor(x, y),
                    cornerTopRightNeighbor(x, y), cornerBottomRightNeighbor(x, y)};
        }

        if (isCornerBottomLeft(x, y)) {
            return new boolean[]{topNeighbor(x, y), rightNeighbor(x, y), cornerTopRightNeighbor(x, y)};
        }

        if (isCornerBottomRight(x, y)) {
            return new boolean[]{topNeighbor(x, y), leftNeighbor(x, y), cornerTopLeftNeighbor(x, y)};
        }

        if (isCornerTopRight(x, y)) {
            return new boolean[]{bottomNeighbor(x, y), leftNeighbor(x, y), cornerBottomLeftNeighbor(x, y)};
        }

        if (isCornerTopLeft(x, y)) {
            return new boolean[]{bottomNeighbor(x, y), rightNeighbor(x, y), cornerBottomRightNeighbor(x, y)};
        }

        return new boolean[]{
                topNeighbor(x, y), cornerTopRightNeighbor(x, y), rightNeighbor(x, y),
                cornerBottomRightNeighbor(x, y), bottomNeighbor(x, y), cornerBottomLeftNeighbor(x, y),
                leftNeighbor(x, y), cornerTopLeftNeighbor(x, y)};
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

    private boolean leftNeighbor(int x, int y) {
        return this.state[x - 1][y];
    }

    private boolean cornerTopLeftNeighbor(int x, int y) {
        return this.state[x - 1][y - 1];
    }

    private boolean topNeighbor(int x, int y) {
        return this.state[x][y - 1];
    }

    private boolean cornerTopRightNeighbor(int x, int y) {
        return this.state[x + 1][y - 1];
    }

    private boolean rightNeighbor(int x, int y) {
        return this.state[x + 1][y];
    }

    private boolean cornerBottomRightNeighbor(int x, int y) {
        return this.state[x + 1][y + 1];
    }

    private boolean bottomNeighbor(int x, int y) {
        return this.state[x][y + 1];
    }

    private boolean cornerBottomLeftNeighbor(int x, int y) {
        return this.state[x - 1][y + 1];
    }

    public boolean[][] getState() {
        return state;
    }

    public int getMaxRowsZeroBased() {
        return maxRowsZeroBased;
    }

    public int getMaxColumnsZeroBased() {
        return maxColumnsZeroBased;
    }

    public void computeNewSpace() {
        boolean[][] newState = deepCopyIntMatrix(this.state);

        for (int i = 0; i <= this.getMaxRowsZeroBased(); i++) {
            for (int j = 0; j <= this.getMaxColumnsZeroBased(); j++) {
                newState[i][j] = GameOfLife.shouldStayAlive(this.state[i][j], getNeighbors(i, j));
            }
        }

        this.state = newState;
    }

    public static boolean[][] deepCopyIntMatrix(boolean[][] input) {
        if (input == null)
            return null;
        boolean[][] result = new boolean[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }
}
