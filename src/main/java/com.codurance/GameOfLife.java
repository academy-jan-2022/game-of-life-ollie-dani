package com.codurance;

public class GameOfLife {
    private final Board board;

    public GameOfLife(int[][] initialState) {
        board = new Board(initialState);

    }

    public int[][] nextGen() {
        var nextBoard = new int[board.Y_AXIS_LIMIT][board.X_AXIS_LIMIT];

        for (int yAxis = 0; yAxis < board.Y_AXIS_LIMIT; yAxis++) {
            for (int xAxis = 0; xAxis < board.X_AXIS_LIMIT; xAxis++) {
                Cell currentCell = board.grid[yAxis][xAxis];

                if (board.getNeighbours(currentCell.point()) == 2) {
                    nextBoard[yAxis][xAxis] = currentCell.state();
                }
                if (board.getNeighbours(currentCell.point()) < 2) {
                    nextBoard[yAxis][xAxis] = 0;
                }
            }
        }
        return nextBoard;
    }



}
