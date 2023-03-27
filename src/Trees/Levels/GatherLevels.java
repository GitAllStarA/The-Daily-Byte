/*
* https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/922676902/
* */

package Trees.Levels;

import java.util.ArrayList;
import java.util.List;

public class GatherLevels {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(110);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(32);
        root2.left.left = new TreeNode(3);
        root2.right.right = new TreeNode(78);


        System.out.println("height "+height(root2));
        System.out.println();
        System.out.println(levelOrder(root2));
    }



    public static List<List<Integer>> levelOrder(TreeNode root){
        int hgt = height(root);
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 1; i <= hgt; i++) {
            var x = levelOrder(root,i,new ArrayList<>());
                a.add(x);
        }
        return a;
    }

    public static int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int result = 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (lHeight>rHeight){
            lHeight += 1;
            result = lHeight;
        }
        else
        {
            rHeight += 1;
            result = rHeight;
        }
        return result;
    }


    public static ArrayList<Integer> levelOrder(TreeNode root, int level,ArrayList<Integer> al){
        if (root==null)
            return null;
        if (level==1) {
            al.add(root.val);
        }
        else if (level>1)
        {
            levelOrder(root.left,level-1,al);
            levelOrder(root.right,level-1,al);
        }
        return al;
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