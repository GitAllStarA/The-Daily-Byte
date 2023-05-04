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
Ex: Given the following tree…

-->        7
         /  \
-->     4     3
       / \   / \
-->   1   4 8   9
                 \
-->               9
return [[7], [4,3], [1,4,8,9], [9]]
* */


package Graphs.BreadthFirstSearch.GatherLevels;

import java.util.*;

public class GatherLevels {
    /*int vertices;
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
    }*/

    /*void gatherLevels(int sourceVertex, int noOfVertices) {
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
            if (lvl.size() >= 1) {
                levels.add(lvl);
            }
        }
        System.out.println(levels);
    }*/


    public static ArrayList<ArrayList<Integer>> gatherLevels(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                arrayList2.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);

                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);

                }
            }
            arrayList.add(arrayList2);

        }
        return arrayList;
    }

    public static void main(String[] args) {
        /*scanner  = new Scanner(System.in);
        int noOfVertices = scanner.nextInt();

        scanner.close();*/
        /*
        GatherLevels gatherLevels = new GatherLevels(4);

        gatherLevels.edgesCreate(0, 1);
        gatherLevels.edgesCreate(0, 2);

        gatherLevels.edgesCreate(1, 0);

        gatherLevels.edgesCreate(2, 0);
        gatherLevels.edgesCreate(2, 3);

        gatherLevels.edgesCreate(3, 2);

        gatherLevels.gatherLevels(0, 4);*/


        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(9);
        System.out.println(gatherLevels(root));

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
*
* -->      7
         /  \
-->     4     3
       / \   / \
-->   1   4 8   9
                 \
-->               9
return [7, 4, 1, 9]
*
* */