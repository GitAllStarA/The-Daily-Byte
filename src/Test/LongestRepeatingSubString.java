package Test;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestRepeatingSubString {


    public static void main(String[] args) {
        String s = "pwwkew";
        String s2 = "abcabcbb";
        System.out.println("size " + longestRepeatedSubStringSizeX(s));
    }

    static int longestRepeatedSubStringSize(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            char[] c = s.toCharArray();
            if (!set.contains(c[j])) {
                set.add(c[j]);
                count++;
            } else {
                set.remove(c[i]);
                i++;
                //count--;
                set.add(c[j]);
                System.out.println(set);
            }
            j++;

            System.out.println(i + " " + j);
            System.out.println("count " + count);

        }
        return set.size();
    }

    static int longestRepeatedSubStringSizeX(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int count = 0;
        ArrayList<Character> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            char[] c = s.toCharArray();
            if (!list.contains(c[j])) {
                list.add(c[j]);
                System.out.println(list);
                //count++;
            } else {
                //list.remove(i);
                if (list.get(i).equals(list.get(j))){
                    list.remove(i);
                }
                //i++;
                //count--;
                list.add(c[j]);
                System.out.println(list);
            }
            j++;

            System.out.println(i + " " + j);
            //System.out.println("count "+count);

        }
        return list.size();
    }
}
