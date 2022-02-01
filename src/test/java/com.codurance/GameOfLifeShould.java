package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GameOfLifeShould {

    @Test
    void return_board_with_single_dead_cell() {
        var initialState = new int[][]{{0}};

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{{0}};

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }

    @Test
    void return_board_with_multiple_dead_cell_horizontally() {
        var initialState = new int[][]{{0, 0}};

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{{0, 0}};

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }

    @Test
    void kill_cell_with_no_neighbour() {
        var initialState = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }


    @Test
    void kill_cell_with_1_neighbour() {
        var initialState = new int[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }


    @Test
    void keep_cell_with_2_neighbours() {
        var initialState = new int[][]{
            {1, 1, 1, 1, 1, 1, 1}
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0, 1, 1, 1, 1, 1, 0},
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }

    @Test
    void keep_cell_with_2_neighbours_vertically() {
        var initialState = new int[][]{
            {1},
            {1},
            {1},

        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0},
            {1},
            {0},

        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }


    @Test
    void keep_cell_with_2_neighbours_on_tl_br_diagonal() {
        var initialState = new int[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1},
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }

    @Test
    void keep_cell_with_2_neighbours_on_dl_tr_diagonal() {
        var initialState = new int[][]{
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0},
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }


    @Test
    void keep_cell_with_3_neighbours() {
        var initialState = new int[][]{
            {1, 1},
            {1, 1},
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {1, 1},
            {1, 1},
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }

    @Test
    void resurrect_cell_with_3_live_neighbours() {
        var initialState = new int[][]{
            {0, 1},
            {1, 1},
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {1, 1},
            {1, 1},
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }

    @Test
    void resurrect_cell_with_3_live_neighbours_even_if_they_die() {
        var initialState = new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 0},
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }

    @Test
    void kill_any_cell_with_four_neighbours() {
        var initialState = new int[][]{
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1},
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
        };

        int[][] result = gameOfLife.nextGen();

        assertArrayEquals(expected, result);
    }


}
