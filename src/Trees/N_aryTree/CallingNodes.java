package Trees.N_aryTree;

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

        Node root = new Node(1);
        Node child1 = new Node(3);
        Node child2 = new Node(2);
        Node child3 = new Node(4);
        Node child4 = new Node(5);
        Node child5 = new Node(6);


        // root.children.add(child1);
        // root.children.add(child2);
        // root.children.add(child3);
        // child1.children.add(child4);
        // child1.children.add(child5);


        // work on it


        System.out.println(printX(100));

    }

    public static int printX(int x) {

        if (x == 0)
            return 0;

        System.out.println(x);
        printX(x - 1);

        return 0;
    }


    public void traverse(Node root) {
        String s = "";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i) + " ";
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


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
