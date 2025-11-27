class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] minPrefix = new long[k];
        for (int i = 0; i < k; i++) {
            minPrefix[i] = Long.MAX_VALUE;
        }

        long prefix = 0;
        long maxSum = Long.MIN_VALUE;

        // prefix[0] = 0 belongs to index 0 % k
        minPrefix[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefix += nums[i - 1];

            int mod = i % k;

            if (minPrefix[mod] != Long.MAX_VALUE) {
                maxSum = Math.max(maxSum, prefix - minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return maxSum;
    }
}
