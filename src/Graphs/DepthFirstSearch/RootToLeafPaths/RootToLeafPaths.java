/*
* Root to Leaf Paths
Depth-first Search
Easy
Given a binary tree, return a list of strings containing all root to leaf paths.

Ex: Given the following tree…

   1
 /   \
2     3
return ["1->2", "1->3"]
Ex: Given the following tree…

    8
   / \
  2  29
    /  \
   3    9
return ["8->2", "8->29->3", "8->29->9"]
*
*
* */


package Graphs.DepthFirstSearch.RootToLeafPaths;

import java.util.ArrayList;

public class RootToLeafPaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(33);
        root.right = new TreeNode(3);
        System.out.println(DFSRootToLeafPaths(root));
    }

    public static ArrayList<String> DFSRootToLeafPaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        gatherPaths(root, paths, "");
        //System.out.println(paths);
        return paths;
    }

    public static void gatherPaths(TreeNode root, ArrayList<String> paths, String current) {
        if (root.left == null && root.right == null) {
            current = current+root.val;
            paths.add(current);
        }
        if (root.left!=null){
            gatherPaths(root.left,paths,current+root.val+"->");
        }
        if (root.right!=null){
            gatherPaths(root.right,paths,current+root.val+"->");
        }
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
