package Backtracking;

import java.util.*;

public class BiggerAndBigger {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //System.out.println(biggerAndBigger(nums));
        System.out.println(subsetOfNums(nums));
    }
    public static List<List<Integer>> biggerAndBigger(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        generateSubsets(new LinkedList<Integer>(), 0, nums, subsets);

        return subsets;
    }

    private static void generateSubsets(LinkedList<Integer> current, int index, int[] nums, List<List<Integer>> subsets) {
        if (current.size() > 1) {
            subsets.add(new LinkedList<Integer>(current));
        }

        Set<Integer> used = new HashSet<>();
        for(int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }

            if(current.size() == 0 || nums[i] >= current.peekLast()) {
                used.add(nums[i]);
                current.add(nums[i]);
                generateSubsets(current, i + 1, nums, subsets);
                current.remove(current.size() - 1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> subsetOfNums(int[] nums) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        Arrays.sort(nums);
        createSubsets(0,arrayList,new ArrayList<>(),nums);
        return arrayList;
    }

    private static void createSubsets(int start, ArrayList<ArrayList<Integer>> arrayList, ArrayList<Integer> current, int[] nums) {

        if (start == nums.length) {

            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            if (current.size() > 1) {
                arrayList.add(new ArrayList<>(current));
            }
            createSubsets(i+1,arrayList,current,nums);
            current.remove(current.size()-1);
        }
    }
}
