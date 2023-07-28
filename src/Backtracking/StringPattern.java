package Backtracking;

import java.util.ArrayList;

public class StringPattern {

    public static void main(String[] args) {
        String word = "ab";
        System.out.println(helperFunction(word));
    }
    static ArrayList<String> helperFunction(String word){
        ArrayList<String> arrayList = new ArrayList<>();
        recursiveCallOnEachWord(word,0,"",arrayList);
        return arrayList;
    }

    static void recursiveCallOnEachWord(String s, int index, String current, ArrayList<String> arrayList){
        if (index>=s.length()){
            arrayList.add(current);
            //System.out.println(arrayList);
            return;
        }

        char c = s.charAt(index);
        if (Character.isAlphabetic(c)) {
            recursiveCallOnEachWord(s,index+1,current+Character.toUpperCase(c),arrayList);
            recursiveCallOnEachWord(s,index+1,current+Character.toLowerCase(c),arrayList);
        }
        else {
            recursiveCallOnEachWord(s,index+1,current+c,arrayList);
        }

    }
}
