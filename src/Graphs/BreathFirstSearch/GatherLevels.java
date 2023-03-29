/*
*
* Given a binary tree, return its level order traversal where the nodes in each level are ordered from left to right.

Ex: Given the following tree...

    4
   / \
  2   7
return [[4], [2, 7]]
Ex: Given the following tree...

    2
   / \
  10  15
        \
         20
return [[2], [10, 15], [20]]
Ex: Given the following tree...

    1
   / \
  9   32
 /      \
3        78
return [[1], [9, 32], [3, 78]]
* */


package Graphs.BreathFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GatherLevels {
    int vertices;
    static ArrayList<Integer> adjList[];

    static Scanner scanner;

    GatherLevels(int noOfVertices) {
        vertices = noOfVertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    void edgesCreate(int vertex, int adjacentVertex) {
        ArrayList<Integer> addVertex = adjList[vertex];
        addVertex.add(adjacentVertex);
    }

    void gatherLevels(int sourceVertex, int noOfVertices) {
        boolean visited[] = new boolean[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);

        visited[sourceVertex] = true;

        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

        ArrayList<Integer> level = new ArrayList<>();
        level.add(queue.peek());

        System.out.println(levels);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll + " ");
            System.out.println();
            int count = 0;
            ArrayList<Integer> lvl = new ArrayList<>();
            if (!adjList[poll].isEmpty()) {
                for (int i = 0; i < adjList[poll].size(); i++) {
                    int adjsVertex = adjList[poll].get(i);
                    if (visited[adjsVertex] == false) {
                        queue.add(adjsVertex);
                        lvl.add(adjsVertex);
                        visited[adjsVertex] = true;
                    }
                }
            }
            if (lvl.size()>=1) {
                levels.add(lvl);
            }
        }
        System.out.println(levels);
    }

    public static void main(String[] args) {
        /*scanner  = new Scanner(System.in);
        int noOfVertices = scanner.nextInt();

        scanner.close();*/
        GatherLevels gatherLevels = new GatherLevels(4);

        gatherLevels.edgesCreate(0, 1);
        gatherLevels.edgesCreate(0, 2);

        gatherLevels.edgesCreate(1, 0);

        gatherLevels.edgesCreate(2, 0);
        gatherLevels.edgesCreate(2,3);

        gatherLevels.edgesCreate(3,2);

        gatherLevels.gatherLevels(0, 4);
    }


}
