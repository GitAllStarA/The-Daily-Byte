package Recursion;

public class Test {

    public static void main(String[] args) {
        int[] array = new int[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 3;
        System.out.println(fibnacci(n));
        System.out.println(binarySearch(array, n, 0, array.length - 1));
    }


    static int fibnacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibnacci(n - 1) + fibnacci(n - 2);
    }


    static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end) {
            return start;
        }
        if (start == end) {
            System.out.print(target+" found in the array at index : " );
            return start;
        }

        int mid = start + (end - start) / 2;

        if (target > mid) {
           return binarySearch(array,target,mid+1,end);
        }
        return binarySearch(array,target,0,mid-1);
    }
}
