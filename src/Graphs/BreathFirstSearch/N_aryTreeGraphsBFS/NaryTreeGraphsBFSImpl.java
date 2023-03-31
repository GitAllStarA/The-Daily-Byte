/*
* Gather N-ary Tree Levels
Breadth-first Search
Easy
Given an n-ary tree, return its level order traversal.
Note: an n-ary tree is a tree in which each node has no more than N children.

Ex: Give the following n-ary tree…

    8
  / | \
 2  3  29
return [[8], [2, 3, 29]]
Ex: Given the following n-ary tree…

     2
   / | \
  1  6  9
 /   |   \
8    2    2
   / | \
 19 12 90
return [[2], [1, 6, 9], [8, 2, 2], [19, 12, 90]]
*
*
* */


package Graphs.BreathFirstSearch.N_aryTreeGraphsBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeGraphsBFSImpl {

    public static void main(String[] args) {
        NAryTree root = new NAryTree(8);
        NAryTree children1 = new NAryTree(2);
        NAryTree children2 = new NAryTree(3);
        NAryTree children3 = new NAryTree(29);
        NAryTree children4 = new NAryTree(39);

        root.children.add(children1);
        root.children.add(children2);
        root.children.add(children3);
        children2.children.add(children4);
        traverse(root);

        NAryBFS(root);

    }

    public static void traverse(NAryTree root) {
        String s = root.val + " = ";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).val + " ";
        }
        System.out.println(s + " ");
        for (int i = 0; i < root.children.size(); i++) {
            traverse(root.children.get(i));
        }
    }

    public static List<List<Integer>> NAryBFS(NAryTree root) {
        List<List<Integer>> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }

        Queue<NAryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NAryTree currentNode = queue.poll();
                arrayList2.add(currentNode.val);
                if (currentNode.children!=null){
                    for (int j = 0; j < currentNode.children.size(); j++) {
                        queue.add(currentNode.children.get(j));
                    }
                }
            }
        arrayList.add(arrayList2);
        }
        System.out.println(arrayList);
        return arrayList;
    }
}


class NAryTree {
    int val;
    List<NAryTree> children;

    NAryTree(int val) {
        this.val = val;
        children = new LinkedList<>();
    }
}