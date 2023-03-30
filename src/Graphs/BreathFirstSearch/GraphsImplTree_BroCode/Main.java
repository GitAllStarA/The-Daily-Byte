package Graphs.BreathFirstSearch.GraphsImplTree_BroCode;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
                                        //index
        graph.addNode(new Node(1));// 0
        graph.addNode(new Node(2));// 1
        graph.addNode(new Node(3));// 2
        graph.addNode(new Node(4));// 3
        graph.addNode(new Node(5));// 4
        graph.addNode(new Node(6));// 5

        graph.addEdge(0,1);
        graph.addEdge(0,4);

        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,4);

        graph.addEdge(2,1);
        graph.addEdge(2,4);
        graph.addEdge(2,3);

        graph.addEdge(3,2);

        graph.addEdge(4,5);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(4,2);

        graph.addEdge(5,4);

        graph.print();

    }
}
