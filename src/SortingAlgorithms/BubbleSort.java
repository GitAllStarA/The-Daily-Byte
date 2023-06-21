package SortingAlgorithms;

import java.util.Arrays;

// in bubble sort form index we will compare next index + 1 element if it's greater than index + 1 , then index and index+1 elements are swapped,
// else they will remain as it is and index will be moved forward and compared it till end of the array
// https://www.geeksforgeeks.org/bubble-sort/

// https://leetcode.com/problems/sort-colors/description/
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{6, 7, 3, 4};
        int[] array2 = new int[]{6, 7, 3, 4};
        bubbleSortAlg(array2, 0);
        System.out.println("-");
        int[] array3 = new int[]{4, 3, 2, 1};

        kkBubbleSort(array3, array3.length - 1, 0);
        System.out.println(Arrays.toString(array3));
        //   bubbleSortAlgNonRecursive(array);

    }

    static void kkBubbleSort(int[] array, int len, int index) {
        if (len == 0){
            return;
        }
        if (index<len){
        if (array[index] > array[index + 1]) {
            int temp = array[index];
            array[index] = array[index + 1];
            array[index + 1] = temp;
        }
        kkBubbleSort(array,len,index+1);
        }
        else {
            kkBubbleSort(array,len-1,0);
        }

    }


    static void bubbleSortAlgNonRecursive(int[] array) {
        boolean swapped;
        for (int k = 0; k < array.length; k++) {
            swapped = false;
            for (int i = 0; i < array.length; i++) {

                int j = i + 1;
                if (j == array.length) {
                    break;
                }
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

        }

        System.out.println(Arrays.toString(array));
    }

    static void bubbleSortAlg(int[] array, int count) {
        if (count == array.length) {
            return;
        }

        boolean swapped = false;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            if (j == array.length) {
                break;
            }
            if (array[i] > array[j]) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                swapped = true;
            }
        }
        if (!swapped) {
            return;
        }
        System.out.println(Arrays.toString(array));
        bubbleSortAlg(array, count + 1);
    }


}
