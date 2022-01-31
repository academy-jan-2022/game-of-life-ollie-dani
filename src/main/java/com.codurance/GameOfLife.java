package com.codurance;

import java.util.Arrays;

public class GameOfLife {
    private final int[][] board;

    public GameOfLife(int[][] initialState) {
        board = initialState;
    }

    public int[][] nextGen() {
        var nextBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);

        for(int row = 0; row < board[0].length; row++){

            if (row == 1 && board[0][row] == 1 && board[0][row - 1] == 1){
                nextBoard[0][row] = 1;
                continue;
            }

            nextBoard[0][row] = 0;
        }

        return nextBoard;
    }
}
