package Backtracking;

import java.util.Scanner;

public class NQueens2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter board size : ");
        int n = scanner.nextInt();
        scanner.close();
        boolean[][] board = new boolean[n][n];

        System.out.println(queens(board, 0));
    }

    private static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count = count + queens(board,row+1);
                board[row][col] = false;

            }

        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row, if placed queen i.e, true then return false
        //check each row at same col;
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        //check left, i.e, in the upper left diagonal if there is a queen placed, i.e., ture
        int upperLeft = Math.min(row,col);
        for (int i = 1; i <= upperLeft; i++) {
            if (board[row-1][col-1]){
                return false;
            }
        }

        //check right, i.e, in the upper right diagonal if there is a queen placed, i.e., ture
        int upperRight = Math.min(row,board.length-col-1);
        for (int i = 1; i <= upperRight ; i++) {
            if (board[row-1][col+1]){
                return false;
            }
        }
        return true;
    }


    private static void display(boolean[][] board) {
        for (boolean[] b : board) {
            for (boolean bool : b) {
                if (bool) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
