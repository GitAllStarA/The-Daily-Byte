package Test;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {10, 50, 30, 70, 80, 20, 90, 40, 40};
        int key = 40;
        //System.out.println(linearSearch(arr,key,0));
        linearSearchMultipleOccurance(arr,key,0);
        System.out.println(list);
        System.out.println(linearSearchMultipleOccurance(arr,40,0,new ArrayList<>()));
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

    static ArrayList<Integer> list = new ArrayList<>();
    static void linearSearchMultipleOccurance(int[] array, int target, int index) {
        if (index == array.length){
            return;
        }

        if (array[index] == target){
            list.add(index);


        }
         linearSearchMultipleOccurance(array,target,index+1);


    }


    static ArrayList<Integer> linearSearchMultipleOccurance(int[] array, int target, int index, ArrayList<Integer> returnList) {
        if (index == array.length){
            return returnList;
        }

        if (array[index] == target){

            returnList.add(index);

        }
        return linearSearchMultipleOccurance(array,target,index+1,returnList);


    }
}
