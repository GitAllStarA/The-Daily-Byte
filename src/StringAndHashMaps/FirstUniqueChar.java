package StringAndHashMaps;

import java.util.HashMap;

/*
* This question is asked by Microsoft. Given a string, return the index of its first unique character. If a unique character does not exist, return -1.

Ex: Given the following strings...

"abcabd", return 2
"thedailybyte", return 1
"developer", return 0
*
* */
public class FirstUniqueChar {

    public static void main(String[] args) {
       String s = "abcabd", s2= "thedailybyte", s3= "mmmvmooooodddddddda";

        System.out.println(uiqueIndex(s3));
    }

    public static int uiqueIndex(String s){
        if (s.length()<=0)
            return -1;
        int freq[] = new int[128];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1)
            {
                return s.indexOf(s.charAt(i));
            }
        }
        return Integer.MAX_VALUE;
    }
}
