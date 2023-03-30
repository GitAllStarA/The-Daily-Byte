/*
*
* Visible Values
Breadth-first Search
Medium
Given a binary tree return all the values you’d be able to see if you were standing on the left side of it with values ordered from top to bottom.

Ex: Given the following tree…

-->    4
      / \
-->  2   7
return [4, 2]
Ex: Given the following tree…

-->        7
         /  \
-->     4     9
       / \   / \
-->   1   4 8   9
                 \
-->               9
return [7, 4, 1, 9]
*
* */


package Graphs.BreathFirstSearch.SideView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class VisibleValues {

    int vertices;

    ArrayList<Integer> adjList[];

    VisibleValues (int vertices){

        this.vertices = vertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int vertex, int dst) {
        ArrayList<Integer> v = adjList[vertex];
        v.add(dst);
    }

    void bfs(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        arrayList.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();

            while (currentNode!=null){
                if (currentNode.left!=null){
                    queue.add(currentNode.left);
                    arrayList.add(currentNode.left.val);
                }
                if (currentNode.left==null&&currentNode.right!=null){
                    queue.add(currentNode.right);
                    arrayList.add(currentNode.right.val);
                }
            }
        }
        System.out.println(arrayList);
    }


    public static void main(String[] args) {
        VisibleValues vv = new VisibleValues(6);
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(9);

        vv.bfs(root);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}