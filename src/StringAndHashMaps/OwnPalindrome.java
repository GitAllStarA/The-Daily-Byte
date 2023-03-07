package StringAndHashMaps;/*
* Make Your Own Palindrome
Hash Maps
Medium
Given a string, s, which consists of only lowercase alphabetical characters,
* return the length of the longest palindrome you can form using its letters.

Ex: Given the following s...

s = “aa”, return 2.
Ex: Given the following s...

s = “abbcaadabac”, return 9.

*
*
* */


import java.util.*;

public class OwnPalindrome {

    public static void main(String[] args) {
        String s = "aabx";
        System.out.println(createPalindrome(s));
    }


    public static int createPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0));
            }
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> oddEntry : hashMap.entrySet()) {

            if (oddEntry.getValue() % 2 != 0 && oddEntry.getValue() > 1) {
                if (hashMap.containsKey(oddEntry.getKey())) {
                    hashMap.put(oddEntry.getKey(), hashMap.getOrDefault(oddEntry.getKey(), hashMap.get(oddEntry.getKey())) - 1);
                }
            }
        }

        System.out.println(hashMap);
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry: hashMap.entrySet()){
            if (entry.getValue()==1){
                list.add(entry.getKey());
            }
        }

        if (list.size()>1){
            for (int i = 1; i < list.size(); i++) {
                if (hashMap.containsKey(list.get(i))){
                    hashMap.put(list.get(i), hashMap.getOrDefault(list.get(i),hashMap.get(list.get(i)))-1);
                }
            }
        }


        System.out.println(hashMap);
        int x = hashMap.values().stream().reduce(0,Integer::sum);
        System.out.println(x);
        return 0;
    }
}
