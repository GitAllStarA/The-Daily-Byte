package Backtracking;

public class NKnights {

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        Knight(board, 0, 0, 4);
    }

    public static void Knight(boolean[][] board, int row, int col, int Knights) {
        if (Knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length-1) {
            return;
        }

        if (col == board.length) {
            Knight(board, row + 1, 0, Knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            Knight(board, row, col + 1, Knights - 1);
            board[row][col] = false;
        }

        Knight(board, row, col + 1, Knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
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
        }
            return false;

    }

    private static void display(boolean[][] board) {
        for (boolean[] b : board) {
            for (boolean placed : b) {
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
