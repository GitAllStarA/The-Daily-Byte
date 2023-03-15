/*
*
* Add Two Numbers
Medium
24.8K
4.8K
Companies
You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

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

public class AddTwoNumbers {


    public static void main(String[] args) {
        int num = 807;

        while (num>0){
            int rem = num%10;
           // System.out.println(rem);
            num = num/10;
        }


        LL10 l1 = new LL10();
        l1.insertAtFirst(1);
        l1.insertAtFirst(1);

       // l1.display(l1.head);

        LL10 l2 = new LL10();
        l2.insertAtFirst(9);
        l2.insertAtFirst(9);
        l2.insertAtFirst(9);

        LL10 ans = new LL10();
        ans.AddTwoNums(l1.head,l2.head);
        ans.AddTwoNumsNC(l1.head,l2.head);
        ans.display(ans.head);



        LL10 l3 = new LL10();

        l3.insertAtFirst(9);
        l3.insertAtFirst(9);
        l3.insertAtFirst(9);
        l3.insertAtFirst(9);
        l3.insertAtFirst(9);
        l3.insertAtFirst(9);
        l3.insertAtFirst(9);

        LL10 l33 = new LL10();
        l33.insertAtFirst(9);
        l33.insertAtFirst(9);
        l33.insertAtFirst(9);
        l33.insertAtFirst(9);

        LL10 ans3 = new LL10();
        ans3.AddTwoNums(l3.head,l33.head);


    }
}
