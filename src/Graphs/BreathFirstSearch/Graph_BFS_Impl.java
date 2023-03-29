package Graphs.BreathFirstSearch;

import java.util.*;

public class Graph_BFS_Impl {

    int vertices;
    ArrayList<Integer> adjList[];

    Graph_BFS_Impl (int vertices){
        this.vertices = vertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        System.out.println(Arrays.toString(adjList));
    }

    void edgeCreate(int vertex_node, int adjNode){
        ArrayList<Integer> edge = adjList[vertex_node];
        edge.add(adjNode);
    }


    void breathFirstSearch(int sourceNode, int totalVertices) {
        Queue<Integer> visitedQueue = new LinkedList<>();

        boolean[] visited = new boolean[totalVertices];
        visitedQueue.add(sourceNode);
        visited[sourceNode] = true;
        int currentVertex = visitedQueue.peek();
        while (!visitedQueue.isEmpty()){


            currentVertex = visitedQueue.poll();
            System.out.print(currentVertex+" ");
            int count = 0;
            while (count < adjList[currentVertex].size()) {
                int adjNode = adjList[currentVertex].get(count);
                if (visited[adjNode] == false){
                    visitedQueue.add(adjNode);
                    visited[adjNode] = true;
                }
                count++;
            }

        }



    }

    public static void main(String[] args) {
        Graph_BFS_Impl bfs = new Graph_BFS_Impl(7);
        bfs.edgeCreate(0,1);
        bfs.edgeCreate(0,2);
        bfs.edgeCreate(0,3);

        bfs.edgeCreate(1,0);
        bfs.edgeCreate(1,6);

        bfs.edgeCreate(2,0);

        bfs.edgeCreate(3,0);
        bfs.edgeCreate(3,4);
        bfs.edgeCreate(3,5);
        bfs.edgeCreate(3,6);

        bfs.edgeCreate(4,3);

        bfs.edgeCreate(5,3);

        bfs.edgeCreate(6,1);
        bfs.edgeCreate(6,3);

        bfs.breathFirstSearch(0,7);

    }

}
