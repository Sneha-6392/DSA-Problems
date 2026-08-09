class Solution {
    public int[][] dp;
    public int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n + 1];
        for (int i = n - 2; i >= 0; i--) {
            piles[i] += piles[i + 1];
        }
        return dfs(piles, 0, 1);
    }
    public int dfs(int[] piles, int i, int m) {
        if (i + 2 * m >= n) return piles[i];
        if (dp[i][m] != 0) return dp[i][m];
        int minopp = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            minopp = Math.min(minopp, dfs(piles, i + x, Math.max(m, x)));
        }
        return dp[i][m] = piles[i] - minopp;
    }
}