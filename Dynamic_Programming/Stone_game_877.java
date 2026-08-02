package Dynamic_Programming;

import java.util.Arrays;

class Solution {
    
    int[][] dp = new int[501][501];

    public int solve(int[] piles, int i, int j){

        if(i > j){
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take_i = piles[i] + Math.min(solve(piles, i+2, j), solve(piles, i+1, j-1));
        int take_j = piles[j] + Math.min(solve(piles, i+1, j-1), solve(piles, i, j-2));

        return dp[i][j] = Math.max(take_i, take_j);
    }
    public boolean stoneGame(int[] piles) {

        int n = piles.length;

        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }

        int sum = Arrays.stream(piles).sum();

        int Al_Score = solve(piles, 0, n-1);

        return Al_Score > sum/2;
    }
}
