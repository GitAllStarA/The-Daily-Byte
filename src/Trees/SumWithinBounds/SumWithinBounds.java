/*
*
* https://leetcode.com/problems/range-sum-of-bst/
*
* */


package Trees.SumWithinBounds;

import java.util.ArrayList;

public class SumWithinBounds {

    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        /*root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = null;
        root.right.right = new TreeNode(18);*/

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = null;
        root.left.right.left = new TreeNode(6);
        root.left.right.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);




        System.out.println(rangeSumBST(root,6,10));

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        System.out.println(al);
        inOrder(root,low,high,al);
        System.out.println();
        System.out.println("here "+ al);
        return helperSum(al);

    }
    static void inOrder(TreeNode root, int low, int high, ArrayList<Integer> al) {
        if (root==null){
            return;
        }
        inOrder(root.left,low,high,al);
        System.out.print(root.val+" ");
        if (root.val>=low && root.val<=high){
            al.add(root.val);
        }
        inOrder(root.right,low,high,al);
    }

    static int helperSum(ArrayList<Integer> arrayList) {
        return arrayList.stream().reduce(0,Integer::sum);
    }
}
class TreeNode {
    TreeNode left;
    TreeNode right;

    int val;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
