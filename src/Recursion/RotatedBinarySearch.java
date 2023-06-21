package Recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println(rotatedBinarySearch(array, 0, array.length - 1, 9));

    }

    static int rotatedBinarySearch(int[] array, int s, int e, int target) {
        if (array.length == 0) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        if (array[mid] == target) {
            return mid;
        }
        if (array[s] < array[mid]) {
            if (target >= array[s] && target <= array[mid]) {

                return rotatedBinarySearch(array, s, mid - 1, target);
            } else {
                return rotatedBinarySearch(array, mid + 1, e, target);
            }
        }

        if (target >= array[mid] && target <= array[e]) {
            return rotatedBinarySearch(array, s, mid - 1, target);
        }
        return rotatedBinarySearch(array, mid + 1, e, target);

    }

}
