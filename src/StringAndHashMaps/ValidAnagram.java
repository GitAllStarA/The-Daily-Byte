package StringAndHashMaps;

/*
* This question is asked by Facebook. Given two strings s and t return whether or not s is an anagram of t.
Note: An anagram is a word formed by reordering the letters of another word.

Ex: Given the following strings...

s = "cat", t = "tac", return true
s = "listen", t = "silent", return true
s = "program", t = "function", return false
*
* */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "silent", t = "lsiten";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() == 0 && s.length()==0)
            return true;
        else if (s.length() == 0 || t.length() ==0 )
            return false;
        else if (s.length() == t.length()) {
            int[] freq = new int[128];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i)]++;
            }
            for (int i = 0; i < t.length(); i++) {
                freq[t.charAt(i)]--;
                if (freq[t.charAt(i)] < 0)
                    return false;
            }
            return true;
        }
        return false;
    }
}
