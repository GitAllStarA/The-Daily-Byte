package Trees;

import java.util.Scanner;

public class BinarySearchTree {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);


        TreeNode node = createBST();

        inOrder(node);
        System.out.println();
        preOrder(node);
        System.out.println();
        postOrder(node);
        System.out.println();
    }

    static TreeNode createBST() {
        TreeNode parent = null;
        System.out.println("enter the val");
        int data = sc.nextInt();
        if (data == -1) return null;

        parent = new TreeNode(data);

        System.out.println("enter the left child for : " + data);
        parent.left = createBST();

        System.out.println("enter the right child for : " + data);
        parent.right = createBST();

        return parent;
    }

    static void inOrder(TreeNode node) {
        if (node == null) return;
        //lnr
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    static void preOrder(TreeNode node) {
        if (node == null) return;
        //nlr
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(TreeNode root) {
        if (root == null) return;
        //lrn

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

}

class TreeNode {
   TreeNode left;
   TreeNode right;

    int data;

    TreeNode(int data) {
        this.data = data;
    }


    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
