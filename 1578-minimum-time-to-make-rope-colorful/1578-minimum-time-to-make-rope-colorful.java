public class Solution {
    public int minCost(String colors, int[] time) {
        int total = 0;
        int n = colors.length();
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                
                total += Math.min(time[i], time[i - 1]);
                
                time[i] = Math.max(time[i], time[i - 1]);
            }
        }

        return total;
    }
}
