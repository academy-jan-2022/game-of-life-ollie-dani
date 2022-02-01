package com.codurance;

public class GameOfLife {
    private final int[][] board;
    private final int X_AXIS_LIMIT;
    private final int Y_AXIS_LIMIT;

    public GameOfLife(int[][] initialState) {
        board = initialState;
        X_AXIS_LIMIT = initialState[0].length;
        Y_AXIS_LIMIT = initialState.length;

    }

    public int[][] nextGen() {
        var nextBoard = new int[Y_AXIS_LIMIT][X_AXIS_LIMIT];

        for (int yAxis = 0; yAxis < Y_AXIS_LIMIT; yAxis++) {
            for (int xAxis = 0; xAxis < X_AXIS_LIMIT; xAxis++) {
                Cell currentCell = new Cell(xAxis, yAxis);

                if (getNeighbours(currentCell) == 2) {
                    nextBoard[yAxis][xAxis] = board[yAxis][xAxis];
                }
                if (getNeighbours(currentCell) < 2) {
                    nextBoard[yAxis][xAxis] = 0;
                }
            }
        }
        return nextBoard;
    }

    private int getNeighbours(Cell cell) {
        return checkLeftNeighbour(cell)
            + checkRightNeighbour(cell)
            + checkTopNeighbour(cell)
            + checkLowerNeighbour(cell)
            + checkTopLeftDiagonalNeighbour(cell)
            + checkBottomRightDiagonalNeighbour(cell);
    }

    private int checkRightNeighbour(Cell cell) {
        if (cell.xAxis() + 1 < X_AXIS_LIMIT)
            return board[cell.yAxis()][cell.xAxis() + 1];
        return 0;
    }

    private int checkLeftNeighbour(Cell cell) {
            if (cell.xAxis() - 1 >= 0)
                return board[cell.yAxis()][cell.xAxis() - 1];
            return 0;

    }


    private int checkLowerNeighbour(Cell cell) {
        if (cell.yAxis() + 1 < Y_AXIS_LIMIT)
            return board[cell.yAxis() + 1][cell.xAxis()];
        return 0;
    }

    private int checkTopNeighbour(Cell cell) {
        if (cell.yAxis() - 1 >= 0)
            return board[cell.yAxis() - 1][cell.xAxis()];
        return 0;
    }

    private int checkTopLeftDiagonalNeighbour(Cell cell){
        if (cell.yAxis() -1 >= 0 && cell.xAxis() -1 >= 0)
            return board[cell.yAxis() -1][cell.xAxis() -1];

        return 0;
    }

    private int checkBottomRightDiagonalNeighbour(Cell cell){
        if (cell.yAxis() + 1 < Y_AXIS_LIMIT && cell.xAxis() +1 < X_AXIS_LIMIT)
            return board[cell.yAxis() +1][cell.xAxis() +1];

        return 0;
    }
}
