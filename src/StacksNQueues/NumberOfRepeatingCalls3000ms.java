/*
*
* This question is asked by Google. Create a class CallCounter that tracks the number of calls a client has made within the last 3 seconds.
*  Your class should contain one method, ping(int t) that receives the current timestamp (in milliseconds) of a new call being made and returns the number
* of calls made within the last 3 seconds.
Note: you may assume that the time associated with each subsequent call to ping is strictly increasing.

Ex: Given the following calls to ping…

ping(1), return 1 (1 call within the last 3 seconds)
ping(300), return 2 (2 calls within the last 3 seconds)
ping(3000), return 3 (3 calls within the last 3 seconds)
ping(3002), return 3 (3 calls within the last 3 seconds)
ping(7000), return 1 (1 call within the last 3 seconds)
*
* */

package StacksNQueues;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRepeatingCalls3000ms {
    private Queue<Integer> queue;

    NumberOfRepeatingCalls3000ms() {
        queue = new LinkedList<>();
    }

    int ping(int t) {
        queue.offer(t);
        while (queue.peek()< t-3000){
            //if the elements in the queue are not under the range of t-3000, they are removed from queue;
            queue.poll();
        }
        System.out.println("range : "+(t-3000)+", "+t);
        System.out.println(queue+" , size : "+queue.size());
        return queue.size();
    }

    public static void main(String[] args) {
        NumberOfRepeatingCalls3000ms nrc = new NumberOfRepeatingCalls3000ms();
        System.out.println(nrc.toString());

        nrc.ping(1);
        nrc.ping(100);
        nrc.ping(3000);
        nrc.ping(4000);
        nrc.ping(10000);
    }

}
