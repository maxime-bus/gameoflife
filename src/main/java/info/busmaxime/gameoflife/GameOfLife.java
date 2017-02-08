package info.busmaxime.gameoflife;

public class GameOfLife {

    public static Cell getNewCellFromNeighbors(Cell cell, Cell[] neighbors) {
        int numberOfNeighorsAlive = 0;

        for (Cell neighbor : neighbors) {
            if (neighbor.isAlive()) numberOfNeighorsAlive++;
        }

        if (numberOfNeighorsAlive == 3) {
            return Cell.livingCell();
        }

        if (cell.isAlive() && numberOfNeighorsAlive == 2) {
            return Cell.livingCell();
        }

        return Cell.deadCell();
    }
}
