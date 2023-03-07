package StringAndHashMaps;

/*StringAndHashMaps.Subsequence
        Strings
        Easy
        This question is asked by Google. Given two strings s and t return whether or not s is a subsequence of t.
        Note: You may assume both s and t only consist of lowercase characters and both have a length of at least one.

        Ex: Given the following strings s and t…

        s = "abc", t = "aabbcc", return true.
        Ex: Given the following strings s and t…

        s = "cpu", t = "computer", return true.
        Ex: Given the following strings s and t…

        s = "xyz", t = "axbyc", return false.*/
public class Subsequence {

    public static void main(String[] args) {
        //  System.out.println(isSubsequence("acb", "ahbgdc"));
        System.out.println(isSubsequence3("ab", "baab"));


        System.out.println("ahbgdc".indexOf('c'));
    }


    /*public static boolean isSubsequence(String s, String t) {

        if (s.length() <= 0 || t.length() <= 0) {
            return false;
        }

        char[] ac = s.toCharArray();

        for (int i = 0; i < ac.length; i++) {
            if (t.indexOf(ac[i])==-1)
            {
                return false;
            }
        }
    return true;
    }
*/


    public static boolean isSubequnce2(String s, String t) {
        StringBuilder sb = new StringBuilder();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int subseqlen = s.length();
        for (int i = 0; i < t.length(); i++) {
            int j =0;
            while(j<subseqlen) {
                if (sc[j] == tc[i]) {
                    sb.append(tc[i]);
                    tc[i]=' ';
                }
                j++;
            }
        }
        System.out.println(sb.toString() +" : "+s);

        return sb.toString().equals(s) || t.indexOf(s)!=-1;
    }

    public static boolean isSubsequence3(String s, String t) {

        if (s.equals(""))
            return true;
        int j_pointer = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j_pointer))
                j_pointer++;
            if (j_pointer>= s.length())
                return true;
        }
            return false;
    }

}


