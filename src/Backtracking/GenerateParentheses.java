package Backtracking;

import java.util.ArrayList;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 2;
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generator(n,0,0,sb,arrayList);
        System.out.println(arrayList);

    }

    public static void generator(int max, int open, int close, StringBuilder current, ArrayList<String> arrayList) {

        if (current.length() == max * 2) {
            arrayList.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            generator(max, open + 1, close, current , arrayList);
            current.deleteCharAt(current.length()-1);
        }
        if (close < open) {
             current.append(")");
             generator(max, open, close + 1, current , arrayList);
            current.deleteCharAt(current.length()-1);
        }

    }
}
