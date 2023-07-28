package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfTargetBackTracking {
    public static void main(String[] args) {
        int[] nums = {8, 2, 2, 4, 5, 6, 3};
        int target = 9;
        System.out.println(TargetSum(nums,target));

    }

    static ArrayList<ArrayList<Integer>> TargetSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        Arrays.sort(nums);
        findCombinationsOfTarget(0, new ArrayList<>(), arrayList, nums, target);
        return arrayList;
    }

    private static void findCombinationsOfTarget(int start, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> arrayList, int[] nums, int target) {
         if (target == 0) {
            arrayList.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                current.add(nums[i]);
                findCombinationsOfTarget(i + 1, current, arrayList, nums, target - nums[i]);
                current.remove(current.size() - 1);
            }
        }

    }

}
