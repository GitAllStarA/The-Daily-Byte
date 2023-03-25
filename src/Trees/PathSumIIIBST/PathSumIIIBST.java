
/*
* https://leetcode.com/problems/path-sum-iii/
*
* */
package Trees.PathSumIIIBST;

import java.util.ArrayList;

public class PathSumIIIBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.left.left = new TreeNode(3);
        System.out.println(pathSum(root,8));


        int x = (int) (4 + 10l);
    }

    static long count = 0l;
    static int pathSum(TreeNode root, int sum){
         ArrayList<Integer> arrayList  =  new ArrayList<>();
        getCountsOfSum(root, sum,arrayList,0l);
        return (int) count;
    }



    static void getCountsOfSum(TreeNode root, int target,ArrayList<Integer> arrayList,long l){

        if (root == null)
            return;

        arrayList.add(root.val);
        System.out.println(arrayList);

        getCountsOfSum(root.left,target,arrayList,l);
        getCountsOfSum(root.right,target,arrayList,l);
        long temp = 0;

        for (int i = arrayList.size()-1; i >=0 ; i--) {
            temp = temp+arrayList.get(i);
            if (temp == target){
                count++;
            }
        }

        arrayList.remove(arrayList.size()-1);
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