package Recursion;

public class NumberOfStepsReduceToZero {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(helper(n));
    }

    static int helper(int n) {
        return reducer(n, 0);
    }

    static int reducer(int n, int steps) {
        if (n == 0) {
            return steps;
        }
        if (n%2==0){
        return reducer(n/2,steps+1);
        }
        return reducer(n-1,steps+1);

    }
}
