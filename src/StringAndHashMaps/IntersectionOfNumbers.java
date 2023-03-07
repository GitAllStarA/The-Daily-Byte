package StringAndHashMaps;/*
*
* This question is asked by Google. Given two integer arrays, return their intersection.
Note: the intersection is the set of elements that are common to both arrays.

Ex: Given the following arrays...

nums1 = [2, 4, 4, 2], nums2 = [2, 4], return [2, 4]
nums1 = [1, 2, 3, 3], nums2 = [3, 3], return [3]
nums1 = [2, 4, 6, 8], nums2 = [1, 3, 5, 7], return []
*
* */


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfNumbers {

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 4, 4};
        int[] nums2 = {4, 4, 4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(intersections(nums1, nums2)));
        System.out.println(Arrays.toString(ints(nums1, nums2)));
    }

    public static int[] intersections(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return new int[]{};
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    hashSet.add(nums1[i]);
                }
            }
        }


        int k = 0;
        int newArr[] = new int[hashSet.size()];
        for (int x : hashSet) {
            newArr[k++] = x;
        }
        return newArr;
    }



    public static int[] ints(int[] nums1, int[] nums2){
       var x = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
       Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (x.contains(nums2[i])){
                set.add(nums2[i]);
            }
        }
        int i=0;
        int[] newA = new int[set.size()];
        for (int y : set){
            newA[i++] = y;
        }
        return newA;

    }
}
