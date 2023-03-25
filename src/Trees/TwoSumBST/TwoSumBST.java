/*
* https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
*
*
* */

package Trees.TwoSumBST;

import java.util.ArrayList;

public class TwoSumBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(findTarget(root,9));
    }


    public static boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> al = new ArrayList<>();
            inOrder(root,al);
        for (int i = 0; i < al.size(); i++) {
            for (int j = i+1; j < al.size(); j++) {
                if (al.get(i) + al.get(j) ==  k)
                    return true;
            }
        }
        return false;
    }

    public static void inOrder(TreeNode root,ArrayList<Integer> al){
        if (root == null)
            return;

        inOrder(root.left,al);
        al.add(root.val);
        inOrder(root.right,al);
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