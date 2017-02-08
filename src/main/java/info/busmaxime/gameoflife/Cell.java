package info.busmaxime.gameoflife;

public class Cell {

    private final boolean alive;

    private Cell(boolean alive) {
        this.alive = alive;
    }

    public static Cell livingCell() {
        return new Cell(true);
    }

    public static Cell deadCell() {
        return new Cell(false);
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return alive == cell.alive;
    }

    @Override
    public int hashCode() {
        return (alive ? 1 : 0);
    }
}
