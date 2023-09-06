package Test;

public class ValidPalindromeTest {
    public static void main(String[] args) {
        String s = "racecar";
        String s2 = "A man, a plan, a canal: Panama";
        System.out.println(isPlaindrome(s2));
    }


    static boolean isPlaindrome(String s) {
        StringBuilder sChar = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                sChar.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        System.out.println(sChar);
            int i =0, j = sChar.length()-1;
            while (i <= j ){
                if (sChar.charAt(i)!=sChar.charAt(j)){
                    return false;
                }
                i++;j--;
            }
            return true;
    }
}
