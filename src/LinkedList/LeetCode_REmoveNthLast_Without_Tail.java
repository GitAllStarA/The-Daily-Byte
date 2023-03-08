package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode_REmoveNthLast {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
       list.insertFirst(5);
     list.insertFirst(4);
     list.insertFirst(3);
     list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(1);
        list.displayResults();

        list.removeNthFromEnd(list.head, 1);
        list.displayResults();
    }

}

class LinkedList {
    ListNode head;
    ListNode tail;


    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        //  size++;
    }

    public void displayResults() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("end");
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sizeOflIst = 0;
        ListNode len = head;
        while (len != null) {
            sizeOflIst++;
            len = len.next;
        }
        System.out.println("the size "+sizeOflIst+"-"+n);


        //remove first
        if (sizeOflIst - n <= 0) {
            ListNode temp = head;
            ListNode removedNode = temp;
            head = head.next.next;
            sizeOflIst--;
            return head;
            //retun removedNode;
        }

        //remove last

            ListNode temp = head;
            int index = sizeOflIst - n;


            ListNode deleteNode = head;
            for (int i = 0; i < index; i++) {
                deleteNode = deleteNode.next;
            }

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            temp.next = deleteNode.next;


            sizeOflIst--;
            return deleteNode;


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