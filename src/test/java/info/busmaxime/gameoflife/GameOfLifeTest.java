package info.busmaxime.gameoflife;

import org.junit.Test;

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

        boolean livingCell = true;
        boolean[] neighbors = new boolean[]{false, false, false, false};

        assertThat(GameOfLife.shouldStayAlive(livingCell, neighbors)).isEqualTo(false);
    }

    @Test
    public void a_living_cell_with_two_neighbors_must_stay_alive() throws Exception {

        boolean livingCell = true;
        boolean[] neighbors = new boolean[]{true, false, true, false};

        assertThat(GameOfLife.shouldStayAlive(livingCell, neighbors)).isEqualTo(true);
    }

    @Test
    public void a_living_cell_with_three_neighbors_must_stay_alive() throws Exception {

        boolean livingCell = true;
        boolean[] neighbors = new boolean[]{true, true, true, false};

        assertThat(GameOfLife.shouldStayAlive(livingCell, neighbors)).isEqualTo(true);
    }

    @Test
    public void a_dead_cell_with_three_neighbors_brings_back_to_life() throws Exception {
        boolean deadCell = false;
        boolean[] neighbors = new boolean[]{true, true, true, false};

        assertThat(GameOfLife.shouldStayAlive(deadCell, neighbors)).isEqualTo(true);
    }

    @Test
    public void a_dead_cell_with_other_than_three_neighbors_remains_dead() throws Exception {

        boolean deadCell = false;
        boolean[] noNeighbor = new boolean[]{false, false, false, false};
        boolean[] oneNeighbor = new boolean[]{true, false, false, false};
        boolean[] twoNeighbors = new boolean[]{true, false, true, false};
        boolean[] threeNeighbors = new boolean[]{true, true, true, false};
        boolean[] fourNeighbors = new boolean[]{true, true, true, true};

        assertThat(GameOfLife.shouldStayAlive(deadCell, noNeighbor)).as("No neighbor").isEqualTo(false);
        assertThat(GameOfLife.shouldStayAlive(deadCell, oneNeighbor)).as("One neighbor").isEqualTo(false);
        assertThat(GameOfLife.shouldStayAlive(deadCell, twoNeighbors)).as("Two neighbors").isEqualTo(false);
        assertThat(GameOfLife.shouldStayAlive(deadCell, threeNeighbors)).as("Three neighbors").isEqualTo(true);
        assertThat(GameOfLife.shouldStayAlive(deadCell, fourNeighbors)).as("Four neighbors").isEqualTo(false);
    }

}
