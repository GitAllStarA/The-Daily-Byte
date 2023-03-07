package StringAndHashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
* Longest Substring Between Characters
Hash Maps
Hard
Given a string, s, return the length of the longest substring between two characters that are equal.
Note: s will only contain lowercase alphabetical characters.

Ex: Given the following string s…

s = "bbccb", return 3 ("bcc" is length 3).
Ex: Given the following string s…

s = "abb", return 0.
* */
public class LongestSubStringBetweenTwoEqualChars {
    public static void main(String[] args) {
        String s = "abcac";
        // System.out.println(length(s));
       // System.out.println(length2(s));
        System.out.println(longestSubstringBetweenCharacters(s));
    }

    public static int length(String s) {
        int count = 0;
        if (s.length() <= 0)
            return -1;
        else if (s.charAt(0) != s.charAt(1) && s.length() <= 2)
            return -1;
        else if (s.charAt(0) == s.charAt(1) && s.length() <= 2)
            return 0;
        else {
            char j = s.charAt(s.length() - 1);
            int m = 0;
            int n = s.length() - 1;
            while (m < s.length()) {
                if (s.charAt(m) != j) {
                    m++;
                    n--;
                } else if (s.charAt(m) == s.charAt(n) && s.length() > 2) {
                    String x = s.substring(m + 1, n - 1);
                    System.out.println(x);
                    count = x.length();
                    break;
                }
            }
        }
        return count;
    }

    public static int length2(String s) {

        if (s.length() == 2 && s.charAt(0) == s.charAt(1))
            return 0;
        if (s.length() == 2 && s.charAt(0) != s.charAt(1))
            return -1;


        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.getOrDefault(hashMap.get(s.charAt(i)), 1) + 1);
            } else hashMap.put(s.charAt(i), 1);
        }
        char repeatedChar = ' ';
        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()){
            if (entry.getValue()>=2){
                repeatedChar = entry.getKey();
                break;
            }
        }

        char[] tochar = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tochar.length; i++) {
            if (tochar[i] == repeatedChar){
                list.add(i);
            }
        }

        System.out.println(list);
        int result = s.substring(list.get(0)+1,list.get(list.size()-1)).length();
        return result;
    }


    public static int longestSubstringBetweenCharacters(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length();i++){
            char current = s.charAt(i);
            if (hashMap.containsKey(s.charAt(i))) {
                 max = Math.max(max,i-hashMap.get(current)-1);
            }
            else {
                hashMap.put(s.charAt(i),i);
            }
        }
        return max;
    }

}
