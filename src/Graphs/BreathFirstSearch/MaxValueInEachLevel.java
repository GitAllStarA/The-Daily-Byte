/*
*
*
Max Value in Each Level
Breadth-first Search
Easy
Given a binary tree, return the largest value in each of its levels. Ex: Given the following tree…

    2
   / \
  10  15
        \
         20
return [2, 15, 20]
Ex: Given the following tree…

          1
         / \
        5   6
       / \   \
      5   3   7
return [1, 6, 7]
*
*
* */


package Graphs.BreathFirstSearch;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MaxValueInEachLevel {

    int vertices;

    ArrayList<Integer> adjList[];

    MaxValueInEachLevel(int numberOfVertices) {
        vertices = numberOfVertices;
        adjList = new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    void createEdge(int x, int y) {
        adjList[x].add(y);
    }

    void maxValueAtEachLevel(int srcVertex, int noOfVertices) {
        boolean[] visited = new boolean[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(srcVertex);
        visited[srcVertex] = true;
        ArrayList<Integer> maxValList = new ArrayList<>();
        maxValList.add(queue.peek());
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (adjList[currentVertex] != null) {
                ArrayList<Integer> xl = new ArrayList<>();
                for (int i = 0; i < adjList[currentVertex].size(); i++) {
                    int c = adjList[currentVertex].get(i);
                    if (visited[c] == false) {
                        queue.add(c);
                        visited[c] = true;
                        xl.add(c);
                    }


                }
                System.out.println(xl);
                if (!xl.isEmpty()) {
                    int m = Collections.max(xl);
                    maxValList.add(m);
                }
            }
        }
        System.out.println("longest values "+maxValList);
    }

    public static void main(String[] args) {
/*
*
*         1
         / \
        5   6
       / \   \
      5   3   7
* */
        MaxValueInEachLevel maxValueInEachLevel = new MaxValueInEachLevel(8);
        maxValueInEachLevel.createEdge(1, 2);
        maxValueInEachLevel.createEdge(1, 3);

        maxValueInEachLevel.createEdge(2, 1);
        maxValueInEachLevel.createEdge(2, 4);
        maxValueInEachLevel.createEdge(2, 5);

        maxValueInEachLevel.createEdge(3, 6);
        maxValueInEachLevel.createEdge(3, 1);

        maxValueInEachLevel.createEdge(4, 2);

        maxValueInEachLevel.createEdge(5, 2);

        maxValueInEachLevel.createEdge(6, 3);
        maxValueInEachLevel.createEdge(5, 5);
        maxValueInEachLevel.createEdge(5, 5);
        maxValueInEachLevel.createEdge(5, 4);
        maxValueInEachLevel.createEdge(4, 5);

        maxValueInEachLevel.maxValueAtEachLevel(1, 8);


    }


}
