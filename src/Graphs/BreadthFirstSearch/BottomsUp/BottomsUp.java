/*
* Bottoms Up
Breadth-first Search
Medium
Given a binary tree, returns of all its levels in a bottom-up fashion (i.e. last level towards the root). Ex: Given the following tree…

        2
       / \
      1   2
return [[1, 2], [2]]
Ex: Given the following tree…

       7
      / \
    6    2
   / \
  3   3
return [[3, 3], [6, 2], [7]]
See Solution
*
* */


package Graphs.BreadthFirstSearch.BottomsUp;

import java.util.*;

public class BottomsUp {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        bfsLastToFirst(root);

    }

    public static ArrayList<ArrayList<Integer>> bfsLastToFirst(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList;
        }

        Queue<TreeNode> queue = new LinkedList<>();


        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                arrayList1.add(currentNode.val);
                if (currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            arrayList.add(arrayList1);
        }

          Collections.reverse(arrayList);
        System.out.println(arrayList);
        return arrayList;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int val) {
        this.val = val;
    }
    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
