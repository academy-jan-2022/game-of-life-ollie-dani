package com.codurance;

public class Board {

    public final int X_AXIS_LIMIT;
    public final int Y_AXIS_LIMIT;
    public Cell[][] grid;


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
}
