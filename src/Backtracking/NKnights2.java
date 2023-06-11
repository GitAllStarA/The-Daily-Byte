package Backtracking;

import java.util.Arrays;

public class NKnights2 {
    public static void main(String[] args) {
        int n = 3;
        int knights = 2;
        boolean[][] board = new boolean[n][n];
        kinghtsTour(board, 0, 0, knights);

        int[][] b = {
                {0,1,2},
                {2,35,36},
                {23,3,2}
        };
        int row = 0,col = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[row][col] == 35){
                System.out.println(row+", "+col);
                System.out.println(b[row][col]);
            }
            row++;col++;
        }
        col = 0;
        for (int[] nums : b){

            if (nums[col] == 36){
                System.out.println("present");
            }
            col++;
        }

    }

    private static void kinghtsTour(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (col == board.length) {
            kinghtsTour(board, row + 1, 0, knights);
            return;
        }

        if (row == board.length - 1 && col == board.length - 1) {
            return;
        }

        if (isSafePlace(board, row, col)) {
            board[row][col] = true;
            kinghtsTour(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        kinghtsTour(board, row, col + 1, knights);

    }

    /*
    |  -  |  -  |
    -  |  |  |  -
    |  |  K  |  |
    |  |  |  |  |
    |  |  |  |  |
     */
    private static boolean isSafePlace(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && col >= 0 && row < board.length && col < board.length) {
            return true;
        } else {
            return false;
        }
    }

    private static void display(boolean[][] board) {
        for (boolean[] arry : board) {
            for (boolean placed : arry) {
                if (placed) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
