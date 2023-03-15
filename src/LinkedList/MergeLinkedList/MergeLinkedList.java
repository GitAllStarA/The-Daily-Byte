package LinkedList.MergeLinkedList;

import java.util.List;

public class MergeLinkedList {

    public static void main(String[] args) {
        LL8 list1 = new LL8();
        list1.insertFirst(9);
        list1.insertFirst(9);
        list1.insertFirst(9);
        list1.insertFirst(6);
        list1.insertFirst(1);
        //list1.insertLast(2);
      //  list1.display();





        LL8 list2 = new LL8();
        list2.insertFirst(5);
        list2.insertFirst(3);
        list2.insertFirst(1);


        LL8 ans = new LL8();

        ans.list1(list1.head, list2.head);

        //ans.Merge(list1.head,list2.head);
       // ans.mergeKN(list1.head, list2.head );
       // ans.display();
    }
}
