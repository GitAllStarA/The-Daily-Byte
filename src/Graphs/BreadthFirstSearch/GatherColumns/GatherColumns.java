/*
*
* Given a binary tree, return its column order traversal from top to bottom and left to right.
*  Note: if two nodes are in the same row and column, order them from left to right.

Ex: Given the following tree…

    8
   / \
  2   29
     /  \
    3    9
return [[2], [8, 3], [29], [9]]
Ex: Given the following tree…

     100
    /   \
  53     78
 / \    /  \
32  3  9    20
return [[32], [53], [100, 3, 9], [78], [20]]
*
* */


package Graphs.BreadthFirstSearch.GatherColumns;

import java.util.*;

public class GatherColumns {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(29);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println(verticalOrderTraversal(root));

    }


    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> hashMap = new TreeMap<>();
        queue.add(root);
        //int key = 0;
        ArrayList<Integer> initial = new ArrayList<>();
        initial.add(root.val);
        hashMap.put(0, initial);
        System.out.println("o" + hashMap);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> cc;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                System.out.println("current node val : " + currentNode.val);
                if (currentNode.left != null) {
                    int currentNodeLevelKey = 0;
                    for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
                        ArrayList<Integer> list = entry.getValue();
                        if (list.contains(currentNode.val)) {
                            currentNodeLevelKey = entry.getKey();
                        }

                    }
                    currentNodeLevelKey = currentNodeLevelKey - 1;
                    if (hashMap.containsKey(currentNodeLevelKey)) {
                        cc = hashMap.get(currentNodeLevelKey);
                        cc.add(currentNode.left.val);
                        hashMap.put(currentNodeLevelKey, cc);
                    } else {
                        ArrayList arrayList1 = new ArrayList();
                        arrayList1.add(currentNode.left.val);
                        hashMap.put(currentNodeLevelKey, arrayList1);
                    }
                }
                if (currentNode.right != null) {
                    int currentNodeLevelKey = 0;
                    for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
                        ArrayList<Integer> list = entry.getValue();
                        if (list.contains(currentNode.val)) {
                            currentNodeLevelKey = entry.getKey();
                        }

                    }
                    currentNodeLevelKey = currentNodeLevelKey + 1;
                    if (hashMap.containsKey(currentNodeLevelKey)) {
                        cc = hashMap.get(currentNodeLevelKey);
                        cc.add(currentNode.right.val);
                        hashMap.put(currentNodeLevelKey, cc);
                    } else {
                        ArrayList arrayList1 = new ArrayList();
                        arrayList1.add(currentNode.right.val);
                        hashMap.put(currentNodeLevelKey, arrayList1);
                    }
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);

                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        System.out.println(hashMap);
        for (ArrayList<Integer> x : hashMap.values()) {
            if (x.size() > 1) {
                int rootVal = x.remove(0);
                x.sort((o1, o2) -> o1 - o2);
                x.add(0, rootVal);
            }
            arrayList.add(x);
        }

        return arrayList;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
