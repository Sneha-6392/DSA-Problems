class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            max = Math.max(max, prices[i] - minSoFar);
        }
        return max;
    }
}