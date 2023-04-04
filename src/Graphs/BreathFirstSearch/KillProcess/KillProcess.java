/*
*
* Reap Children
Breadth-first Search
Easy
You are given two lists of integers and an integer representing a process id to kill.
* One of the lists represents a list of process ids and the other represents a list of each of the processes’
* corresponding (by index) parent ids. When a process is killed, all of its children should also be killed.
* Return a list of all the process ids that are killed as a result of killing the requested process.

Ex: Given the following…

pid =  [2, 4, 3, 7]
ppid = [0, 2, 2, 3]
kill = 3
the tree of processes can be represented as follows:
           2
         /   \
        4     3
             /
            7
return [3, 7] as killing process 3 will also require killing its child (i.e. process 7).

*
* */
/*
*
* Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes.
* This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains
* PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs
* of processes that will be killed in the end. You should assume that when a process is killed,
* all its children processes will be killed. No order is required for the final answer.

Example 1:

Input:
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation:
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.
* */

package Graphs.BreathFirstSearch.KillProcess;

import java.util.*;

public class KillProcess {

    static TreeNode root;

    public static void main(String[] args) {

        int[] pPId = new int[]{3, 0, 05, 3, 1, 1,1};
        int[] pId  = new int[] {1, 3, 10, 5, 9, 99,2};
        int kill = 5;

        HashMap<Integer,ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < pId.length; i++) {
            int parent = pPId[i];
            int child = pId[i];
            ArrayList<Integer> al;

            if (hashMap.containsKey(parent)){
                //bring the parent list into the picture and add it.
                al = hashMap.get(parent);
            }
            else {
                al = new ArrayList<>();
                hashMap.put(parent,al);
            }
            al.add(child);
        }
        bfsProcessKill(hashMap, kill);
    }

    public static ArrayList<Integer> bfsProcessKill(HashMap<Integer, ArrayList<Integer>> hashMap, int kill) {
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Integer> killedProcessesList = new ArrayList<>();
        if (hashMap.isEmpty()) {
            return killedProcessesList;
        }
        System.out.println(hashMap);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
            keys.add(entry.getKey());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(keys.get(0));

        int i = 1;
        while (!queue.isEmpty() & i < keys.size()) {
            int currentKey = queue.poll();
            if (hashMap.containsKey(currentKey)){
                System.out.println("here "+hashMap.get(currentKey));
                if (hashMap.get(currentKey).contains(kill))
                {
                    killedProcessesList.add(kill);
                }
                if (hashMap.keySet().contains(kill)){
                    for (int child : hashMap.get(kill)){
                        killedProcessesList.add(child);
                    }
                }
            }
            else {
                System.out.println("not found");
            }
            queue.add(keys.get(i++));
        }
        System.out.println(killedProcessesList);
        return killedProcessesList;
    }


    public static ArrayList<Integer> bfsKillProcess(TreeNode root, int killPId) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    if (currentNode.left.val == killPId) {
                        System.out.println(currentNode.val);
                        arrayList.add(currentNode.val);
                        System.out.println(currentNode.left.val);
                        arrayList.add(currentNode.left.val);
                    }
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                    if (currentNode.right.val == killPId) {
                        arrayList.add(currentNode.val);
                        arrayList.add(currentNode.right.val);
                    }
                }
            }
        }
        System.out.println(arrayList);
        return arrayList;
    }

    public static void createTree(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            System.out.println("root "+root.val);
        } else {
            TreeNode focusNode = root;
            TreeNode parent;

            while (true) {
                parent = focusNode;
                if (val < focusNode.val) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        System.out.println("left "+newNode.val);
                        break;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        System.out.println("right "+newNode.val);
                        break;
                    }
                }
            }
        }
    }

    //node left right
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
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
