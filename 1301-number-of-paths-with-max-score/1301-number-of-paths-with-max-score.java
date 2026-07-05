class Solution {
    private final int MOD = (int) (1e9 + 7);
    private int[][][] dp;

    public int[] pathsWithMaxScore(List<String> board) {
        int rows = board.size();
        int cols = board.get(0).length();

        dp = new int[rows][cols][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int[] upCheck = fillAns(board, rows - 2, cols - 1);
        int[] diagCheck = fillAns(board, rows - 2, cols - 2);
        int[] leftCheck = fillAns(board, rows - 1, cols - 2);

        return consolidateChecks(upCheck, diagCheck, leftCheck);
    }

    private int[] fillAns(List<String> board, int row, int col) {
        if (row < 0 || col < 0 || board.get(row).charAt(col) == 'X') {
            return new int[] {0, 0};
        }

        if (row == 0 && col == 0) {
            return new int[] {0, 1};
        }

        if (dp[row][col][0] != -1) {
            return dp[row][col];
        }

        int curValue = board.get(row).charAt(col) - '0';

        int[] upCheck = fillAns(board, row - 1, col).clone();
        int[] diagCheck = fillAns(board, row - 1, col - 1).clone();
        int[] leftCheck = fillAns(board, row, col - 1).clone();

        if (upCheck[1] > 0) {
            upCheck[0] += curValue;
        }

        if (diagCheck[1] > 0) {
            diagCheck[0] += curValue;
        }

        if (leftCheck[1] > 0) {
            leftCheck[0] += curValue;
        }

        return dp[row][col] = consolidateChecks(upCheck, diagCheck, leftCheck);
    }

    private int[] consolidateChecks(int[] up, int[] diag, int[] left) {
        int max = Math.max(up[0], Math.max(diag[0], left[0]));
        int total = 0;

        if (up[0] == max && up[1] > 0) {
            total = (total + up[1]) % MOD;
        }

        if (diag[0] == max && diag[1] > 0) {
            total = (total + diag[1]) % MOD;
        }

        if (left[0] == max && left[1] > 0) {
            total = (total + left[1]) % MOD;
        }

        return new int[] {max, total};
    }
}