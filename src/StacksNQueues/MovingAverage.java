/*Moving Average
        Stacks & Queues
        Medium
        This question is asked by Microsoft. Design a class, MovingAverage, which contains a method,
        next that is responsible for returning the moving average from a stream of integers.

        Note: a moving average is the average of a subset of data at a given point in time.

        Ex: Given the following series of events...

// i.e. the moving average has a capacity of 3.
        MovingAverage movingAverage = new MovingAverage(3);
        m.next(3) returns 3 because (3 / 1) = 3
        m.next(5) returns 4 because (3 + 5) / 2 = 4
        m.next(7) = returns 5 because (3 + 5 + 7) / 3 = 5
        m.next(6) = returns 6 because (5 + 7 + 6) / 3 = 6
        */


package StacksNQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> queue;
    int size;
    MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }



    double next(int val){
        queue.offer(val);

        double sum = 0;
        double avg = 0;
        if (queue.size() > size) {
            queue.poll();
            sum = 0;
        }
        for (int x : queue){
            sum=sum+x;
            avg = sum/queue.size();
        }

        System.out.println("avg : "+avg);
        return avg;
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(4);
        ma.next(3);

        ma.next(4);
        ma.next(5);
        ma.next(6);
        ma.next(7);
        ma.next(9);
       // ma.next(3);

    }
}
