package StringAndHashMaps;/*
*
 *
 *Removing Vowels
Strings
Easy
This question is asked by Amazon. Given a string s remove all the vowels it contains and return the resulting string.
Note: In this problem y is not considered a vowel.

Ex: Given the following string s…

s = "aeiou", return ""
Ex: Given the following string s…

s = "byte", return "byt"
Ex: Given the following string s…

s = "xyz", return "xyz"
* */

import java.util.HashSet;

public class RemoveVowels {
    public static void main(String[] args) {
        String d ="daily";
        System.out.println(removeVowels(d));
    }

    static String removeVowels(String word) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'A'||word.charAt(i) == 'E'||word.charAt(i) == 'I'||word.charAt(i) == 'O'||word.charAt(i) == 'U'||
                    word.charAt(i) == 'a'||word.charAt(i) == 'e'||word.charAt(i) == 'i'|| word.charAt(i) == 'o'||word.charAt(i) == 'u') {
                s.append("");
            }
            else {
                s.append(word.charAt(i));
            }
        }
        return s.toString();
    }
}
