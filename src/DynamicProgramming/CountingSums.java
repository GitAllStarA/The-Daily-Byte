package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class CountingSums {
    public static void main(String[] args) {
        int nums[] = {1,2,1,2,1};
        int target = 3;

        int nums2[] = {1,1,4};
        int target2 = 5;
        System.out.println(sumOfTarget(nums,target));
        System.out.println(continuousSums(nums,target));
        //System.out.println(returnTargetNoOfSubArrays(nums,target));
        //System.out.println(returnTargetNoOfSubArrays(nums2,target2));
    }

    public static int continuousSums(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
    //using prefix sum; by Ayushi Sharma https://www.youtube.com/watch?v=XjP2mQr98WQ&ab_channel=AyushiSharma
    static int sumOfTarget(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        hashMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (hashMap.containsKey(sum-k)){
                count += hashMap.get(sum-k);
            }
            hashMap.put(sum,hashMap.getOrDefault(sum,0)+1);

            /*if(sum == k) {
                count++;
            }*/
        }
        return count;
    }


    //brute force is not correct
    static int returnTargetNoOfSubArrays(int[] nums, int target) {

        //int dp[] = new int[nums.length];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp == 5 )
                {
                    arrayList.add(temp);
                    break;
                }
            }
        }
        System.out.println(arrayList);
        return arrayList.size();
    }
}
