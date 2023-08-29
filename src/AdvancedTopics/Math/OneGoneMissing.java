package AdvancedTopics.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
* One Gone Missing
Math
Medium
This question is asked by Amazon. Given an array that contains all distinct values from zero through N except one number,
*  return the number that is missing from the array.

Ex: Given the following array nums…

nums = [1, 4, 2, 0], return 3.
3 is the only number missing in the array between 0 and 4.
Ex: Given the following array nums…

nums = [6, 3, 1, 2, 0, 5], return 4.
4 is the only number missing in the array between 0 and 6.
*/
public class OneGoneMissing {
    public static void main(String[] args) {
        int[] n = {1,4,2,0};
        System.out.println(returnMissingNumber(n));
        System.out.println(returnMissingNumber2(n));
    }

    static int returnMissingNumber(int[] n) {
       HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n.length; i++) {
            hashSet.add(n[i]);
        }

        for (int i = 0; i < n.length; i++) {
            if(!hashSet.contains(i)){
                return i;
            }
        }
        return -1;
    }
    static int returnMissingNumber2(int[] n) {
        int arraySum = 0;
        for (int i = 0; i < n.length; i++) {
            arraySum +=n[i];
        }


        return (n.length*(n.length+1)/2)-arraySum;
    }
}
