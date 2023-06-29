package Test;

import java.util.Arrays;

public class SortAlgorithms {
    public static void main(String[] args) {
        int[] arrayQSA = new int[]{77, 99, 68, 33, -22, 55, 78};
        //output = -22,33,55,68,77,78,99
        quickSortAlgorithm(arrayQSA, 0, arrayQSA.length - 1);
        System.out.println(Arrays.toString(arrayQSA)); // timer 05:07.76


        int[] arrayMSA = new int[]{77, 99, 68, 33, -22, 55, 78};
        System.out.println(Arrays.toString(mergeSort(arrayMSA))); // timer 15:46.79

        int[] arraySSA = new int[]{77, 99, 68, 33, -22, 55, 78};
        //selectionSortAlgorithm(arraySSA, 0);
        KKSelectionSA(arraySSA, arraySSA.length, 0, 0); // 31:25.74 not solved
        System.out.println("-> "+Arrays.toString(arraySSA));

        int[] arrayBSA = new int[]{77, 99, 68, 33, -22, 55, 78};
       // bubbleSortAlgorithm(arrayBSA,0);
        kkbubbleSortAlg(arrayBSA,arrayBSA.length-1,0);
        System.out.println(Arrays.toString(arrayBSA)); // timer 23:22.62
    }

    static void quickSortAlgorithm(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;

        int mid = (s + e) / 2;

        int pivot = array[mid];

        while (s <= e) {
            while (array[s] < pivot) {
                s++;
            }
            while (array[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = array[s];
                array[s] = array[e];
                array[e] = temp;
                s++;
                e--;
            }
        }

        quickSortAlgorithm(array, low, e);
        quickSortAlgorithm(array, s, high);
    }

    static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }


        int mid = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

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


    static void selectionSortAlgorithm(int[] array, int index) {
        if (index == array.length) {
            return;
        }
        boolean swap = false;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int j = index; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                minIndex = j;

            }
        }

        if (min < array[index]) {
            int temp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;
        }


        selectionSortAlgorithm(array, index + 1);
    }


    static void KKSelectionSA(int[] array, int len, int index, int max) {

      if (len == 0) {
          return;
      }

      if (index < len) {
          if (array[index] > array[max] ){
              KKSelectionSA(array,len,index+1,index);
          }
          KKSelectionSA(array,len,index+1,max);
      }

      if (array[max] > array[len-1]){
          int temp = array[len-1];
          array[len-1] = array[max];
          array[max] = temp;
      }
      KKSelectionSA(array,len-1,0,0);
    }


    static void bubbleSortAlgorithm(int[] array, int index) {

        for (int l = 0; l < array.length; l++) {
            int j = 1;
            for (int i = index; i < array.length; i++) {
                j = i + 1;
                if (j == array.length) {
                    break;
                }
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    static void kkbubbleSortAlg(int[] array, int len, int index){
        if (len == 0){
            return;
        }

        if (index < len){
            if (array[index] > array[index+1]){
                int temp = array[index];
                array[index] = array[index+1];
                array[index+1] = temp;
                kkbubbleSortAlg(array,len,index+1);
            }
            else {
                kkbubbleSortAlg(array,len,index+1);
            }
        }
        kkbubbleSortAlg(array,len-1,0);
    }
}

