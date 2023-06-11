/*
* Distance to Rabbit Holes
Depth-first Search
Medium
Given a 2D array containing only the following values: -1, 0, 1 where -1 represents an obstacle, 0represents a rabbit hole, and 1represents a rabbit, update every cell containing a rabbit with the distance to its closest rabbit hole.

Note: multiple rabbit may occupy a single rabbit hole and you may assume every rabbit can reach a rabbit hole. A rabbit can only move up, down, left, or right in a single move. Ex: Given the following grid…

-1  0  1
 1  1 -1
 1  1  0

your grid should look like the following after running the function...
-1  0  1
 2  1 -1
 2  1  0
Ex: Given the following grid…

 1  1  1
 1 -1 -1
 1  1  0

your grid should look like the following after running the function...
 4  5  6
 3 -1 -1
 2  1  0
See Solution
* */

package Graphs.DepthFirstSearch.RabbitHole;

import java.util.LinkedList;
import java.util.Queue;

public class RabbitHole {

    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int arry[][] = {
                {1, 1, 1},
                {1, -1, -1},
                {1, 1, 0}
        };
        int arry2[][] = {
                {-1, 0, 1},
                {1, 1, -1},
                {1, 1, 0}
        };
        //System.out.println(BFS(arry));
rabbitHoleDistances(arry2);
    }


    public static void rabbitHoleDistances(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {
                if(rooms[i][j] == 0) {
                    dfs(i, j, 0, rooms);
                }
            }
        }
        System.out.println("new array");
        for (int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
                System.out.println(" ");
        }
    }

    public static void dfs(int i, int j, int count, int[][] rooms) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < count) {
            return;
        }

        rooms[i][j] = count;
        dfs(i + 1, j, count + 1, rooms);
        dfs(i - 1, j, count + 1, rooms);
        dfs(i, j + 1, count + 1, rooms);
        dfs(i, j - 1, count + 1, rooms);
    }

    public static int BFS(int[][] array) {
        int result = 0;
        if (array == null || array.length == 0)
            return result;
        int rows = array.length;
        int cols = array[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 0) {
                    System.out.println("here"+i+","+j);
                   // bfsHelper(array, rows, cols, i, j);
                    dfsHelper(array, rows, cols, i, j, 0);
                }
            }
        }

        System.out.println("new array");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return result;

    }

    public static void dfsHelper(int[][] array, int rows, int cols, int i, int j, int count) {
        if (i < 0 || i >= rows || j < 0|| j >= cols || array[i][j] < count ) {
            return;
        }
        System.out.println("count : "+i+","+ j +" : "+count);
        array[i][j] = count;
        dfsHelper(array,rows,cols,i+1,j,count+1);
        dfsHelper(array,rows,cols,i-1,j,count+1);
        dfsHelper(array,rows,cols,i,j+1,count+1);
        dfsHelper(array,rows,cols,i,j-1,count+1);

    }


    public static void bfsHelper(int[][] array, int rows, int cols, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] ab = new boolean[array.length * array[0].length];
        queue.add(i * cols + j);
        array[i][j] = 10;
        while (!queue.isEmpty()) {
            int count = 0;
            int currentPosition = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int r = currentPosition / cols;
                int c = currentPosition % cols;
                int x = r + dir[0];
                int y = c + dir[1];
                if (x > -1 && y > -1 && x < rows && y < cols && array[x][y] == 1) {
                    count++;
                    array[x][y] = 10;
                    queue.add(x * cols + y);
                }
            }
            System.out.println("count " + count);
        }
    }


}
