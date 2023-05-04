package Graphs.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Stack;

public class DFSImpl {


    static private int vertices;

    static private ArrayList[] adjList;

    DFSImpl(int noOfEdges) {
        vertices = noOfEdges;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int edge, int adjEdge) {
        adjList[edge].add(adjEdge);
    }

    public void DFS(int sourceEdge) {

        boolean[] isVisited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.add(sourceEdge);
        isVisited[sourceEdge] = true;
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            switch (currentNode){
                case 0:
                    System.out.print("A"+" ");
                    break;
                case 1:
                    System.out.print("B"+" ");
                    break;
                case 2:
                    System.out.print("C"+" ");
                    break;
                case 3:
                    System.out.print("D"+" ");
                    break;
                case 4:
                    System.out.print("E"+" ");
                    break;
                case 5:
                    System.out.print("F"+" ");
                    break;
            }
            for (int i = 0; i < adjList[currentNode].size(); i++) {
                int adjNode = (int) adjList[currentNode].get(i);
                if (isVisited[adjNode] == false)
                {
                    stack.add(adjNode);
                    isVisited[adjNode] = true;
                }
            }

        }
    }


    public static void main(String[] args) {
        DFSImpl dfs = new DFSImpl(6);

        //A
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 5);
        //B
        dfs.addEdge(1, 0);
        dfs.addEdge(1, 2);
        //C
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 1);
        dfs.addEdge(2, 3);
        dfs.addEdge(2, 4);
        //E
        dfs.addEdge(3, 2);
        dfs.addEdge(3, 5);
        //D
        dfs.addEdge(4, 2);
        //F
        dfs.addEdge(5, 0);
        dfs.addEdge(5, 3);

        dfs.DFS(0);
    }


}
