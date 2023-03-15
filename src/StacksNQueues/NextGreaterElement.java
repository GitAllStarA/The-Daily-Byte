/*
* Greater Elements
Stacks & Queues
Easy
This question is asked by Amazon. Given two arrays of numbers, where the first array is a subset of the second array,
* return an array containing all the next greater elements for each element in the first array, in the second array.
* If there is no greater element for any element, output -1 for that number.

Ex: Given the following arrays…

nums1 = [4,1,2], nums2 = [1,3,4,2], return [-1, 3, -1] because no element in nums2 is greater than 4, 3 is the first number in nums2 greater than 1, and no element in nums2 is greater than 2.
nums1 = [2,4], nums2 = [1,2,3,4], return [3, -1] because 3 is the first greater element that occurs in nums2 after 2 and no element is greater than 4.
See Solution
*
*
* */




package StacksNQueues;

import java.util.*;

public class NextGreaterElement {



    public static void main(String[] args) {
        int n1[] = new int[]{4,1,2};
        int n2[] = new int[]{1,9,8,7,6,5,4,3,2,11,10};
        int n3[] = new int[]{1,3,5,2,4};
        int n4[] = new int[]{6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(nexterGreaterIndexValue(n3,n4)));
        nextGreater(n3,n4);
    }


    //brute force approach not passing all test cases;

    public static int[] nexterGreaterIndexValue(int[] nums1, int[] nums2) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    if (j==nums2.length-1){
                        queue.offer(-1);
                    }
                    else if (nums2[j]<nums2[j+1]){
                        queue.offer(nums2[j+1]);
                    } else if (nums2[j+1]<nums2[j]){
                        queue.offer(-1);
                    }
                }
            }
        }
        System.out.println(queue);
        int index = 0;
        int result[] = new int[queue.size()];
        for (int x : queue){
            result[index++] = x;
        }
        return result;
    }


    public static int[] nextGreater(int[] nums1, int[] nums2) {
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int x : nums2){
            while (!stack.isEmpty() && stack.peek() < x ){
                hashMap.put(stack.pop(),x);
                //System.out.println(hashMap);
            }
            stack.push(x);
            //System.out.println(stack);
        }
        //System.out.println(hashMap);

        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hashMap.getOrDefault(nums1[i],-1);
        }
        System.out.println(Arrays.toString(nums1));
        return nums1;
    }


    // Om agoribyo togoribyo gor gor tharibya
    // sarvebya sarv sarvebyo
    // Namaste asth roop roopbebya
}
