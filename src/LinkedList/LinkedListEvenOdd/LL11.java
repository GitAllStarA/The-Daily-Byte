package LinkedList.LinkedListEvenOdd;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LL11 {

    ListNode head;
    ListNode tail;

    public void insertFisrt(int val) {
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

    public void insertEnd(int data){
        ListNode node = new ListNode(data);
        if (tail!=null){
            tail.next = node;
            tail = node;
        } else {
            insertFisrt(data);
        }
    }

    public ListNode LinkedListOddNEven(ListNode list) {
        ListNode temp = list;

        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();

        while (temp != null) {
            if (temp.val % 2 == 0) {
                even.add(temp.val);
            } else {
                odd.add(temp.val);
            }
            temp = temp.next;
        }

        ListNode dummy = null;

        ListNode newTemp = dummy;

        System.out.println(even);

        System.out.println(odd);
        int count=0;
        while (!even.empty()) {
            int evenNum = even.pop();
            ListNode evenHead = new ListNode(evenNum);
            count++;
            if (newTemp == null){
                evenHead.next = newTemp;
                newTemp = evenHead;
            }
            else {
                evenHead.next = newTemp;
                newTemp = evenHead;
            }
        }
        while (!odd.empty()) {
            int oddNum = odd.pop();
            ListNode oddHead = new ListNode(oddNum);
            count++;
            oddHead.next = newTemp;
            newTemp = oddHead;
        }

        while (newTemp!=null){
            System.out.print(newTemp.val+"->");
            newTemp = newTemp.next;
        }
        System.out.print("end");



        return newTemp;
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
