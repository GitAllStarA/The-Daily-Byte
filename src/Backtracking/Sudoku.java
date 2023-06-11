package Backtracking;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (sudokuSolver(board)) {
            System.out.println();
            display(board);
        } else {
            display(board);
            System.out.println("not solved");
        }
    }

    private static boolean sudokuSolver(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmptyLeft = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmptyLeft = false;
                    break;
                }
            }

            if (isEmptyLeft == false) {
                break;
            }
        }

        if (isEmptyLeft == true){
            System.out.println("sudoku solved");
            return true;
        }

        for (int number = 1; number < 10; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (sudokuSolver(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {

        // check in horizontal order -------
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // check in vertical order |
        //                           |
        for (int[] number : board) {
            if (number[col] == num) {
                return false;
            }
        }
        //check the first box in 3x3 box
        int sqrtOfBoard = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrtOfBoard;
        int colStart = col - col % sqrtOfBoard;
        for (int i = rowStart; i < rowStart + sqrtOfBoard; i++) {
            for (int j = colStart; j < colStart + sqrtOfBoard; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
