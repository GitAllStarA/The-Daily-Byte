package Recursion;

public class Arithmetics {
    public static void main(String[] args) {
        //System.out.println(sum(3));

        Long n = 7372309020L;
        int n2 = 1234;

//        System.out.println("sum " + sumOfDigit(n));
//        System.out.println("prod " + prodOfDigit(n));
//        sub(5);
//        System.out.println("done");
//        reverseNum(n2);
//        System.out.println("with helper " + rev2(n2));
//
//         int n3 = 1221;
//         String s = String.valueOf(n3);
       // System.out.println(palindrome(s,0,s.length()-1));
        System.out.println(helpwrrrZeros(10004));
    }

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        int add = sum(n - 1);
        return add + n;
    }


    static Long sumOfDigit(Long n) {

        if (n <= 10) {
            return n;
        }
        Long rem = n % 10;
        return rem + sumOfDigit(n / 10);
    }


    static Long prodOfDigit(Long n) {

        if (n < 10) {
            return n;
        }
        Long rem = n % 10;
        return rem * sumOfDigit(n / 10);
    }

    static void sub(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + "-");

        //n--                               vs                              --n
        //pass value first                                          subtract the value first
        //sub(n--);  this will give infinite recursion because n-- pass n value first meaning everytime 5 is passed to logic line of code, so infinite loop.
        sub(--n); //here value of n is first SUBTRACT and sent to logic meaning value n = 5 will get subtracted first by --n i.e, n = 4 is sent logic
        // so no infinite loop because value is changed everytime when passed to our function or login
    }

    static int sum = 0;

    static void reverseNum(int n) {
        if (n < 10) {
            sum = sum * 10 + n;
            System.out.println(sum);
            return;
        }

        int rem = n % 10;

        sum = sum * 10 + rem;

        reverseNum(n / 10);
    }


    static int rev2(int n) {
        int digits = (int) (Math.log10(n) + 1);
        System.out.println("digits " + digits);
        return helper(n, digits);
    }

    static int helper(int n, int digits) {
        if (n < 10) {
            return n;
        }

        int rem = n % 10;
        return (int) (rem * Math.pow(10, digits - 1) + helper(n / 10, digits - 1));
    }



    static boolean palindrome(String s,int start, int end){

        if (start==end && s.charAt(start) == s.charAt(end)){
            return true;
        }

        if (s.charAt(start) != s.charAt(end)){
            return false;
        }

        return palindrome(s,start+1,end-1);


    }

    static int helpwrrrZeros(int n){
        return countZeros(n,0);
    }

    static int countZeros(int n, int count){
       if (n==0){
           return count;
       }
       int rem = n%10;

       if (rem == 0){
         return   countZeros(n/10,count+1);
       }
       return countZeros(n/10,count);


    }
}
