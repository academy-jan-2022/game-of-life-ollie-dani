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
                Cell currentCell = board.getCell(xAxis, yAxis);

                if (getNeighbours(currentCell) == 2) {
                    nextBoard[yAxis][xAxis] = currentCell.state();
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
        if (cell.xAxis() + 1 < board.X_AXIS_LIMIT) {
            var neighbour =  board.getCell(cell.xAxis() + 1, cell.yAxis());
            return neighbour.state();
        }

        return 0;
    }

    private int checkLeftNeighbour(Cell cell) {
            if (cell.xAxis() - 1 >= 0){
                var neighbour =  board.getCell(cell.xAxis() - 1, cell.yAxis());
                return neighbour.state();
            }

            return 0;

    }

    private int checkLowerNeighbour(Cell cell) {
        if (cell.yAxis() + 1 < board.Y_AXIS_LIMIT){
            var neighbour =  board.getCell(cell.xAxis(), cell.yAxis() + 1);
            return neighbour.state();
        }
        return 0;
    }

    private int checkTopNeighbour(Cell cell) {
        if (cell.yAxis() - 1 >= 0){
            var neighbour =  board.getCell(cell.xAxis(), cell.yAxis() - 1);
            return neighbour.state();
        }
        return 0;
    }

    private int checkTopLeftDiagonalNeighbour(Cell cell){
        if (cell.yAxis() -1 >= 0 && cell.xAxis() -1 >= 0){
            var neighbour =  board.getCell(cell.xAxis() -1, cell.yAxis() -1);
            return neighbour.state();
        }

        return 0;
    }

    private int checkBottomRightDiagonalNeighbour(Cell cell){
        if (cell.yAxis() + 1 < board.Y_AXIS_LIMIT && cell.xAxis() +1 < board.X_AXIS_LIMIT){
            var neighbour =  board.getCell(cell.xAxis() + 1, cell.yAxis() + 1);
            return neighbour.state();
        }

        return 0;
    }
}
