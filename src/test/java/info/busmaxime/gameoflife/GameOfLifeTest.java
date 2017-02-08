package info.busmaxime.gameoflife;

import org.junit.Test;

import static info.busmaxime.gameoflife.Cell.deadCell;
import static info.busmaxime.gameoflife.Cell.livingCell;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Game of life rules :
 * <ul>
 * <li>Each cell with one or no neighbors dies, as if by solitude</li>
 * <li>Each cell with four or more neighbors dies, as if by overpopulation</li>
 * <li>Each cell with two or three neighbors survives</li>
 * <li>A cell become alive if there is three neighbors</li>
 * </ul>
 * <p>
 */
public class GameOfLifeTest {

    @Test
    public void a_living_cell_with_no_neighbor_must_die() throws Exception {
        Cell[] neighbors = new Cell[]{deadCell(), deadCell(), deadCell(), deadCell()};

        assertThat(GameOfLife.getNewCellFromNeighbors(livingCell(), neighbors)).isEqualTo(deadCell());
    }

    @Test
    public void a_living_cell_with_two_neighbors_must_stay_alive() throws Exception {
        Cell[] neighbors = new Cell[]{livingCell(), deadCell(), livingCell(), deadCell()};

        assertThat(GameOfLife.getNewCellFromNeighbors(livingCell(), neighbors)).isEqualTo(livingCell());
    }

    @Test
    public void a_living_cell_with_three_neighbors_must_stay_alive() throws Exception {
        Cell[] neighbors = new Cell[]{livingCell(), livingCell(), livingCell(), deadCell()};

        assertThat(GameOfLife.getNewCellFromNeighbors(livingCell(), neighbors)).isEqualTo(livingCell());
    }

    @Test
    public void a_dead_cell_with_three_neighbors_brings_back_to_life() throws Exception {
        Cell[] neighbors = new Cell[]{livingCell(), livingCell(), livingCell(), deadCell()};

        assertThat(GameOfLife.getNewCellFromNeighbors(deadCell(), neighbors)).isEqualTo(livingCell());
    }

    @Test
    public void a_dead_cell_with_other_than_three_neighbors_remains_dead() throws Exception {

        Cell[] noNeighbor = new Cell[]{deadCell(), deadCell(), deadCell(), deadCell()};
        Cell[] oneNeighbor = new Cell[]{livingCell(), deadCell(), deadCell(), deadCell()};
        Cell[] twoNeighbors = new Cell[]{livingCell(), deadCell(), livingCell(), deadCell()};
        Cell[] threeNeighbors = new Cell[]{livingCell(), livingCell(), livingCell(), deadCell()};
        Cell[] fourNeighbors = new Cell[]{livingCell(), livingCell(), livingCell(), livingCell()};

        assertThat(GameOfLife.getNewCellFromNeighbors(deadCell(), noNeighbor)).as("No neighbor").isEqualTo(deadCell());
        assertThat(GameOfLife.getNewCellFromNeighbors(deadCell(), oneNeighbor)).as("One neighbor").isEqualTo(deadCell());
        assertThat(GameOfLife.getNewCellFromNeighbors(deadCell(), twoNeighbors)).as("Two neighbors").isEqualTo(deadCell());
        assertThat(GameOfLife.getNewCellFromNeighbors(deadCell(), threeNeighbors)).as("Three neighbors").isEqualTo(livingCell());
        assertThat(GameOfLife.getNewCellFromNeighbors(deadCell(), fourNeighbors)).as("Four neighbors").isEqualTo(deadCell());
    }

}
