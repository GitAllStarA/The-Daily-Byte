package Recursion;

import java.util.ArrayList;

public class LinkedListMultipleOccurrences {

    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 6, 9, 0, 4};
        lsMultiOccur(array, 0, 6);
        System.out.println(list);
        System.out.println(lsMultiOccur(array, 0, 0, new ArrayList<>()));
        System.out.println(helper(array));
        System.out.println("no argument ");
        System.out.println(noArrayListAsArgument(array,0,6));
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static void lsMultiOccur(int[] array, int index, int target) {
        if (index > array.length - 1) {
            return;
        }
        if (array[index] == target) {
            list.add(index);
        }
        lsMultiOccur(array, ++index, target);
    }

    static ArrayList<Integer> lsMultiOccur(int[] array, int index, int target, ArrayList<Integer> arrayList) {
        if (index > array.length - 1) {
            return new ArrayList<>();
        }
        if (array[index] == target) {
            arrayList.add(index);
        }
        lsMultiOccur(array, ++index, target, arrayList);
        return arrayList;
    }

    static ArrayList<Integer> helper(int[] array) {
        ArrayList<Integer> al = new ArrayList<>();
        if (array.length <= 0)
            return new ArrayList<>();
        else {
            return (lsMultiOccurHelper(array, 0, 4, al));
        }
    }

    static ArrayList lsMultiOccurHelper(int[] array, int index, int target,ArrayList<Integer> arrayList) {
        if (index > array.length - 1) {
            return new ArrayList<>();
        }
        if (array[index] == target) {
            arrayList.add(index);
        }
        lsMultiOccurHelper(array,++index, target,arrayList);
        return arrayList;
    }



    static ArrayList<Integer> noArrayListAsArgument(int array[], int index, int target){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (index > array.length-1)
        {
            return arrayList;
        }
        if (array[index] == target) {
            arrayList.add(index);
        }
        ArrayList<Integer> results =  noArrayListAsArgument(array,++index,target);
        arrayList.addAll(results);
        return arrayList;
    }
}
