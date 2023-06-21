package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] array1 = {5, 4, 3, 2, 1};
        //here the merge sort is not modifying the above original object but creates a new array object and sort it return new sorted array containig same elements of above array
        int[] array1Sorted = MergeSortAlg(array1);
        System.out.println("unsorted array1 = "+Arrays.toString(array1));
        System.out.println("merge sorted array1 = "+Arrays.toString(array1Sorted));
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
        System.out.println("mix length = "+mix.length+ " "+mix);

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }
            else {
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
}
