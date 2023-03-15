/*
*
* List Sum
Linked Lists
Easy
Given two linked lists that represent two numbers, return the sum of the numbers also represented as a list.

Ex: Given the two linked lists…

a = 1->2, b = 1->3, return a list that looks as follows: 2->5
Ex: Given the two linked lists…

a = 1->9, b = 1, return a list that looks as follows: 2->0
* */

package LinkedList.ListSum;

public class ListSum {
    public static void main(String[] args) {
        LL9 list1 = new LL9();
        list1.insertFirst(2);
        list1.insertFirst(4);
        LL9 list2 = new LL9();
        list2.insertFirst(111);
       // list2.insertFirst(2);


        LL9 ans = new LL9();
        ans.addLists(list1.head, list2.head);
    }

}
