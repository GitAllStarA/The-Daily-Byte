package Backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class DictionaryWords {
    public static void main(String[] args) {
        String s = "pizzaplanet";
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("p");
        dictionary.add("pizza");
        HashMap<String, Boolean> hashMap = new HashMap<>();
        // System.out.println(wordBreak(s,dictionary,0, hashMap));
        System.out.println(wordBreakBU(s, dictionary));
    }

    static boolean wordBreak(String s, HashSet<String> dictionary, int index, HashMap<String, Boolean> stringBooleanHashMap) {
        if (s == "") {
            return true;
        }
        if (stringBooleanHashMap.containsKey(s)) {
            return stringBooleanHashMap.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            if (dictionary.contains(s.substring(0, i)) && wordBreak(s.substring(i, s.length()), dictionary, index, stringBooleanHashMap)) {

                stringBooleanHashMap.put(s.substring(i, s.length()), true);
                return true;
            }
        }
        stringBooleanHashMap.put(s, false);
        return false;
    }

    //bottom up approach
    static boolean wordBreakBU(String s, HashSet<String> dictionary) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //System.out.println(s.substring(j,i));
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
