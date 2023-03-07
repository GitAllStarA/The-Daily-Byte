package StringAndHashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/*
* Crack the Code
Hash Maps
Hard
Given a string s and a string code, return whether or not s could have been encrypted using the pattern represented in code.

Ex: Given the following s and code...

s = “the daily byte”, code = “abc”, return true
Ex: Given the following s and code...

s = “the daily byte curriculum”, code = “abcc”, return false because ‘c’ in code already maps to the word “byte”

*
* */
public class CrackTheCode {
    public static void main(String[] args) {
        String s  = "vikranth is a jobless software engineer developer" , code = "abcdefg";
        System.out.println(isEncrypted(s,code));
    }

    public static boolean isEncrypted(String s, String code) {

        LinkedHashMap<String,Character> hashMap = new LinkedHashMap<>();

        String sA[] = s.split(" ");
        if (sA.length != code.length()){
            return false;
        }
        for (int i = 0; i < sA.length; i++) {
            if (!hashMap.containsKey(sA[i]))
                hashMap.put(sA[i],hashMap.getOrDefault(sA[i],code.charAt(i)));
            else
                hashMap.put(sA[i],hashMap.getOrDefault(sA[i],code.charAt(i)));
        }

        //boolean result = hashMap.values().stream().distinct().count() == hashMap.size();


        //System.out.println(result);

        HashSet<Character> hashSet = new HashSet<>();
        for (char x : hashMap.values()) {
            hashSet.add(x);
        }

        return hashSet.size() == hashMap.size();
    }
}
