class Solution {
    static final long MOD = 1_000_000_007;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        long[][][] dp = new long[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j] % k;

                if (i > 0) {
                    for (int r = 0; r < k; r++) {
                        long ways = dp[i-1][j][r];
                        if (ways > 0) {
                            int newR = (r + val) % k;
                            dp[i][j][newR] = (dp[i][j][newR] + ways) % MOD;
                        }
                    }
                }

                if (j > 0) {
                    for (int r = 0; r < k; r++) {
                        long ways = dp[i][j-1][r];
                        if (ways > 0) {
                            int newR = (r + val) % k;
                            dp[i][j][newR] = (dp[i][j][newR] + ways) % MOD;
                        }
                    }
                }
            }
        }

        return (int) dp[m-1][n-1][0];
    }
}
