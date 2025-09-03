class Solution {
    public int maxProfit(int[] prices) {
        int min_profit = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i : prices){
            if (i < min_profit){
                min_profit = i;
            }
            else if (i - min_profit > max_profit){
                max_profit = i - min_profit;
            }
        }
        return max_profit;
    }
}