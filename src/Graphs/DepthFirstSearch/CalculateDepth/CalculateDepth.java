package Graphs.DepthFirstSearch.CalculateDepth;

import java.util.Stack;

public class CalculateDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(30);
        System.out.println(calDepth(root));
    }

    public static int calDepth(TreeNode root) {

        int result = Integer.MIN_VALUE;

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int count = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = stack.pop();
                if (currentNode != null) {
                    if (currentNode.left != null) {
                        stack.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        stack.add(currentNode.right);
                    }
                }
            }
        }
        return count;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
