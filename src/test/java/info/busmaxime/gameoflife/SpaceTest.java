package info.busmaxime.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static info.busmaxime.gameoflife.Cell.deadCell;
import static info.busmaxime.gameoflife.Cell.livingCell;
import static org.assertj.core.api.Assertions.assertThat;

public class SpaceTest {

    private Cell[][] space;

    @Before
    public void setUp() throws Exception {
        space = new Cell[][]{
                {livingCell(), deadCell(), livingCell()},
                {deadCell(), livingCell(), deadCell()},
                {livingCell(), deadCell(), livingCell()}
        };
    }

    @Test
    public void i_can_get_eight_neighbors_at_selected_space() throws Exception {
        assertThat(new Space(space).getNeighbors(1, 1))
                .containsOnly(deadCell(), deadCell(), deadCell(), deadCell(),
                        livingCell(), livingCell(), livingCell(), livingCell());
    }

    @Test
    public void i_can_only_get_right_corner_bottom_right_and_bottom_neighbor_on_corner_top_left() throws Exception {
        assertThat(new Space(space).getNeighbors(0, 0)).containsOnly(deadCell(), deadCell(), livingCell());
    }

    @Test
    public void i_can_only_get_left_corner_bottom_left_and_bottom_neighbor_on_corner_top_right() throws Exception {
        assertThat(new Space(space).getNeighbors(2, 0)).containsOnly(deadCell(), deadCell(), livingCell());
    }

    @Test
    public void i_can_only_get_left_corner_top_left_and_top_neighbor_on_corner_bottom_right() throws Exception {
        assertThat(new Space(space).getNeighbors(2, 2)).containsOnly(deadCell(), deadCell(), livingCell());
    }

    @Test
    public void i_can_only_get_right_corner_top_right_and_top_neighbor_on_corner_bottom_left() throws Exception {
        assertThat(new Space(space).getNeighbors(0, 2)).containsOnly(deadCell(), deadCell(), livingCell());
    }

    @Test
    public void i_can_only_get_top_corner_top_right_right_corner_bottom_right_and_bottom_neighbors_on_left_edge() throws Exception {
        assertThat(new Space(space).getNeighbors(0, 1)).containsOnly(livingCell(), livingCell(), livingCell(), deadCell(), deadCell());
    }

    @Test
    public void i_can_only_get_left_corner_bottom_left_corner_bottom_right_right_and_bottom_neighbors_on_top_edge() throws Exception {
        assertThat(new Space(space).getNeighbors(1, 0)).containsOnly(livingCell(), livingCell(), livingCell(), deadCell(), deadCell());
    }

    @Test
    public void i_can_only_get_top_corner_top_left_left_corner_bottom_left_and_bottom_neighbors_on_right_edge() throws Exception {
        assertThat(new Space(space).getNeighbors(2, 1)).containsOnly(livingCell(), livingCell(), livingCell(), deadCell(), deadCell());
    }

    @Test
    public void i_can_only_get_left_corner_top_left_top_corner_top_right_and_right_neighbors_on_bottom_edge() throws Exception {
        assertThat(new Space(space).getNeighbors(1, 2)).containsOnly(livingCell(), livingCell(), livingCell(), deadCell(), deadCell());
    }
}
