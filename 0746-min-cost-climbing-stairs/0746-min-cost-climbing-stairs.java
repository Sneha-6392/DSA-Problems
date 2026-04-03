class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return recur(n, cost, dp);
    }
    public int recur(int n, int[] cost, int[] dp) {
        if (n <= 1)  {
            dp[n] = 0;
            return dp[n];
        }

        if (dp[n] != -1) return dp[n];

        int oneStep = cost[n - 1] + recur(n - 1, cost, dp);
        int twoStep = cost[n - 2] + recur(n - 2, cost, dp);

        dp[n] = Math.min(oneStep, twoStep);

        return dp[n];
    }
}