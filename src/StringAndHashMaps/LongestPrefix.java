package StringAndHashMaps;

import java.util.Arrays;
import java.util.HashMap;

public class LongestPrefix {

    public static void main(String[] args) {
        System.out.println(longPrefix(new String[]{"cold", "colorado", "coldstar", "cola", "claps"}));
        System.out.println(longPrefix2(new String[]{"cold", "colorado", "coldstar", "cola", "claps"}));

        //  String s = "rado", s2 = "colorado";


        //    System.out.println(s2.indexOf(s));
    }


/*
    public static String longPrefix(String[] values) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (String x : values) {

            for (int i = 0; i < x.length(); i++) {
                char[] charArr = x.toCharArray();
                if (!hashMap.containsKey(charArr[i]))
                    hashMap.put(charArr[i],1);
                else
                    hashMap.put(charArr[i],hashMap.get(charArr[i])+1);
            }

        }

        System.out.println(hashMap);



        return "x";
    }
*/


    public static String longPrefix(String[] strings) {
        if (strings.length <= 0) {
            return "";
        }
        Arrays.sort(strings);
        String prefix = strings[0];
        System.out.println(Arrays.toString(strings));
      //  System.out.println(strings[1]);
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;

    }


    public static String longPrefix2(String[] strings){
        if (strings.length<=0){
            return "";
        }

        Arrays.sort(strings);
        String first = strings[0];
        String last = strings[strings.length-1];

        while (last.indexOf(first)!=0){
            first = first.substring(0,first.length()-1);
        }

        return first;

    }
}
