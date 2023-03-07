package StringAndHashMaps;/*
* Two Unique Characters
Strings
Medium
Given a string s, return the length of the longest substring containing at most two distinct characters.
Note: You may assume that s only contains lowercase alphabetical characters.

Ex: Given the following value of s…

s = "aba", return 3.
Ex: Given the following value of s…

s = "abca", return 2.
*
* */

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueLongestCharacters {

    static String s1 = "abc";
    static String s2 = "abca";

    public static void main(String[] args) {
        System.out.println(uniqueLongestCharas("abxcaaacccccccccc"));
        System.out.println(unqHashMap("abxcaaacccccccccc"));
        System.out.println(unqHashMap(s1));
    }


    public static int uniqueLongestCharas(String s){
        if (s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int uniqueCharCount = 0;
        int sameCharCount = 1;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i)))
            {
                set.add(s.charAt(i));
                uniqueCharCount++;
            }
            else
            {
                sameCharCount++;
            }
        }
    if (sameCharCount == 0){
        return uniqueCharCount;
    }
    else {
        return sameCharCount;
    }
    }




    public static int unqHashMap(String s) {
        if (s.length() == 0 ){
            return 0;
        }
        int uniqcount = 0;
        int sameCount =0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!hashMap.containsKey(x)){
                uniqcount++;
                hashMap.put(s.charAt(i),0);
            }else {
                hashMap.put(s.charAt(i),hashMap.getOrDefault(x,0)+1);
                sameCount++;
            }
        }

        int max = Collections.max(hashMap.values());
        if (sameCount > uniqcount){
            return max;
        } else {
            return uniqcount;
        }

    }
}
