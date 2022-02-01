package com.codurance;

public class GameOfLife {
    private final int[][] board;
    private final int ROW_LIMIT;
    private final int COLUMN_LIMIT;

    public GameOfLife(int[][] initialState) {
        board = initialState;
        ROW_LIMIT = initialState[0].length;
        COLUMN_LIMIT = initialState.length;

    }

    public int[][] nextGen() {
        var nextBoard = new int[COLUMN_LIMIT][ROW_LIMIT];

        for (int column = 0; column < COLUMN_LIMIT; column++) {
            for (int row = 0; row < ROW_LIMIT; row++) {
                if (checkLeftNeighbour(row, column) + checkRightNeighbour(row, column) == 2) {
                    nextBoard[column][row] = board[column][row];
                }
                if (checkLeftNeighbour(row, column) + checkRightNeighbour(row, column) < 2) {
                    nextBoard[column][row] = 0;
                }

            }
        }
        return nextBoard;
    }

    private int checkRightNeighbour(int row, int column) {
        if (row + 1 < ROW_LIMIT)
            return board[column][row + 1];
        return 0;
    }

    private int checkLeftNeighbour(int row, int column) {
        if (row - 1 >= 0)
            return board[column][row - 1];
        return 0;
    }
}
