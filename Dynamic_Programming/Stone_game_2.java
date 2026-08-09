package Dynamic_Programming;

class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // suffix[i] = total stones from i to n-1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }

    private int solve(int i, int M, int[] piles) {

        // No piles left
        if (i >= piles.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int n = piles.length;

        int answer = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int newM = Math.max(M, X);

            int opponent = solve(i + X, newM, piles);

            int currentPlayer = suffix[i] - opponent;

            answer = Math.max(answer, currentPlayer);
        }

        dp[i][M] = answer;

        return answer;
    }
}
