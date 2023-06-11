package Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(numberFactorial(5));
    }

    static int numberFactorial(int n) {
        if (n == 0){
            return 1;
        }

        int factorial = numberFactorial(n-1);
        return n*factorial;
    }
}
