package LinkedList.LinkedListEvenOdd;


import LinkedList.LL1.LL;

public class LinkedListOddFirstEvenLast {

    public static void main(String[] args) {
        LL11 list  = new LL11();

        list.insertFisrt(5);
        list.insertFisrt(4);
        list.insertFisrt(3);
        list.insertFisrt(2);
        list.insertFisrt(1);
        list.display();

        LL11 ans = new LL11();
        ans.LinkedListOddNEven(list.head);
    }
}
