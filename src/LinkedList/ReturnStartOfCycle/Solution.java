package LinkedList.ReturnStartOfCycle;

public class Solution {
    public static void main(String[] args) {

        LL6 list = new LL6();
//        list.insertFirst(-4);
//        list.insertFirst(0);
//        list.insertFirst(2);
//        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
        list.createLoop();
        //list.display();
        list.CycleStartsAt();

    }
}
