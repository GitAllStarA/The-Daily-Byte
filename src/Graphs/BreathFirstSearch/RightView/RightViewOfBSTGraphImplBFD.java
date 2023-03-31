/*
* https://leetcode.com/problems/binary-tree-right-side-view/
*
* */

package Graphs.BreathFirstSearch.RightView;


import java.util.*;

public class RightViewOfBSTGraphImplBFD {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(13);
        root.right.right.right = new TreeNode(9);
        root.left.left.left.left = new TreeNode(1);
        bfsRight(root);

    }
    
    public static List<Integer> bfsRight(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                if (i == size-1){
                    arrayList.add(currentNode.val);
                }
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
