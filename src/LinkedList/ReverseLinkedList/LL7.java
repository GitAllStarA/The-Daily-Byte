/*
*
* Reverse List
Linked Lists
Easy
This question is asked by Facebook. Given a linked list, containing unique values, reverse it, and return the result.

Ex: Given the following linked lists...

1->2->3->null, return a reference to the node that contains 3 which points to a list that looks like the following: 3->2->1->null
7->15->9->2->null, return a reference to the node that contains 2 which points to a list that looks like the following: 2->9->15->7->null
1->null, return a reference to the node that contains 1 which points to a list that looks like the following: 1->null

*
* */


package LinkedList.ReverseLinkedList;

import LinkedList.ReturnStartOfCycle.LL6;

public class LL7 {


    ListNode head;
    ListNode tail;


    int size;

    LL7() {
        size = 0;
    }


    public void insertFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        size++;
    }


    public void display() {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            count++;
            temp = temp.next;
        }
        System.out.print("end");
        System.out.println();
        System.out.println("size: " + count);
    }


    public void reverse(){
      ListNode previous = null;
      ListNode current = head;

      while(current!=null){
          ListNode temp = current.next;
          current.next = previous;
          previous = current;
          current = temp;
      }

      head = previous;
    }



    public ListNode reverse2LC() {
        ListNode current = head;
        ListNode prev= null;


        ListNode iterate = head;
        int count=0;
        while (iterate!=null){
            count++;
            iterate=iterate.next;
        }


        if (count<1){
            return head;
        }

        ListNode temp = current.next;

        while (current!=null){
            current.next = prev;
            prev = current;
            current = temp;
            if (temp!=null){
                temp=temp.next;
            }
        }
        head = prev;
        return head;
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
