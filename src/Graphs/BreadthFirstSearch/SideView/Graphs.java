package Graphs.BreadthFirstSearch.SideView;

import java.util.*;

public class Graphs {

    //int val;
    ArrayList<LinkedList<Integer>> adjList;
    HashMap<Integer, Integer> mapVertexToIndex;

    Graphs() {
        adjList = new ArrayList<>();
        mapVertexToIndex = new HashMap<>();
    }

    public int addNode(int vertex) {
        LinkedList<Integer> vertexAdjsList = new LinkedList<>();
        //head
        vertexAdjsList.add(vertex);
        //adding to adj list
        adjList.add(vertexAdjsList);
        System.out.println("added vertex : " + vertex);
        return vertex;
    }

    public void setMapVertexToIndex() {

        System.out.println(adjList);
        for (int i = 0; i < adjList.size(); i++) {
            int head = adjList.get(i).get(0);
            //System.out.println(head);
            mapVertexToIndex.put(i, head);
        }
        System.out.println(mapVertexToIndex);
    }

    public void addEdge(int srcVertex, int destVertex) {
        LinkedList<Integer> vertexsList = adjList.get(srcVertex);
        int destinationVertex = adjList.get(destVertex).get(0);
        vertexsList.add(destinationVertex);
    }

    public boolean checkEdge(int srcVertex, int destVertex) {
        LinkedList<Integer> vertexsList = adjList.get(srcVertex);
        int destinationVertex = adjList.get(destVertex).get(0);
        for (int vertex : vertexsList) {
            if (vertex == destinationVertex) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (LinkedList<Integer> vertexList : adjList) {
            for (int vertex : vertexList) {
                System.out.print(vertex + " -> ");
            }
            System.out.println();
        }
    }


    public void bfs(int srcVertex, int noOfNodes) {
        boolean[] visited = new boolean[noOfNodes];
        Queue<Integer> queue = new LinkedList<>();
        int valeOfIndex = mapVertexToIndex.get(srcVertex);
        //System.out.println(valeOfIndex);
        queue.add(valeOfIndex);
        //System.out.println("queue first" +queue);
        visited[srcVertex] = true;
        while (!queue.isEmpty()) {
            int currentNode_Vertex = queue.poll();
            System.out.print(currentNode_Vertex + " ");
            int key = 0;
            for (Map.Entry<Integer, Integer> entry : mapVertexToIndex.entrySet()) {
                if (currentNode_Vertex == entry.getValue()) {
                    key = entry.getKey();
                    break;
                }
            }
            if (!adjList.get(key).isEmpty()) {
                for (int i = 1; i < adjList.get(key).size(); i++) {
                    int adjNode_vertex = adjList.get(key).get(i);
                    //System.out.println(adjNode_vertex);
                    int whatIndex = 0;
                    for (Map.Entry<Integer, Integer> entry : mapVertexToIndex.entrySet()) {
                        if (adjNode_vertex == entry.getValue()) {
                            whatIndex = entry.getKey();
                            break;
                        }
                    }
                    if (visited[whatIndex] == false) {
                        queue.add(adjNode_vertex);
                        visited[whatIndex] = true;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs(); //index
        graphs.addNode(9);  // 0
        graphs.addNode(10); // 1
        graphs.addNode(3);  // 2
        graphs.addNode(33); // 3
        graphs.addNode(25); // 4
        graphs.addNode(1);  // 5

        graphs.addEdge(0, 1);
        graphs.addEdge(0, 2);

        graphs.addEdge(1, 0);
        graphs.addEdge(1, 3);

        graphs.addEdge(2, 0);
        graphs.addEdge(2, 4);

        graphs.addEdge(3, 1);
        graphs.addEdge(3, 4);
        graphs.addEdge(3, 5);

        graphs.addEdge(4, 3);
        graphs.addEdge(4, 2);

        graphs.addEdge(5, 3);


        //graphs.print();


        //System.out.println(graphs.adjList.get(0).get(0));
        graphs.setMapVertexToIndex();
        graphs.bfs(0, 6);


    }
}
