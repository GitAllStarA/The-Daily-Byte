
/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
* */

package Trees.LowerCommonAncestor;

import java.util.ArrayList;
import java.util.Scanner;

public class LowerCommonAncestor {
    static ArrayList<Integer> a = new ArrayList<>();
    static ArrayList<Integer> b = new ArrayList<>();
    static TreeNode root;


    static Scanner sc;

    public static void main(String[] args) {
        /*int[] array = new int[]{5,4,1,2,10,9,11};
        for (int x : array){
            //createTree(x);
        }
*/

        sc = new Scanner(System.in);
        System.out.println("enter values for binary search tree");

        root = insertToBinaryTree();




        findNode(2);
        findNode(6);

        System.out.println(a);
        System.out.println(b);
        System.out.println(findKey(closestAncestor(a,b)));

        inOrder(root);
    }

    static TreeNode insertToBinaryTree() {
        TreeNode parent = null;
        System.out.println("enter data");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        parent = new TreeNode(data);

        System.out.println("enter left child for parent " + data);
        parent.left = insertToBinaryTree();

        System.out.println("enter right child for parent" + data);
        parent.right = insertToBinaryTree();

        return parent;


    }

    static void createTree(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode focusNode = root;

            TreeNode parent;

            while (true) {
                parent = focusNode;
                if (val < focusNode.val) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

    }


    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            inOrder(root.left);
            System.out.print(root.val + " ");
            if (root.val == closestAncestor(a,b)){
                System.out.println();
                System.out.println(root);
                System.out.println();
            }
            inOrder(root.right);
        }
    }


    static void findNode(int key) {
        if (root == null)
            return;

        TreeNode focusNode = root;
        while (focusNode != null) {
            if (key < focusNode.val) {
                a.add(focusNode.val);
                focusNode = focusNode.left;
                if (focusNode.val == key || focusNode == null)
                    return;

            } else {
                b.add(focusNode.val);
                focusNode = focusNode.right;
                if (focusNode.val == key || focusNode == null)
                    return;
            }
        }
    }

    static TreeNode findKey(int key){
        if (root ==  null) {
            return null;
        }
        TreeNode focusNode = root;
        while (focusNode!=null){
            if (key < focusNode.val)
            {
                focusNode = focusNode.left;
                if (focusNode.val == key)
                    return focusNode;
            }
            else
            {
                focusNode = focusNode.right;
                if (focusNode.val == key)
                    return focusNode;
            }
        }
        return focusNode;
    }

    static int closestAncestor(ArrayList<Integer> a, ArrayList<Integer> b) {
        int result = 0;
        for (int i = a.size()-1; i >= 0; i--) {
            for (int j = b.size()-1; j >= 0; j--) {
                if (a.get(i) != b.get(j)) {
                    break;
                }
                result = a.get(i);
            }

        }

        return result;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;

    int val;

    TreeNode(int data) {
        this.val = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }
}
