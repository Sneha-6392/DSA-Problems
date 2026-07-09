class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum / k;
        int i = 0;
        for (int j = k; j < nums.length; j++) {
            sum -= nums[i];
            sum += nums[j];
            i++;
            double avg = sum / k;
            max = Math.max(max, avg);
        }
        return max;
    }
}