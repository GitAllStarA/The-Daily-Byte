package Graphs.DepthFirstSearch.RootToLeafPathSum;

import java.util.ArrayList;

public class RootToLeafPathSum {

    public static void main(String[] args) {
        TreeNode top = new TreeNode(1);
        top.left = new TreeNode(5);
        top.left.left = new TreeNode(1);
        top.right = new TreeNode(2);
        top.right.left = new TreeNode(12);
        top.right.right = new TreeNode(29);
        int target = 15;
        System.out.println(pathSumDFS(top,target));
    }


    public static ArrayList<String> pathSumDFS(TreeNode node,int target){
        ArrayList<String> arrayList = new ArrayList<>();
        int currentSum = 0;
        if (node == null){
            return arrayList;
        }

        helper(node, arrayList, currentSum,"",target);
        return arrayList;
    }

    public static ArrayList<String> helper(TreeNode node, ArrayList<String> arrayList, int currentSum,String curret,int target) {

        if (node.left == null && node.right == null) {
            currentSum = currentSum +  node.val;
            curret =  curret + node.val;
            arrayList.add(curret);
            if (currentSum == target){
                System.out.println(currentSum);
                System.out.println(arrayList);
                return arrayList;
            }
        }
        if (node.left!=null){
            helper(node.left, arrayList, currentSum+node.val,curret + node.val+"->",target);
        }
        if (node.right!=null){
            helper(node.right,arrayList,currentSum+node.val,curret+node.val+"->",target);
        }
    return null;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;

    int val;

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}