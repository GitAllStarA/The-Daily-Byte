package Backtracking;

import java.util.ArrayList;

public class WordSearch {
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 3};

        char[][] board = {
                {'c', 'a', 't', 'f'},
                {'f', 'e', 'e', 's'},
                {'i', 't', 'a', 'e'}
        };

        //System.out.println(getFirstWord(board,"see"));
        System.out.println(exist(board,"see"));
    }


/*    static ArrayList<Integer> formSubset(int[] nums, int index,ArrayList<Integer> arrayList1) {
        if (index >= nums.length){
            //ArrayList<Integer> arrayList2 = new ArrayList<>();
            arrayList.add(arrayList1);
            return new ArrayList<>();
        }

        int num = nums[index];
        arrayList.add(formSubset(nums, index + 1,arrayList1));
        arrayList.add(formSubset(nums,index+1,,arrayList));


    }*/

    static boolean getFirstWord(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean findWord(char[][] board, String word, int index, int i, int j) {
        // l       r        d        u
        //int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found =
                findWord(board, word, index + 1, i, j - 1) ||
                findWord(board, word, index + 1, i + 1, j) ||
                findWord(board, word, index + 1, i - 1, j) ||
                findWord(board, word, index + 1, i, j + 1) ;

        board[i][j] = temp;
        return found;
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0 ;i<board.length;i++) {
            for(int j =0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0) && search(board, word, 0, i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] board, String word, int index, int i, int j) {
        if(index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = search(board, word, index + 1, i+1, j) ||
                search(board, word, index + 1, i-1, j) ||
                search(board, word, index + 1, i, j+1) ||
                search(board, word, index + 1, i, j-1) ;
        board[i][j] = temp;
        return found;
    }
}
