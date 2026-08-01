class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int left = 0; left + len - 1 < n; left++) {
                int right = left + len - 1;

                int pickLeft = nums[left] - dp[left + 1][right];
                int pickRight = nums[right] - dp[left][right - 1];

                dp[left][right] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}