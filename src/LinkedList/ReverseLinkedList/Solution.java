package LinkedList.ReverseLinkedList;

public class Solution {
    public static void main(String[] args) {
        LL7 list = new LL7();
        list.insertFirst(6);
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
        list.reverse();
        list.display();
        list.reverse2LC();
        list.display();
    }
}
