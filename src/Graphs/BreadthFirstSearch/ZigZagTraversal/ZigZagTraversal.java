/*
* Zigzag Traversal
Breadth-first Search
Easy
Given a binary tree, return its zig-zag level order traversal (i.e. its level order traversal from left to right the first level, right to left the level the second, etc.).

Ex: Given the following tree…

    1
   / \
  2   3
return [[1], [3, 2]]
Ex: Given the following tree…

    8
   / \
  2  29
    /  \
   3    9
return [[8], [29, 2], [3, 9]]
*
* */

package Graphs.BreadthFirstSearch.ZigZagTraversal;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.right = new TreeNode(29);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);
        rightToLeftTraversal(root);

        System.out.println(2 % 2 == 0 ? true : false);
    }


    public static List<List<Integer>> rightToLeftTraversal(TreeNode root) {
        List<List<Integer>> arrayList = new LinkedList<>();

        if (root == null)
            return arrayList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> arrayList2 = new LinkedList<>();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode currentNode = queue.poll();
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                arrayList2.add(currentNode.val);
            }
            count++;
                arrayList.add(arrayList2);
        }
        System.out.println(arrayList);
        return arrayList;
    }

/*
*
* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
* */
    public static List<List<Integer>> rightToLeftTraversalAlternatively(TreeNode root) {
        List<List<Integer>> arrayList = new LinkedList<>();

        if (root == null)
            return arrayList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> arrayList2 = new LinkedList<>();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode currentNode = queue.poll();
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                arrayList2.add(currentNode.val);
            }
            count++;
            System.out.println(count);
            if (count % 2 != 0) {
                Collections.reverse(arrayList2);
                arrayList.add(arrayList2);
            }
            else {
                arrayList.add(arrayList2);
            }
        }
        System.out.println(arrayList);
        return arrayList;
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
