package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int n[] = {0,3,5,2,1,6};
        System.out.println(subSequence(n));
    }

    static int subSequence(int[] n) {
        int len[] = new int[n.length];
        int subSeq[] = new int[n.length];
        for (int i = 0; i < len.length; i++) {
            len[i] = 1;
        }
        for (int i = 1; i < n.length; i++) {
            for (int j = 0; j < i; j++) {
                if (n[j]<n[i] && len[i] < len[j] + 1){

                    len[i] = len[i]+1;
                    subSeq[i] = j;
                }
            }
        }
        System.out.println(Arrays.toString(len));
       return Arrays.stream(len).max().getAsInt();
    }
}
