package StringAndHashMaps;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public static void main(String[] args) {
        //System.out.println(vp());
        System.out.println(isPalindrome21("A man, a plan, a canal: Panama."));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama."));
    }


    public static boolean isPalindrome21(String s) {
        if (s.length()==0 && s.length()==1)
            return true;
        String ss = "";
        for (char c : s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                ss = ss+c;
            }
        }
        ss= ss.toLowerCase();
        System.out.println(ss);

        int i = 0;
        int j = ss.length()-1;
        char[] x =  ss.toCharArray();
        while (i<j) {
            if (x[i]!=x[j]){
                return false;
            }
            i++;
            j--;
        }
       return true;
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {

            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                System.out.println(s.charAt(i));
                System.out.println("-> "+i);
                i++;
            }

            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                System.out.println(s.charAt(j));
                System.out.println("-> "+j);
                j--;
            }

            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome222(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(Character.isLetterOrDigit(Character.toLowerCase(s.charAt(i++))) != Character.isLetterOrDigit(Character.toLowerCase(s.charAt(j--)))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean vp() {
        String s = "level";
        char[] c = s.toCharArray();

        List<Character> one = new ArrayList<>();
        List<Character> two = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            one.add(c[i]);
        }

        for (int i = s.length()-1; i>=0 ; i--) {
            two.add(c[i]);
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.println(one.get(i)+" : "+two.get(i));
            if (one.get(i)!=two.get(i))
                return false;
        }

        return true;
    }
}