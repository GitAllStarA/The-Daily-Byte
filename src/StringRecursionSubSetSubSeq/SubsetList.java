package StringRecursionSubSetSubSeq;

import java.util.ArrayList;
import java.util.List;

public class SubsetList {
    public static void main(String[] args) {
        String s = "abc";
       // System.out.println(subset(s, new ArrayList<>()));
       // subsetKK("", s);
        System.out.println(subsetArrayListRetKK("","abc"));
    }

    static void subsetKK(String processed, String uprocessed) {
        if (uprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char x = uprocessed.charAt(0);
        subsetKK(processed + x, uprocessed.substring(1));
        subsetKK(processed, uprocessed.substring(1));
    }


    //wrong
    static ArrayList<String> subset(String s, ArrayList<String> al) {

        if (s.isEmpty()) {
            return al;
        }


        char c = s.charAt(0);
        al.add(String.valueOf(s.charAt(0)));
        al.add(s.substring(1));


        return subset(s.substring(1), al);


    }

    static ArrayList<String> subsetArrayListRetKK(String x, String s) {

        if (s.isEmpty()) {
            ArrayList<String> al = new ArrayList<>();
            al.add(x);
            return al;
        }
        char c = s.charAt(0);
        ArrayList<String> left = subsetArrayListRetKK(x+String.valueOf(c) , s.substring(1));
        ArrayList<String> right = subsetArrayListRetKK(x , s.substring(1));

        left.addAll(right);

        return left;


    }
}
































