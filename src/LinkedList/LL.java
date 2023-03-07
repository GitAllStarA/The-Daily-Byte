package LinkedList;

public class LL {


    Node head;
    Node tail;

    int size;


 /*   private LL() {
        this.size = 0;
    }*/

    public void insertAtFirst(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;


        if (tail == null){
            head = tail;
        }
    }


    public void display() {
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data+" -> ");
            temp = temp.next;
        }
    }

    class Node {

        int data;
        Node next;



        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next){
            this.data = data;
            this.next =  next;
        }


    }

}
