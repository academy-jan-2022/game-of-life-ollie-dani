package com.codurance;

public class Board {

    public final int X_AXIS_LIMIT;
    public final int Y_AXIS_LIMIT;
    public Cell[][] grid;


    public Board(int[][] initialState) {
        X_AXIS_LIMIT = initialState[0].length;
        Y_AXIS_LIMIT = initialState.length;
        grid = new Cell[Y_AXIS_LIMIT][X_AXIS_LIMIT];

        for (int yAxis = 0; yAxis < initialState.length; yAxis++) {
            for (int xAxis = 0; xAxis < initialState[yAxis].length; xAxis++) {
                var cell = new Cell(new Point(xAxis, yAxis), initialState[yAxis][xAxis]);
                grid[yAxis][xAxis] = cell;
            }
        }
    }

    public int getNeighbours(Point cellPosition) {
        var xStart = cellPosition.x() - 1;
        var xEnd = cellPosition.x() + 1;
        var yStart = cellPosition.y() - 1;
        var yEnd = cellPosition.y() + 1;
        var sum = 0;

        for (int yIndex = yStart; yIndex <= yEnd; yIndex++) {
            for (int xIndex = xStart; xIndex <= xEnd; xIndex++) {
                sum += isNeighbour(cellPosition, new Point(xIndex, yIndex)) ? grid[yIndex][xIndex].state() : 0;
            }
        }

        return sum;
    }

    private boolean isNeighbour(Point cellPosition, Point point) {
        return !isOutOfRange(point) && !isActualCell(cellPosition, point);
    }


    private boolean isActualCell(Point cellPosition, Point point) {
        return cellPosition.equals(point);
    }

    private boolean isOutOfRange(Point point) {

        return point.y() >= Y_AXIS_LIMIT || point.y() < 0 || point.x() >= X_AXIS_LIMIT || point.x() < 0;
    }

}
