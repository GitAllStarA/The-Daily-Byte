package DynamicProgramming;
/*Art Gallery Thief
Dynamic Programming
Hard
You’ve broken into an art gallery and want to maximize the value of the paintings you steal. All the paintings you steal you place in your bag which can hold at most W pounds. Given that the weight and value of the ith painting is given by weights[i] and values[i] respectively, return the maximum value you can steal.

Ex: Given the following W, weights array and values array…

W = 10, weights = [4, 1, 3], values = [4, 2, 7], return 13.

Ex: Given the following W, weights array and values array…

W = 5, weights = [2, 4, 3], values = [3, 7, 2], return 7.

Ex: Given the following W, weights array and values array…

W = 7, weights = [1, 3, 4], values = [3, 5, 6], return 11.*/
import java.util.*;

public class Knapsack_ThiefsMaxLoot {
    public static void main(String[] args) {
        int[] w = {4,1,3};
        int[] v = {4,2,7};
        int bagCapacity = 10;
        int[] w2 = {2,4,3};
        int[] v2 = {3,7,2};
        int bagCapacity2 = 4;
        int[] w3 = {1,3,4};
        int[] v3 = {3,5,6};
        int bagCapacity3 = 7;

        System.out.println(maxLootOfThief(w,v,bagCapacity));
        System.out.println(maxLootOfThief(w2,v2,bagCapacity2));
        System.out.println(maxLootOfThief(w3,v3,bagCapacity3));
    }

    static int maxLootOfThief(int[] w, int[] v,int bagCapacity) {
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < w.length; i++) {
            hashMap.put(w[i],v[i]);
        }
        System.out.println(hashMap);

        Map<Integer, Integer> sortedHashMap = new TreeMap<Integer,Integer>(hashMap);
        System.out.println("hashMap sorted");

        System.out.println(sortedHashMap);
        System.out.println(":====================================:");
        int[][] dp = new int[w.length][bagCapacity+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        Arrays.sort(w);


        for (int i = 1; i < dp[0].length; i++) {
            if (w[0]<i){
                dp[0][i] = sortedHashMap.get(w[0]);
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (w[i]<=j){
                    int aboveCellValue = dp[i-1][j];
                    int sowMinusCurrentWeight = j-i;
                    int prevCellValue =  dp[i-1][sowMinusCurrentWeight];
                    int newValue = sortedHashMap.get(w[i]) + prevCellValue;
                    int currentWeight = Math.max(aboveCellValue,newValue);
                    dp[i][j] = currentWeight;
                }
                else if (w[i]>j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.print("   | ");
        for (int i = 0; i < dp[0].length; i++) {
            if (i < 10){
                System.out.print("0"+i+" | ");
            }
            else {
                System.out.print(i+ " | ");
            }
        }
        System.out.println();

        for (int i = 0; i < dp.length; i++) {

            if (i< 10){
                System.out.print("0"+i+" | ");
            }
            else {
                System.out.print(i + " | ");
            }

            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] < 10){
                    System.out.print("0"+dp[i][j]+" | ");
                }
                else {
                    System.out.print(dp[i][j] + " | ");
                }
            }
            System.out.println();
        }



        return dp[w.length-1][bagCapacity];
    }
}
