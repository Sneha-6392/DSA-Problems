class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return recur(n, dp);
    }
    public int recur(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }

        if (dp[n] != -1) return dp[n];

        dp[n] = fib(n - 2) + fib(n - 1);
        return dp[n];
    }
}