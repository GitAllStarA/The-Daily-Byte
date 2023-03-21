package Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseLinkedList {


    ListNode head;
    ListNode tail;


    public void addAtFirst(int val) {
        ListNode newNode = new ListNode(val);

        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }

    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("end");
        System.out.println();
    }


    public void reverse() {

        ListNode prev = null;
        ListNode current = head;
        ListNode mynext = current.next;


        /*
         * prev  current    mynext   mynext.next
         * null   10        12        13
         *      prev.next
         * */

        while (current != null) {
            current.next = prev;
            prev = current;
            current = mynext;
            if (mynext != null) {
                mynext = mynext.next;
            }
        }
        //head = prev;
        while (prev != null) {
            System.out.print(prev.val + " -> ");
            prev = prev.next;
        }
        System.out.print("end");


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;


        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
            //temp = temp.next;

        }

        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }

        dummy = dummy.next;
        head = dummy;
        while (dummy != null) {
            System.out.print(dummy.val + " -> ");
            dummy = dummy.next;
        }
        System.out.print("end");
        System.out.println();
        //return dummy.next;
        return head;

    }

    public void combineTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(Integer.MIN_VALUE);
        ListNode temp = node;


        while (l1 != null && l2 != null) {
            int currentSum = l1.val + l2.val;
            ListNode s = new ListNode(currentSum);
            temp.next = s;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;

        }


        node = node.next;
        head = node;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print("end");
        System.out.println();


    }


    class ListNode {
        int val;
        ListNode next;


        ListNode(int data) {
            this.val = data;
        }

        ListNode(int data, ListNode next) {
            this.val = data;

            this.next = next;
        }
    }


}


class Solution {
    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();


        r.addAtFirst(17);
        r.addAtFirst(16);
        r.addAtFirst(14);
        r.addAtFirst(12);
        //r.addAtFirst(11);
        r.addAtFirst(10);

        r.display();


        ReverseLinkedList r2 = new ReverseLinkedList();

        r2.addAtFirst(18);
        r2.addAtFirst(15);
        r2.addAtFirst(13);
        r2.addAtFirst(11);
        r2.addAtFirst(9);

        r2.display();

        ReverseLinkedList r3 = new ReverseLinkedList();
        r3.mergeTwoLists(r.head, r2.head);
        //  r3.display();


        ReverseLinkedList r4 = new ReverseLinkedList();
        r4.combineTwoLists(r.head, r2.head);

        r4.reverse();


    }
}