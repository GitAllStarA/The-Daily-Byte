package Trees.FindValue;

import com.sun.source.tree.Tree;

import java.util.List;
import java.util.Scanner;

public class FindValue {
    static Scanner sc;
    static TreeNode root;

    public static void main(String[] args) {

        int[] arr = new int[]{10,9,12,15,16,1,13};
        for (int x : arr){
            insertToTree(x);
        }
        System.out.println(findKey(1));
       // sc = new Scanner(System.in);


       // TreeNode parent = createBinarySearchTree();

       // findValue(parent, 1);




    }


    static TreeNode createBinarySearchTree() {
        TreeNode parent = null;
        System.out.println("enter the data : ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }

        parent = new TreeNode(data);

        System.out.println("enter the left child data for parent : " + data);
        parent.left = createBinarySearchTree();

        System.out.println("enter the right child data for parent : " + data);
        parent.right = createBinarySearchTree();

        return parent;
    }

    static void inOrderTraversal(TreeNode parent) {
        if (parent == null) return;

        inOrderTraversal(parent.left);
        System.out.print(parent.data + " ");
        inOrderTraversal(parent.right);
    }

    static void preOrderTraversal(TreeNode parent) {
        if (parent == null) return;

        System.out.print(parent.data + " ");
        inOrderTraversal(parent.left);
        inOrderTraversal(parent.right);

    }

    static void postOrderTraversal(TreeNode parent) {
        if (parent == null) return;

        inOrderTraversal(parent.left);
        inOrderTraversal(parent.right);
        System.out.print(parent.data + " ");
    }


    static TreeNode findValue(TreeNode parent, int val) {

        TreeNode resultNode = null;

        if (parent == null) {
            resultNode = parent;
            return resultNode;
        }


        findValue(parent.left, val);
        if (parent.data == val) {
            System.out.println(parent + " " + parent.data);
            resultNode = parent;

        }

        findValue(parent.right, val);
        if (parent.data == val) {
            System.out.println(parent + " " + parent.data);
            resultNode = parent;

        }

        if (resultNode != null) {
            System.out.println(resultNode.data);
        }

        return resultNode;

    }


    static void insertToTree(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null)
        {
            root = newNode;
        }

        else {
            //when root is not null
            TreeNode focusNode = root;
            TreeNode parent;

            //inifinite loop for adding elements, when node is null we return
            while (true) {

                parent = focusNode;

                if (val < focusNode.data){
                    focusNode = focusNode.left;
                    if (focusNode==null){
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode==null){
                        parent.right = newNode;
                        return;
                    }
                }

            }
        }
    }


    static TreeNode findKey(int val){
        if (root==null) return null;

        TreeNode currentNode = root;
        TreeNode parent;
        while (currentNode!=null){
            parent = currentNode;
            if (val<currentNode.data){
                currentNode=currentNode.left;
                if (val == currentNode.data){
                    System.out.println("found left of parent : "+parent.data);
                    System.out.println(currentNode.data);
                    return currentNode;
                }
            }
            else {
                currentNode=currentNode.right;
                if (val == currentNode.data) {
                    System.out.println("found right of parent : "+parent.data);
                    System.out.println(currentNode.data);
                    return currentNode;
                }
            }
        }
        System.out.println(currentNode.data);
        return currentNode;
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;

    int data;

    TreeNode(int data) {
        this.data = data;
    }
}