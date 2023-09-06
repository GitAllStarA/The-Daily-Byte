package LinkedList.RemoveValue2;

import LinkedList.RemoveValue.LL3;

public class Solution {

    Node head;
    Node tail;
    int size;

    Solution(){
        head = null;
        size=0;
    }


    public static void main(String[] args) {

        //LL3 ll3 = new LL3();

        Solution s = new Solution();
        s.insert(10);
        s.insert(20);
        s.insert(30);
        s.insert(30);
        s.insert(40);

        s.display(s.head);

        //s.insertAtLast(5);
        s.removeElement(40);
        s.display(s.head);



    }

    //try to insert
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;

    }

    public void insertAtLast(int data) {
        Node addLast = new Node(5);
        while (head.next!=null){
            head.next = addLast;
        }
    }


    public void removeElement(int data){
        Node temp = new Node(0);
        temp.next = head;

        while (temp!=null){

            if (temp == null || temp.next == null){
                return;
            }
            if (temp.next.val == data && temp.next !=null) {
                temp.next = temp.next.next;
                size--;
            }
            if(temp.val == data) {
                temp = temp.next;
                size--;
            }
            temp = temp.next;
        }
    }

    //try to display
    public void display(Node head) {
        Node temp = head;
        int index = 0;
        while (temp!=null && index< size){
            System.out.println(index +":"+temp.val);
            temp = temp.next;
            index++;
        }
        System.out.println(size);
    }

    //try to remove value from the node;
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
