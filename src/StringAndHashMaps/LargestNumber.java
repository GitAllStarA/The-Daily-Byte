package StringAndHashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        //Output: "9534330"
        //formLargeNumber(nums);
        formLN(nums);

        selectionSort(nums);
        System.out.println("=============");
        System.out.println(Arrays.toString(nums));

    }


    static String formLN(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(i, array[i]);
            al.add(array[i]);
        }




        int max = Integer.MIN_VALUE;
        for (int i = 0; i < hashMap.size(); i++) {
            int n = al.get(i) % 10;
            if (max < n) {
                max = n;
            }
        }

        System.out.println(max);
        System.out.println(hashMap);

        return "";
    }


    static String formLargeNumber(int[] nums) {

        int newArray[] = new int[nums.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 10) {
                newArray[i] = nums[i] % 10;
                hashMap.put(i, nums[i] % 10);
            } else {
                newArray[i] = nums[i];
                hashMap.put(i, nums[i]);
            }
        }

        System.out.println(Arrays.toString(newArray));
        System.out.println(hashMap);
        System.out.println(Arrays.toString(selectionSort(newArray)));
        HashMap<Integer, Integer> newnHasp = new HashMap<>();

        var list = Arrays.asList(newArray);

        for (int i = 0; i < newArray.length; i++) {

        }


        return "";
    }

    static int[] selectionSort(int[] newArray) {
        int[] arrIndex = new int[newArray.length];
        for (int i = 0; i < newArray.length; i++) {
            int min = Integer.MIN_VALUE;
            int minIndex = 0;
            for (int j = i; j < newArray.length; j++) {
                int n = newArray[i]%10;
                if (min < newArray[j]) {
                    min = newArray[j];
                    minIndex = j;
                }

            }

            if (newArray[i] < newArray[minIndex]) {
                int temp = newArray[minIndex];
                newArray[minIndex] = newArray[i];
                newArray[i] = temp;
            }


        }

        return newArray;
    }

}
