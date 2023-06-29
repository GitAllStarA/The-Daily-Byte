package StringRecursionSubSetSubSeq;

import java.util.ArrayList;

public class subSetArray {
    public static void main(String[] args) {
        int array[]={1,2,3};
        //System.out.println(subsetA(array));
        //System.out.println("remove duplicates");
        int a[] = {1,2,2};
        //System.out.println(subsetDuplicate(a));

        int nums[]={0,2,3};

               int sum = 0;
               int arraySum = 0;
                for(int i = 0;i<nums.length;i++){
                    sum = sum + i+1;
                    arraySum = arraySum + nums[i];
                }
                System.out.println(sum);
        System.out.println(arraySum);


    }

    static ArrayList<ArrayList<Integer>> subsetA(int[] array) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i = 0; i < array.length; i++) {

            int n = outer.size();
            System.out.println(outer);
            System.out.println("size : "+n);
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> al = new ArrayList<>(outer.get(i));
                al.add(array[i]);
                outer.add(al);

            }

        }

        return outer;
    }


    static ArrayList<ArrayList<Integer>> subsetDuplicate(int[] array) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {

            if (i>0 && array[i] == array[i-1]){
                start = end + 1;
            }
            end = outer.size() - 1;

            int n = outer.size();
            for (int j = start; j < n; j++) {
                ArrayList<Integer> al = outer.get(j);
                ArrayList<Integer> inner = new ArrayList<>(al);
                inner.add(array[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
