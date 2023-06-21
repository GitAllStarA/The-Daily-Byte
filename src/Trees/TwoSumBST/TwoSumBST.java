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
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(17);
        //root.right.right.right = new TreeNode(200);
        //System.out.println(findTarget(root,9));
        //System.out.println("find the depth");
        //System.out.println(depthOfBST(root));
        System.out.println("is balanced tree");
        //System.out.println(isBalancedHelper(root));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(10);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(-100);
        root2.left.left.right = new TreeNode(2000);
        System.out.println("is balanced tree");



        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(3);
        root3.right.right = new TreeNode(233);
        System.out.println(helperIsBalanced(root3));
        System.out.println("//////////////");
        System.out.println(isB(root));

    }
    /*
     *              5
     *            /  \
     *          3     10
     *        /  \   /  \
     *       2    4 9    17
     * */



    static int isB(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = 1 + isB(root.left);
        int right = 1 + isB(root.right);

        if (Math.abs(left - right) > 1){
            return -1;
        }
        else return 0;
    }

    static boolean helperIsBalanced(TreeNode root){
        System.out.println(isBalancedLeft(root));
        System.out.println(isBalancedRight(root));
        if (isBalancedLeft(root) == isBalancedRight(root)){

            return true;
        }
        return false;
    }

    static int isBalancedLeft(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int count = 1 + isBalancedLeft(root.left);

        return count;
    }


    static int isBalancedRight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int count = 1 + isBalancedRight(root.right);
        return count;
    }


    static int depthOfBST(TreeNode root) {
        return helperDepthOfBST(root, 0);
    }

    static int helperDepthOfBST(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        int left = helperDepthOfBST(root.left, count + 1);
        int right = helperDepthOfBST(root.right, count + 1);
        // System.out.println(left+" "+right);
        return Math.max(left, right);
    }

    public static boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        inOrder(root, al);
        for (int i = 0; i < al.size(); i++) {
            for (int j = i + 1; j < al.size(); j++) {
                if (al.get(i) + al.get(j) == k)
                    return true;
            }
        }
        return false;
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> al) {
        if (root == null)
            return;

        inOrder(root.left, al);
        al.add(root.val);
        inOrder(root.right, al);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}