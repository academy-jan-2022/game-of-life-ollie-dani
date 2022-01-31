package com.codurance;

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

        assertEquals(initialState,gameOfLife.nextGen());
    }
}
