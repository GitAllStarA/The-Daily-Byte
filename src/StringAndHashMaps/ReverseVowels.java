package StringAndHashMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("vikranth"));
    }

    /*public static String reversVows(String s) {

        s = s.toLowerCase();
        char[] x = s.toCharArray();

        String vowels = "aeiou";
        char[] vowelsList = vowels.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                System.out.println(s.indexOf(c));
            }
            s = s.substring(i,s.length()-1);

        }
        return "hello";
    }*/


    //tc = o(n) , travelling throught the list character only using while loop,
    //sc = o(n), we are storing string of length n in the char array.

    public static String reverseVowels(String s) {
        if (s.equals("")){
            return "";
        }

        int start = 0;
        int end = s.length()-1;
        char[] characters = s.toCharArray();
        while (start<end){
            if (!vowelsList(characters[start])){
                start++;
            } else if (!vowelsList(characters[end])) {
                end--;
            }
            else {
                char temp = characters[start];
                characters[start] = characters[end];
                characters[end] = temp;
                start++;
                end--;
            }
        }
        return new String(characters);
    }


    public static boolean vowelsList(char c){
        if (c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u'|| c=='A'|| c=='E'|| c=='I'|| c=='O'|| c=='U'){
            return true;
        }
        return false;
    }



}
