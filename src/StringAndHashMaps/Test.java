package StringAndHashMaps;

public class Test {
    public static void main(String[] args) {
    String a = "11";
    String b = "1";
        System.out.println(value(a, b));
    }

    public static String value(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
             sum = carry;

            if (i >= 0) {
                int aChar = a.charAt(i) - 0;
                sum += aChar;
                i--;
            }

            if (j >= 0) {
                int bChar = b.charAt(j) - 0;
                sum += bChar;
                j--;
            }
            if (sum >= 2){
                carry = 1;
            } else
            {
                carry = 0;
            }
            sb.append(sum % 2);

        }
 if (carry != 0)
                sb.append(1);

        return sb.reverse().toString();
    }

}
