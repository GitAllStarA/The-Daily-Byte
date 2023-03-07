package LinkedList;

public class Executor2 {

    public static void main(String[] args) {
        LL2 list = new LL2();

        //insert first
        list.insertFirst(10);
        list.insertFirst(11);
        list.insertFirst(13);
        list.insertFirst(14);

        //insert last
        list.insertLast(30);
        list.insertLast(35);

        //insert at index
        list.insert(100,3);
        System.out.println("deleted first node in linkedlist -> "+list.deleteFirst());
        list.display();

        System.out.println();
        System.out.println("deleted last node in linkedlist -> "+list.deleteLast());

        list.display();
        System.out.println();
        System.out.println("the deleted value at given index -> "+list.deleteAtIndex(3));


        list.display();System.out.println();
        System.out.println("size "+list.size);

        list.display();
        System.out.println();
        System.out.println(list.find(30));

    }
}
