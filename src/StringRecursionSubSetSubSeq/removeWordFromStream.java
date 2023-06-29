package StringRecursionSubSetSubSeq;

public class removeWordFromStream {
    public static void main(String[] args) {
        String t = "bccapplex";
        String s = "btoph";
        System.out.println(removeWord(t));
        System.out.println(removeWord2(s));
    }

    static String removeWord(String s) {
        if (s.isEmpty()){
            return "";
        }
        String res = "";
        if (s.startsWith("appl")) {
            res = removeWord(s.substring(4));
            return res;
        }
        res = s.charAt(0) + removeWord(s.substring(1));
        return res;

    }


    static String removeWord2(String s) {
        if (s.isEmpty()){
            return "";
        }
        String res = "";
        if (s.startsWith("to") ) {
            if ( !s.startsWith("top")) {
                res = removeWord2(s.substring(2));
                return res;
            }
        }
        res = s.charAt(0) + removeWord2(s.substring(1));
        return res;

    }
}
