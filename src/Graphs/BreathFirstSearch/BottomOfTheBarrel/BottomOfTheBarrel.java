/*
* Bottom of the Barrel
Breadth-first Search
Medium
Given a binary tree, return the bottom-left most value.
Note: You may assume each value in the tree is unique.
Ex: Given the following binary tree…

      1
     / \
    2   3
   /
  4
return 4.
Ex: Given the following binary tree…

      8
     / \
    1   4
       /
      2
return 2.
See Solution
*
* */



package Graphs.BreathFirstSearch.BottomOfTheBarrel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BottomOfTheBarrel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        bottomLeftValue(root);
    }

    public static void bottomLeftValue (TreeNode root) {
        int bottomLeftVal = 0;
        if (root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                if (currentNode.left!=null){
                    bottomLeftVal = currentNode.left.val;
                }
            }
        }
        System.out.println(bottomLeftVal);
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
        this.right = right;
        this.left = left;
    }
}
