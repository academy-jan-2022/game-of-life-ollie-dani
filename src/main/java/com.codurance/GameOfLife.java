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

                int aliveNeighbours = board.getNeighbours(currentCell.point());

                if (aliveNeighbours == 2) {
                    nextBoard[yAxis][xAxis] = currentCell.state();
                }

                if(aliveNeighbours == 3){
                    nextBoard[yAxis][xAxis] = 1;
                }

                if (aliveNeighbours >= 4){
                    nextBoard[yAxis][xAxis] = 0;
                }

                if (aliveNeighbours < 2) {
                    nextBoard[yAxis][xAxis] = 0;
                }
            }
        }
        return nextBoard;
    }



}
