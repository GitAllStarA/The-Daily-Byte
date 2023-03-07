package StringAndHashMaps;/*
*
* Double Value
Hash Maps
Medium
Given an integer array, nums, return true if for any value within nums its double also exists within the array.

Ex: Given the following nums…

nums = [4, 3, 9, 8], return true (4 and 8 both appear in nums).
Ex: Given the following nums…

nums = [9, 2, 3, 5], return false.

*
* */

import java.util.HashMap;
import java.util.Map;

public class DoubleValue {

    public static void main(String[] args) {
     int[] nums = new int[] {4, 3, 9, 8};
     int[] nums2 = new int[] {9, 2, 3, 5};
     // return true (4 and 8 both appear in nums).
        System.out.println(isDouble(nums2));

    }


    public static boolean isDouble(int[] nums) {

        if (nums.length <= 0) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],nums[i]*2);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if (hashMap.containsKey(entry.getValue())){
                return true;
            }
        }
        System.out.println(hashMap);
        return false;
    }
}
