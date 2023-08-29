package AdvancedTopics.BrainTeaser;

import java.util.Arrays;
import java.util.Map;


public class GymLockers {
    public static void main(String[] args) {
        int n = 1000;
        //System.out.println(isOpened(n));
        System.out.println(getOpened(n));
    }

    //https://www.youtube.com/watch?v=_njfdUQJqio&ab_channel=JoshuaOlsen
    static int getOpened(int n) {
        return (int)Math.sqrt(n);
    }

    //not working brute force
    static int isOpened(int n) {

        //true = opened
        //false = closed;
        //from 1 to 1000 inclusive
        String[] locker = new String[n+1];

        // 1-indexed array
        for (int i = 1; i < locker.length; i++) {
            locker[i] = "open";
        }

        for (int i = 2; i < locker.length; i +=2) {
            //close every other element;
           // System.out.println(i);
            locker[i] = "close";
        }

        for (int i = 4; i < locker.length; i +=3) {
            //close every third element from 1 ie 4 elements and so on;
            //System.out.println(i);
            locker[i] = "close";
        }

        int count  = 0;

        for (int i = 1; i < locker.length; i++) {
            if (locker[i].equalsIgnoreCase("open")){
                count++;
            }
        }
        System.out.println(Arrays.toString(locker));
        return count;
    }



}
