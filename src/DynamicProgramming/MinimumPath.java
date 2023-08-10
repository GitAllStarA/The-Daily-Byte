package DynamicProgramming;
/*
* Minimize Path
Dynamic Programming
Hard

 This question is asked by Google. Given an NxM matrix, grid,
* where each cell in the matrix represents the cost of stepping on the current cell,
* return the minimum cost to traverse from the top-left hand corner of the matrix to the bottom-right hand corner.
Note: You may only move down or right while traversing the grid.

Ex: Given the following grid…

grid = [
    [1,1,3],
    [2,3,1],
    [4,6,1]
], return 7.
The path that minimizes our cost is 1->1->3->1->1 which sums to 7.
*/

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MinimumPath {
    public static void main(String[] args) {
        int[][] x = {
                {1, 1, 3},
                {2, 3, 1},
                {4, 6, 1}
        };
        int[][] y ={{0,0}, {0,0}};
        System.out.println(minPathSum(y));
        System.out.println(dpMiniPath(x));
    }

    static int minPathSum(int[][] grid) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int mapTopLeftPoint = grid[0][0];
        if (grid.length<=1 && grid[0].length<=1 ){
            return grid[grid.length-1][grid[0].length-1];
        }
        traversalFunction(grid, arrayList, grid.length-1, grid[0].length-1, 0);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) < result){
                result = arrayList.get(i);
            }
        }
        System.out.println(arrayList);
        return result;
    }

    static void traversalFunction(int matrix[][], ArrayList<Integer> arrayList, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length ) {
            return;
        } else {
            count += matrix[i][j];
        }

        if (i == 0 && j == 0) {
            arrayList.add(count);
            System.out.println(arrayList);
            return;
        }


        int temp = matrix[i][j];
        matrix[i][j] = 0;
        traversalFunction(matrix, arrayList, i - 1, j, count);
        traversalFunction(matrix, arrayList, i, j - 1, count);
        //arrayList.remove(arrayList.size() - 1);
        matrix[i][j] = temp;
    }


    static int dpMiniPath(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] += grid[i][j];
                //to reach next cell we will add its up + down cells i-1,j and i,j-1
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                     dp[i][j] += dp[i-1][j];
                } else if (j>0) {
                    dp[i][j] += dp[i][j-1];
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
