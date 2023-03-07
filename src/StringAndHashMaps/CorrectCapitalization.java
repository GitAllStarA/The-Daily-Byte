package StringAndHashMaps;

public class CorrectCapitalization {
    public static void main(String[] args) {
        //System.out.println(isCorrectCapital("USAA"));
        System.out.println(isCapitalized("USAll"));
    }

    public static boolean isCorrectCapital(String s) {

        if (s.length() <= 0) {
            return false;
        }

        char[] x = s.toCharArray();
        int i =0 ;
        while (i<x.length){
            if (Character.isUpperCase(x[i]) ) {
               continue;
            } else
            i++;
        }

        return true;
    }

    public static boolean isCapitalized(String s) {
        if (s.length()<=0){
            return false;
        }
        char[] chA = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chA.length; i++) {
            if (Character.isUpperCase(chA[i])){
                count++;
            }
        }
        return count == 0 || count == chA.length || Character.isUpperCase(chA[0]) && count == 1;
    }
}
