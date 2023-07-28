package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombinations {
    public static void main(String[] args) {
        int[] numbers = {2, 3,4};
        int target = 6;
        System.out.println(combintn(numbers,target));
        //int[] ary = new int[]{1,4,6,2,3,5};
       // selectionSort(ary);
        //System.out.println(Arrays.toString(ary));
       // combinations(numbers, target);
    }

    public static void combinations(int[] numbers, int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int number = numbers[1];
        int temp = target;
        while (temp > 0) {
            target = target - number;
            temp = target;
            System.out.println(target + " " + temp);

        }

    }


    public static ArrayList<ArrayList<Integer>> combintn(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        Arrays.sort(numbers);
        generateCombs(combinations,new ArrayList<>(), numbers, target, 0);
        return combinations;
    }

    public static void generateCombs(ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> current, int[] numbers, int remaining, int start) {
        if (remaining < 0){
            return;
        }

        if (remaining == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            current.add(numbers[i]);
            generateCombs(combinations, current, numbers, remaining - numbers[i], i);
          current.remove(current.size() - 1);
            //current.clear();
        }
    }

    //selection sort

    static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int temp = 0;
                if (array[j] < array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
