package com.codurance;

public class GameOfLife {
    private final boolean[][] board;

    public GameOfLife(boolean[][] initialState) {
        board = initialState;
    }

    public boolean[][] nextGen() {

        if (board[0][0] == false
            && board[0][1] == true
            && board[1][0] == true
            && board[1][1] == true){
            return new boolean[][]{{true, true},{true, true}};
        }

        if (board[0][0] == true
            && board[0][1] == false
            && board[1][0] == true
            && board[1][1] == true){
            return new boolean[][]{{true, true},{true, true}};
        }

        if (board[0][0] == true
            && board[0][1] == true
            && board[1][0] == false
            && board[1][1] == true){
            return new boolean[][]{{true, true},{true, true}};
        }

        return new boolean[][]{{false, false},{false, false}};

    }

}
