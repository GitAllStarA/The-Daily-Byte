package SortingAlgorithms;

import java.util.Arrays;
import java.util.Map;

public class RadixSort {

    public static void main(String[] args) {
        int[] a = {12, 6, 88, 98, 14, 471};
                 //6, 12, 14, 88, 98, 471
        rSort(a);
    }

    public static int[] rSort(int[] array) {
        //int[] workingArray = new int[array.length];
        if (array.length == 1){
            System.out.println(array);
            return array;

        }
        int[] workingArray = Arrays.copyOfRange(array,0,array.length);


        //highest
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (MAX < array[i]){
                MAX = array[i];
            }
        }
        //units count
        int count = 0;
        while (MAX!=0){
            MAX = MAX/10;
            count++;
          //  System.out.println(MAX);
        }
        //System.out.println(count);



        int val = 472;
        int rem = 0;
        while (val!=0) {
            rem = val%10;
            val = val/10;
           // System.out.println(val+" rem : "+rem);
        }



        //sort based on unit's place;
        int max2 = Integer.MAX_VALUE;
        int placeIndex = 0;

       // for (int j = 1; j <= count; j++) {
            int arrSort[] = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]%10);
                arrSort[i] = array[i]%10;
                //array[i] = array[i]/10;
            }
            for (int i = 0; i < arrSort.length; i++) {
                for (int k = 1; k < array.length; k++) {
                    if (arrSort[i]>arrSort[k]){
                        int temp = array[i];
                        array[i] = array[k];
                        array[k] = temp;
                    }
                }
            }


            System.out.println("----------------------");
       // }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        return array;
    }
}
