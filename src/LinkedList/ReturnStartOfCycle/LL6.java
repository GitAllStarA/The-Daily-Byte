package LinkedList.ReturnStartOfCycle;

import java.util.List;

public class LL6 {

    ListNode head;
    ListNode tail;


    int size;

    LL6() {
        size = 0;
    }


    public void insertFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }

        size++;
    }


    public void display() {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            count++;
            temp = temp.next;
        }
        System.out.print("end");
        System.out.println();
        System.out.println("size: " + count);
    }

    public void createLoop() {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        ListNode travelNode = head;
        for (int i = 0; i < 0; i++) {
            travelNode = travelNode.next;
        }
        tail.next = travelNode;
    }

    public ListNode CycleStartsAt(){
//        if (head == null || head.next == null)
//            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println(fast.val +"||"+ slow.val);
                break;
            }
        }

        // checking for the condition if while came out becuse fast or fast.next is null
        if (fast == null || fast.next == null) {
            System.out.println("came out of while loop becuase the fast or fast.next is null and also there is no cycle");
            return null;
        }


        slow = head;
        while (fast!=slow){
            slow  = slow.next;
            fast = fast.next;
            if (fast == slow)
                System.out.println("fast is" +slow.val);
                return fast;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
