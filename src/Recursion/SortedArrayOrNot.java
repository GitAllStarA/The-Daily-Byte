package Recursion;

public class SortedArrayOrNot {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4};
        System.out.println(isSorted(array,0,1,0));
    }

    static boolean isSorted(int[] array,int i, int j, int count){

        if (array[i]>array[j]){
            return false;
        }

        if (i == array.length-2 && j == array.length-1 && array[array.length-2] < array[array.length-1])
        {
            return true;
        }

        boolean result =  isSorted(array,i+1,j+1,count+1);
        System.out.println(result+" -> "+count);
        return result;

    }
}
