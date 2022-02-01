package com.codurance;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Thread.sleep;

public class GameOfLife {
    private Board board;

    public GameOfLife(int[][] initialState) {
        board = new Board(initialState);

    }

    public int[][] nextGen() {
        var nextBoard = new int[board.Y_AXIS_LIMIT][board.X_AXIS_LIMIT];

        for (int yAxis = 0; yAxis < board.Y_AXIS_LIMIT; yAxis++) {
            for (int xAxis = 0; xAxis < board.X_AXIS_LIMIT; xAxis++) {
                nextBoard[yAxis][xAxis] = getCellNextState(new Point(xAxis, yAxis));
            }
        }
        board = new Board(nextBoard);
        return nextBoard;
    }

    private int getCellNextState(Point point) {
        Cell currentCell = board.getCell(point);
        return switch (board.getNeighbours(currentCell.point())) {
            case 2 -> currentCell.state();
            case 3 -> 1;
            default -> 0;
        };
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] ints = new int[10][10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Arrays.fill(ints[i], random.nextInt() % 2 == 0 ? 1 : 0);
        }
        GameOfLife gameOfLife = new GameOfLife(ints);

        while (true) {
            sleep(500);
            var gameString = "";
            int[][] a = gameOfLife.nextGen();
            for (int i = 0; i < 10; i++) {
                gameString += String.join(" " , Arrays.asList(a[i])) + "\n";
            }
            System.out.println(gameString);
        }
    }


}
