package com.codurance;

public class Board {

    public final int X_AXIS_LIMIT;
    public final int Y_AXIS_LIMIT;
    public Cell[][] grid;
    public Cell[][] nextBoard;



    public Board(int[][] initialState){
        X_AXIS_LIMIT = initialState[0].length;
        Y_AXIS_LIMIT = initialState.length;
        grid = new Cell[Y_AXIS_LIMIT][X_AXIS_LIMIT];

        for (int yAxis = 0; yAxis < initialState.length; yAxis++) {
            for (int xAxis = 0; xAxis < initialState[yAxis].length; xAxis++) {
                var cell = new Cell(xAxis, yAxis, initialState[yAxis][xAxis]);
                grid[yAxis][xAxis] = cell;
            }
        }
    }


    public Cell getCell(int xAxis, int yAxis){
        return grid[yAxis][xAxis];
    }

    public int getNeighbours(Cell cell) {
        return checkLeftNeighbour(cell)
            + checkRightNeighbour(cell)
            + checkTopNeighbour(cell)
            + checkLowerNeighbour(cell)
            + checkTopLeftDiagonalNeighbour(cell)
            + checkBottomRightDiagonalNeighbour(cell);
    }


    private int checkRightNeighbour(Cell cell) {
        if (cell.xAxis() + 1 < X_AXIS_LIMIT) {
            var neighbour =  getCell(cell.xAxis() + 1, cell.yAxis());
            return neighbour.state();
        }

        return 0;
    }

    private int checkLeftNeighbour(Cell cell) {
        if (cell.xAxis() - 1 >= 0){
            var neighbour =  getCell(cell.xAxis() - 1, cell.yAxis());
            return neighbour.state();
        }

        return 0;

    }

    private int checkLowerNeighbour(Cell cell) {
        if (cell.yAxis() + 1 < Y_AXIS_LIMIT){
            var neighbour =  getCell(cell.xAxis(), cell.yAxis() + 1);
            return neighbour.state();
        }
        return 0;
    }

    private int checkTopNeighbour(Cell cell) {
        if (cell.yAxis() - 1 >= 0){
            var neighbour =  getCell(cell.xAxis(), cell.yAxis() - 1);
            return neighbour.state();
        }
        return 0;
    }

    private int checkTopLeftDiagonalNeighbour(Cell cell){
        if (cell.yAxis() -1 >= 0 && cell.xAxis() -1 >= 0){
            var neighbour =  getCell(cell.xAxis() -1, cell.yAxis() -1);
            return neighbour.state();
        }

        return 0;
    }

    private int checkBottomRightDiagonalNeighbour(Cell cell){
        if (cell.yAxis() + 1 < Y_AXIS_LIMIT && cell.xAxis() +1 < X_AXIS_LIMIT){
            var neighbour =  getCell(cell.xAxis() + 1, cell.yAxis() + 1);
            return neighbour.state();
        }

        return 0;
    }
}
