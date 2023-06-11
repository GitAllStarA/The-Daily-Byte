package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class permutationOfString {

    public static void main(String[] args) {

        System.out.println(stringPermutations("c7w2"));
    }

    public static List<String> stringPermutations(String S) {
        List<String> permutations = new ArrayList<String>();
        generatePermutations(S, 0, permutations, "");
        return permutations;
    }

    public static void generatePermutations(String S, int index, List<String> permutations, String current) {
        if(index >= S.length()) {
            System.out.println("index "+index);
            permutations.add(current);
            return;
        }

        char c = S.charAt(index);
        if(Character.isLetter(c)) {
            generatePermutations(S, index + 1, permutations, current + Character.toUpperCase(c));
            System.out.println(index+"-> "+current);

            generatePermutations(S, index + 1, permutations, current + Character.toLowerCase(c));
            System.out.println(index+"-->> "+current);
        } else {
            generatePermutations(S, index + 1, permutations, current + c);
        }
    }
}
