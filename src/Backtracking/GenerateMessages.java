package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/*0 -> null
1 -> null
2 -> "abc"
3 -> "def"
4 -> "ghi"
5 -> "jkl"
6 -> "mno"
7 -> "pqrs"
8 -> "tuv"
9 -> "wxyz"
Ex: digits = "23" return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*/
public class GenerateMessages {
    public static void main(String[] args) {
        String digits = "23";
        String[] mappings = {null,null,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        System.out.println(generateMsg(digits,mappings));
    }

    static ArrayList<String> generateMsg(String digits, String[] mappings){
        ArrayList<String> arrayList = new ArrayList<>();
        generateTextMsg(digits,0,"", mappings,arrayList);
        return arrayList;
    }

    private static void generateTextMsg(String digits, int index, String current, String[] mappings, ArrayList<String> arrayList) {
     if (index >= digits.length()){
         arrayList.add(current);
         return;
     }
     String maps = mappings[digits.charAt(index)-'0'];
        for (int i = 0; i < maps.length(); i++) {
            char c = maps.charAt(i);
            generateTextMsg(digits,index+1,current+c,mappings,arrayList);

        }

    }


}
