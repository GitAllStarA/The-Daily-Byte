
/*
* https://leetcode.com/discuss/interview-question/963428/Google-or-Phone-or-Most-frequent-element-in-a-BST
*
* */

package Trees.FindMode;

import java.util.*;

public class FindMode {

    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(9);

        inOrder(root);
        System.out.println();
        System.out.println(hashMap);
        System.out.println(findMaxOccuranceOfVal(hashMap));
        System.out.println();
    }

    static int findMaxOccuranceOfVal(HashMap<Integer,Integer> hashMap) {
       int MaxValue =  hashMap.get(hashMap.values().toArray()[0]);
       int result = 0;
       for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
           if (MaxValue < entry.getValue()){
               MaxValue = entry.getValue();
               result = entry.getKey();
           }
       }
       return result;
    }

    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        if (hashMap.containsKey(root.val)){
            hashMap.put(root.val, hashMap.getOrDefault(root.val,0)+1);
        }
        else {
            hashMap.put(root.val,1);
        }
        inOrder(root.right);
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
