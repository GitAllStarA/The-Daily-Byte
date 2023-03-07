package StringAndHashMaps;/*
*
* Keyboard Row
Hash Maps
Medium
Given a list of words, return all the words that require only a single row of a keyboard to type.
Note: You may assume that all words only contain lowercase alphabetical characters.

Ex: Given the following list of words…

words = ["two", "dad", "cat"], return ["two", "dad"].
Ex: Given the following list of words…

words = ["ufo", "xzy", "byte"], return [].
*
* */


import java.util.*;

public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = {"two", "dad", "cat","Alaska"};         // return ["two", "dad"].

        String[] words2 = {"ufo", "xzy", "byte"}; // return [].

        String[] words3 = {"Hello","Alaska","Dad","Peace"};

        String[] words4 = {"a","b"};

        //System.out.println(findWords(words4));
        System.out.println(findword3(words3));
    }


    public static String kbrow1(String word) {
        String s = word;
        char[] kb1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        HashSet<Character> hashSet1 = new HashSet<>();
        for (int i = 0; i < kb1.length; i++) {
            hashSet1.add(kb1[i]);
        }
        for (int i = 0; i < kb1.length; i++) {
            hashSet1.add(Character.toUpperCase(kb1[i]));
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!hashSet1.contains(s.charAt(i))) {
                break;
            }
            else {
                sb.append(s.charAt(i));
                count++;
            }
            if (count == s.length()) {
            //    System.out.println(count + " " + s.length());
            }
        }
        return sb.toString();
    }

    public static String kbrow2(String word) {
        String s = word;
        char[] kb2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        HashSet<Character> hashSet1 = new HashSet<>();
        for (int i = 0; i < kb2.length; i++) {
            hashSet1.add(kb2[i]);
        }
        for (int i = 0; i < kb2.length; i++) {
            hashSet1.add(Character.toUpperCase(kb2[i]));
        }
        int count = 0;
        String csdc = ";";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!hashSet1.contains(s.charAt(i))) {
                break;

            }
            else {
                sb.append(s.charAt(i));
                count++;
            }
            if (count == s.length()) {
            }
        }
        return sb.toString();
    }

    public static String kbrow3(String word) {
        String s = word;
        char[] kb3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        HashSet<Character> hashSet1 = new HashSet<>();
        for (int i = 0; i < kb3.length; i++) {
            hashSet1.add(kb3[i]);
        }
        for (int i = 0; i < kb3.length; i++) {
            hashSet1.add(Character.toUpperCase(kb3[i]));
        }
        int count = 0;
        String csdc = ";";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!hashSet1.contains(s.charAt(i))) {
                break;
            }
            else {
                sb.append(s.charAt(i));
                count++;
            }
            if (count == s.length()) {
            }
        }
        return sb.toString();
    }


    public static String[] findWords(String[] words){
        List<String> list = new ArrayList<>();
        if (words.length<=0){
            return new String[] {};
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            System.out.println("findWords loop words -> "+word.length());
            if (kbrow1(word).length() == word.length()){
                list.add(word);
            } else if (kbrow2(word).length() == word.length()){
                list.add(word);
            } else if ( kbrow3(word).length() == word.length()){
                list.add(word);
            }
        }

        String[] wordsFormed = new String[list.size()];

        System.out.println("here -> list "+list);
        int i = 0;
        for (String x : list){
            wordsFormed[i++] = x;
        }
        return wordsFormed;
    }

    public static List<String> isWordInOneRow_notWorking(String[] words) {

        if (words.length <= 0) return new ArrayList<>();

        char[] kb1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};

        char[] kb2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};

        char[] kb3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        HashSet<Character> hashSet1 = new HashSet<>();
        for (int i = 0; i < kb1.length; i++) {
            hashSet1.add(kb1[i]);
        }
        HashSet<Character> hashSet2 = new HashSet<>();
        for (int i = 0; i < kb2.length; i++) {
            hashSet2.add(kb2[i]);
        }
        HashSet<Character> hashSet3 = new HashSet<>();
        for (int i = 0; i < kb3.length; i++) {
            hashSet3.add(kb1[i]);
        }

        List<String> list = new ArrayList<>();
        HashSet<String> hashSetWord = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                StringBuilder sb = new StringBuilder();
                if (hashSet1.contains(word.charAt(j))) {
                    sb.append(word.charAt(j));
                }
                if (hashSet2.contains(word.charAt(j))) {
                    sb.append(word.charAt(j));
                }
                if (hashSet3.contains(word.charAt(j))) {
                    sb.append(word.charAt(j));
                }
                hashSetWord.add(sb.toString());
            }
        }

        System.out.println(hashSetWord);
        return new ArrayList<>();
    }



    public static String[] findword3(String[] words){
        if (words.length<=0){
            return new String[]{};
        }

        String row0 = "qwertyuiopQWERTYUIOP";
        String row1 = "asdfghjklASDFGHJKL";
        String row2 = "zxcvbnmZXCVBNM";


        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();

        for (char x : row0.toCharArray()){
            hashMap.put(x,0);
        }
        for (char x : row1.toCharArray()){
            hashMap.put(x,1);
        }
        for (char x : row2.toCharArray()){
            hashMap.put(x,2);
        }
        List<String> list = new ArrayList<>();
        System.out.println(hashMap);
        boolean isValid = true;
        for (String word : words){
            int row = hashMap.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                int rowWord = hashMap.get(word.charAt(i));
                System.out.println(rowWord+" "+row);
                if ( rowWord != row){
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                list.add(word);
        }
        int x = 0;
        String[] wordslist = new String[list.size()];
        for (String xx : list){
            System.out.println(xx);
        wordslist[x++] = xx;
        }

        return wordslist;
    }
}
