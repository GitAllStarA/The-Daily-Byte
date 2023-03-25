package Trees.IdenticalTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IdenticalTrees {

    static Scanner sc;
    static ArrayList<Integer> al = new ArrayList<>();
    static ArrayList<Integer> al2 = new ArrayList<>();
    static ArrayList<Integer> x = new ArrayList<>();

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        TreeNode aTree = createTree();
        TreeNode bTree = createTree();

        al = inOrder(aTree,new ArrayList<>());
        al2 = inOrder(bTree,new ArrayList<>());

        /*TreeNode aTree = null;
        TreeNode bTree = null;
        int[] array = new int[]{2,1,3};
        int[] array2 = new int[] {2,1,3};

        for (int x : array) {
            createTreeNoRecursion(x, aTree);
        }

        for (int y : array2) {
            createTreeNoRecursion(y, bTree);
        }*/

        System.out.println(x);
        System.out.println("inorder : ");

        al = inOrder(aTree,new ArrayList<>());
        al2 = inOrder(bTree,new ArrayList<>());

        System.out.println("al  : "+al);
        System.out.println("al2 : "+al2);
        System.out.println(areIdentical(al,al2));

    }

    static TreeNode createTree()
    {
        System.out.println("enter the value");
        int data = sc.nextInt();

        if (data == -1)
        {
            return null;
        }

        TreeNode parent = new TreeNode(data);

        System.out.println("enter the data for left child of parent : "+data);
        parent.left = createTree();

        System.out.println("enter the data for right child of parent : "+data);
        parent.right = createTree();

        return parent;

    }

/*
    static void createTreeNoRecursion(int val,TreeNode root) {

        TreeNode newNode = new TreeNode(val);
        if (root == null)
        {
            root = newNode;
        }
        else {
            TreeNode focusNode = root;
            TreeNode parent;
            while (true) {
                parent = focusNode;

                if (val < focusNode.val)
                {
                    focusNode = focusNode.left;
                    if (focusNode == null)
                    {
                        parent.left = newNode;
                        x.add(newNode.val);
                        System.out.println(x);
                        return;
                    }
                }
                else
                {
                    focusNode = focusNode.right;
                    if (focusNode == null)
                    {
                        focusNode.right = newNode;
                        x.add(newNode.val);
                        System.out.println(x);
                        return;
                    }
                }
            }
        }
    }
*/


    static ArrayList<Integer> inOrder(TreeNode root,ArrayList<Integer> store)
    {
        if (root==null)
        {
            return null;
        }
        inOrder(root.left,store);
        System.out.print(root.val+" ");
        store.add(root.val);
        inOrder(root.right,store);

        return store;
    }

    static boolean areIdentical(ArrayList<Integer> a, ArrayList<Integer> b){
        return  (a.equals(b)) ? true:false;
    }

}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}