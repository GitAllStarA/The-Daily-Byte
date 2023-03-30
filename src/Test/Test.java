package Test;

import java.sql.Array;
import java.util.*;


public class Test {
    public static void main(String[] args) {
        String key = "qwertyuiopasdfghjklzxcvbnm";
        String s = "perry";

        String key2 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "abc";
        String key3 = "zyxwvutsrqponmlkjihgfedcba";
        String s3 = "zayb";

        timeTakenToMail(key, s);
        timeTakenToMail(key2,s2);
        timeTakenToMail(key3,s3);
    }


//for next time please allow console to show the sout statement outputs


        public static int timeTakenToMail(String keyboard, String s)
        {
            // Write your code here.
            //char[] keyChars = new char[26];
            String words = keyboard;

            HashMap<Character,Integer> keyChars = new HashMap<>();
            int count=0;
            for(int i = 0;i < words.length(); i++) {
                char key = words.charAt(i);
                keyChars.put(key,i);
            }
            System.out.println(keyChars);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char s2 = s.charAt(i);
                if(keyChars.containsKey(s2)){
                    list.add(keyChars.get(s2));
                }
            }
            int sum = list.get(0);


            for (int i = 1; i < list.size(); i++) {
                int a = list.get(i);
                int b = list.get(i-1);
                int timeTaken = Math.abs(a-b);
                sum = sum+timeTaken;
            }
            System.out.println("time taken to send message, result : "+sum);
            return sum;
        }

}

