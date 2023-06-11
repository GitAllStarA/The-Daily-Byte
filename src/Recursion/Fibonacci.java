package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        fibIterative(10);

        fibRecursive(4);
    }

    static void fibIterative(int n) {

        int a = 0;
        int b = 1;
        int sum = a + b;
        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(sum + " ");
        for (int i = 0; i < n; i++) {
            a = b;
            b = sum;
            sum = a + b;
            System.out.print(sum + " ");
        }
        System.out.println();
    }


    static int fibRecursive(int n) {
        if (n<2){
            System.out.println("-----");
            return n;
        }

        int a = fibRecursive(n-1);

        int b = fibRecursive(n-2);

        int sum = a+b;
        System.out.println(sum);
        System.out.println("=====");

        return sum;

    }

}
