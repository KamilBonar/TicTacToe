package com.project1.tictactoe;

public class PrintBoard {

    public void printBoard(char[][] board) {
        int dim = board.length;

        System.out.print(" ");
        for (int i = 0; i < dim; i++) {
            System.out.print("    " + i + "\t");
        }
        System.out.println();
        for (int row = 0; row < dim; row++) {
            System.out.print(row + ":");
            for (int column = 0; column < dim; column++) {
                System.out.print("   " + board[row][column] + "\t|");
            }
            System.out.println();
        }
    }
}
