/*
* Averages
Breadth-first Search
Medium
This question is asked by Facebook. Given a reference to the root of a binary tree, return a list containing the average value in each level of the tree.

Ex: Given the following binary tree…

       1
      / \
    6    8
   / \
  1   5
return [1.0, 7.0, 3.0]
*
* */

package Graphs.BreathFirstSearch.AverageBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Averages {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        averageAtEachLevel(root);
    }

    public static void averageAtEachLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Double> arrayList = new ArrayList<>();
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            ArrayList<Integer> kidsAtEachLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode currentNode = queue.poll();
                kidsAtEachLevel.add(currentNode.val);
                sum = sum + currentNode.val;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            arrayList.add(sum / kidsAtEachLevel.size());
        }
        System.out.println(arrayList);
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
