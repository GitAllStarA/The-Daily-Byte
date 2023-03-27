/*
*
* Boring Tree
Trees
Easy
A boring tree is a tree whose nodes only contain a single value. Given a reference to the root of a binary tree, root, return whether or not it is a boring tree.
Note: It is guaranteed that a single value exists within the tree.

Ex: Given the following root…

       7
      / \
     7   7, return true.
Ex: Given the following root…

       1
      / \
     2   3, return false.

*
* */


package BoringTree_UniValuedTree;

import java.util.HashSet;

public class BoringTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        //root.left.left = new TreeNode(2);
        System.out.println(isUnivalTree(root));

    }

    static boolean isUnivalTree(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        return inOrder(root,set);
    }

    static boolean inOrder(TreeNode root, HashSet<Integer> set){
        if (root==null)
            return false;

        inOrder(root.left,set);
        set.add(root.val);
        inOrder(root.right,set);
        return set.size()<=1?true:false;
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
