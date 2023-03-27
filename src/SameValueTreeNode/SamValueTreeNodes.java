/*
*
* Given the root of a binary tree, return the total number of subtrees that all contain the same value.

Ex: Given the following binary tree...

          2
        /   \
       5     7
     /   \     \
    3     3     7, return 4 (both threes and both sevens).
See Solution
* */


package SameValueTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SamValueTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        noOfSameNode(root);
    }


    public static int noOfSameNode(TreeNode root) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int x = 1;
        inOrder(root, hashMap,x);
        //System.out.println(hashMap);

        int value = (int) hashMap
                            .values()
                            .stream()
                            .filter(integer -> integer > x)
                            .reduce(Integer::sum)
                            .get();
        System.out.println(value);
        return value;

    }

    public static void inOrder(TreeNode root, HashMap<Integer,Integer> hashMap,int x){
        if (root == null){
            return;
        }
        if (hashMap.containsKey(root.val)){

            hashMap.put(root.val, hashMap.get(root.val)+1);
            x++;
        }
        else {
            hashMap.put(root.val, 1);
            x++;
        }
        inOrder(root.left,hashMap,x);
        inOrder(root.right,hashMap,x);

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