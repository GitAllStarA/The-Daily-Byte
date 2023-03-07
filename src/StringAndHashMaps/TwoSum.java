package StringAndHashMaps;/*
* This question is asked by Google. Given an array of integers, return whether or not two numbers sum to a given target, k.
Note: you may not sum a number with itself.

Ex: Given the following...

[1, 3, 8, 2], k = 10, return true (8 + 2)
[3, 9, 13, 7], k = 8, return false
[4, 2, 6, 5, 2], k = 4, return true (2 + 2)
*
*
* */


public class TwoSum {
    public static void main(String[] args) {
        int[] x = new int[] {4, 2, 6, 5, 2};
        int k = 4;
        System.out.println(twoSumTarget(x,k));
    }
    public static boolean twoSumTarget(int[] x, int k){
        if (x.length == 0){
            return false;
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length; j++) {
                if (x[i]+x[j]==k) {
                    System.out.println(i + "+" + j);
                    return true;
                }
            }
        }
        return false;
    }
}
