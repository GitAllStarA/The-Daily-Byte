package Trees.N_aryTree;

import java.util.ArrayList;
import java.util.List;

public class CallingNodes {
    public static void main(String[] args) {

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.mid = new TreeNode(3);
        root.right = new TreeNode(4);

        root.left.left  = new TreeNode(6);
        root.left.mid = new TreeNode(7);
        root.left.right = new TreeNode(8);

        root.mid.left = new TreeNode(9);
        root.mid.mid = new TreeNode(10);
        root.mid.right = new TreeNode(11);

        root.right.left = new TreeNode(12);
        root.right.mid = new TreeNode(13);
        root.right.right = new TreeNode(14);

        postOrderN_AryTree(root);*/

        Node<Integer> root = new Node(1);
        Node<Integer> child1 = new Node(3);
        Node<Integer> child2 = new Node(2);
        Node<Integer> child3 = new Node(4);
        Node<Integer> child4 = new Node(5);
        Node<Integer> child5 = new Node(6);

         root.children.add(child1);
         root.children.add(child2);
         root.children.add(child3);
         child1.children.add(child4);
         child1.children.add(child5);
        // work on it
        traverse(root);

    }

    public static void traverse(Node<Integer> root) {
        String s = root.val+" = ";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).val + ", ";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            traverse(root.children.get(i));
        }
    }

    /*static void postOrderN_AryTree(TreeNode root){
        if (root == null)
            return;

        postOrderN_AryTree(root.left);
        postOrderN_AryTree(root.mid);
        postOrderN_AryTree(root.right);
        System.out.print(root.val+" ");
    }*/
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode mid;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode mid, TreeNode right) {
        this.val = val;
        this.left = left;
        this.mid = mid;
        ;
        this.right = right;
    }
}


class Node<T>{
    public T val;
    public List<Node<T>> children;



    public Node(T _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(T _val, List<Node<T>> _children) {
        val = _val;
        children = _children;
    }
}
