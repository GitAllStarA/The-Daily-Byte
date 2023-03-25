package Trees.SortedArrayToBST;

import java.util.Arrays;

public class SortedArrayToBinarySearchTree {


    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,5};

        TreeNode root = sortedArrayToBST(array);
        inOrder(root);
    }

    static TreeNode sortedArrayToBST(int[] array){
        return sortedArrayToBST2(array,null);
    }

   static TreeNode sortedArrayToBST2(int[] array, TreeNode root) {

        array = modifyArray(array);
        int parent = array[0];

       if (array.length == 1){
           TreeNode sizeOne = new TreeNode(parent);
           return sizeOne;
       }
       else {
           root = new TreeNode(parent);
           TreeNode xy = null;
           for (int i = 1; i < modifyArray(array).length; i++) {
               xy = createTree(modifyArray(array)[i], root);
           }
           return xy;
       }
    }

  static   TreeNode createTree(int val, TreeNode root) {
        TreeNode newNode = new TreeNode(val);
        TreeNode focusNode = root;
        TreeNode parent;
        while (true) {
            parent = focusNode;
            if (val < focusNode.val) {
                focusNode = focusNode.left;
                if (focusNode == null) {
                    parent.left = newNode;
                    break;
                }
            } else {
                focusNode = focusNode.right;
                if (focusNode == null) {
                    parent.right = newNode;
                    break;
                }
            }
        }
        return root;
    }

    static  int[] modifyArray(int[] array) {
        if (array.length==1){
            return array;
        }
        int size = array.length - 1;
        int mid = size / 2;

        int temp = array[mid];
        array[mid] = array[0];
        array[0] = temp;
        return array;
    }

   static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
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