/*
* Pond Size
Depth-first Search
Medium
You are given two-dimensional matrix that represents a plot of land. Within the matrix there exist two values: ones which represent land and zeroes which represent water within a pond. Given that parts of a pond can be connected both horizontally and vertically (but not diagonally), return the largest pond size.
Note: You may assume that each zero within a given pond contributes a value of one to the total size of the pond.

Ex: Given the following plot of land…

land = [
    [1,1,1],
    [1,0,1],
    [1,1,1]
], return 1.
Ex: Given the following plot of land…

land = [
    [1,0,1],
    [0,0,0],
    [1,0,1]
], return 5.
*
*
* */

package Graphs.DepthFirstSearch.PondSize;

public class PondSize {

    public static void main(String[] args) {
        int[][] land = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        System.out.println(graphTrav(land));
       // System.out.println(maxPondSize(land));
    }


    public static int graphTrav(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    max = Math.max(max, dfsx(array, i, j));
                }

            }
        }

        return max;
    }

    public static int dfsx(int[][] array, int i, int j) {
        if (i < 0 || i >= array.length || j < 0 || j >= array[i].length || array[i][j] == 1) {
            return 0;
        }
        array[i][j] = 1;
        int count = 1;
        count += dfsx(array, i + 1, j);
        count += dfsx(array, i - 1, j);
        count += dfsx(array, i, j + 1);
        count += dfsx(array, i, j - 1);
        return count;
    }
}


