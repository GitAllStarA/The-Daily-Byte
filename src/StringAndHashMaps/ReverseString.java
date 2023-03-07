package StringAndHashMaps;

public class ReverseString {
    public static void main(String[] args) {
        String s = "civic";
        String s2 = "The Daily Byte";

        char[] x = s.toCharArray();
        System.out.println(x.length);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = x.length-1; i >=0; i--) {
            stringBuilder.append(x[i]);
        }
        System.out.println(stringBuilder.toString());

    }





    public static StringBuilder SwapFirstAndLast(String word) {
        char[] chA = word.toCharArray();
        char temp = chA[0];
        chA[0] = chA[chA.length-1];
        chA[chA.length-1] = temp;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < chA.length; j++) {
            sb.append(chA[j]);
        }
        return sb;
    }
}
