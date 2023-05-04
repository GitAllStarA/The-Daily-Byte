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


package Graphs.BreadthFirstSearch.MaxValAtEachLevel;


import java.util.*;

public class MaxValueInEachLevel {

    /*int vertices;

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
    }*/


    static List<Integer> bfsMaxValAtEachLevelInTree(TreeNodeForGatherLevels root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }

        Queue<TreeNodeForGatherLevels> queue = new LinkedList<>();
        queue.add(root);
        //arrayList.add(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNodeForGatherLevels node = queue.poll();
                if (max < node.val){
                    max = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            arrayList.add(max);
        }
        System.out.println(arrayList);
        return arrayList;
    }

    public static void main(String[] args) {


        TreeNodeForGatherLevels root = new TreeNodeForGatherLevels(7);
        root.left = new TreeNodeForGatherLevels(4);
        root.right = new TreeNodeForGatherLevels(3);
        root.left.left = new TreeNodeForGatherLevels(1);
        root.left.right = new TreeNodeForGatherLevels(4);
        root.right.left = new TreeNodeForGatherLevels(8);
        root.right.right = new TreeNodeForGatherLevels(9);
        root.right.right.right = new TreeNodeForGatherLevels(9);

        bfsMaxValAtEachLevelInTree(root);

    }


}

class TreeNodeForGatherLevels {
    int val;
    TreeNodeForGatherLevels left;
    TreeNodeForGatherLevels right;

    TreeNodeForGatherLevels(int val) {
        this.val = val;
    }

    TreeNodeForGatherLevels(int val, TreeNodeForGatherLevels left, TreeNodeForGatherLevels right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}




/*
*
*         1
         / \
        5   6
       / \   \
      5   3   7
* */
        /*MaxValueInEachLevel maxValueInEachLevel = new MaxValueInEachLevel(8);
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

        maxValueInEachLevel.maxValueAtEachLevel(1, 8);*/