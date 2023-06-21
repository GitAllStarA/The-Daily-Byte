package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        String word = "hello";
        String rev = reverse(word, word.length() - 1, "");
        System.out.println(rev);
    }

    static String reverse(String word, int index, String reversedWord) {
        if (index < 0) {
            return "";
        }

        System.out.print(word.charAt(index));
        return reversedWord + reverse(word, index - 1, reversedWord);
    }

    static void reverse(String word, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(word.charAt(index));
        reverse(word, index - 1);

    }
}
