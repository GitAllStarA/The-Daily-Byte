// https://www.youtube.com/watch?v=kC-DgdVK2jw&ab_channel=Education4u
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//if you forgot this please watch state space tree from the above link
public class SumOfSubset {

    public static void main(String[] args) {
        int[] nums = {8, 2, 2, 4, 5, 6, 3};
        int target = 9;
        System.out.println(subsetsOfTarget(nums, target));
    }

    static ArrayList<ArrayList<Integer>> subsetsOfTarget(int[] nums, int target) {
        HashSet<ArrayList<Integer>> combinations = new HashSet<>();
        Arrays.sort(nums);
        combinationsgenerator(0, nums, target, combinations, new ArrayList<Integer>());

        return new ArrayList<>(combinations);
    }

    private static void combinationsgenerator(int start, int[] nums, int target, HashSet<ArrayList<Integer>> combinations, ArrayList<Integer> current) {
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i]<=target) {
                current.add(nums[i]);
                combinationsgenerator(i + 1, nums, target - nums[i], combinations, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
