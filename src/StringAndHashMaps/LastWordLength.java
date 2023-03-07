package StringAndHashMaps;

import java.util.Arrays;

/*
Word Length
Strings
Easy
Given a string, s, return the length of the last word.
Note: You may not use any sort of split() method.

Ex: Given the following string…

s = "The Daily Byte", return 4 (because "Byte" is four characters long).

* */
public class LastWordLength {
    public static void main(String[] args) {
        String s = "vikranthB yte";
        String sw = " vikranthB yte cscsdsvfvfsdcf";
        System.out.println(lengthOfLastWord(sw));
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }

        int count=0;
        String sss="";
        String res = "";
        s = s.stripTrailing();
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i) == ' '){
                count++;
                return count-1;
            }
            else count++;
        }
        return count;
    }

}
