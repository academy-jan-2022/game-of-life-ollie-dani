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
        Assertions.assertArrayEquals(expected, result);

    }

    @Test
    void bring_top_left_cell_to_life_when_neighbours_are_all_alive() {
        var initialState = new boolean[][]{
            {false, true},
            {true, true}
        };

        GameOfLife gameOfLife = new GameOfLife(initialState);
        var expected = new boolean[][]{
            {true, true},
            {true, true}
        };
        var result = gameOfLife.nextGen();
        Assertions.assertArrayEquals(expected, result);
    }

//    @Test
//    void give_us_an_empty_board_when_one_cell_living_with_all_dead_neighbours() {
//        var initialState = new boolean[][]{
//            {false, false, false},
//            {false, true, false},
//            {false, false, false}
//        };
//
//        GameOfLife gameOfLife = new GameOfLife(initialState);
//        var expected = new boolean[][]{
//            {false, false, false},
//            {false, false, false},
//            {false, false, false}
//        };
//        var result = gameOfLife.nextGen();
//        Assertions.assertArrayEquals(expected, result);
//    }
//
//    @Test
//    void give_us_an_empty_board_when_one_cell_living_with_1_neighbour() {
//        var initialState = new boolean[][]{
//            {true, false, false},
//            {false, true, false},
//            {false, false, false}
//        };
//
//        GameOfLife gameOfLife = new GameOfLife(initialState);
//        var expected = new boolean[][]{
//            {false, false, false},
//            {false, false, false},
//            {false, false, false}
//        };
//        var result = gameOfLife.nextGen();
//        Assertions.assertArrayEquals(expected, result);
//    }




}
