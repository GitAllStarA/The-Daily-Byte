/*
Backtracking
Hard
This question is asked by Amazon. Given a 2D board that represents a word search puzzle and a string word, return whether or the given word can be formed in the puzzle by only connecting cells horizontally and vertically.

Ex: Given the following board and words…

board =
[
  ['C','A','T','F'],
  ['B','G','E','S'],
  ['I','T','A','E']
]
word = "CAT", return true
word = "TEA", return true
word = "SEAT", return true
word = "BAT", return false*/
package Backtracking;

public class WordSearchTwoDArray {
    public static void main(String[] args) {
        char[][] board =
                {
                        {'C', 'A', 'T', 'F'},
                        {'B', 'G', 'E', 'S'},
                        {'I', 'T', 'A', 'X'}
                };

        String word1 = "CAT";// , return true
        String word2 = "TEA";// , return true
        String word3 = "SEAT";// , return true
        String word4 = "BAT";// , return false*/

        System.out.println(isPresent(board, word3));
    }


    static boolean isPresent(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    return isCharPresent(board, word, i, j, 0);
                }
            }
        }
        return false;
    }

    private static boolean isCharPresent(char[][] board, String word, int i, int j, int index) {


        if (index == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(index)) {
            System.out.println(i + " " + j + " = " + word.charAt(index) + " not found");
            return false;
        }
        System.out.println(i + " " + j + " = " + word.charAt(index) + " found");
        char c = word.charAt(index);
        board[i][j] = ' ';

        boolean resultD = isCharPresent(board, word, i + 1, j, index + 1); //d
        boolean resultU = isCharPresent(board, word, i - 1, j, index + 1); //u
        boolean resultR = isCharPresent(board, word, i, j + 1, index + 1); //r
        boolean resultL = isCharPresent(board, word, i, j - 1, index + 1); //l
        board[i][j] = c;

        if (resultD == true) {
            return resultD;
        } else if (resultU == true) {
            return resultU;
        } else if (resultR == true) {
            return resultR;
        } else if (resultL == true) {
            return resultL;
        } else {
            return false;
        }
    }
}
