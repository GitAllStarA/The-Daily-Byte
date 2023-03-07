package StringAndHashMaps;/*
* Valid Words
Hash Maps
Easy
Given a string permitted and a string array, words, valid words are strings within words that only contain permitted characters. Return the total number of valid words.

Ex: Given the following permitted and words…

permitted = "abc", words = ["d", "ab", "abce"], return 1.
Ex: Given the following permitted and words…

permitted = "ake", words = ["ail", "kea", "a"], return 2.

*
* */

public class ValidWords {
    public static void main(String[] args) {
     String   permitted = "abc";
     String[] words = {"d", "ab", "abce","abc"};// return 1.
     String   permitted2 = "ake";
     String[] words2 = {"ail", "kea", "a"};
        System.out.println(valid(permitted2,words2));
    }

    public static int valid(String permitted, String[] words) {
        int count=0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean isValid = false;
            for (int j = 0; j < word.length(); j++) {
                if (permitted.indexOf(word.charAt(j))==-1){
                    isValid = false;
                    break;
                }
                else {
                    isValid = true;
                }
            }
            if (isValid)
                count ++;
        }
        return count;
    }
}
