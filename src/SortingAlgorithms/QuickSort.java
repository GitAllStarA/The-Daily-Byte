package SortingAlgorithms;

import java.util.Arrays;

//qucik sort
//https://www.youtube.com/watch?v=Z8svOqamag8&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=6&ab_channel=KunalKushwaha

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{66,33,22,44,55,11};
        quickSortAlg(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSortAlg(int[] arr, int low, int high) {
        if (low >= high){
            return;
        }

        //get low and high in s and e for swapping elements
        int s = low;
        int e = high;

        //pivot can be anything i am choosing mid-index , we can also take last index element in the array
        //get mid-index for pivot
        int mid = (s + e) /2;

        //store pivot
        int pivot = arr[mid];

        //if s is less than e then only enter
        while (s<=e) {

            //if arr[s] < pivot s++
            while (arr[s] < pivot) {
                s++;
            }

            //if arr[e] > pivot e--
            while (arr[e] > pivot) {
                e--;
            }

            //if while loop condition violates
            //check if we are in the bound from s <= e
            if (s<=e){
                //if in bound perform swap
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                //add s ,  sub e
                s++;
                e--;
            }
        }

        //recursion
        // now apply function from low, e
        quickSortAlg(arr,low,e);

        //now apply function from s, high
        quickSortAlg(arr,s,high);

    }
}
