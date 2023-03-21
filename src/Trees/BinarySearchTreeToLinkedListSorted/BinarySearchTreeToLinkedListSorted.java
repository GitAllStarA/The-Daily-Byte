package Trees.BinarySearchTreeToLinkedListSorted;

public class BinarySearchTreeToLinkedListSorted {

    private static ListNode head;
    //ListNode tail;

    private static TreeNode root; //or parent;

    public static void main(String[] args)
    {
        int[] array = new int[]{5,2,1,3,9};

        for (int x : array)
        {
            createTreeNode(x);
        }
        System.out.println();
        // inOrder traversal of binarySearchTree
        inOrder(root);
        System.out.println();

    }

    static void createTreeNode(int val)
    {
        TreeNode newNode = new TreeNode(val);
        if (root ==null)
        {
            root = newNode;
        }

        else
        {
            TreeNode focusNode = root;
            TreeNode parent;

            while (true)
            {
                parent = focusNode;

                if (val < focusNode.val)
                {
                    focusNode = focusNode.left;
                    if (focusNode == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                }
                else
                {
                    focusNode = focusNode.right;
                    if (focusNode == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }


    static void inOrder(TreeNode root){
        if (root == null)
        {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);

    }

}


class TreeNode
{

    TreeNode left;
    TreeNode right;

    int val;

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

class ListNode
{

    ListNode next;
    int val;

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(ListNode next, int val)
    {
        this.val = val;
        this.next = next;
    }
}