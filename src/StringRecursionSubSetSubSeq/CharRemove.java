package StringRecursionSubSetSubSeq;

public class CharRemove {
    public static void main(String[] args) {
        String a = "baca";

        String s = "applebanana";
        //  System.out.println(helperFunction(a));
        // System.out.println(removeCharKK("",a));

       // System.out.println(removeCharKK2(a));



    }

    static String helperFunction(String s) {
        char[] charArray = s.toCharArray();
        return removeChar(charArray, 0, 'a', "");
    }

    static String removeChar(char[] charArray, int index, char target, String ans) {
        if (index == charArray.length) {
            return ans;
        }

        if (charArray[index] == 'a') {
            return removeChar(charArray, index + 1, 'a', ans);
        }
        return removeChar(charArray, index + 1, 'a', ans + charArray[index]);

    }


    static String removeCharKK(String res, String charRemove) {
        if (charRemove.length() == 0) {
            return res;
        }

        char c = charRemove.charAt(0);
        if (c == 'a') {
            return removeCharKK(res, charRemove.substring(1));
        }
        return removeCharKK(res + c, charRemove.substring(1));
    }

    static String removeCharKK2(String s) {
        if (s.length() == 0) {
            return "";
        }
        String res = "";
        if (s.charAt(0) != 'a') {
            res = s.charAt(0) + removeCharKK2(s.substring(1));
            return res;
        }
        res = removeCharKK2(s.substring(1));
        return res;
    }



}
