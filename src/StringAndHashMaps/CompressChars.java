package StringAndHashMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
*
* Compression
Strings
Easy
This question is asked by Facebook. Given a character array, compress it in place and return the new length of the array.
Note: You should only compress the array if its compressed form will be at least as short as the length of its original form.

Ex: Given the following character array chars…

chars = ['a', 'a', 'a', 'a', 'a', 'a'], return 2.
chars should be compressed to look like the following:
chars = ['a', '6']
Ex: Given the following character array chars…

chars = ['a', 'a', 'b', 'b', 'c', 'c'], return 6.
chars should be compressed to look like the following:
chars = ['a', '2', 'b', '2', 'c', '2']
Ex: Given the following character array chars…

chars = ['a', 'b', 'c'], return 3.
In this case we chose not to compress chars.

*
* */
public class CompressChars {
    public static void main(String[] args) {
        char[] c = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(c));
    }

    public static int compress(char[] chars) {
        int cLen = chars.length;
       // StringBuilder sb = new StringBuilder();
        String sb = "";
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < chars.length && j < chars.length) {

                if (chars[i] == chars[j]) {
                    count++;
                } else {
                   // sb.append(chars[i]);
                    sb += chars[i];
                    if (count > 1) {
                      //  sb.append(count);
                        sb+=count+"";
                    }

                    i = j;
                    System.out.println(chars[j]);
                    count =1;
                }
                j++;
            }
        if (count>1){
           // sb.append(chars[i]);
            // sb.append(count);
            sb += chars[i];
            sb+=count+"";
        }


        System.out.println(sb);


        List<String> al = new ArrayList<>();
        for( char x : sb.toCharArray()){
            al.add(x+"");
        }
        System.out.println(al);
        return al.size();
    }
}




class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i =0;i<word.length();i++){

            if(Character.isUpperCase(word.charAt(i))){
                count++;
                if (count == word.length()){
                    return true;
                }
            }
        }
        return count==0 || count ==1 && Character.isUpperCase(word.charAt(0));
    }
}