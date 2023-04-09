/*
* https://leetcode.com/problems/rotting-oranges/
* Infection
*
* Given a 2D array each cells can have one of three values. Zero represents
* an empty cell, one represents a healthy person, and two represents a sick person.
* Each minute that passes, any healthy person who is adjacent to a sick person becomes sick.
* Return the total number of minutes that must elapse until every person is sick.
*
* Note: If it is not possible for each person to become sick, return -1.

Ex: Given the following 2D array grid…

grid = [ [1,1,1],
         [1,1,0],
         [0,1,2]
       ], return 4.
[2, 1] becomes sick at minute 1.
[1, 1] becomes sick at minute 2.
[1, 0] and [0, 1] become sick at minute 3.
[0, 0] and [0, 2] become sick at minute 4.
Ex: Given the following 2D array grid…

grid = [
    [1,1,1],
    [0,0,0],
    [2,0,1]
], return -1.

*
*   https://www.youtube.com/watch?v=vsAeM9EGhFo&ab_channel=MichaelMuinos
* */
package Infection_or_RottenOranges;

import java.util.LinkedList;
import java.util.Queue;

public class InfectionOrRottenOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {2, 1, 0}
        };

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        System.out.println(rottenOrangesOrInfection(grid));
    }

    public static int rottenOrangesOrInfection(int[][] grid) {

        if (grid.length == 0) {
            return -1;
        }

        int m = grid.length; //rows
        int n = grid[0].length; //columns

        //take the count of healthy one's

        int healthy = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    healthy++;
                }
            }
        }
        System.out.println("healthy : " + healthy);

        //take the position of the rotten/infected one's and store them in queue

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {

                    // storing the position of each infected one's in the form of relative position as [ 0,6 ] instead 2d array format like [(0,0),(2,0)]
                    // i = row position , j = column position, n = column length.
                    int relative_position = i * n + j;
                    queue.add(relative_position);
                }
            }
        }

        System.out.println("relative position of rotten/infected one's " + queue);

        // in order to travel the grid left right up and down we need to use a directions 2d array.
        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };
        int minutes = 0;
        while (!queue.isEmpty() && healthy > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentOne = queue.poll();
                for (int[] direction : directions) {
                    int row =  currentOne / n;
                    int x = direction[0] + row;
                    int column =  currentOne % n;
                    int y = direction[1] + column;
                    if (x > -1 && y > -1 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(x * n + y);
                        healthy--;
                    }

                }
            }
            minutes++;
        }

        // if healthy not equal to zero the return -1;
        System.out.println("remaining healthy "+healthy);


        return healthy == 0 ? minutes : -1;

    }
}
