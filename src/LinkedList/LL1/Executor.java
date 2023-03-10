package LinkedList.LL1;

import LinkedList.LL1.LL;

public class Executor {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtFirst(4);
        list.insertAtFirst(5);
        list.insertAtFirst(10);
        list.insertAtFirst(133);
       // list.insetAtLast(16);
        list.insert(1000,4);
        list.display();
        //System.out.println(list.deleteFirst());
        System.out.println(list.deteleEnd());
        System.out.println(list.deleteAtIndex(3));
        System.out.println(list.deleteAtIndex2(1));
        System.out.println(list.find(5));
        list.display();
    }
}
