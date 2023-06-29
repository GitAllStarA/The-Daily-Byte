package Test;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {10, 50, 30, 70, 80, 20, 90, 40};
        int key = 130;
        System.out.println(linearSearch(arr,key,0));
    }

    static boolean linearSearch(int[] array, int target, int index){
        if (index == array.length){
            return false;
        }
        if (array[index] == target){
            return true;
        }
        return linearSearch(array,target,index+1);
    }
}
