package Recursion;

public class Recursion {


    public static void main(String[] args) {
        callNumberUsingRecursion(1);
    }

    static void callNumberUsingRecursion(int n) {

        //base case
        if (n == 5) {
            System.out.println(n);
            return;
        }
        System.out.println(n);

        //call function
        //tail recursion
        callNumberUsingRecursion(n + 1);
    }
}
