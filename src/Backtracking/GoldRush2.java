package Backtracking;

public class GoldRush2 {

    public static void main(String[] args) {
        int[] gold = {0,49,5,0,10, 9};

       findMax(gold);

    }

    static void findMax(int[] gold) {
        int MAX = Integer.MIN_VALUE;
        int x = 0;
        for (int i = 0; i < gold.length; i++) {
            if (gold[i] > MAX) {
                MAX = gold[i];
                x = i;
            }

        }
        //start to search;
        System.out.println(findGold(gold,x,0,0));

    }

    private static int findGold(int[] gold, int x,  int count, int result) {


        if (x<0 || x>=gold.length || gold[x] == 0 || x == gold.length){
            System.out.println("-> "+count);
            return result;
        }

        int temp = gold[x];
        result = result + temp;

        return findGold(gold, x+1,count+1,result);

    }
}
