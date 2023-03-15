/*
*
* Queue Stack
Stacks & Queues
Easy
Design a class to implement a stack using only a single queue. Your class, QueueStack,
*  should support the following stack methods: push() (adding an item), pop() (removing an item),
* peek() (returning the top value without removing it), and empty() (whether or not the stack is empty).

See Solution
*
* */


package StacksNQueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    private Deque<Integer> queue;

    ImplementStackUsingQueue() {
        queue = new LinkedList<>();
    }

    void push(int val) {
        queue.offer(val);
    }

    void display() {
        System.out.println(queue);
    }

    int pop() {
       return queue.pollLast();
    }

    int peek() {
        return queue.peekLast();
    }

    boolean empty() {
        return queue.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        ImplementStackUsingQueue isq = new ImplementStackUsingQueue();
        //fifo
        isq.push(1);
        isq.push(2);
        isq.push(3);
        isq.push(4);
        isq.push(5);
        isq.display();
        System.out.println("pop "+isq.pop());
        isq.display();
        System.out.println("peek "+isq.peek());
        System.out.println("is empty : "+isq.empty());
    }

}
