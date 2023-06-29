package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] array1 = {-2,3,-5};
        //here the merge sort is not modifying the above original object but creates a new array object and sort it return new sorted array containig same elements of above array
        //int[] array1Sorted = MergeSortAlg(array1);
        //System.out.println("unsorted array1 = " + Arrays.toString(array1));
        //System.out.println("merge sorted array1 = " + Arrays.toString(array1Sorted));

        System.out.println("merge sort in place");
        int[] array2 = {5, 4, 2, 1};
        // here we are modifying original array
        mergeSortAlgInplace(array2, 0, array2.length);
        System.out.println(Arrays.toString(array2));

        System.out.println(Arrays.toString(sortArray(array1)));
    }

    static int[] MergeSortAlg(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;
        int left[] = MergeSortAlg(Arrays.copyOfRange(array, 0, mid));
        int right[] = MergeSortAlg(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        //every time a new array is created
        int[] mix = new int[left.length + right.length];
        System.out.println("mix length = " + mix.length + " " + mix);

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            mix[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length) {
            mix[k] = right[j];
            k++;
            j++;
        }
        return mix;
    }

    //inplace = modify the original array
    static void mergeSortAlgInplace(int[] array, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = s + (e - s) / 2;
        mergeSortAlgInplace(array, s, mid);
        mergeSortAlgInplace(array, mid, e);

        mergeInplace(array, s, mid, e);
    }

    private static void mergeInplace(int[] array, int s, int mid, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = mid;
        int k = 0;

        while (i < mid && j < e) {
            if (array[i] < array[mid]) {
                mix[k] = array[i];
                i++;
            } else {
                mix[k] = array[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = array[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = array[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            array[s + l] = mix[l];
        }


        System.out.println(Arrays.toString(array));
    }



    static int[] sortArray(int[] nums) {
        return mergeSort(nums);

    }

    static int[] mergeSort(int[] array) {
        if(array.length == 1){
            return array;
        }

        int mid = array.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return mergeSort(left,right);
    }

    static int[] mergeSort(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<left.length && j<right.length) {
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }
            else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length){
            mix[k] = left[i];
            i++;
            k++;
        }

        while(j<right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;

    }
}
