package SortingAlgorithms;

import java.util.Arrays;
//in the selection sort we will find the minim element from the array and place in the first index and secoond minimun is placed in the second index
// https://www.geeksforgeeks.org/selection-sort/#
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {4,-1,-2};
        int[] array2 = {4,3,2,8,1};
        int[] array3 = {2,0,2,1,1,0};
       // selectionSortAlg(array);
        //System.out.println("-> "+Arrays.toString(array));
        System.out.println("==with Recursion==");
       // selectionSortAlgRecursion(array3,0);
        //System.out.println(Arrays.toString(array3));

        System.out.println("find least value");
        int x = leastValue(array,array.length,0,0);
        System.out.println("least value "+x);

        KKSelectionSort(array,array.length-1,0,0);
        System.out.println(Arrays.toString(array));




        //selectionSortAlgRecursion(array3,0);
        //System.out.println("-> "+Arrays.toString(array3));
    }

    static void selectionSortAlgRecursion(int[] array,int i) {
            if (i == array.length){
                return;
            }
            boolean sort  = false;
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for ( int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                    sort = true;
                }
            }

            if (array[minIndex] < array[i]) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

            }

            if (!sort){
                return;
            }

        selectionSortAlgRecursion(array,i+1);

    }

    static void selectionSortAlg(int[] array) {
        boolean noMinFound;
        for (int i = 0; i < array.length; i++) {
            noMinFound = false;
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for ( int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                    noMinFound = true;
                }
            }

            if (min < array[i]) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

            }

          if (!noMinFound){
              break;
          }
        }


        System.out.println(Arrays.toString(array));

    }

    //find the least value from array using recurion
    static int leastValue(int[] array,int len,int index,int val) {
        if (index == len){
            return array[val];
        }


            if (array[index] < array[val]) {
             return    leastValue(array, len, index + 1, index);
            }
           else {
               return leastValue(array, len, index + 1, val);
            }


    }


    static void KKSelectionSort(int[] array, int len, int index, int max) {

        if (len == 0){
            return;
        }

        if (index < len) {
            if (array[index]>array[max]) {
                KKSelectionSort(array,len,index+1,index);
            }
            KKSelectionSort(array,len,index+1,max);
        }

        if (array[max] > array[len-1]) {
            int temp = array[max];
            array[max] = array[len-1];
            array[len-1] = temp;
            KKSelectionSort(array,len-1,0,0);
        }

    }



}
