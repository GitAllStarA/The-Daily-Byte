package DynamicProgramming;

import java.util.Arrays;

public class MinimumEditDistance {
    public static void main(String[] args) {
        String s = "beach";
        String t = "batch";
        System.out.println(editDistance(s, t));
        System.out.println(s.substring(0,5));
    }

    static int editDistance(String s, String t) {
        int sLen = s.length() + 1;
        int tLen = t.length() + 1;
        int dp[][] = new int[sLen][tLen];
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < tLen; j++) {
                if (i==0){
                    dp[i][j] = j;
                }
                else if (j == 0){
                    dp[i][j] = i;
                }
                else if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                  dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }

            }

            for (int j = 0; j < tLen; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[s.length()][t.length()];
    }

}
