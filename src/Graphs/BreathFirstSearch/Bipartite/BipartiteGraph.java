/* https://leetcode.com/problems/is-graph-bipartite/
*
* Coloring
Breadth-first Search
Hard
This question is asked by Facebook. Given an undirected graph determine whether it is bipartite.
Note: A bipartite graph, also called a bigraph, is a set of graph vertices decomposed into two
*  disjoint sets such that no two graph vertices within the same set are adjacent.

Ex: Given the following graph...

graph = [[1, 3], [0, 2], [1, 3], [0, 2]]
0----1
|    |
|    |
3----2
return true.
Ex: Given the following graph...

graph = [[1, 2], [0, 2, 3], [0, 1, 3], [0, 2]]
0----1
|  / |
| /  |
3----2
return false.

*
* */


package Graphs.BreathFirstSearch.Bipartite;

import java.sql.Array;
import java.util.*;

public class BipartiteGraph {
    private static Scanner scanner;

    public static void main(String[] args) {


        int[][] graph2 = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };

        int[][] graph3 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        int[][] graph4 = {
               //c1 c2 c3
                {1, 3, 3},// row 1
                {0, 2, 2},// row 2
                {1, 3, 1},// row 3
                {0, 2, 1} // row 4
        };

        int[][] graph5 = {
                {0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0}
        };
        for (int i = 0; i < graph4[0].length; i++) {
            //single row all columns
            System.out.print(graph4[0][i]+" ");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < graph4.length; i++) {
            System.out.println(graph4[i][0]);
        }



        System.out.println();
        System.out.println("-------------------------------");


        System.out.println(isBipartite(graph5));
    }

    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 1 || color[i] == -1) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                System.out.println(Arrays.toString(graph[currentNode]));
                for (int adjNode : graph[currentNode]) {
                    if (color[adjNode] == 0) {
                        color[adjNode] = -color[currentNode];
                        queue.add(adjNode);
                    }
                    if (color[adjNode] == color[currentNode]) return false;
                }
            }
        }
        return true;
    }
}
