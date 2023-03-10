/*
*
* Merge Linked Lists
Linked Lists
Medium
This question is asked by Apple. Given two sorted linked lists,
* merge them together in ascending order and return a reference to the merged list

Ex: Given the following lists...

list1 = 1->2->3, list2 = 4->5->6->null, return 1->2->3->4->5->6->null
list1 = 1->3->5, list2 = 2->4->6->null, return 1->2->3->4->5->6->null
list1 = 4->4->7, list2 = 1->5->6->null, return 1->4->4->5->6->7->null

*
* */

package LinkedList.MergeLinkedList;

import LinkedList.ReverseLinkedList.LL7;

import java.util.List;

public class LL8 {


    ListNode head;
    ListNode tail;

    public void insertFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = head;
        }

    }

    public void insertLast(int val) {
        ListNode newNode = new ListNode(val);
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            insertFirst(val);
        }

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


    public void last(int data) {
        ListNode ddd = new ListNode(data);
        if (tail != null) {
            ddd.next = tail;
            tail = ddd;
        } else {
            first(data);
        }
    }

    public void first(int data) {
        ListNode aaa = new ListNode(data);
        aaa.next = head;
        head = aaa;
        if (tail == null) {
            tail = aaa;
        }
        //head=aaa;
    }


    //adding list to another list

    public void list1(ListNode list1){
        ListNode head = new ListNode(0);
        ListNode temp = head;

        /*while (list1!=null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }*/

        temp.next = list1;

        while (head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.print("end");
    }


    public ListNode mergeKN(ListNode list1, ListNode list2) {

        ListNode l1 = list1;
        ListNode l2 = list2;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
            if (l1!=null){
                temp.next = l1;
            }
            if (l2!=null){
                temp.next = l2;
            }

        while(dummy!=null){
            System.out.print(dummy.val+"->");
            dummy=dummy.next;
        }
        System.out.print("end");
        return dummy.next;
    }


    //not working properly
    public LL8 Merge(ListNode l1, ListNode l2) {

        ListNode f = l1;
        ListNode s = l2;
        LL8 ans = new LL8();

        ListNode x = ans.head;

        ListNode dummy = new ListNode(0);

        while (f != null && s != null) {
            if (f.val < s.val) {
                if (x == null) {
                    f.next = x;
                    x = f;
                    if (ans.tail == null) {
                        ans.tail = x;
                    }
                } else {
                    ans.tail.next = x;
                    ans.tail = x;
                }
                f = f.next;
            } else {
                if (x == null) {
                    s.next = x;
                    x = s;
                    if (ans.tail == null) {
                        ans.tail = x;
                    } else {
                        ans.tail.next = x;
                        ans.tail = x;

                    }
                    s = s.next;
                }
            }
            x = x.next;
            if (f != null) {
                x.next = f;
                // f=f.next;
            }
            if (s != null) {
                x.next = s;
                // s = s.next;
            }
        }

        while (x != null) {
            System.out.print(x.val + ">");
            x = x.next;
        }


        return ans;

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

