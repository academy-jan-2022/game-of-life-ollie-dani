package com.codurance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;
import java.util.function.Consumer;

public class GameOfLife {
    private Board board;

    public GameOfLife(int[][] initialState) {
        board = new Board(initialState);
    }

    public Board nextGen() {
        var copy = board.copy();
        for (var point : getAllPoints()) {
            getNextStateOperation(point, copy).accept(point);
        }
        return board = copy;
    }

    private List<Point> getAllPoints() {
        var points = new ArrayList<Point>();
        for (int y = 0; y < board.height; y++) {
            points.addAll(getRow(y));
        }
        return points;
    }

    private List<Point> getRow(int y) {
        var row = new ArrayList<Point>();
        for (int x = 0; x < board.width; x++) {
            row.add(new Point(x, y));
        }
        return row;
    }

    private Consumer<Point> getNextStateOperation(Point point, Board copy) {
        return switch (board.calculateNearbyPopulation(point)) {
            case 2 -> p -> {};
            case 3 -> copy::revive;
            default -> copy::kill;
        };

    }

    public static void main(String[] args) throws InterruptedException {
        int[][] ints = new int[10][40];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            Arrays.fill(ints[i], random.nextInt() % 2 == 0 ? 1 : 0);
        }
        GameOfLife gameOfLife = new GameOfLife(ints);

        while (true) {
            sleep(1000);
            var result = gameOfLife.nextGen();
            result.process(grid -> System.out.print(Arrays.deepToString(grid)
                .replace("], ", "\n")
                .replace("[", "")
                .replace("[[", "")
                .replace("]]", "")
                .replace(", ", "")));



            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }

    }

}
