/*List Sum
Linked Lists
Easy
Given two linked lists that represent two numbers, return the sum of the numbers also represented as a list.

Ex: Given the two linked lists…

a = 1->2, b = 1->3, return a list that looks as follows: 2->5
Ex: Given the two linked lists…

a = 1->9, b = 1, return a list that looks as follows: 2->0
*
*
* */

package LinkedList.ListSum;

import java.awt.*;

public class LL9 {
    ListNode head;
    ListNode tail;

    public void insertFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public void display() {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("end");
        System.out.println();
        System.out.println("size " + count);
    }


    public void addLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode travelNode = head;

        while (list1 != null && list2 != null) {
            int sum = list1.val +list2.val;
            ListNode sumNode = new ListNode(sum);
            travelNode.next = sumNode;
            list1=list1.next;
            list2=list2.next;
            travelNode = travelNode.next;
        }

        if (list1!=null && list2==null){
            ListNode sumNode = new ListNode(0);
            travelNode.next = sumNode;
        }

        if (list2!=null && list1==null){
            ListNode sumNode = new ListNode(0);
            travelNode.next = sumNode;
        }

        head = head.next;

        while (head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print("end");
    }

    class ListNode {
        int val;
        ListNode next;


        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
