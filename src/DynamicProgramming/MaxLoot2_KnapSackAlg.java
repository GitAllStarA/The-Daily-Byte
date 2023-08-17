package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxLoot2_KnapSackAlg {
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,2};
        System.out.println(maxLootKSA(nums));
        System.out.println(maxLootDB(nums));
    }

    //the daily byte solution
    static int maxLootDB(int[] nums) {
        if (nums == null || nums.length ==0)
            return 0;
        if (nums.length == 2)
            return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length>2) {
            dp[1] = Math.max(dp[0],nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }

    //not correct approach
    static int maxLootKSA(int[] nums) {
        int numsSum  = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][numsSum+1];
        System.out.println(dp.length);
        Arrays.sort(nums);
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i,nums[i]);
        }
        System.out.println(hashMap);

        for (int i = 0; i < hashMap.size(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = hashMap.get(i);
            }
        }

        for (int i = 1; i < hashMap.size(); i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (hashMap.get(i)>j){
                    dp[i][j]=dp[i-1][j];
                }
                else if (hashMap.get(i) <= j) {
                    int x = dp[i-1][j];
                    int yCell = j - hashMap.get(i);
                    int y = dp[i-1][yCell] + hashMap.get(i);
                    //System.out.println("-> "+y);
                    int max = Math.max(x,y);
                    dp[i][j] = max;
                }
            }
        }

        for (int i = 0; i < hashMap.size(); i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]<10){
                    System.out.print("0"+dp[i][j]+" ");

                }
                else
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[hashMap.size()-1][dp[0].length-1];
    }
}
