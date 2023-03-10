/*
* Find Middle Element
Linked Lists
Easy
This question is asked by Amazon. Given a non-empty linked list,
* return the middle node of the list.
* If the linked list contains an even number of elements, return the node closer to the end.
Ex: Given the following linked lists...

1->2->3->null, return 2
1->2->3->4->null, return 3
1->null, return 1
See Solution
*
* */
package LinkedList.MiddleElement;

import java.util.List;

public class LL4 {


    ListNode head;
    ListNode tail;

    int size;

    LL4() {
        size = 0;
    }

    public void insertAtFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void display() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print("end");
    }

    public ListNode findMiddleElement() {
        ListNode temp = head;

        //getting size
        int count = 0;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }

        int mid = count/2;
        System.out.println(mid);

        ListNode midNode = head;
        for (int i = 0; i < mid; i++) {
            midNode = midNode.next;
        }
        System.out.println("the midNode value : "+midNode.val+" "+midNode.next.val);
        return midNode;


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
