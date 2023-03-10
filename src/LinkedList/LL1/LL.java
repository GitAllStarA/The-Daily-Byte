package LinkedList.LL1;

import java.sql.SQLOutput;

public class LL {


    private Node head;
    private Node tail;

    private int size;

//     LL() {
//        this.size = 0;
//    }

    public void insertAtFirst(int data) {
        //System.out.println(data);
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }

        size++;

    }


    public void insetAtLast(int data) {
        Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            insertAtFirst(data);
        }
        size++;
    }

    public void insert(int data, int index) {
        if (index == 0) {
            insertAtFirst(data);
            return;
        }
        if (index == size) {
            insetAtLast(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data, temp.next);
        temp.next = newNode;

        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return val;
    }

    public int deteleEnd() {
        if (size <= 1)
            return deleteFirst();
        Node secondLast = getIndex(size - 2);
        System.out.println("->>>>>" + secondLast.value);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }


    //gives given index node data+ref.
    public Node getIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public int deleteAtIndex(int index) {
        if (index == 0)
            return deleteFirst();
        if (index == size - 1)
            return deteleEnd();
        Node temp = head;
        Node prevTemp = null;
        for (int i = 0; i < index; i++) {
            prevTemp = temp;
            temp = temp.next;

        }
        prevTemp.next = temp.next;
        int val = temp.value;
        return val;

    }

    public int deleteAtIndex2(int index){
        if (index == 0)
            return deleteFirst();
        if (index == size - 1)
            return deteleEnd();

        Node prev = getIndex(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public void display() {

        Node temp = head;
        // System.out.println("---->>>>>"+head.value);

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("end");
    }



    public Node find(int data){
        Node temp = head;
        while (temp!=null){
            if (temp.value == data){
                System.out.println("found "+temp.value);
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("not found "+temp.value);
        return temp;
    }


    private class Node {

        private int value;
        private Node next;


        private Node(int data) {
            this.value = data;
        }

        private Node(int data, Node next) {
            this.value = data;
            this.next = next;
        }


    }

}
