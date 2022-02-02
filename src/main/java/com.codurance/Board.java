package com.codurance;

import java.util.function.Consumer;

public class Board {

    public final int width;
    public final int height;
    private final int[][] grid;


    public Board(int[][] initialState) {
        width = initialState[0].length;
        height = initialState.length;
        grid = initialState;
    }

    public Board copy() {
        return new Board(copyGrid());
    }

    private int[][] copyGrid() {
        var newGrid = getScaffold();
        for (int y = 0; y < height; y++) {
            newGrid[y] = copyRow(y);
        }
        return newGrid;
    }

    private int[] copyRow(int y) {
        int[] row = new int[0];
        if (width >= 0)
            System.arraycopy(grid[y], 0, row, 0, width);
        return row;
    }

    public int getCell(Point point) {
        return grid[point.y()][point.x()];
    }

    public void revive(Point point) {
        grid[point.y()][point.x()] = 1;
    }

    public void kill(Point point) {
        grid[point.y()][point.x()] = 0;
    }

    public int[][] getScaffold() {
        return new int[height][width];
    }

    public void process(Consumer<int[][]> f) {
        f.accept(copyGrid());
    }

    public int calculateNearbyPopulation(Point cellPosition) {
        var xStart = cellPosition.x() - 1;
        var xEnd = cellPosition.x() + 1;
        var yStart = cellPosition.y() - 1;
        var yEnd = cellPosition.y() + 1;
        var sum = 0;

        for (int yIndex = yStart; yIndex <= yEnd; yIndex++) {
            for (int xIndex = xStart; xIndex <= xEnd; xIndex++) {
                sum += isNeighbour(cellPosition, new Point(xIndex, yIndex)) ? grid[yIndex][xIndex]: 0;
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

        return point.y() >= height || point.y() < 0 || point.x() >= width || point.x() < 0;
    }

}
