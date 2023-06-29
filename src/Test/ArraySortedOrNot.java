package Test;

public class ArraySortedOrNot {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,4,5};
        int[] array2 = new int[]{0,9,1};
        System.out.println(isSorted(array2,0));
    }


    static boolean isSorted(int[] array, int index) {
        if (index == array.length - 1){
            return true;
        }
        if (array[index] > array[index+1]){
            return false;
        }

        return isSorted(array, index+1);

    }
}
