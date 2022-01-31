package com.codurance;

public class GameOfLife {
    private final boolean[][] board;

    public GameOfLife(boolean[][] initialState) {
        board = initialState;
    }

    public boolean[][] nextGen() {
        for(int column = 0 ; column < board[0].length ; column ++){
            for(int row = 0 ; row < board.length; row ++){
                board[column][row] = false;
            }
        }
        return board;
    }
}
