package Backtracking;

import org.w3c.dom.css.CSSStyleRule;

import java.util.ArrayList;

public class GenerateMessage {
    public static void main(String[] args) {
        String digit = "23";
        System.out.println(generateMessage(digit));
    }

    static ArrayList<String> generateMessage(String digit) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] list =
                {null
                        , null
                        , "abc"
                        , "def"
                        , "ghi"
                        , "jkl"
                        , "mno"
                        , "pqrs"
                        , "tuv"
                        , "wxyz"};
        messageGeneratorCombinations(digit, 0, arrayList, "", list);

        return arrayList;
    }

    static void messageGeneratorCombinations(String digit, int index, ArrayList<String> arrayList, String current, String[] list) {

        if (index == digit.length()){
            arrayList.add(current);
            return;
        }

        int number = Integer.parseInt(String.valueOf(digit.charAt(index)));
        String s = list[number];
        for (char x : s.toCharArray()) {
            messageGeneratorCombinations(digit,index+1,arrayList,current+x,list);
        }

    }

}
