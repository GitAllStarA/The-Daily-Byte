/*Add Two Numbers
Medium
24.8K
4.8K
Companies

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
* */
package LinkedList.AddTwoNumbers;


import java.util.List;
import java.util.Stack;

public class LL10 {

    ListNode head;
    ListNode tail;

    public void insertAtFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }


    public void AddLast(int val, ListNode head) {
        ListNode last = new ListNode(val);
        ListNode ta = null;
        if (ta == null) {
            ta = head;
        } else {
            ta.next = last;
            ta = last;
        }


    }

    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("end");
        System.out.println();
    }


    public ListNode AddTwoNums(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(Integer.MIN_VALUE);

        ListNode temp = head;


        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (l1 != null) {
            sb.append(l1.val + "");
            l1 = l1.next;
        }

        while (l2 != null) {
            sb2.append(l2.val + "");
            l2 = l2.next;
        }
        int x = Integer.valueOf(String.valueOf(sb.reverse()));
        int y = Integer.valueOf(String.valueOf(sb2.reverse()));

        int sum = x + y;
        //System.out.println(sum);
        String s = sum + "";

        int count = 0;
        while (sum > 0) {
            int rem = sum % 10;
            sum = sum / 10;
            count++;
            //System.out.println(rem);
            ListNode newNode = new ListNode(rem);
            temp.next = newNode;
            temp = temp.next;
        }
        ListNode xc = head.next;

        System.out.print("end");
        System.out.println();
        return xc;


    }


public ListNode AddTwoNumsNC(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        ListNode temp = head;

        int carry=0;
        while (l1!=null || l2!=null){

            int l1V = l1 == null ? 0 : l1.val;
            int l2V = l2 == null ? 0 : l2.val;

            int currentSum = l1V + l2V + carry;
            carry = currentSum/10;
            int lastDigit = currentSum%10;

            ListNode node = new ListNode(lastDigit);
            temp.next = node;

            if (l1!=null)
                l1 = l1.next;
            if (l2!=null)
                l2=l2.next;
            temp = temp.next;
        }
        if (carry>0){
            ListNode nodeCarry = new ListNode(carry);
            temp.next = nodeCarry;
            temp = temp.next;
        }
        ListNode sol = head.next;
while (sol!=null){
    System.out.print(sol.val+" -> ");
    sol = sol.next;
}
        return head.next;


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
