package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 45;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println(totalWaysOfClimbingStairs(n, hashMap));
        System.out.println(totalWays(45));
    }

    //top-down approach with hashmap as memorization
    static int totalWaysOfClimbingStairs(int n, HashMap<Integer, Integer> hashMap) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (hashMap.containsKey(n)){
            return hashMap.get(n);
        }
        int result = totalWaysOfClimbingStairs(n - 2, hashMap) + totalWaysOfClimbingStairs(n - 1, hashMap);
        hashMap.put(n,result);
        return hashMap.get(n);
    }

    //bottom-up approach with array as memorization
    static int totalWays(int steps){
        int[] dp = new int[steps+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= steps; i++) {
          dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
