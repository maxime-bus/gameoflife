package info.busmaxime.gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpaceTest {

    @Test
    public void i_can_get_four_neighbors_at_selected_space() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(1, 1)).containsExactly(false, false, false, false);
    }

    @Test
    public void i_can_only_get_right_and_bottom_neighbor_on_corner_top_left() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(0, 0)).containsExactly(false, false);
    }

    @Test
    public void i_can_only_get_left_and_bottom_neighbor_on_corner_top_right() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(2, 0)).containsExactly(false, false);
    }

    @Test
    public void i_can_only_get_left_and_top_neighbor_on_corner_bottom_right() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(2, 2)).containsExactly(false, false);
    }

    @Test
    public void i_can_only_get_right_and_top_neighbor_on_corner_bottom_left() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(0, 2)).containsExactly(false, false);
    }

    @Test
    public void i_can_only_get_top_right_and_bottom_neighbors_on_left_edge() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(0, 1)).containsExactly(true, true, true);
    }

    @Test
    public void i_can_only_get_left_right_and_bottom_neighbors_on_top_edge() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(1, 0)).containsExactly(true, true, true);
    }

    @Test
    public void i_can_only_get_top_left_and_bottom_neighbors_on_right_edge() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(2, 1)).containsExactly(true, true, true);
    }

    @Test
    public void i_can_only_get_left_top_adn_right_neighbors_on_bottom_edge() throws Exception {

        boolean[][] space = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        assertThat(new Space(space).getNeighbors(1, 2)).containsExactly(true, true, true);
    }

}
