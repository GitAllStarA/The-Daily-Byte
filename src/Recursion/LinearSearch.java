package Recursion;

public class LinearSearch {

    public static void main(String[] args) {
        int array[] = new int[]{1,4,2,70,44,22,3,67755,46,455};
        int target= 3;
        linearSearch(array,0,target);
        System.out.println("om Sai Ram");
        linearSearchReturn(array,0,target);
    }

    static void linearSearch(int[] array,int index, int target) {
        if (index > array.length-1){
            System.out.println(target+" not found");
            return;
        }
        if (array[index] == target){
            System.out.println("target "+array[index] +" found at index "+ index);
            return;
        }
        linearSearch(array,++index,target);
    }

    static boolean linearSearchReturn(int[] array,int index, int target) {
        if (index > array.length-1){
            System.out.println(target+" not found");
            return false;
        }

        boolean resultIndex = linearSearchReturn(array,++index,target) && target==array[index];
        System.out.println(target +" found at "+array[index]);
        return resultIndex;
    }
}
