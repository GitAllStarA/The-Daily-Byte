package DynamicProgramming;

/*
* Painting Houses
Dynamic Programming
Medium
This question is asked by Apple. You are tasked with painting a row of houses in your
* neighborhood such that each house is painted either red, blue, or green. The cost of
* painting the ith house red, blue or green, is given by costs[i][0], costs[i][1],
* and costs[i][2] respectively. Given that you are required to paint each house and no
* two adjacent houses may be the same color, return the minimum cost to paint all the houses.

Ex: Given the following costs array…

costs = [[1, 3, 5],[2, 4, 6],[5, 4, 3]], return 8.
Paint the first house red, paint the second house blue, and paint the third house green.
See Solution
*
* */
public class PaintingHouses {
    public static void main(String[] args) {
        int[][] houses = {
                {1, 3, 5},
                {2, 4, 6},
                {5, 4, 3}};
        //System.out.println(paintHouses(houses));
        System.out.println(paintHousesNoNewArray(houses));
    }

    static int paintHouses(int[][] houses) {

        //make a dp 2d[][] array of same size
        int[][] dp = new int[houses.length][3];

        //now at dp[0] is first house data, fill them with houses[0] first houses data
        for (int i = 0; i < houses[0].length; i++) {

            //i is the house and j is the color meaning 0,1,2.
            dp[0][i] = houses[0][i]; //dp[0][0] == houses[0][0] and so on till no of colors
        }

        //from second house try finding minimum to paint the houses and so on
        for (int i = 1; i < houses.length; i++) {
            dp[i][0] = houses[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = houses[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = houses[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }

        //from last row return the minimum value
        return Math.min(dp[houses.length-1][0],Math.min(dp[houses.length-1][1],dp[houses.length-1][2]));
    }

    static int paintHousesNoNewArray(int[][] houses) {

        int[][] dp = new int[houses.length][3];

        for (int i = 0; i < houses[0].length; i++) {
            dp[0][i] = houses[0][i];
        }

        for (int i = 1; i < houses.length; i++) {
            houses[i][0] = houses[i][0] + Math.min(houses[i-1][1],houses[i-1][2]);
            houses[i][1] = houses[i][1] + Math.min(houses[i-1][0],houses[i-1][2]);
            houses[i][2] = houses[i][2] + Math.min(houses[i-1][0],houses[i-1][1]);
        }

        return Math.min(houses[houses.length-1][0],Math.min(houses[houses.length-1][1],houses[houses.length-1][2]));
    }
}
