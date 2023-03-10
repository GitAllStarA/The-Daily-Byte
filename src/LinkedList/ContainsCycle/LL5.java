/*
* This question is asked by Microsoft. Given a linked list, containing unique numbers, return whether or not it has a cycle.
Note: a cycle is a circular arrangement (i.e. one node points back to a previous node)

Ex: Given the following linked lists...

1->2->3->1 -> true (3 points back to 1)
1->2->3 -> false
1->1 true (1 points to itself)

*
* */


package LinkedList.ContainsCycle;

import java.util.List;

public class LL5 {
    ListNode head;
    ListNode tail;

    int size;

    LL5() {
        size = 0;
    }

    public void inserAtFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void display() {
        ListNode travelNode = head;
        while (travelNode != null) {
            System.out.print(travelNode.val + " -> ");
            travelNode = travelNode.next;
        }
        System.out.print("end");
    }




    public boolean hasCycle() {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycleNW() {

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }

        return false;
    }


    public void createCycle(){

        if(tail!=null){
            ListNode temp = head;
            int count = 0;
            while (temp!=null){
                count++;
                temp =temp.next;
            }

            ListNode loopPoint = head;
            for (int i = 0; i < count/2; i++) {
                loopPoint = loopPoint.next;
                tail.next = loopPoint;
            }

        }

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
