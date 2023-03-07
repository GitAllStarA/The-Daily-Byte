package StringAndHashMaps;/*
* Valid Palindrome with Removal
Strings
Easy
This question is asked by Facebook. Given a string and the ability to delete at most one character, return whether or not it can form a palindrome.
Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

Ex: Given the following strings...

"abcba", return true
"foobof", return true (remove the first 'o', the second 'o', or 'b')
"abccab", return false
*
* */

public class ValidPalindrome2 {

    public static void main(String[] args) {
       // System.out.println(validPalindrome("abcbna"));
        System.out.println(validPalindrome("abc"));
       // System.out.println(validPalin("foobof"));
    }


    public static boolean validPalindrome(String s){
        int i = 0 ;
        int j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) !=s.charAt(j)) {
                return helperFunction(s,i+1,j) || helperFunction(s,i,j-1);
            }
                i++;
                j--;
        }
        return true;
    }


    public static boolean helperFunction(String s, int i, int j){

        while (i<=j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


   /* public static boolean validPalin(String s) {
        if (s.length()==0||s.length()==1){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        int count =0;
        while (i < j){
            if (Character.isLetterOrDigit(s.charAt(i)) == Character.isLetterOrDigit(s.charAt(j))){
                System.out.println(s.charAt(i)+"="+s.charAt(j));
                if (Character.isLetterOrDigit(s.charAt(i)) != Character.isLetterOrDigit(s.charAt(j))){
                    count++;
                    continue;
                }
                if (count>=2){
                    System.out.println(s.charAt(i)+"="+s.charAt(j));
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }*/
}
