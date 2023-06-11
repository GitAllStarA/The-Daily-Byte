package Recursion;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = new int[]{12, 22, 13, 34, 25, 36, 27};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int target = 12;
        binayS(array, target);
        System.out.println(
                "\n"
        );
        int val = recursiveBS(array, 36, 0, array.length - 1);
        System.out.println("from recursiveBS");
        System.out.println(val);
    }

    static int binayS(int[] array, int target) {
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 0) {
            return -1;
        }

        //gather index
        int midV = array.length / 2;
        int midValue = array[midV];


        if (target < midValue) {
            for (int i = 0; i <= midV; i++) {
                if (array[i] == target) {
                    System.out.println(target + " at index " + i);
                    return array[i];
                }
            }
        }

        if (target > midValue) {
            for (int i = midV + 1; i < array.length; i++) {
                if (array[i] == target) {
                    System.out.println(target + " at index " + i);
                    return array[i];
                }
            }
        }

        return -1;
    }


    static int recursiveBS(int[] array, int target, int s, int e) {

        if (e < s){
            return -1;
        }

        if (s == e){
            return s;
        }

        int mid = s + (e - s) / 2;



        if (target > array[mid]) {
            return recursiveBS(array,target,mid+1,e);
        }

        return recursiveBS(array,target,s,mid);

    }
}
