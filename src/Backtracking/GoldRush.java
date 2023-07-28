package Backtracking;

import java.util.HashSet;

public class GoldRush {

    public static void main(String[] args) {
        int[][] gold = {
                {0, 2, 0},
                {8, 6, 3},
                {0, 9, 0}};
        int[][] gold2 = {
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        };
        int[][] gold3 = {{1, 6, 1}, {5, 8, 7}, {1, 9, 1}};
        int[][] gold4 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(getMaximumGoldEveryNonZeroElement(gold3));
    }
    //store count using recursion.

    static int getMaximumGoldEveryNonZeroElement(int[][] grid) {
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    getMaxGold(grid, i, j, 0, 0, set);
                    System.out.println(set);
                }
            }
        }


        int maxGold = set.stream().max((a, b) -> a - b).orElse(0);

        return maxGold;
    }


    static int getMaximumGold(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        getMaxGold(grid, x, y, 0, 0, set);

        int maxGold = set.stream().max((a, b) -> a - b).get();

        return maxGold;
    }

    private static void getMaxGold(int[][] gold, int x, int y, int index, int count, HashSet<Integer> set) {

        if (x < 0 || y < 0 || x >= gold.length || y >= gold[x].length || gold[x][y] == 0 || index == gold.length * gold[0].length) {
            set.add(count);
            return;
        }

        int temp = gold[x][y];
        gold[x][y] = 0;
        count = count + temp;

        getMaxGold(gold, x + 1, y, index + 1, count, set);
        getMaxGold(gold, x - 1, y, index + 1, count, set);
        getMaxGold(gold, x, y + 1, index + 1, count, set);
        getMaxGold(gold, x, y - 1, index + 1, count, set);
        gold[x][y] = temp;
    }
}
