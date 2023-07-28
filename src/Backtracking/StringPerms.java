package Backtracking;

import java.util.ArrayList;


public class StringPerms {
    public static void main(String[] args) {
        String word = "c7w3";
        System.out.println(wordPerms(word));
    }

    static ArrayList<String> wordPerms(String word) {
        ArrayList<String> arrayList = new ArrayList<>();
        generateCombsForString(word, 0, arrayList, "");
        return arrayList;
    }

    private static void generateCombsForString(String word, int index, ArrayList<String> arrayList, String current) {
        if (index == word.length()){
            arrayList.add(current);
            return;
        }

        char c = word.charAt(index);
        if (Character.isAlphabetic(c)) {
            generateCombsForString(word,index+1,arrayList,current+Character.toLowerCase(c));
            generateCombsForString(word,index+1,arrayList,current+Character.toUpperCase(c));
        }
        else {
            generateCombsForString(word,index+1,arrayList,current+c);
        }

    }

}
