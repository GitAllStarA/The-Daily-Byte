/*
https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */

package Trees.MinimumDifference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class MinimumDifference {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(0);
        //root.left.left = new TreeNode(48);
        //root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        //root.left.left.left = new TreeNode(12);
        //root.left.left.right = new TreeNode(49);

        System.out.println(getMinimumDifference(root));

    }



    static ArrayList inOrder(TreeNode root,ArrayList<Integer>arrayList){
        if (root==null){
            return null;
        }

        inOrder(root.left,arrayList);
        System.out.print(root.val+" ");
        arrayList.add(root.val);
        inOrder(root.right,arrayList);

        return arrayList;
    }

    public static  int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println();
        ArrayList sub = inOrder(root,arrayList);

        System.out.println();
        System.out.println(arrayList);
        for (int i = 0; i < sub.size()-1; i++) {
            int a = (int) sub.get(i);
            int b = (int) sub.get(i+1);
            al.add(Math.abs(a-b));

        }
        System.out.println(al);
        return Collections.min(al);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
