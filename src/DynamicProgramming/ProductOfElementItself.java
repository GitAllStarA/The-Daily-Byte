package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.youtube.com/watch?v=G9zKmhybKBM&ab_channel=NikhilLohia
public class ProductOfElementItself {

    public static void main(String[] args) {
        int nums[] = {3, 4, 6, 0, 1, 2};
        // 60,40,30,24
        //
        System.out.println(products(nums));
    }

    static int[] products(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int temp = 1;

        left[0] = 1;
        //multiply from left
        for (int i = 1; i < nums.length; i++) {
            temp = left[i - 1] * nums[i - 1];
            left[i] = temp;
        }

        right[nums.length - 1] = 1;
        //multiply from right
        for (int i = nums.length - 2; i >= 0; i--) {
            temp = right[i + 1] * nums[i + 1];
            right[i] = temp;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

}
