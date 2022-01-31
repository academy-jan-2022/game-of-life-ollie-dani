package com.codurance;

public class GameOfLife {
    private final int[][] board;

    public GameOfLife(int[][] initialState) {
        board = initialState;
    }

    public int[][] nextGen() {
        for(int row = 0; row < board[0].length; row++){
            board[0][row] = 0;
        }

        return board;
    }
}
