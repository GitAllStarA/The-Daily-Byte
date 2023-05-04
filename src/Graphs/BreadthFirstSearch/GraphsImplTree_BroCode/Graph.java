package Graphs.BreadthFirstSearch.GraphsImplTree_BroCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    ArrayList<LinkedList<Node>> adjList;

    Graph() {
        adjList = new ArrayList<>();
    }

    //whenever we add a node we create new linked list to keep track for all the adj node
    void addNode(Node node){

        LinkedList<Node> currentList = new LinkedList<>();
        // new node will be head of linked list
        currentList.add(node);
        adjList.add(currentList);
    }

    public  void addEdge(int src, int dest) {
        // get the node and from adj list
        LinkedList<Node> currentList = adjList.get(src);

        //head of our adj node from adj linked list
        Node dstNode = adjList.get(dest).get(0);

        // adding to tail of current node
        currentList.add(dstNode);


    }

    public boolean checkEdge(int src, int dest) {
        LinkedList<Node> currentNode = adjList.get(src);

        Node dstNode = adjList.get(dest).get(0);

        for (Node node : currentNode) {
            if (node == dstNode){
                return true;
            }
        }
        return false;
    }

    public void print () {
        for (LinkedList<Node> currentNode : adjList) {
            for (Node node : currentNode){
                System.out.print(node.val+" -> ");
            }
            System.out.println();
        }

    }
}
