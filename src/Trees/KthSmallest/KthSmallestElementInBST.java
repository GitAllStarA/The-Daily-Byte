

/*
*
* 230. Kth Smallest Element in a BST
Medium
9.4K
166
Companies
Given the root of a binary search tree, and an integer k,
* return the kth smallest value
                " (1-indexed) "
* of all the values of the nodes in the tree.



Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

*
* */
package Trees.KthSmallest;

import java.util.ArrayList;

public class KthSmallestElementInBST {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(3);
        root.left =  new TreeNode(2);
        root.right = new TreeNode(4);*/

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(kthSmallest(root,3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        findKthElement(root,al, k);
        return al.get(k);
    }

    static void findKthElement(TreeNode root,ArrayList<Integer> al ,int k){
        if (root == null)
            return;
        findKthElement(root.left,al,k);
        al.add(root.val);
        findKthElement(root.right,al,k);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}