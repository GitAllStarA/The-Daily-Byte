/*
* Remove Value
Linked Lists Easy
This question is asked by Google. Given a linked list and a value,
* remove all nodes containing the provided value, and return the resulting list.

Ex: Given the following linked lists and values...

1->2->3->null, value = 3, return 1->2->null
8->1->1->4->12->null, value = 1, return 8->4->12->null
7->12->2->9->null, value = 7, return 12->2->9->null

*
*
* */


package LinkedList.RemoveValue;


public class Solution {
    public static void main(String[] args) {

         LL3 list = new LL3();
        list.insertFirst(6);
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(6);
        list.insertFirst(2);
        list.insertFirst(1);
        list.displayList();
        list.removeElements(list.head,6);
        System.out.println();
        list.displayList();



        LL3 list2 = new LL3();


        list2.insertFirst(7);
        list2.insertFirst(7);
        list2.insertFirst(7);
        list2.insertFirst(7);
        list2.displayList();
        list2.removeElements(list.head,7);
        System.out.println();
        list2.displayList();
    }

}
