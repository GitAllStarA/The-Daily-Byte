/*
* Remove Nth to Last Node
Linked Lists
Medium
This question is asked by Facebook. Given a linked list and a value n, remove the nth to last node and return the resulting list.

Ex: Given the following linked lists...

1->2->3->null, n = 1, return 1->2->null
1->2->3->null, n = 2, return 1->3->null
1->2->3->null, n = 3, return 2->3->null
See Solution
*
* */


package LinkedList;

public class RemoveNthLastNodes {


    public static void main(String[] args) {
        LL3 list = new LL3();
        list.insertFirst(6);
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        //list.deleteAtNthPlaceFromLast(3);
        System.out.println("the size : " + list.sizeOfList());
        list.displayResults();

    }


}

class LL3 {
    Node head;
    Node tail;

    int size;

    LL3() {
        size = 0;
    }


    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void displayResults() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("end");
    }


    public Node indexLL(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            //System.out.println("->"+temp.data);
            temp = temp.next;
            //System.out.println(temp.data);

        }
        return temp;
    }

    public int deleteAtNthPlaceFromLast(int n) {
        if (n == size) {
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        if (n == 1) {
            Node prevNode = indexLL(size - n - 1);
            int val = tail.data;
            tail = prevNode;
            tail.next = null;
            size--;
            return val;
        }

        if (n > 1) {
            Node temp = head;
            int travel = size - n;
            Node currentNode = indexLL(travel);

            for (int i = 0; i < travel - 1; i++) {
                temp = temp.next;
            }
            temp.next = currentNode.next;
            int val = currentNode.data;
            return val;

        }
        return -1;
    }


    public int sizeOfList() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;

    }

    class Node {
        int data;
        Node next;


        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}