/*Given a 2D array of integers with ones representing land and zeroes representing water,
return the number of islands in the grid. Note: an island is one or more ones surrounded by
water connected either vertically or horizontally.
Ex: Given the following grid…

11000
11010
11001
return 3.
Ex: Given the following grid…

00100
00010
00001
00001
00010
return 4.
*/
package Graphs.DepthFirstSearch.Island;

import java.util.LinkedList;
import java.util.Queue;

public class TotalIsland {

    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] arrayOfIslands = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 1}
        };

        int[][] arrayOfIslands2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 1}
        };
        System.out.println(noOfIslandsBFS(arrayOfIslands));
        System.out.println();
        System.out.println(DFSTravel(arrayOfIslands2));
    }

    public static int noOfIslandsBFS(int[][] arrayOfIslands) {
        int islands = 0;
        if (arrayOfIslands == null || arrayOfIslands.length == 0) {
            return 0;
        }

        int rows = arrayOfIslands.length;
        int cols = arrayOfIslands[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arrayOfIslands[i][j] == 1) {
                    islands++;
                    helperBFS(arrayOfIslands, rows, cols, i, j);
                }
            }
        }
        return islands;
    }

    public static void helperBFS(int[][] arrayOfIslands, int rows, int cols, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        int twoDToOneD = i * cols + j;
        queue.add(twoDToOneD);
        arrayOfIslands[i][j] = 0;
        while (!queue.isEmpty()) {
            int current1DayArray = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int row = current1DayArray / cols;
                int col = current1DayArray % cols;
                int x = row + direction[0];
                int y = col + direction[1];
                if (x > -1 && y > -1 && x < rows && y < cols && arrayOfIslands[x][y] == 1) {
                    arrayOfIslands[x][y] = 0;
                    queue.add(x * cols +y);
                }
            }
        }
    }


    public static int DFSTravel(int[][] array) {
        int noOfIslands = 0;
        if (array.length == 0) {
            return noOfIslands;
        }
        int rows = array.length;
        int columns = array[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (array[i][j] == 1) {
                    noOfIslands++;
                    helperDFS(array, i, j);
                }
            }
        }
        return noOfIslands;
    }

    public static void helperDFS(int[][] array, int x, int y) {
        if (x < 0 || y < 0 || x >= array.length || y >= array[0].length || array[x][y] == 0)
            return;
        array[x][y] = 0;
        helperDFS(array, x + 1, y);
        helperDFS(array, x - 1, y);
        helperDFS(array, x, y + 1);
        helperDFS(array, x, y - 1);

    }

}

