package com.codurance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOfLifeShould {

    @Test
    void give_us_an_empty_board_when_no_live_cells() {
        var initialState = new boolean[][]{
            {false, false},
            {false, false}
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);

        var expected = new boolean[][]{
            {false, false},
            {false, false}
        };

        var result = gameOfLife.nextGen();
        Assertions.assertArrayEquals(initialState, result);

    }

    @Test
    void give_us_an_empty_board_when_one_cell_living_with_all_dead_neighbours(){
        var initialState = new boolean[][]{
            {false, false, false},
            {false, true, false},
            {false, false, false}
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);
        var expected = new boolean[][]{
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        var result = gameOfLife.nextGen();
        Assertions.assertArrayEquals(expected, result);
    }
}
