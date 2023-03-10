/*
* Find Middle Element
Linked Lists
Easy
This question is asked by Amazon. Given a non-empty linked list,
*  return the middle node of the list.
* If the linked list contains an even number of elements, return the node closer to the end.
Ex: Given the following linked lists...

1->2->3->null, return 2
1->2->3->4->null, return 3
1->null, return 1
See Solution
*
* */

package LinkedList.MiddleElement;

public class Solution {

    public static void main(String[] args) {
        LL4 list = new LL4();

        //insert first
        list.insertAtFirst(5);
        list.insertAtFirst(4);
        list.insertAtFirst(3);
        list.insertAtFirst(2);
        list.insertAtFirst(1);
        list.display();
        System.out.println();
        list.findMiddleElement();



    }
}
