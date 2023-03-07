package StringAndHashMaps;

import java.util.HashMap;

/*
*
* Character Scramble, Hash Maps - Medium
This question is asked by Amazon. Given two strings, passage and text return whether or not the characters in text can be used to form the given passage.
Note: Each character in text may only be used once and passage and text will only contain lowercase alphabetical characters.

Ex: Given the following passage and text…

passage = "bat", text = "cat", return false.
Ex: Given the following passage and text…

passage = "dog" text = "didnotgo", return true.
*
*
*
*/
public class CharacterScramble {

    public static void main(String[] args) {
        String passage = "dog", text = "didnotgo";
        String p = "bat" , t = "cat";
        String  s1 = "abcde", s2 = "caebd";
        System.out.println(charScramble(passage,text));
        System.out.println(charScramble(p,t));
        System.out.println(charScramble(s1,s2));
        System.out.println("uuuu");
        System.out.println(charScramble(s1,s2));
    }

    public static boolean charScramble(String passage, String text) {

        if (passage.length()<=0)
            return false;
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (passage.indexOf(text.charAt(i)) !=-1){
                count++;
                if (count>=passage.length())
                    System.out.println(count);
                    return true;
            }
        }
        return false;
    }

    public boolean characterScramble(String passage, String text) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for(char c: text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for(char c: passage.toCharArray()) {
            if(!counts.containsKey(c) || counts.get(c) <= 0) {
                return false;
            }

            counts.put(c, counts.get(c) - 1);
        }

        return true;
    }

}
