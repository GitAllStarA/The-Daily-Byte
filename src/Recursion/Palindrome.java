package Recursion;

public class Palindrome {

    public static void main(String[] args) {


        String n = "12221";

        System.out.println(palindrome(n, 0, n.length() - 1));
    }

    static boolean palindrome(String s, int start, int end) {
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        if (s.charAt(start) == s.charAt(end) && start == s.length() - 1 && end == 0) {
            return true;
        }

        boolean result = palindrome(s, start + 1, end - 1);
        System.out.println(result);
        return result;
    }

}
