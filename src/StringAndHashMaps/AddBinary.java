package StringAndHashMaps;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11", b = "1";
        //System.out.println(getBinary(a,b));

        System.out.println(getBinary(a,b));
       // System.out.println(1 % 2);
    }

    /*public static String getBinary(String a, String b) {
StringBuilder stringBuilder = new StringBuilder();
//        if (a.length() <=0 && b.length() <=0)
//            return "null";

        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i>=0 || j>=0){
            int sum = carry;
            if (i>=0){
                System.out.println(a.charAt(i--)-0);
                sum += a.charAt(i--)-0;
            }
            if (j>=0){
                System.out.println(b.charAt(j--)-0);
                sum += b.charAt(j--)-0;
            }
            stringBuilder.insert(0,sum%2);
            carry = sum/2;
        }

        if (carry>0){
            stringBuilder.insert(0,1);
        }



        return stringBuilder.toString();
    }*/

    public static String getBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
           sum = carry;
            if (i >= 0) {
                int aIntVal = a.charAt(i) - 0;
                sum += aIntVal;
                i--;
            }
            if (j >= 0) {
                int bIntVal = b.charAt(j) - 0;
                sum += bIntVal;
                j--;
            }
            carry = sum / 2;
            sb.append(sum % 2);

        }
        if (a.length()!=b.length()) {
            if (carry != 0)
                sb.append(1);
        }
        return sb.reverse().toString();
    }

}
