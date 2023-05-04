package Graphs.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestClass {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(9);
        System.out.println(bfs(root));
    }

    static List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size = 1;
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            System.out.println("max "+max);
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                System.out.println("node "+node.val);
                max = Math.max(max, node.val);
                if(node.left != null) {
                    queue.add(node.left);
                    System.out.println("left "+node.left.val);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    System.out.println("right "+node.right.val);
                }
            }

            size = queue.size();
            result.add(max);
            System.out.println("result "+result);
        }

        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
