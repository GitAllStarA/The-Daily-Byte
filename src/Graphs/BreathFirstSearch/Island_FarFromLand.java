/* Far From Land
Breadth-first Search
* Medium
*
* You are given a two-dimensional matrix, grid, that only contains zeroes and ones.
* Zeroes represent water and ones represent land. Return the furthest distance any cell with water is from any cell with land.
* Note: One cell represents a unit distance of one and you may only travel
* four-directionally from any given cell (i.e. up, down, left, and right). If no land exists within grid, return -1.

Ex: Given the following grid…

grid = [
  [0, 0, 1],
  [0, 0, 0],
  [0, 0, 0]
], return 4 (cell (0, 2) is 4 units away from cell (2, 0)).
Ex: Given the following grid…

grid = [
  [0, 0, 0],
  [0, 1, 0],
  [0, 0, 0]
], return 2.
*
* */

package Graphs.BreathFirstSearch;

import java.util.*;

public class Island_FarFromLand {

    public static void main(String[] args) {
        int[][] grid =
                {
                        {1, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                };

        int[][] grid2 = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        int[] current = queue.poll();
        //System.out.println(Arrays.toString(current));
        int x = current[0];
        int y = current[1];
        //System.out.println(grid[x][y]);


        System.out.println(furthestCellFromLand(grid2));
    }

    public static int furthestCellFromLand(int[][] grid) {
        if (grid.length == 0)
            return -1;

        int rows = grid.length;
        int columns = grid[0].length;

        int waterCells = 0;
        int relativeLandPosition = 0;
        int land = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<int[]> queue1 = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    waterCells++;
                }
                if (grid[i][j] == 1) {
                    relativeLandPosition = i * columns + j;
                    queue1.add(new int[]{i,j});
                    land++;
                }
            }
        }
        System.out.println("water cells : " + waterCells);
        System.out.println(queue);
        System.out.println("land : " + land);
        System.out.println("relative land position : "+relativeLandPosition);
        System.out.println("_________________________________________");
        int[][] directions = {
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
                // r       d      u       l
        };
        int count = -1;
        boolean[][] visited = new boolean[rows][columns];
        while (!queue1.isEmpty()) {
            count++;
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                int[] currentWaterCell = queue1.poll();
                // at xna d y if confused please use chatgpt to get the concept
                int x = currentWaterCell[0];
                int y = currentWaterCell[1];
                System.out.println("current water cell : " + grid[x][y]);
                visited[x][y] = true;
                for (int direction[] : directions) {
                    int newWaterCellRow = direction[0] + x;
                    int newWaterCellColumn = direction[1] + y;
                    if (newWaterCellRow > -1 && newWaterCellColumn > -1 && newWaterCellRow < rows && newWaterCellColumn < columns) {
                        if (grid[newWaterCellRow][newWaterCellColumn] != 1 && visited[newWaterCellRow][newWaterCellColumn]==false) {
                            visited[x][y] = true;
                            grid[newWaterCellRow][newWaterCellColumn] = 1;
                            queue1.add(new int[]{newWaterCellRow,newWaterCellColumn});
                        }
                    }
                }
            }

        }
        System.out.println("count "+count);
        //System.out.println(hashMap);
        return waterCells==0?-1:count;
    }
}

