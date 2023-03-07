package StringAndHashMaps;/*
* easy
*
* Given a string s, return all of its repeated 10 character substrings.
Note: You may assume s only contains uppercase alphabetical characters.

Ex: Given the following string s…

s = "BBBBBBBBBBB", return ["BBBBBBBBBB"].
Ex: Given the following string s…

s = "ABABABABABABBBBBBBBBBB", return ["ABABABABAB","BBBBBBBBBB"].
*
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class StringRepeatation {


    public static void main(String[] args) {
        String s  =  "ABABABABABBBBBBBBBBBvikranthravikranthramustanggt5bbbbbbbbbbbbbbbbbbbbccccccccccttttttttttcccccccccctttttttttt";
        String s2 = "BBBBBBBBBB";
        String s3 = "ABABABABABABBBBBBBBBBB";

        System.out.println(subString(s));

//        for (int i = 0; i < s.length()-9; i++) {
//            String current = s.substring(i,i+10);
//            System.out.println(current);
//        }

    }

    public static List<String> subString(String s) {
        List<String> repeated =  new ArrayList<>();
        if (s.length() == 0 && s == ""){
            return repeated;
        }

        LinkedHashMap<String, Integer> seen  = new LinkedHashMap<>();
        for (int i = 0; i < s.length()-3; i ++ ) {
            String current = s.substring(i,i+4);
            if (!seen.containsKey(current)) {
                    seen.put(current,0);
            }
            else {
                seen.put(current,seen.get(current)+1);
                repeated.add(current);
            }
        }
        return repeated;
    }
}
