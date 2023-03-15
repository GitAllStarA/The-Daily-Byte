/*232. Implement Queue using Stacks
Easy
5.8K
340
Companies
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false


Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.


Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

*/

package StacksNQueues;


import java.util.Stack;

public class ImplementQueueUsingStacks {


    private Stack<Integer> stack;
    private Stack<Integer> stack2;

    public ImplementQueueUsingStacks() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }


    public void push(int x) {
        stack.push(x);
        System.out.println("stack1 :" + stack);

    }


    public void implQueue() {
        int i = stack.size()-1;
        System.out.println("size "+i);
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        System.out.println("stack2 :" + stack2);
    }

    public int pop() {

        if (stack2.isEmpty()){
            implQueue();
        }

        return stack2.pop();
    }

    public int peek() {
      if (stack2.isEmpty()){
          implQueue();
      }
      return stack2.peek();

    }

    public boolean empty() {
        return stack2.empty() ? true : false;
    }


    public static void main(String[] args) {
        //["MyQueue","push = 1","push = 2","peek","pop","empty"]
        ImplementQueueUsingStacks s = new ImplementQueueUsingStacks();
        s.push(1);
        s.push(2);
        System.out.println(s.stack);
        System.out.println("stack2 : "+s.stack2);
       System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.empty());


        Stack<Integer>s4 = new Stack<>();
        s4.push(1);
        s4.push(100);


        for (int i = s4.size()-1; i >=0 ; i--) {
            //System.out.println(s4.get(i));
        }
    }
}



