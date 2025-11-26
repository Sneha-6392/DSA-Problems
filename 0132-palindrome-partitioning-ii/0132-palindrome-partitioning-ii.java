class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && 
                    (j - i <= 2 || isPal[i + 1][j - 1])) {

                    isPal[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                int minCuts = Integer.MAX_VALUE;
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        minCuts = Math.min(minCuts, dp[j - 1] + 1);
                    }
                }
                dp[i] = minCuts;
            }
        }

        return dp[n - 1];
    }
}
