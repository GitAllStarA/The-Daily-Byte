/*
* Remove Value
Linked Lists Easy
This question is asked by Google. Given a linked list and a value, remove all nodes containing the provided value, and return the resulting list.

Ex: Given the following linked lists and values...

1->2->3->null, value = 3, return 1->2->null
8->1->1->4->12->null, value = 1, return 8->4->12->null
7->12->2->9->null, value = 7, return 12->2->9->null

*
*
* */


package LinkedList.RemoveValue;

public class LL3 {


    ListNode head;
    ListNode tail;


    int size;

    LL3(){
        size=0;
    }



    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void displayList() {
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.print("end");
        System.out.println();
    }


    public ListNode removeElements(ListNode head,int val){

        ListNode temp = head;

        while (head!=null && head.val == val)
        {
            head = head.next;
        }

        while (temp!=null){
            if (temp.next == null){
                return head;
            }
            if (temp.next.val==val){
               // System.out.println("tmp val "+temp.val);
               // System.out.println("tmp next val "+temp.next.val);
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.next = next;
            this.val = val;
        }


    }
}
