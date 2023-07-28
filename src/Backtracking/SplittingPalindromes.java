package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SplittingPalindromes {
    public static void main(String[] args) {
        String word = "ababa";
        String word2 = "aaba";
        System.out.println(palindromeStore(word2));
    }

    static ArrayList<ArrayList<String>> palindromeStore(String word) {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        addPalindrome(0, arrayList, new ArrayList<>(), word);
        System.out.println(arrayList);
        return arrayList;
    }



    private static void addPalindrome(int start, ArrayList<ArrayList<String>> palindromeCollectorList, ArrayList<String> current, String word) {
        if (start==word.length()) {
            palindromeCollectorList.add(new ArrayList<>(current));
            System.out.println(current);
            return;
        }

        for (int i = start; i < word.length(); i++) {
            if (isPalindromeOrNot(word,start,i)) {
                String newWord = word.substring(start,i+1);
                current.add(newWord);
                addPalindrome(i+1,palindromeCollectorList,current,word);
                current.remove(current.size()-1);
            }
        }
    }

    private static boolean isPalindromeOrNot(String word, int i, int j) {
        while (i<j){
            if (word.charAt(i) != word.charAt(j)){
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }

   /* public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> palindromes = new ArrayList<>();
        findPalindromes(s, new ArrayList<>(), palindromes, 0);

        return palindromes;
    }

    public static void findPalindromes(String s, ArrayList<String> current, List<ArrayList<String>> palindromes, int start) {
        if (start == s.length()) {
            palindromes.add(new ArrayList<>(current));
            System.out.println(palindromes);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                System.out.println(start+" "+i);
                String x =  s.substring(start, i + 1);
                current.add(x);
                findPalindromes(s, current, palindromes, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                System.out.println(s.charAt(i) +" "+s.charAt(j));
                return false;
            }
        }
        System.out.println("true "+s.charAt(i)+" "+s.charAt(j));
        return true;
    }
*/
}
