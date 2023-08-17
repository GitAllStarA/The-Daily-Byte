package DynamicProgramming;

import java.util.HashMap;

public class SubsetSumDP {
    public static void main(String[] args) {
        int nums[] = {1, 5, 11, 5};
        int nums2[] = {1, 1, 2};
        int nums3[] = {10, 3, 2};
        int nums4[] = {1, 2, 5};
        System.out.println(isSubSetSum(nums));
    }


    //kevin N
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i: nums) {
            total += i;
        }

        if(total % 2 != 0) {
            return false;
        }

        return equalShare(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    public boolean equalShare(int[] nums, int index, int sum, int total, HashMap<String, Boolean> state) {
        String current = index + "" + sum;
        if(state.containsKey(current)) {
            return state.get(current);
        }
        if(sum * 2 == total) {
            return true;
        }
        if(sum > total / 2 || index >= nums.length) {
            return false;
        }

        boolean foundPartition = equalShare(nums, index + 1, sum, total, state) || equalShare(nums, index + 1, sum + nums[index], total, state);
        state.put(current, foundPartition);
        return foundPartition;
    }

    //not working
    static boolean isSubSetSum(int[] nums) {
        int x = 0;
        for (int ele : nums) {
            x = x + ele;
        }
        HashMap<String, Boolean> hashMap = new HashMap<>();
        if (x % 2 == 0) {
            return isPossible(nums, x, 0, hashMap);
        } else return false;
    }

    static boolean isPossible(int[] nums, int val, int index, HashMap<String, Boolean> state) {
        String current = index + "" + val;
        if (state.containsKey(current)) {
            return state.get(current);
        }
        if (val == 0) {
            System.out.println(val + " here " + index);
            return true;
        }
        if (state.containsKey(val)) {
            return state.get(val);
        }
        if (index == nums.length) {
            return false;
        }
        if (val < 0) {
            return false;
        }


        boolean result = isPossible(nums, val, index + 1, state) || isPossible(nums, val - nums[index], index + 1, state);
        state.put(current, result);
        return result;
    }

}