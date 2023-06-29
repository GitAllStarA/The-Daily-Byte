package StringRecursionSubSetSubSeq;

import java.util.ArrayList;
import java.util.List;

public class Ascii {
    public static void main(String[] args) {
        char c = 'a';
        System.out.println(c+0);

        String s = "abc";
        System.out.println(getAscii("",s));
    }

    static ArrayList<String> getAscii(String x, String s) {
        if (s.isEmpty()){
            ArrayList<String> al = new ArrayList<>();
            al.add(x);
            return al;
        }

        char c = s.charAt(0);
        ArrayList<String> left = getAscii(x+String.valueOf(c),s.substring(1));
        ArrayList<String> ascii = getAscii(x+ String.valueOf(c+0),s.substring(1));
        ArrayList<String>right = getAscii(x,s.substring(1));
        left.addAll(ascii);
        left.addAll(right);

        return left;
    }



}
