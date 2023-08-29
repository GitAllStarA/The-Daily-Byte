package AdvancedTopics.BitManipulation;
/*Complementary Numbers
Given a positive number, return its complementary number.
Note: The complement of a number is the number that results from flipping every
bit in the original number. (i.e. zero bits become one bits and one bits become zero bits).

Ex: Given the following number…

number = 27, return 4.
27 in binary (not zero extended) is 11011.
Therefore, the complementary binary is 00100 which is 4.*/
public class ComplementaryNumber_DeminalNumberFlip {
    public static void main(String[] args) {

        int n = 200232454;
        System.out.println(compN(n));
        //System.out.println(value(n));
    }

    //https://www.youtube.com/watch?v=sOtG79vus9g&ab_channel=Codebix
    //working
    public static int compN(int n) {
        int i = 0;
        int j = 0;
        while (i<n) {
            i += Math.pow(2,j);
            j++;
        }
        return i-n;
    }

    static int value(int n){
        StringBuffer sbe = new StringBuffer();
        int temp = 0;
        while (n>=1) {
            temp = n%2;
            n=n/2;
            sbe.append(temp);
        };
        String sb = sbe.reverse().toString();
        System.out.println(sb);
        StringBuffer newsb = new StringBuffer();
        for (int i = 0; i < sb.length();i++) {
                if (sb.charAt(i)=='1'){
                    newsb.append("0");
                }else if (sb.charAt(i)=='0'){
                    newsb.append("1");
                }
        }
        int x = Integer.parseInt(newsb.toString());

        int sum = 0; int power = 0;
        while (x>=1) {
            int tempv = x%10;
            if (tempv == 1) {
                sum += 1 * Math.pow(2,power);
            }
            power++;
            x= x/10;
        }
        return sum;
    }
}
