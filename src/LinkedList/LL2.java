package LinkedList;

public class LL2 {

    Node tail;
    Node head;
    int size;

    LL2() {
        size = 0;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("end");
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        //tail.next = null;
        size++;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
            size++;
        }
    }

    public void insert(int data, int index) {
        if (index == 0) {
            insertFirst(data);
            return;
        }
        if (index >= size) {
            insertLast(data);
            return;
        }


        Node temp = head;
        Node newNode = new Node(data);
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public int deleteLast() {
        int val = tail.value;
        if (tail!=null){

            Node secondlast = getNode(size-2);
            tail = secondlast;
            tail.next = null;
            size--;
        }
        return val;
    }

    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int deleteAtIndex(int index){
        if (index==0)
            return deleteFirst();
        if (index==size)
            return deleteLast();
        Node temp = head;
        Node current = getNode(index-1);

        int val = current.next.value;
        temp = current;
        temp.next = current.next.next;
        size--;
        return val;
    }


    public Node find(int data){
        Node temp = head;
        while (head!=null){
            if(head.value == data){
                System.out.println(head.value);
                return head;
            }
            else{
                head = head.next;
            }
        }

        return temp;
    }

    class Node {
        int value;
        Node next;


        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
