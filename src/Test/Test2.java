/*
*
* Given an n-ary tree, return its level order traversal.
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
* */
package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test2 {

    public static void main(String[] args) {
        NAryTree root = new NAryTree(8);
        NAryTree child1 = new NAryTree(5);
        NAryTree child2 = new NAryTree(6);
        NAryTree child3 = new NAryTree(7);
        NAryTree child4 = new NAryTree(1);
        NAryTree child5 = new NAryTree(2);
        NAryTree child6 = new NAryTree(3);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        child1.children.add(child4);
        child2.children.add(child5);
        child3.children.add(child6);
        System.out.println(nAryTree(root));
    }

    public static ArrayList<ArrayList<Integer>> nAryTree(NAryTree root) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList;
        }

        Queue<NAryTree> queue = new LinkedList<NAryTree>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NAryTree currentNode = queue.poll();
                arrayList2.add(currentNode.val);
                if (currentNode!=null){
                    for (NAryTree nAryTreeChild : currentNode.children) {
                        queue.add(nAryTreeChild);
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

    NAryTree(int val){
        this.val = val;
        children = new ArrayList<NAryTree>();
    }
}
