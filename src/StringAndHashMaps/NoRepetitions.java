package StringAndHashMaps;/*Given a string s, return the length of the longest substring that contains only unique characters.

Ex: Given the following string s…

s = "ababbc", return 2.
Ex: Given the following string s…

s = "abcdssa", return 5.
To solve this problem we can use a two pointer technique. We can use a pointer i to represent the start of our substring without repeated characters and a pointer j, to represent the end of our substring without repeated characters. We can traverse our string s incrementing our pointer j while we have no reused a character. Every character we encounter we can add it to a hash set to ensure we mark that character as visited. As soon as we encounter a character that we’ve already seen, we can update a max variable accordingly (since seeing a duplicate character means our substring must end at the current index j). Once we’ve seen a character that we’ve already seen, we must start incrementing our pointer i until that character is only used once in our substring again. By following this approach we will continuously update our max variable and can return it once our loop ends.
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class NoRepetitions {

    static String s = "abcdssa";

    public static void main(String[] args) {
        System.out.println(noReps(s));
    }

    public static int noReps(String s) {
        if (s.length() <= 0)
            return 0;


        LinkedHashSet<Character> seen = new LinkedHashSet<>();
        int j = 0, i = 0;
        int max = 0;
        while (j < s.length()) {
            if (!seen.contains(s.charAt(j))){
                seen.add(s.charAt(j));
                System.out.println(seen);
                j++;
                max = Math.max(max,j-i);
            }
            else {
                seen.remove(s.charAt(i));
                System.out.println(seen);
                i++;
            }

        }
        return max;
    }
}
