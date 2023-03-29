/*
*
* Tree Cousins
Trees
Medium
Given the root of a binary tree that contains only unique values, and two tree values x and y, return whether or not the nodes containing values x and y are cousins.
Note: Two nodes in a tree are cousins if they have the same depth but different parents.

Ex: Given the following root, x, and y…

      1
    /   \
   2     3, x = 2, y = 3, return false (2 and 3 are on the same level but have the same parent).
Ex: Given the following root, x, and y…

      5
    /   \
   3     2
  / \   / \
 4  7  9   8, x = 8, y = 4, return true.
*
* */


package Trees.TreeCousins;

import java.util.ArrayList;

public class TreeCousins {
    public static void main(String[] args) {
        TreeNode root=  new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(9);
        root.right.right.right = new TreeNode(55);
       // System.out.println(height(root));

        x(root,9,55);
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        int result=0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        if (lHeight > rHeight){
            lHeight += 1;
            result = lHeight;
        }
        else {
            rHeight += 1;
            result = rHeight;
        }
        return result;
    }

    static void x(TreeNode root,int x, int y){
        ArrayList<Integer> al = new ArrayList<>();

        preOrder(root,al,x,y);
        System.out.println(al);
    }

    static void preOrder(TreeNode root, ArrayList<Integer> al,int x, int y){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        System.out.println(root.val);
        if (root.left.val == x || root.right.val==x || root.right.val==y ||root.left.val==y)
            return;
        else if (root.left.val == x || root.right.val == x || root.right.val == y || root.left.val == y)
        {
            al.add(root.val);
        }
        preOrder(root.left,al,x,y);
        preOrder(root.right,al,x,y);
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}