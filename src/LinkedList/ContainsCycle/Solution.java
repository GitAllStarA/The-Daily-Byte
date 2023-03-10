/*
This question is asked by Microsoft. Given a linked list, containing unique numbers, return whether or not it has a cycle.
Note: a cycle is a circular arrangement (i.e. one node points back to a previous node)

Ex: Given the following linked lists...

1->2->3->1 -> true (3 points back to 1)
1->2->3 -> false
1->1 true (1 points to itself)

* */

package LinkedList.ContainsCycle;

public class Solution {
    public static void main(String[] args) {
        LL5 list = new LL5();

        list.inserAtFirst(6);
        list.inserAtFirst(5);
        list.inserAtFirst(1);
        list.inserAtFirst(2);
        list.inserAtFirst(1);
        list.display();
        System.out.println();
       list.createCycle();
        System.out.println(list.hasCycle()); //use this one for less confusion
        System.out.println(list.hasCycleNW());
    }

}
