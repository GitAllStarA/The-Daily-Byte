package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalance_SettingDebts_SplitwiseAlgorithm {
    public static void main(String[] args) {
        int[][] debts = {
                {0, 1, 5},
                {0, 2, 10},
                {2, 1, 15}
        };
        int[][] debts2 = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
        System.out.println(settleTransactions(debts));

    }

    static int settleTransactions(int[][] debts) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int debt[] : debts) {
            int from = debt[0];
            int to = debt[1];
            int amount = debt[2];

            hashMap.put(from, hashMap.getOrDefault(from, 0) - amount);
            hashMap.put(to, hashMap.getOrDefault(to, 0) + amount);

        }
        System.out.println(hashMap);

        ArrayList<Integer> balanceList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() !=0)
                balanceList.add(entry.getValue());
        }
        System.out.println(balanceList);
        return minimalTransaction_dfs_backtracking(balanceList, 0, 0);
    }

    static int minimalTransaction_dfs_backtracking(ArrayList<Integer> balanceList, int currentIndex, int minimalTransactionCount) {
        if (currentIndex >= balanceList.size()) {
            return 0;
        }

        if (balanceList.get(currentIndex) == 0) {
            return minimalTransaction_dfs_backtracking(balanceList, currentIndex + 1, minimalTransactionCount);
        }

        int currentValue = balanceList.get(currentIndex);
        for (int trxIndex = currentIndex + 1; trxIndex < balanceList.size(); trxIndex++) {
            int nextValue = balanceList.get(trxIndex);
            if (currentValue * nextValue < 0) {
                balanceList.set(trxIndex, currentValue + nextValue);
                System.out.println(balanceList);
                minimalTransactionCount = Math.min(Integer.MAX_VALUE, 1 + minimalTransaction_dfs_backtracking(balanceList, currentIndex + 1, minimalTransactionCount));
                balanceList.set(currentIndex, nextValue);
                System.out.println(balanceList);
                if (currentValue + nextValue == 0) {
                    break;
                }
            }
        }
        return minimalTransactionCount;
    }
}
